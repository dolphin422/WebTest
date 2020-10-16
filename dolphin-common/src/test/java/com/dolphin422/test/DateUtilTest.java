package com.dolphin422.test;

import com.dolphin422.common.util.DateUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT WIN
 * @createDate: 2019.01.02 17:56
 */
public class DateUtilTest {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(DateUtilTest.class);

    @Test
    public void getCurrentDateTimeTest() {
        String currentDateTime = DateUtil.getCurrentDateTime();
        logger.info("--{}--currentDateTime值为------>{}", System.currentTimeMillis(), currentDateTime);
        String currentDate = DateUtil.getCurrentDate();
        logger.info("--{}--currentDate 值为------>{}", System.currentTimeMillis(), currentDate);
        String currentTime = DateUtil.getCurrentTime();
        logger.info("--{}--currentTime 值为------>{}", System.currentTimeMillis(), currentTime);
    }

}
