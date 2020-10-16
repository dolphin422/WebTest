package com.dolphin422.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2020/10/11 10:59
 */
public class BasicTest {

    /**
     * logger
     */
    private static final Logger logger = LoggerFactory.getLogger(BasicTest.class);


    @Test
    public void tryCatchTest() {
        int a = 0;
        int b = 0;
        logger.info("0-a的值{}，b的值{}", a, b);
        int intAdd = getIntAdd(a, b);
        logger.info("5-a的值{}，b的值{}", a, b);
        logger.info("result=={}", intAdd);
    }

    /**
     * 进入finally语句时， try或catch中 return语句 a++ ，a += 10已执行完毕，a的值已被改写，暂存，执行完finall中语句后，将该值返回
     * 若finally中有return,直接返回finally中return值
     *
     * @param a
     * @param b
     * @return
     */
    private int getIntAdd(int a, int b) {
        try {
            a++;
            logger.info("1-a的值{}，b的值{}", a, b);
            b++;
            logger.info("2-a的值{}，b的值{}", a, b);
            int c = 9 / 0;
            return a++;
        } catch (Exception ex) {
            logger.info("3-a的值{}，b的值{}", a, b);
            return a += 10;
        } finally {
            logger.info("4-a的值{}，b的值{}", a, b);
            //return a += 100;
            return 20;
        }
    }
}
