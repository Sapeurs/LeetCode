package Test;

/**
 * @author: Spaeurs
 * @date: 2021/10/15 17:26
 * @description:
 */
public class MainTest {
    public static void main(String[] args) {

        int left = 1, right = 1, s = 0;

        while (left <= 50){
            if (s < 100){
                s += right;
                right++;
            }else if (s > 100){
                s -= left;
                left++;
            }else {
                for (int i = left; i < right; i++) {
                    System.out.print(i+" ");
                }
                s -= left;
                left++;
                System.out.println();
            }
        }
    }


}

