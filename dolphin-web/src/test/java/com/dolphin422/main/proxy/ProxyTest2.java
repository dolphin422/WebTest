package com.dolphin422.main.proxy;

import com.dolphin422.system.service.api.user.ISysUserService;
import com.dolphin422.system.service.impl.user.SysUserServiceImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description:
 * @author: DamonJT MAC
 * @createDate: 2019-07-07 15:33
 */
public class ProxyTest2 {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ProxyTest2.class);


    public static void main(String[] args) throws Exception {
        //传入目标对象
        SysUserServiceImpl target = new SysUserServiceImpl();
        //目的：1.根据它实现的接口生成代理对象 2.代理对象调用目标对象方法
        ISysUserService proxyService = (ISysUserService) getProxy(target);
        proxyService.getUserName("12");
    }

    private static Object getProxy(final Object target) throws Exception {
        //参数1：随便找个类加载器给它， 参数2：目标对象实现的接口，让代理对象实现相同接口
        Class<?> proxyClass = Proxy.getProxyClass(target.getClass().getClassLoader(), target.getClass().getInterfaces());
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        Object proxyTarget = constructor.newInstance((InvocationHandler) (proxy, method, args) -> {
            logger.info(method.getName() + "方法开始执行...");
            Object result = method.invoke(target, args);
            logger.info("执行结果：{}", result);
            logger.info("{}方法执行结束。", method.getName());
            return result;
        });
        return proxyTarget;

    }
}
