package lib.android.timingbar.com.base.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import lib.android.timingbar.com.base.app.BaseApplication;

/**
 * Sputil
 * -----------------------------------------------------------------------------------------------------------------------------------
 *
 * @author rqmei on 2019/7/2
 */
public class Sputil {
    public static final String SP_NAME = "config";

    /**
     * 保存数据的方法
     *
     * @param key
     * @param object
     */
    public static void putValue(Context context,String key, Object object) {
        SharedPreferences mSharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, (String) object);
        }
        editor.apply();
    }

    /**
     * 获取数据
     *
     * @param key
     * @param defaultObject
     * @return
     */
    public static Object getValue(Context context,String key, Object defaultObject) {
        SharedPreferences mSharedPreferences = BaseApplication.getAppContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        if (defaultObject instanceof String) {
            return mSharedPreferences.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return mSharedPreferences.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return mSharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return mSharedPreferences.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return mSharedPreferences.getLong(key, (Long) defaultObject);
        }
        return null;
    }

    /**
     * 清除某个内容
     */
    public static void removeSF(Context context,String key) {
        SharedPreferences mSharedPreferences = BaseApplication.getAppContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        mSharedPreferences.edit().remove(key).apply();
    }

    /**
     * 清除Shareprefrence
     */
    public static void clearShareprefrence() {
        SharedPreferences mSharedPreferences = BaseApplication.getAppContext().getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        mSharedPreferences.edit().clear().apply();
    }

    /**
     * 将对象储存到sharepreference
     *
     * @param key
     * @param device
     * @param <T>
     */
    public static <T> boolean saveDeviceData(Context context,String key, T device) {
        try {
            SharedPreferences mSharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            //Device为自定义类
            // 创建对象输出流，并封装字节流
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            // 将对象写入字节流
            oos.writeObject(device);
            // 将字节流编码成base64的字符串
            String oAuth_Base64 = new String(Base64.encode(baos
                    .toByteArray(), Base64.DEFAULT));
            mSharedPreferences.edit().putString(key, oAuth_Base64).apply();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 将对象从shareprerence中取出来
     *
     * @param key
     * @param <T>
     * @return
     */
    public static <T> T getDeviceData(Context context,String key) {
        T device = null;
        try {
            SharedPreferences mSharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
            String productBase64 = mSharedPreferences.getString(key, null);
            if (productBase64 == null) {
                return null;
            }
            // 读取字节
            byte[] base64 = Base64.decode(productBase64.getBytes(), Base64.DEFAULT);

            // 封装到字节流
            ByteArrayInputStream bais = new ByteArrayInputStream(base64);
            // 再次封装
            ObjectInputStream bis = new ObjectInputStream(bais);

            // 读取对象
            device = (T) bis.readObject();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return device;
    }
}
