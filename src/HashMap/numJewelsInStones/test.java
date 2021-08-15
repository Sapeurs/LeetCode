package HashMap.numJewelsInStones;


/**
 * 771. 宝石与石头
 *
 * 给定字符串J代表石头中宝石的类型，和字符串S代表你拥有的石头。
 * S中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *
 * J中的字母不重复，J和S中的所有字符都是字母。字母区分大小写，
 * 因此"a"和"A"是不同类型的石头。
 *
 */

public class test {
}


class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        char[] jewel = jewels.toCharArray();
        char[] stone = stones.toCharArray();

        int sum = 0;
        for (int i = 0; i < jewel.length; i++) {
            for (int j = 0; j < stone.length; j++) {
                if (jewel[i] == stone[j]) {
                    sum++;
                }
            }
        }
        return sum;
    }
}