package Test;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/8/1 14:41
 * @description:
 */
public class test11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.substring(1,s.length()-1);
        String[] str = s.split(",");
        int size = str.length;
        int[] list = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(str[i]);
        }
        int[] ans = new int[size];
        HashMap<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> list1 = new LinkedList<>();
        Arrays.fill(ans,1);
        for (int i = 0; i < size; i++) {
            if (list[i]>0){
                if (map.containsKey(list[i])){
                    int tmp = map.get(list[i]);
                    if (list1.size() == 0 || list1.getLast() < tmp){
                        System.out.println(Arrays.toString(new int[]{}));
                    }

                    int ti = -1;
                    Iterator<Integer> iterator = list1.iterator();
                    while ((ti = iterator.next())<=tmp);
                    iterator.remove();
                    ans[ti] = list[i];
                }
                map.put(list[i],i);
            }else {
                list1.add(i);
            }
        }
        for (int i :
                list1) {
            ans[i] = -1;
        }
        System.out.println(Arrays.toString(ans));
    }
}