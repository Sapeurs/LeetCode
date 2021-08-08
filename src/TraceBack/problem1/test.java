package TraceBack.problem1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Spaeurs
 * @date: 2021/8/7 19:14
 * @description: 剑指 Offer 38. 字符串的排列
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 回溯算法核心框架
 * for 选择 in 选择列表:
 *     # 做选择
 *     将该选择从选择列表移除
 *     路径.add(选择)
 *     backtrack(路径, 选择列表)
 *     # 撤销选择
 *     路径.remove(选择)
 *     将该选择再加入选择列表
 */
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.permutation("aba")));
    }
}


class Solution {

    List<String> res = new LinkedList<>();
    char[] c;

    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[0]);
    }

    void dfs(int x) {
        //满足结束条件
        if (x == c.length - 1) {
            //加入路径，也就是已做出的选择
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < c.length; i++) {
            if (set.contains(c[i])) continue; //重复，因此剪枝
            set.add(c[i]);
            //做选择
            swap(i, x);
            dfs(x + 1);
            //撤销选择
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }
}

//class Solution1 {
//
//    List<String> res = new LinkedList<>();
//
//    public String[] permutation(String s) {
//        LinkedList<Character> list = new LinkedList<>();
//        dfs(s.toCharArray(),list);
//        return res.toArray(new String[0]);
//    }
//
//    /**
//     *
//     * @param chars 路径
//     * @param list 选择列表
//     */
//    void dfs(char[] chars, LinkedList<Character> list){
//        if (list.size() == chars.length){
//            res.add(String.valueOf(list));
//            return;
//        }
//
//        for (int i = 0; i < chars.length; i++) {
//            if (list.contains(chars[i])) continue;
//            list.add(chars[i]);
//            dfs(chars,list);
//            list.removeLast();
//        }
//    }
//
//}