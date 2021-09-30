package Test.jianxin;

/**
 * @author: Spaeurs
 * @date: 2021/9/25 19:05
 * @description:
 */
public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().func(3, 4));
        int i = 100, j,cnt = 0;
        while (i>0){
            for (j = 0; j <= 100; j++) {
                cnt++;
            }
            i = i >> 1;
        }
        System.out.println(cnt);
    }
}

class Solution{
    int func(int a, int b){
        if(a<=0|| b<=0) return 1;
        if (a%2 != b%2 )return func(a-1,b)+func(a,b-1);
        else return func(a-1,b)*2;
    }
}