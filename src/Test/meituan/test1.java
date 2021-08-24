package Test.meituan;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/8/22 10:04
 * @description:
 */
public class test1 {

    static List<List<Integer>> ans = new ArrayList<>();
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        isVisited = new boolean[n];
        List<Integer> track = new ArrayList<>();
        dfs(nums,0,track);
        ans.sort((o1, o2) -> {
            for (int i = 0; i < n; i++) {
                if (o1.get(i) > o2.get(i))
                    return 1;
                else if (o1.get(i) < o2.get(i))
                    return -1;
            }
            return o1.get(0) - o2.get(0);
        });
        System.out.println(ans.size());
        for (List<Integer> an : ans) {
            for (int j = 0; j < n; j++) {
                System.out.print(an.get(j) + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int[] nums, int x, List<Integer> track){
        if (x == nums.length){
            ans.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i] || (i>0 && nums[i] == nums[i-1] && !isVisited[i-1]))
                continue;
            track.add(nums[i]);
            isVisited[i] = true;
            dfs(nums,x + 1, track);
            isVisited[i] = false;
            track.remove(x);
        }
    }
}