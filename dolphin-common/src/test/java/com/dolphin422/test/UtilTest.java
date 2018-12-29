package com.dolphin422.test;

import com.dolphin422.common.util.MathUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT WIN
 * @createDate: 2018.12.29 15:28
 */
public class UtilTest {
    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(UtilTest.class);

    @Test
    public void mathUtilTest() {
        double v = 12345.6789;
        String s = MathUtil.strFormatDouToInt(v);
        logger.info("-----15:35----v值为--------->{}", s);
        logger.info("-15:37-({})---s值为--------->{}",System.currentTimeMillis(),s);
    }
}
