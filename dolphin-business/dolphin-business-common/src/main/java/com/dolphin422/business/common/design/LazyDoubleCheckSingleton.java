package com.dolphin422.business.common.design;

/**
 * @Description: 懒汉式双检查单例模式
 * @author: DamonJT MAC
 * @createDate: 2020/12/25 18:47
 */
public class LazyDoubleCheckSingleton {

    private LazyDoubleCheckSingleton() {
    }

    private static volatile LazyDoubleCheckSingleton lazy = null;

    public static LazyDoubleCheckSingleton getInstance() {
        if (null == lazy) {
            synchronized (LazyDoubleCheckSingleton.class) {
                if (null == lazy) {
                    lazy = new LazyDoubleCheckSingleton();
                }
            }
        }
        return lazy;
    }


}

