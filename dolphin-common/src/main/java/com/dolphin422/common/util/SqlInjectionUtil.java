package com.dolphin422.common.util;

import com.dolphin422.common.enumeration.statuscode.business.BusinessStatusCodeEnum;
import com.dolphin422.common.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: sql关键字校验
 * 含路径参数 ../
 * @author: DamonJT MAC
 * @createDate: 2018/12/22 22:52
 */
public class SqlInjectionUtil {

    private static Logger logger = LoggerFactory.getLogger(SqlInjectionUtil.class);
    /**
     * 过滤规则
     * ../ 防止路径遍历
     * 英文单词为 Sql关键字
     */
    private static final String REG =
            "\\.\\./|(\\b" + "(union|insert|select|delete|update|drop|alter|truncate|declare|xp_)\\b)";

    private static final Pattern SQL_PATTERN = Pattern.compile(REG, Pattern.CASE_INSENSITIVE);

    /**
     * 字符串过滤,防止SQL注入
     *
     * @param str 待校验的字符串
     */
    public static void checkSQLInjection(String str) throws BusinessException {
        str = str.toLowerCase().trim();
        Matcher matcher = SQL_PATTERN.matcher(str);
        if (matcher.find()) {
            logger.debug("未能通过校验的字符为---->({})", matcher.group(0));
            logger.debug("传入的原始字符串为---->({})", str);
            throw new BusinessException(BusinessStatusCodeEnum.ILLEGAL_ARGUMENT,
                    "所提交内容含有未通过校验字符,请检查。该字符为：{}", matcher.group(0));
        }
    }
}
