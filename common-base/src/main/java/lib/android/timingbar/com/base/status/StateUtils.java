package lib.android.timingbar.com.base.status;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.IntRange;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Timer;

/**
 * StateUtils
 * -----------------------------------------------------------------------------------------------------------------------------------
 * 状态栏沉浸式
 *
 * @author rqmei on 2019/4/22
 */
public class StateUtils {
    /**
     * 1.修改状态栏颜色，支持4.4以上版本
     *
     * @param activity
     * @param colorId
     */
    public static void setStatusBarColor(Activity activity, int colorId) {
        setStatusBarColor (activity, colorId, 0);
    }

    /**
     * 设置状态栏颜色
     *
     * @param activity       需要设置的activity
     * @param colorId        状态栏颜色值
     * @param statusBarAlpha 状态栏透明度
     */

    public static void setStatusBarColor(Activity activity, @ColorInt int colorId, @IntRange(from = 0, to = 255) int statusBarAlpha) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow ();
            //清除透明状态栏
            window.clearFlags (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置状态栏颜色必须添加
            window.addFlags (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            //设置状态栏颜色及透明度
            window.setStatusBarColor (calculateStatusColor (colorId, statusBarAlpha));
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //使用SystemBarTint库使4.4版本状态栏变色，需要先将状态栏设置为透明
            transparencyBar (activity);
            SystemBarTintManager tintManager = new SystemBarTintManager (activity);
            //显示状态栏
            tintManager.setStatusBarTintEnabled (true);
            //设置状态栏颜色
            tintManager.setStatusBarTintResource (colorId);
        }
    }

    /**
     * 2.修改状态栏文字颜色，这里小米，魅族区别对待。
     */
    public static void setLightStatusBar(final Activity activity, final boolean dark) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            switch (RomUtils.getLightStatusBarAvailableRomType ()) {
                case RomUtils.AvailableRomType.MIUI:
                    MIUISetStatusBarLightMode (activity, dark);
                    break;

                case RomUtils.AvailableRomType.FLYME:
                    setFlymeLightStatusBar (activity, dark);
                    break;

                case RomUtils.AvailableRomType.ANDROID_NATIVE:
                    setAndroidNativeLightStatusBar (activity, dark);
                    break;
                case RomUtils.AvailableRomType.NA:
                    if(dark) {
                        //其他情况下我们将状态栏设置为95白色透明，就不会看不见字体
                        setStatusBarColor (activity, Color.parseColor ("#333333"));//灰色
                    }
                    break;

            }
        }
    }


    /**
     * 小米修改状态栏字体
     *
     * @param activity
     * @param dark
     * @return
     */
    public static boolean MIUISetStatusBarLightMode(Activity activity, boolean dark) {
        boolean result = false;
        Window window = activity.getWindow ();
        if (window != null) {
            Class clazz = window.getClass ();
            try {
                int darkModeFlag = 0;
                Class layoutParams = Class.forName ("android.view.MiuiWindowManager$LayoutParams");
                Field field = layoutParams.getField ("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                darkModeFlag = field.getInt (layoutParams);
                Method extraFlagField = clazz.getMethod ("setExtraFlags", int.class, int.class);
                if (dark) {
                    extraFlagField.invoke (window, darkModeFlag, darkModeFlag);//状态栏透明且黑色字体
                } else {
                    extraFlagField.invoke (window, 0, darkModeFlag);//清除黑色字体
                }
                result = true;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && RomUtils.isMiUIV7OrAbove ()) {
                    //开发版 7.7.13 及以后版本采用了系统API，旧方法无效但不会报错，所以两个方式都要加上
                    if (dark) {
                        activity.getWindow ().getDecorView ().setSystemUiVisibility (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    } else {
                        activity.getWindow ().getDecorView ().setSystemUiVisibility (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
                    }
                }
            } catch (Exception e) {

            }
        }
        return result;
    }

    /**
     * 魅族修改字体颜色
     *
     * @param activity
     * @param dark
     * @return
     */
    private static boolean setFlymeLightStatusBar(Activity activity, boolean dark) {
        boolean result = false;
        if (activity != null) {
            try {
                WindowManager.LayoutParams lp = activity.getWindow ().getAttributes ();
                Field darkFlag = WindowManager.LayoutParams.class
                        .getDeclaredField ("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field meizuFlags = WindowManager.LayoutParams.class
                        .getDeclaredField ("meizuFlags");
                darkFlag.setAccessible (true);
                meizuFlags.setAccessible (true);
                int bit = darkFlag.getInt (null);
                int value = meizuFlags.getInt (lp);
                if (dark) {
                    value |= bit;
                } else {
                    value &= ~bit;
                }
                meizuFlags.setInt (lp, value);
                activity.getWindow ().setAttributes (lp);
                result = true;
            } catch (Exception e) {
            }
        }
        return result;
    }

    /**
     * 谷歌原生方式修改
     * 设置6.0的字体
     *
     * @param activity
     * @param dark
     */
    @SuppressLint("InlinedApi")
    private static void setAndroidNativeLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow ().getDecorView ();
        if (dark) {
            decor.setSystemUiVisibility (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    /**
     * 设置状态栏透明，启用全屏模式
     *
     * @param activity
     */
    @TargetApi(19)
    public static void transparencyBar(Activity activity) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow ();
            window.clearFlags (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags (WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor (Color.TRANSPARENT);
            window.getDecorView ().setSystemUiVisibility (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = activity.getWindow ();
            window.setFlags (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    /**
     * 计算状态栏颜色
     *
     * @param color color值
     * @param alpha alpha值
     * @return 最终的状态栏颜色
     */
    private static int calculateStatusColor(@ColorInt int color, int alpha) {
        if (alpha == 0) {
            return color;
        }
        float a = 1 - alpha / 255f;
        int red = color >> 16 & 0xff;
        int green = color >> 8 & 0xff;
        int blue = color & 0xff;
        red = (int) (red * a + 0.5);
        green = (int) (green * a + 0.5);
        blue = (int) (blue * a + 0.5);
        return 0xff << 24 | red << 16 | green << 8 | blue;
    }
    
    
}
