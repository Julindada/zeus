package cn.celitea.zeus.common.utils;

import java.util.regex.Pattern;

/**
 * 字符串工具类
 * <p>
 * Created by julin on 2019/11/5
 */
public class StringUtils {

    /**
     * 判断字符串是否为数字
     *
     * @param str 字符串
     * @return
     */
    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) return false;
        Pattern pattern = Pattern.compile("^[0-9]*$");
        return pattern.matcher(str).matches();
    }

    /**
     * 判断字符串是否为n位数字
     *
     * @param str 字符串
     * @param n 数字位数
     * @return
     */
    public static boolean isNumeric(String str, int n) {
        if (str == null || str.length() == 0) return false;
        Pattern pattern = Pattern.compile("^\\d{" + n + "}$");
        return pattern.matcher(str).matches();
    }

    public static String[] splitStr(String str, String regex) {
        if (str == null || str.length() == 0) return new String[]{};
        return str.split(regex);
    }
}
