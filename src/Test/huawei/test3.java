package Test.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Spaeurs
 * @date: 2021/9/15 20:09
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> strs = new ArrayList<>();
        while (sc.hasNext()){
           strs.add(sc.nextLine());
        }
        String[] customs = new String[strs.size()];
        Arrays.setAll(customs, strs::get);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < customs.length; i++) {
            
        }
    }
}