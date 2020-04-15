package com.dolphin422.system.multithreading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2020/4/15 16:53
 */
public class RunnableThread implements Runnable {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(RunnableThread.class);

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
        RunnableThread Thread1=new RunnableThread();
        Thread myThread1=new Thread(Thread1,"线程1");
        Thread myThread2=new Thread(Thread1,"线程2");
        Thread myThread3=new Thread(Thread1,"线程3");
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }

}
