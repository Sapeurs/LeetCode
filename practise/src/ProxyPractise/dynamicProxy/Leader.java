package ProxyPractise.dynamicProxy;

/**
 * @author: Sapeurs
 * @date: 2021/4/15 11:08
 * @description: 定义领导类，实现开会功能
 */
public class Leader implements IWork {
    @Override
    public void meeting() {
        System.out.println("领导组织会议");
    }
}