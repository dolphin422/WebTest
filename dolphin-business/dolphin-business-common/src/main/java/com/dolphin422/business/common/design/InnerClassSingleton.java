package com.dolphin422.business.common.design;

/**
 * @Description: 存在反射攻击或者反序列化攻击
 * @author: DamonJT MAC
 * @createDate: 2020/12/25 18:57
 */
public class InnerClassSingleton {

    private InnerClassSingleton() {
    }

    private static class InnerClassHolder {

        private static InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

    public InnerClassSingleton getInstance() {
        return InnerClassHolder.innerClassSingleton;
    }

}
