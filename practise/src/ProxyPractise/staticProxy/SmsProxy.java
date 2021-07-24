package ProxyPractise.staticProxy;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 10:02
 * @description: 创建一个代理类并同样实现发送短信的接口
 */
public class SmsProxy implements SmsService {

    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String msg) {

        //调用方法之前，我们可以添加自己的操作
        System.out.println("发送短信之前。。。");
        //调用被代理类的方法
        smsService.send(msg);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("发送短信之后。。。");
        return null;
    }
}