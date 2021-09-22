package Test.rongyao;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/9/18 18:51
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] ori = new String[N];
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            ori[i] = sc.nextLine();
        }
        int M = sc.nextInt();
        String[] now = new String[M];
        sc.nextLine();
        for (int i = 0; i < M; i++) {
            now[i] = sc.nextLine();
        }

        Map<String, String> map = new HashMap<>();
        for (String s : ori) {
            map.put(s.substring(0,9),s.substring(9));
        }
        HashMap<String, String> newMap = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : now) {
            String remove = map.get(s.substring(0,9));
            newMap.put(s.substring(10),remove);
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            for (String s : now) {
                if (entry.getKey().equals(s.substring(0,9)) || entry.getKey().equals(s.substring(10))){
                }else {
                    list.add(entry.getKey() + entry.getValue());
                    break;
                }

            }
        }
        for (Map.Entry<String, String> entry : newMap.entrySet()) {
            list.add(entry.getKey()+entry.getValue());
        }
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}