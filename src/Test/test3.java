package Test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author: Sapeurs
 * @date: 2021/4/29 19:02
 * @description:
 */
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer, Integer> map1 = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (!map1.containsKey(nums[i])) {
                map1.put(nums[i], 1);
            } else {
                map1.put(nums[i], map1.get(nums[i]) + 1);
            }
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry :
                map1.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
                break;
            }
        }
        System.out.println(ans);
    }
}