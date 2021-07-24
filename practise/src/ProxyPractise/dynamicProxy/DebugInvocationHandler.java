package ProxyPractise.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 10:17
 * @description: 定义一个JDK动态代理类实现InvocationHandler接口，并实现invoke方法
 */
public class DebugInvocationHandler implements InvocationHandler {

    //代理类中的真实对象
    private final Object target;

    public DebugInvocationHandler(Object target) {
        this.target = target;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("object: " + target.getClass().getSimpleName());
        System.out.println("proxy: " + proxy.getClass().getSimpleName());

        //调用方法之前，我们可以添加自己的操作
        //System.out.println("发送短信之前。。。"+method.getName());
        System.out.println("领导开会之前进行准备工作" + method.getName());
        //调用被代理类的方法
        Object result = method.invoke(target, args);
        //调用方法之后，我们同样可以添加自己的操作
        //System.out.println("发送短信之后。。。"+method.getName());
        System.out.println("领导开完会了" + method.getName());
        return result;
    }
}