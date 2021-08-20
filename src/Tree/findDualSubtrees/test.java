package Tree.findDualSubtrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author: Spaeurs
 * @date: 2021/8/19 21:23
 * @description: 652. 寻找重复的子树
 * <p>
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，
 * 你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 */
public class test {
}


class Solution {

    //记录所有子树以及出现的次数
    Map<String, Integer> map = new HashMap<>();

    //记录重复的子树根节点
    List<TreeNode> res = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    //将二叉树序列化
    String traverse(TreeNode root){
        if (root == null)
            return "#";
        String left = traverse(root.left);
        String right = traverse(root.right);

        String subTree = left + "," + right + "," + root.val;

        int freq = map.getOrDefault(subTree,0);
        //多次重复也只会被加入结果集一次
        if (freq == 1) res.add(root);

        //给子树对应的出现次数加一
        map.put(subTree, freq + 1);
        return subTree;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
