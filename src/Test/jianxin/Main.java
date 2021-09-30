package Test.jianxin;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/9/25 19:39
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        int n = sc.nextInt();
        int[] pages = new int[n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!set.contains(pages[i])){
                res++;
                if (queue.size() == cap){
                    set.remove(queue.poll());
                }
                queue.add(pages[i]);
                set.add(pages[i]);
            }
        }
        System.out.println(res);
    }
}