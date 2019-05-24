package com.dolphin422.system.service.impl.reentrantlock;

import com.dolphin422.common.base.BaseServiceImpl;
import com.dolphin422.common.base.IMyThreadService;
import com.dolphin422.system.service.api.reentrantlock.IReentrantLockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.locks.Condition;
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

    @Override
    public void await() {
        try {
            lock.lock();
            logger.info("--时间:{}--AA----", System.currentTimeMillis());
            condition.await();
            //查询当前线程保持此锁定的个数
            int holdCount = lock.getHoldCount();
            //返回正等待获取此锁定的线程估计数
            int queueLength = lock.getQueueLength();
            //返回等待与此锁定相关的给定条件Condition的线程计数
            int waitQueueLength = lock.getWaitQueueLength(condition);

            //判断是不是公平锁：默认情况下，ReentrantLock使用的是非公平锁
            boolean isFair = lock.isFair();
            //查询当前线程是否保持此锁定
            boolean heldByCurrentThread = lock.isHeldByCurrentThread();
            //查询此锁定是否由任意线程保持
            boolean locked = lock.isLocked();


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
