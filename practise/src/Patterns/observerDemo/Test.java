package Patterns.observerDemo;

/**
 * 测试类
 * @author: Spaeurs
 * @date: 2021/8/28 14:55
 * @description:
 */
public class Test {
    public static void main(String[] args) {
        Server server = new Server();

        User user1 = new User("user1");
        User user2 = new User("user2");
        User user3 = new User("user3");

        server.registerObserver(user1);
        server.registerObserver(user2);
        server.registerObserver(user3);

        server.setInformation("服务器发布新消息了");

        System.out.println("------------------------------");
        server.removeObserver(user1);
        server.setInformation("服务器又发布了一条消息");
    }
}