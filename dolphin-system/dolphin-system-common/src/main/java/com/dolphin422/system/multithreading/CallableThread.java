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
    private String name;

    public CallableThread(String name) {
        this.name = name;
    }

    @Override
    public String call() {
        Thread thread = Thread.currentThread();
        String threadName = thread.getName();

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            logger.info(threadName + ":i=:" + i);
            sum += i;
        }
        logger.info(threadName + ":sum=:" + sum);
        logger.info(threadName + ":name=:" + name);
        return name + sum;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<String> callable1 = new CallableThread("one");
        FutureTask<String> futureTask1 = new FutureTask<>(callable1);
        Thread mThread = new Thread(futureTask1);
        Callable<String> callable2 = new CallableThread("two");
        FutureTask<String> futureTask2 = new FutureTask<>(callable2);
        Thread mThread2 = new Thread(futureTask2);
        mThread.start();
        mThread2.start();
        System.out.println("----------1--------");
        System.out.println("---------2---------");
        System.out.println("futureTask.get():" + futureTask1.get());
        System.out.println("futureTask.get():" + futureTask2.get());
        System.out.println("---------3---------");
    }

}
