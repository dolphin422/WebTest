package com.dolphin422.system.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2020/4/15 16:44
 */
public class ThreadThread extends Thread {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ThreadThread.class);

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            logger.info(threadName + ":i=:" + i);
            sum += i;
        }
        logger.info(threadName + ":sum=:" + sum);
    }

    public static void main(String[] args) {
        ThreadThread myThread1 = new ThreadThread();
        ThreadThread myThread2 = new ThreadThread();
        ThreadThread myThread3 = new ThreadThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }


}
