package com.dolphin422.main.proxy;

import com.dolphin422.system.service.api.user.ISysUserService;
import com.dolphin422.system.service.impl.user.SysUserServiceImpl;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 动态代理
 * @author: DamonJT MAC
 * @createDate: 2019-07-07 15:20
 */
public class ProxyTest {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ProxyTest.class);

    public static void main(String[] args) throws Throwable {
        //参数1:要代理接口的类加载器
        //参数2:要代理接口的class,代理对象需要与目标对象实现相同的接口
        Class<?> proxyClass = Proxy.getProxyClass(SysUserServiceImpl.class.getClassLoader(), ISysUserService.class);
        //传入  InvocationHandler
        Constructor<?> constructor = proxyClass.getConstructor(InvocationHandler.class);
        ISysUserService proxyService = (ISysUserService) constructor.newInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                SysUserServiceImpl sysUserServiceImpl = new SysUserServiceImpl();
                Object result = method.invoke(sysUserServiceImpl, args);
                return result;
            }
        });
        String userName = proxyService.getUserName("2011101");
        logger.info("----userName------{}", userName);
    }
}
