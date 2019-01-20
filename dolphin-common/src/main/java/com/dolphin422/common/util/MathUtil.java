package com.dolphin422.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Description: 计算工具类
 * @author: DamonJT WIN
 * @createDate: 2018.12.29 15:05
 */
public class MathUtil {

    /**
     * 默认小数精确的位数
     */
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和 double
     */
    public static double douAdd(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算。
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和 big decimal
     */
    public static BigDecimal bigAdd(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);
    }

    /**
     * 提供精确的加法运算。 String
     *
     * @param v1    被加数
     * @param v2    加数
     * @param scale 保留小数位数（小数点后位数）
     * @return 两个参数的和 string
     */
    public static String strAdd(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差 double
     */
    public static double douSub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差 big decimal
     */
    public static BigDecimal bigSub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2);
    }

    /**
     * 提供精确的减法运算。String
     *
     * @param v1    被减数
     * @param v2    减数
     * @param scale 小数位数
     * @return 两个参数的差 string
     */
    public static String strSub(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积 double
     */
    public static double douMul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。 保留scale 位小数
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 小数位数
     * @return 两个参数的积 double
     */
    public static double douMul(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return douRound(b1.multiply(b2).doubleValue(), scale);
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积 big decimal
     */
    public static BigDecimal bigMul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2);
    }

    /**
     * 提供精确的乘法运算。 保留scale 位小数 String
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 小数位数
     * @return 两个参数的积 string
     */
    public static String strMul(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return 两个参数的商 double
     */
    public static double douDiv(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商 double
     */
    public static double douDiv(double v1, double v2) {
        return douDiv(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return 两个参数的商 big decimal
     */
    public static BigDecimal bigDiv(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商 big decimal
     */
    public static BigDecimal bigDiv(String v1, String v2) {
        return bigDiv(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 精确的除法运算。除不尽时，由scale参数指 定精度 四舍五入。string
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示需要精确到小数点以后几位。
     * @return 两个参数的商 string
     */
    public static String strDiv(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 取余数 BigDecimal
     *
     * @param v1    the v 1
     * @param v2    the v 2
     * @param scale the scale
     * @return big decimal
     */
    public static BigDecimal bigRemainder(BigDecimal v1, BigDecimal v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        return v1.remainder(v2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 取余数 string
     *
     * @param v1    the v 1
     * @param v2    the v 2
     * @param scale the scale
     * @return big decimal
     */
    public static BigDecimal bigRemainder(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 取余数 string
     *
     * @param v1    the v 1
     * @param v2    the v 2
     * @param scale the scale
     * @return string string
     */
    public static String strRemainder(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.remainder(b2).setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果 double
     */
    public static double douRound(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 对一个数字取精度
     *
     * @param v     the v
     * @param scale 小数位数
     * @return big decimal
     */
    public static BigDecimal bigRound(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * 提供精确的小数位四舍五入处理。string
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果 string
     */
    public static String strRound(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, BigDecimal.ROUND_HALF_UP).toString();
    }

    /**
     * format double to String
     *
     * @param s      the s
     * @param format 例如###,##0.00 表示精确到小数点后两位，无千分位
     * @return string string
     */
    public static String strFormatDou(double s, String format) {
        DecimalFormat df = new DecimalFormat(format);
        return df.format(s);
    }

    /**
     * 取整 四舍五入，不带千分位
     *
     * @param s the s
     * @return string string
     */
    public static String strFormatDouToInt(double s) {
        //带千分位 "###,##0"  不带"##0"
        return strFormatDou(s, "##0");
    }

    /**
     * 比较大小  大于
     * 如果v1 大于v2 则 返回true 否则false
     *
     * @param v1 the v 1
     * @param v2 the v 2
     * @return boolean boolean
     */
    public static boolean greaterStr(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        return bj > 0;
    }

    /**
     * 比较大小  等于
     * 如果v1 等于v2 则 返回true 否则false
     *
     * @param v1 the v 1
     * @param v2 the v 2
     * @return boolean boolean
     */
    public static boolean equalStr(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        return bj == 0;
    }

    /**
     * 比较大小  大于等于
     * 如果v1 大于等于v2 则 返回true 否则false
     *
     * @param v1 the v 1
     * @param v2 the v 2
     * @return boolean boolean
     */
    public static boolean greaterEqualStr(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        return bj >= 0;
    }
}
