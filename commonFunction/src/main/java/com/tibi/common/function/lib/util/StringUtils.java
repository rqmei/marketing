package com.tibi.common.function.lib.util;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import androidx.core.content.ContextCompat;

/**
 * StringUtil
 * -----------------------------------------------------------------------------------------------------------------------------------
 * 字符串管理工具类
 *
 * @author rqmei on 2018/4/24
 */

public class StringUtils {
    /**
     * 判断给定字符串是否空白串。 空白串是指由空格、制表符、回车符、换行符组成的字符串 若输入字符串为null或空字符串，返回true
     *
     * @param input
     * @return boolean
     */
    public static boolean isEmpty(String input) {
        if (input == null || "".equals(input) || input.equals("null") || input.equals("NULL"))
            return true;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c != ' ' && c != '\t' && c != '\r' && c != '\n') {
                return false;
            }
        }
        return true;
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static String parse(String strDate, String pattern) {
        Log.i("parse","strDate"+strDate);
        if (isEmpty(strDate)) {
            return "";
        }
        try {
            // 字符串到日期 "yyyy-MM-dd'T'HH:mm:ssZ"
            SimpleDateFormat  dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date dd = dateFormat.parse(strDate);
            Log.i("parse","dd"+dd);
            // 日期到师傅串
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            Log.i("parse","转是付出pattern"+pattern);
            return sdf.format(dd);
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }

}
