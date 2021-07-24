package ProxyPractise.staticProxy;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 10:05
 * @description: Main测试
 */
public class Main {
    public static void main(String[] args) {
        SmsServiceImpl smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("Java");
    }
}