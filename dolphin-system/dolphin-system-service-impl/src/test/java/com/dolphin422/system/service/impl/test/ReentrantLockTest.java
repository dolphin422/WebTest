package com.dolphin422.system.service.impl.test;

import com.dolphin422.system.service.impl.reentrantlock.ReentrantLockServiceImpl;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.05.24 16:57
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLockServiceImpl reentrantLockService = new ReentrantLockServiceImpl();
        MyThread a1 = new MyThread(reentrantLockService);
        MyThread a2 = new MyThread(reentrantLockService);
        MyThread a3 = new MyThread(reentrantLockService);
        MyThread a4 = new MyThread(reentrantLockService);
        MyThread a5 = new MyThread(reentrantLockService);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }

}
