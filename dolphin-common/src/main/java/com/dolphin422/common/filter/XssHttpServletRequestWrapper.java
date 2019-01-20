package com.dolphin422.common.filter;

import com.dolphin422.common.exception.BusinessException;
import com.dolphin422.common.util.SqlInjectionUtil;
import org.apache.commons.lang3.StringEscapeUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Description: Xss过滤+SQL关键字校验
 * @author: DamonJT MAC
 * @createDate: 2018/12/22 22:30
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {

    XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Map<String, String[]> getParameterMap() throws BusinessException {
        Map<String, String[]> parameterMap = super.getParameterMap();
        Iterator iterator = parameterMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry me = (Map.Entry) iterator.next();
            String[] values = (String[]) me.getValue();
            for (int i = 0; i < values.length; i++) {
                values[i] = this.xssCleanSqlCheck(values[i]);
            }
        }
        return parameterMap;
    }


    /**
     * 获取参数值
     *
     * @param paramString 参数
     * @return 参数
     * @throws BusinessException 异常
     */
    @Override
    public String[] getParameterValues(String paramString) throws BusinessException {
        String[] arrayOfString1 = super.getParameterValues(paramString);
        if (arrayOfString1 == null) {
            return null;
        }
        int i = arrayOfString1.length;
        String[] arrayOfString2 = new String[i];
        for (int j = 0; j < i; j++) {
            arrayOfString2[j] = this.xssCleanSqlCheck(arrayOfString1[j]);
        }
        return arrayOfString2;
    }

    /**
     * 获取参数
     *
     * @param paramString 参数
     * @return 参数
     * @throws BusinessException 异常
     */
    @Override
    public String getParameter(String paramString) throws BusinessException {
        String str = super.getParameter(paramString);
        if (str == null) {
            return null;
        }
        return this.xssCleanSqlCheck(str);
    }

    /**
     * 清除请求头换行
     *
     * @param paramString 参数
     * @return 返回
     * @throws BusinessException 异常
     */
    @Override
    public String getHeader(String paramString) throws BusinessException {
        String str = super.getHeader(paramString);
        if (str == null) {
            return null;
        }
        String emptyStr = "";
        String lineBreak = "\r|\n";
        str = str.replaceAll(lineBreak, emptyStr);
        return this.xssCleanSqlCheck(str);
    }

    /**
     * Xss清除+Sql关键字校验
     *
     * @param paramStr 参数
     * @return 参数
     * @throws BusinessException
     */
    private String xssCleanSqlCheck(String paramStr) throws BusinessException {
        //paramStr = this.xssClean(paramStr);
        //paramStr = HtmlUtils.htmlEscape(paramStr);
        paramStr = StringEscapeUtils.escapeHtml4(paramStr);
        SqlInjectionUtil.checkSQLInjection(paramStr);
        return paramStr;
    }

    /**
     * 清除会引入XSS漏洞的字符
     *
     * @param value
     * @return
     */
    private String xssClean(String value) throws BusinessException {
        if (null == value) {
            return null;
        }
        String emptyStr = "";
        String space = "\0";
        // NOTE: It's highly recommended to use the ESAPI library and
        // uncomment the following line to
        // avoid encoded attacks.
        // value = encoder.canonicalize(value);
        value = value.replaceAll(space, emptyStr);
        // Avoid anything between script tags
        value = BETWEEN_SCRIPT_TAGS_PATTERN.matcher(value).replaceAll(emptyStr);
        // Avoid anything in a src='...' type of expression
        value = SRC_PATTERN.matcher(value).replaceAll(emptyStr);

        // Remove any lonesome </script> tag
        value = SCRIPT_TAG_PATTERN.matcher(value).replaceAll(emptyStr);

        // Remove any lonesome <script ...> tag
        value = SCRIPT_TAGS_PATTERN.matcher(value).replaceAll(emptyStr);

        // Avoid eval(...) expressions
        value = EVAL_PATTERN.matcher(value).replaceAll(emptyStr);

        // Avoid expression(...) expressions
        value = EXPRESSION_PATTERN.matcher(value).replaceAll(emptyStr);

        // Avoid javascript:... expressions
        value = JAVASCRIPT_PATTERN.matcher(value).replaceAll(emptyStr);

        // Avoid vbscript:... expressions
        value = VBSCRIPT_PATTERN.matcher(value).replaceAll(emptyStr);

        // Avoid onload= expressions
        value = ONLOAD_PATTERN.matcher(value).replaceAll(emptyStr);

        return value;
    }

    /**
     * Avoid anything between script tags
     */
    private static final String BETWEEN_SCRIPT_TAGS_REG = "<script>(.*?)</script>";
    private static Pattern BETWEEN_SCRIPT_TAGS_PATTERN = Pattern
            .compile(BETWEEN_SCRIPT_TAGS_REG, Pattern.CASE_INSENSITIVE);

    /**
     * Avoid anything in a src='...' type of expression
     */
    private static final String SRC_REG = "src[\r\n]*=[\r\n]*\\\'(.*?)\\\'";
    private static Pattern SRC_PATTERN = Pattern
            .compile(SRC_REG, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

    /**
     * Remove any lonesome </script> tag
     */
    private static final String SCRIPT_TAG_REG = "</script>";
    private static Pattern SCRIPT_TAG_PATTERN = Pattern.compile(SCRIPT_TAG_REG, Pattern.CASE_INSENSITIVE);

    /**
     * Remove any lonesome <script ...> tag
     */
    private static final String SCRIPT_TAGS_REG = "<script(.*?)>";
    private static Pattern SCRIPT_TAGS_PATTERN = Pattern
            .compile(SCRIPT_TAGS_REG, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

    /**
     * Avoid eval(...) expressions
     */
    private static final String EVAL_REG = "eval\\((.*?)\\)";
    private static Pattern EVAL_PATTERN = Pattern
            .compile(EVAL_REG, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

    /**
     * Avoid expression(...) expressions
     */
    private static final String EXPRESSION_REG = "expression\\((.*?)\\)";
    private static Pattern EXPRESSION_PATTERN = Pattern
            .compile(EXPRESSION_REG, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);

    /**
     * Avoid javascript:... expressions
     */
    private static final String JAVASCRIPT_REG = "javascript:";
    private static Pattern JAVASCRIPT_PATTERN = Pattern.compile(JAVASCRIPT_REG, Pattern.CASE_INSENSITIVE);

    /**
     * Avoid vbscript:... expressions
     */
    private static final String VBSCRIPT_REG = "vbscript:";
    private static Pattern VBSCRIPT_PATTERN = Pattern.compile(VBSCRIPT_REG, Pattern.CASE_INSENSITIVE);

    /**
     * Avoid onload= expressions
     */
    private static final String ONLOAD_REG = "onload(.*?)=";
    private static Pattern ONLOAD_PATTERN = Pattern
            .compile(ONLOAD_REG, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);


}
