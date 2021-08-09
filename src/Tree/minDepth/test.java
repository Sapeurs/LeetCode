package Tree.minDepth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Spaeurs
 * @date: 2021/8/9 21:24
 * @description:
 */
public class test {
}

class Solution{
    public int minDepth(TreeNode root){
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        //将起点加入队列
        queue.offer(root);
        //初始化最小距离为1
        int depth = 1;

        while (!queue.isEmpty()){
            int len = queue.size();
            //将当前队列中的所有节点向四周扩散
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                //判断是否到达终点
                if (cur.left == null && cur.right == null)
                    return depth;
                //将cur的相邻节点加入队列
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            //增加距离
            depth++;
        }
        return depth;
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}