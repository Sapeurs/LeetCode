package Jdk8.java3;

import org.testng.annotations.Test;

import java.util.Optional;

/**
 * @author: Sapeurs
 * @date: 2021/6/30 15:39
 * @description:
 */
public class OptionalTest {

    /*
    Optional.of(T t) : 创建一个Optional实例，t必须非空
    Optional.empty() : 创建一个空的Optional实例
    Optional.ofNullable(T t) : t可以为null
     */

    @Test
    public void test1() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.of(girl);

    }

    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

    }

    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    @Test
    public void test3() {
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后的getGirlName():
    public String getGirlName1(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional类的getGirlName():
    public String getGirlName2(Boy boy) {
        Optional<Boy> boyOptional = Optional.ofNullable(boy);

        Boy boy1 = boyOptional.orElse(new Boy(new Girl("明里秞")));

        Girl girl = boy1.getGirl();

        Optional<Girl> girlOptional = Optional.ofNullable(girl);
        Girl girl1 = girlOptional.orElse(new Girl("明日花"));

        return girl1.getName();
    }

    @Test
    public void test5() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }
}