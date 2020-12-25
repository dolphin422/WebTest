package com.dolphin422.business.common.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2020/12/25 18:51
 */
public enum EnumSingleton {
    INSTANCE;

    /**
     * logger
     */
    private final Logger logger = LoggerFactory.getLogger(EnumSingleton.class);

    public void doSomething(String name) {
        logger.info("name", name);
    }

    public static void main(String[] args) {
        EnumSingleton.INSTANCE.doSomething("abc");
    }
}
