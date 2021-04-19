package lib.android.timingbar.com.base.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.util.Base64;

import java.io.*;

/**
 * DataHelper 数据保存工具类（SharedPreferences、sdcard）
 * -----------------------------------------------------------------------------------------------------------------------------------
 *
 * @author rqmei on 2018/1/29
 */
public class DataHelper {
    public static String bytyToString(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream ();
        byte[] buf = new byte[1024];
        int num = 0;
        while ((num = in.read (buf)) != -1) {
            out.write (buf, 0, buf.length);
        }
        String result = out.toString ();
        out.close ();
        return result;
    }

 
    /**
     * 获取mipmap下面的图片
     *
     * @param context 上下文
     * @param resId   资源图片id
     */
    public static String getMipmapImg(Context context, int resId) {
        return "android.resource://" + context.getApplicationContext ().getPackageName () + "/" + resId;
    }

    /**
     * 获取mipmap下面的图片
     *
     * @param fileName 在assets下的文件路径
     */
    public static String getAssetsImg(String fileName) {
        return "file:///android_asset/" + fileName;
    }
}
