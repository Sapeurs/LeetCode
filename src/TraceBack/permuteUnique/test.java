package TraceBack.permuteUnique;

import java.util.*;

/**
 * @author: Sapeurs
 * @date: 2021/8/8 15:19
 * @description: 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列 nums ，
 * 按任意顺序 返回所有不重复的全排列。
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permuteUnique(new int[]{1, 2, 1}).toString());
    }
}


class Solution {

    List<List<Integer>> res = new LinkedList<>();
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> track = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, track, 0);
        return res;
    }

    void backTrack(int[] nums, List<Integer> track, int index) {
        if (nums.length == track.size()) {
            res.add(new ArrayList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) continue;
            track.add(nums[i]);
            vis[i] = true;
            backTrack(nums, track, index + 1);
            vis[i] = false;
            track.remove(index);
        }
    }

}