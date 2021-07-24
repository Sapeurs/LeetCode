package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: Sapeurs
 * @date: 2021/5/8 19:33
 * @description:
 */
public class test10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        long n = sc.nextLong();
        Map<Character, Long> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            } else {
                hashMap.put(s.charAt(i), 1L);
            }
        }
        long max = 0L;
        long min = 1000L;
        if (s.length() > n) {
            s = s.substring(0, (int) n);
            hashMap.clear();
            for (int i = 0; i < s.length(); i++) {
                if (hashMap.containsKey(s.charAt(i))) {
                    hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
                } else {
                    hashMap.put(s.charAt(i), 1L);
                }
                max = Math.max(max, hashMap.get(s.charAt(i)));
                min = Math.min(min, hashMap.get(s.charAt(i)));
            }
        } else {
            //要重复的字符串数量
            long num = (n - s.length()) / s.length();
            //额外的字符
            int add = Math.toIntExact(n % s.length());
            for (char c :
                    hashMap.keySet()) {
                hashMap.put(c, hashMap.get(c) + hashMap.get(c) * num);
                max = Math.max(max, hashMap.get(c));
                min = Math.min(min, hashMap.get(c));
            }
            for (int i = 0; i < add; i++) {
                if (hashMap.containsKey(s.charAt(i))) {
                    hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
                }
                max = Math.max(max, hashMap.get(s.charAt(i)));
                min = Math.min(min, hashMap.get(s.charAt(i)));
            }
        }
        boolean isPrime = true;
        long k = (long) Math.sqrt(max - min);
        for (long i = 2; i <= k; i++) {
            if ((max - min) % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            System.out.println("Yes");
        else
            System.out.println("NO");
        System.out.println(max - min);
    }
}

