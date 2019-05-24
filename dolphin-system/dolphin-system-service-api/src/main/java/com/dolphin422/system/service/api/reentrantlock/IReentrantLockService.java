package com.dolphin422.system.service.api.reentrantlock;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019.05.24 16:24
 */
public interface IReentrantLockService {

    void await();

    void signal();
}
