package com.dolphin422.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.05.17 15:51
 */
public class StringTest {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(StringTest.class);

    @Test
    public void StringFormatTest() {
        String wholeStr = "this is a test String , id = %s , pwd = %s , this is ok";
        String id = "AbCdEfGh";
        String pwd = "ZxYG";
        String format = String.format(wholeStr, id, pwd);
        logger.info("-----------------{}--format值为---->{}", System.currentTimeMillis(), format);

    }
}
