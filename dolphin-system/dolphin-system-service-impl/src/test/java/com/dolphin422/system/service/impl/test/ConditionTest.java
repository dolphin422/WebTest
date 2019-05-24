package com.dolphin422.system.service.impl.test;

import com.dolphin422.system.service.impl.reentrantlock.ReentrantLockServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.05.24 17:40
 */
public class ConditionTest {
    /**
     * logger
     */
    private  static Logger logger = LoggerFactory.getLogger(ConditionTest.class);

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockServiceImpl reentrantLockService = new ReentrantLockServiceImpl();
        MyThreadA a1 = new MyThreadA(reentrantLockService);
        a1.start();
        Thread.sleep(3000);
        reentrantLockService.signal();


    }
}
