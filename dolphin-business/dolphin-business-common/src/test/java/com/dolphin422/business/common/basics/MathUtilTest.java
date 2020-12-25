package com.dolphin422.business.common.basics;

import com.dolphin422.common.util.MathUtil;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT WIN
 * @createDate: 2018.12.29 15:28
 */
public class MathUtilTest {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(MathUtilTest.class);

    @Test
    public void countAdd() {
        AtomicInteger count = new AtomicInteger();
        logger.info("count---{}", count);
        count.addAndGet(1);
        logger.info("count---{}", count);
    }

    @Test
    public void mathUtilTest() {
        double v = 12345.6789;
        String s = MathUtil.strFormatDouToInt(v);
        logger.info("-----15:35----v值为--------->{}", s);
        logger.info("-15:37-({})---s值为--------->{}", System.currentTimeMillis(), s);
    }

    @Test
    public void intParseTest() {
        String a = "123";
        Double aDouble = Double.valueOf(a);
        logger.info("----15:23({})----integer值为------>{}", System.currentTimeMillis(), aDouble);
    }

    @Test
    public void testConvert() {
        String good1 = "81";
        String good2 = "80";
        String middle1 = "74";
        String middle2 = "60";
        String bad = "59";
        String good1s = this.convertScoreToType(good1);
        logger.info("----16:08({})----good1s------>{}", System.currentTimeMillis(), good1s);
        String good2s = this.convertScoreToType(good2);
        logger.info("----16:08({})----good2s------>{}", System.currentTimeMillis(), good2s);
        String middle1s = this.convertScoreToType(middle1);
        logger.info("----16:08({})----middle1s------>{}", System.currentTimeMillis(), middle1s);
        String middle2s = this.convertScoreToType(middle2);
        logger.info("----16:08({})----middle2s------>{}", System.currentTimeMillis(), middle2s);
        String bads = this.convertScoreToType(bad);
        logger.info("----16:08({})----bads------>{}", System.currentTimeMillis(), bads);
    }

    @Test
    public void strMathAddTest() {
        String firstVersion = "1.0";
        String add = MathUtil.strAdd(firstVersion, firstVersion, 1);
        logger.debug("-----------add------{}", add);
        String add2 = MathUtil.strAdd(add, firstVersion, 1);
        logger.debug("-----------add2------{}", add2);
    }

    /**
     * 转换分数为类型
     *
     * @param commentType
     * @return
     */
    private String convertScoreToType(String commentType) {
        String goodScore = "80";
        String middleScore = "60";
        if (MathUtil.greaterEqualStr(commentType, goodScore)) {
            return "好";
        } else if (MathUtil.greaterEqualStr(commentType, middleScore)) {
            return "中";
        } else {
            return "差";
        }
    }
}
