package Test.ZTE;

/**
 * @author: Spaeurs
 * @date: 2021/9/10 10:57
 * @description:
 */
public class test2 {

    public static void main(String[] args) {
        System.out.println(DoubleNumber(3154354L));
    }

    public static int DoubleNumber(Long n){
        long i = 1;
        int count = 0;
        while (Long.parseLong(String.valueOf(i) + i) <= n){
            i++;
            count++;
        }
        return count;
    }

}