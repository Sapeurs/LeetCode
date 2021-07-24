package ProxyPractise.dynamicProxy;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 10:53
 * @description:
 */
public class Main {

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        //smsService.send("Java");

        IWork iWork = (IWork) JdkProxyFactory.getProxy(new Leader());
        iWork.meeting();

    }

}