package com.dolphin422.system.service.impl.test;


import com.dolphin422.system.service.api.reentrantlock.IReentrantLockService;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.05.24 17:11
 */
public class MyThreadA extends Thread {

    private IReentrantLockService reentrantLockService;

    public MyThreadA(IReentrantLockService reentrantLockService) {
        super();
        this.reentrantLockService = reentrantLockService;
    }

    @Override
    public void run() {
        reentrantLockService.await();
    }
}
