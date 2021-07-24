package ProxyPractise.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 10:50
 * @description: 获取代理对象的工厂类
 */
public class JdkProxyFactory {
    //获取代理对象
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), //目标类的加载
                target.getClass().getInterfaces(), //代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target) //代理对象对应的自定义InvocationHandler
        );
    }
}