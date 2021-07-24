package ProxyPractise.dynamicProxy;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 10:01
 * @description: 实现发送短信的接口
 */
public class SmsServiceImpl implements SmsService {
    @Override
    public String send(String msg) {
        System.out.println(msg);
        return msg;
    }
}