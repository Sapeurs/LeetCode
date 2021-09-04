package Test.thoughtWorks;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author: Spaeurs
 * @date: 2021/9/4 15:03
 * @description:
 */
public class test {
    public static void main(String[] args) {
        System.out.println(possibleCombinations(12));
    }

    public static String possibleCombinations(int numbers) {
        int a = numbers%10;
        int b = numbers/10;
        ArrayList<String> list = new ArrayList<>();
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1,"");
        map.put(0,"");
        map.put(2,"ABC");
        map.put(3,"DEF");
        map.put(4,"GHI");
        map.put(5,"JKL");
        map.put(6,"MNO");
        map.put(7,"PQRS");
        map.put(8,"TUV");
        map.put(9,"WXYZ");
        if (b==0||b==1){
            if (a==0||a==1)
                return "N/A";
            else
                for (int i = 0; i < map.get(a).length(); i++) {
                    list.add(String.valueOf(map.get(a).charAt(i)));
                }
        }
        for (int i = 0; i < map.get(b).length(); i++) {
            if (a == 0 || a== 1){
                list.add(String.valueOf(map.get(b).charAt(i)));
            }else {
                for (int j = 0; j < map.get(a).length(); j++) {
                    list.add(map.get(b).charAt(i) + "" + map.get(a).charAt(j));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (String s :list) {
            ans.append(s);
            ans.append(" ");
        }
        return ans.toString().trim();
    }
}