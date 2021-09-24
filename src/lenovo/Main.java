package lenovo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/24 14:32
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String haystack = sc.nextLine();

        int plen = pattern.length(),hlen = haystack.length();
        //if (plen == 0) return;
        int[] lps = new int[plen];
        List<Integer> list = new ArrayList<>();
        int idx = -1;
        for (int i = 1, j = 0; i < plen; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = lps[j-1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)){
                j++;
            }
            lps[i] = j;
        }
        for (int i = 0, j = 0; i < hlen; i++) {
            while (j > 0 &&  pattern.charAt(j)!= haystack.charAt(i)) {
                j = lps[j-1];
            }
            list.add(j);
            if (pattern.charAt(j) == haystack.charAt(i)){
                j++;
            }
            if (j == plen){
                idx = i + 1 - plen;
                break;
            }
        }
        if (idx != -1){
            System.out.println(Arrays.toString(lps));
        }

        for (Integer i :
                list) {
            System.out.println(i);
        }
        if (idx != -1){
            System.out.println("Found at: " + idx);
        }else {
            System.out.println("Not Found");
        }

    }
}