package com.dolphin422.system.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2020/4/15 16:27
 */
public class CallableThread implements Callable<String> {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(CallableThread.class);
    private int seconds;
    private String name;

    public CallableThread(String name, int seconds) {
        this.name = name;
        this.seconds = seconds;
    }

    @Override
    public String call() throws InterruptedException {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();
        Thread.sleep(seconds * 1000);
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            logger.info(threadName + ":i=:" + i);
            sum += i;
        }
        logger.info(threadName + ":sum=:" + sum);
        logger.info(threadName + ":name=:" + seconds);
        return name + seconds + ":" + sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //生成具有两个线程的线程池
        Callable<String> callable1 = new CallableThread("one", 1);
        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        Thread mThread = new Thread(futureTask1);
        Callable<String> callable2 = new CallableThread("two", 10);
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);
        Thread mThread2 = new Thread(futureTask2);
        mThread.start();
        mThread2.start();
        System.out.println("----------1--------");
        String s1 = futureTask1.get();
        System.out.println("futureTask.get():" + s1);
        System.out.println("---------2---------");
        //String s2 = futureTask2.get();
        //System.out.println("futureTask.get():" + s2);
        System.out.println("---------3---------");
    }

}
