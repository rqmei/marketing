package lib.android.timingbar.com.base.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import lib.android.timingbar.com.base.app.BaseApplication;

/**
 * FileUtils
 * -----------------------------------------------------------------------------------------------------------------------------------
 * 文件管理工具类
 *
 * @author rqmei on 2019/4/19
 */
public class FileUtils {
    /**
     * 获取文件名字
     *
     * @param filePath
     * @return
     */
    public static String getFileName(String filePath) {
        if (TextUtils.isEmpty(filePath)) {
            return filePath;
        }

        int filePosi = filePath.lastIndexOf(File.separator);
        return (filePosi == -1) ? filePath : filePath.substring(filePosi + 1);
    }

    /**
     * 返回缓存文件夹
     */
    public static File getCacheFile(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File file = null;
            file = context.getExternalCacheDir();//获取系统管理的sd卡缓存文件
            if (file == null) {//如果获取的为空,就是用自己定义的缓存文件夹做缓存路径
                file = new File(getCacheFilePath(context));
                makeDirs(file);
            }
            return file;
        } else {
            return context.getCacheDir();
        }
    }

    /**
     * 获取自定义缓存文件地址
     *
     * @param context
     * @return
     */
    public static String getCacheFilePath(Context context) {
        String packageName = context.getPackageName();
        return "/mnt/sdcard/" + packageName;
    }


    /**
     * 创建未存在的文件夹
     *
     * @param file
     * @return
     */
    public static File makeDirs(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /**
     * 使用递归获取目录文件大小
     *
     * @param dir
     * @return
     */
    public static long getDirSize(File dir) {
        if (dir == null) {
            return 0;
        }
        if (!dir.isDirectory()) {
            return 0;
        }
        long dirSize = 0;
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                dirSize += file.length();
            } else if (file.isDirectory()) {
                dirSize += file.length();
                dirSize += getDirSize(file); // 递归调用继续统计
            }
        }
        return dirSize;
    }

    /**
     * 使用递归删除文件夹
     *
     * @param dir
     * @return
     */
    public static boolean deleteDir(File dir) {
        if (dir == null) {
            return false;
        }
        if (!dir.isDirectory()) {
            return false;
        }
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                file.delete();
            } else if (file.isDirectory()) {
                // 递归调用继续删除
                deleteDir(file);
            }
        }
        return true;
    }

    /**
     * 根据文件名 获取保存的文件地址
     * @param folderPath 目录名
     * @param fileName 文件名
     * @return
     */
    public static File getSaveFile(String folderPath, String fileName) {
        String cacheFile = getCacheFile(BaseApplication.getAppContext()).getAbsolutePath();
        if(!folderPath.equals("") && folderPath != null) {
            cacheFile = cacheFile + File.separator + folderPath;
        }
        if(!fileName.equals("") && fileName != null) {
            cacheFile = cacheFile + File.separator + fileName;
        }
        File file = new File(cacheFile);
        try {
            file.createNewFile();
        } catch (IOException var4) {
            var4.printStackTrace();
        }
        return file;
    }
    /**
     * 【说明】：保存错误信息到指定文件中
     */
    public static boolean saveCrashInfo2File(Throwable ex) {
        boolean append = false;
        StringBuffer sbf = new StringBuffer();
        // 创建向内存中写文件的对象
        Writer writer = new StringWriter();
        // 创建打印流
        PrintWriter printWriter = new PrintWriter(writer);
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        printWriter.println(date);
        try {
            // 写入手机的基本信息
            SystemUtil.dumpPhoneInfo(BaseApplication.getAppContext(), printWriter);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        // printStackTrace方法将异常信息保存到printWriter字符串中
        ex.printStackTrace(printWriter);

        // 获取可抛出异常的原因，当原因不存在或未知时，它返回null。
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        // 关闭打印流
        printWriter.close();

        // 写入到当前 StringWriter（writer） 中的所有的字符串。
        String result = writer.toString();
        sbf.append(result);
        try {
            //格式化日期，作为文件名的一部分
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = dateFormat.format(new Date());
            String fileName = "crash-tibi.txt";
            // 获取缓存路径
            File dir = getCacheFile(BaseApplication.getAppContext());
            if (dir != null) {
                // 文件保存路径
                String filePath = dir.getAbsoluteFile() + File.separator + fileName;
                File crashFile = new File(filePath);
                if(crashFile != null && System.currentTimeMillis() - crashFile.lastModified() > 5000){
                    append = true;
                }
                FileOutputStream fos = new FileOutputStream(filePath);
                Log.e("异常", "log file path:" + filePath);
                fos.write(sbf.toString().getBytes());
                fos.close();
            }
        } catch (FileNotFoundException e) {
            Log.e("异常", "an error occurred while find file...", e);
        } catch (IOException e) {
            Log.e("异常", "an error occurred while writing file...", e);
        }
        return append;
    }
}
