package Test;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author: Sapeurs
 * @date: 2021/5/8 15:48
 * @description:
 */
public class test8 {
    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        t0.left = t1;
        t0.right = t2;
        t1.left = t3;
        t1.right = t4;
        t3.right = t6;
        t2.left = t5;
        Solution2 solution2 = new Solution2();
        int[] colMax = solution2.getColMax(t0);
        System.out.println(Arrays.toString(colMax));
    }
}


class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类 根节点
     * @return int整型一维数组
     */

    TreeMap<Integer, Integer> map = new TreeMap<>();

    public int[] getColMax(TreeNode root) {
        // write code here
        if (root == null)
            return null;
        preOrder(root, 0);
        int len = map.size();
        int[] ans = new int[len];
        Object[] values = map.values().toArray();
        for (int i = 0; i < len; i++) {
            ans[i] = (int) values[i];
        }
        return ans;
    }

    public void preOrder(TreeNode root, int x) {
        if (root == null)
            return;
        if (map.containsKey(x)) {
            map.put(x, Math.max(root.val, map.get(x)));
        } else {
            map.put(x, root.val);
        }
        preOrder(root.left, x - 1);
        preOrder(root.right, x + 1);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
