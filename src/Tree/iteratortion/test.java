package Tree.iteratortion;

import java.util.Stack;

/**
 * @author: Sapeurs
 * @date: 2021/4/9 9:24
 * @description: 二叉树的前序，中序，后序遍历
 */
public class test {

    public static void main(String[] args) {
        TreeNode[] node = new TreeNode[10];//以数组形式生成一棵完全二叉树
        for (int i = 0; i < 10; i++) {
            node[i] = new TreeNode(i);
        }
        for (int i = 0; i < 10; i++) {
            if (i * 2 + 1 < 10)
                node[i].left = node[i * 2 + 1];
            if (i * 2 + 2 < 10)
                node[i].right = node[i * 2 + 2];
        }

//        midOrderRe(node[0]);
//        System.out.println();
//        midOrder(node[0]);

//        preOrderRe(node[0]);
//        System.out.println();
        preOrder(node[0]);

        postOrder(node[0]);
    }

    //二叉树的前序遍历递归实现
    public static void preOrderRe(TreeNode root) {
        if (root == null)
            return;
        System.out.println(root.val);
        preOrderRe(root.left);
        preOrderRe(root.right);
    }

    //二叉树的前序遍历非递归实现
    public static void preOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            //将左子树不断压入栈
            while (root != null) {
                //先访问再入栈
                System.out.println(root.val);
                stack.push(root);
                root = root.left;
            }
            //出栈并处理右子树
            if (!stack.isEmpty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    //二叉树的中序遍历递归实现
    public static void midOrderRe(TreeNode root) {
        if (root == null)
            return;
        midOrderRe(root.left);
        System.out.println(root.val);
        midOrderRe(root.right);
    }

    //二叉树的中序遍历非递归实现
    public static void midOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            //左子树进栈完毕
            if (!stack.isEmpty()) {
                root = stack.pop();
                System.out.println(root.val);
                root = root.right;
            }
        }
    }

    //二叉树的后序遍历递归实现
    public static void postOrderRe(TreeNode root) {
        if (root == null)
            return;
        postOrderRe(root.left);
        postOrderRe(root.right);
        System.out.println(root.val);
    }

    //二叉树的后序遍历非递归实现
    public static void postOrder(TreeNode root) {
        int left = 1;//在辅助栈里表示左节点
        int right = 2;//在辅助栈里表示右节点
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();//辅助栈，用来判断子节点返回父节点时处于左节点还是右节点

        while (root != null || !stack.empty()) {
            while (root != null) {
                //将节点压入栈1，并在栈2将节点标记为左节点
                stack.push(root);
                stack1.push(left);
                root = root.left;
            }

            while (!stack.empty() && stack1.peek() == right) {
                //如果是从右子节点返回父节点，则任务完成，将两个栈的栈顶弹出
                stack1.pop();
                System.out.println(stack.pop().val);
            }

            while (!stack.empty() && stack1.peek() == left) {
                //如果是从左子节点返回父节点，则将标记改为右子节点
                stack1.pop();
                stack1.push(right);
                root = stack.peek().right;
            }
        }

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