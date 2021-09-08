package Test.baidu;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/9/7 19:45
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        sub(s.toCharArray(),0,"",k);
        int count = 0;
        for (String str :list) {
            if (isContain(str,k))
                count++;
        }
        System.out.println(count);
    }
    static List<String> list = new ArrayList<>();
    static void sub(char[] chars, int i, String ans, int k){
        if (i== chars.length){
            if (ans.length() < k)
                return;
            list.add(ans);
            return;
        }
        sub(chars, i+1, ans,k);
        sub(chars, i+1, ans + chars[i],k);
    }

    static boolean isContain(String s, int k){
        HashSet<Character> set = new HashSet<>();
        for (char c :s.toCharArray()) {
            set.add(c);
        }
        return set.size() == k;
    }
}