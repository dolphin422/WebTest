package com.dolphin422.system.service.impl.reentrantlock;

import com.dolphin422.common.base.BaseServiceImpl;
import com.dolphin422.common.base.IMyThreadService;
import com.dolphin422.system.service.api.reentrantlock.IReentrantLockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.05.24 16:25
 */
public class ReentrantLockServiceImpl extends BaseServiceImpl implements IReentrantLockService, IMyThreadService {

    /**
     * logger
     */
    private Logger logger = LoggerFactory.getLogger(ReentrantLockServiceImpl.class);

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            logger.info("--时间:{}--AA----", System.currentTimeMillis());
            condition.await();
            int holdCount = lock.getHoldCount();
            int queueLength = lock.getQueueLength();
            int waitQueueLength = lock.getWaitQueueLength(condition);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void signal() {
        try {
            lock.lock();
            logger.info("--时间:{}--signal--1--", System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();

        }
    }

    @Override
    public void run() {
        lock.lock();


        for (int i = 0; i < 5; i++) {
            logger.info("ThreadName=" + Thread.currentThread().getName() + (" " + (i + 1)));
        }
        lock.unlock();
    }
}
