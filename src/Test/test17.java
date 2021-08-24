package Test;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/8/21 15:54
 * @description:
 */
public class test17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> lists = new ArrayList<>();
        String s = sc.nextLine();
        int a = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                List<Integer> list = new ArrayList<>();
                list.add(j++);
                list.add(Integer.parseInt(s.substring(a,i)));
                lists.add(list);
                a = i + 1;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(j);
        list.add(Integer.parseInt(s.substring(a)));
        lists.add(list);
        Collections.sort(lists, Comparator.comparingInt(o -> o.get(1)));

        int [][] f = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> tmp = lists.get(i);
            f[tmp.get(0)][1] = tmp.get(1);
            if (tmp.get(0) == 0){
                if (f.length > 1){
                    if (f[0][1] > f[1][1])
                        f[0][0] = f[1][0] + 1;
                    else
                        f[0][0] = 1;
                }
            }else if (tmp.get(0) == lists.size() - 1){
                if (f[lists.size()-1][1] > f[lists.size() - 2][1])
                    f[lists.size()-1][0] = f[list.size() - 2][0] + 1;
                else
                    f[lists.size() - 1][0] = 1;
            }else {
                if (f[i][1] == Math.max(f[i-1][1],f[i+1][1]))
                    f[i][0] = Math.max(f[i-1][0],f[i+1][0]);
                else
                    f[i][0] = Math.max(f[i-1][0],f[i+1][0]) + 1;
            }
        }
        int ans = 0;
        for (int[] ints : f) {
            ans += ints[0];
        }
        System.out.println(ans);
    }
}