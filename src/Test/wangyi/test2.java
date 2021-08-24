package Test.wangyi;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: Spaeurs
 * @date: 2021/8/22 15:15
 * @description:
 */
public class test2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minDelete("ceabaacb"));
    }
}


class Solution{
    public int minDelete(String s){
        // count数组记录input各字母出现的频次
        int[] count = new int[26];
        int deletion = 0;
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        //用一个set来记录出现频次 以保证唯一
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int freq = count[i];

            //看看这个频次是不是已经有了 有的话就得做delete
            while (freq > 0 && !unique.add(freq)) {
                freq--;
                deletion++;
            }
        }
        return deletion;
    }
}