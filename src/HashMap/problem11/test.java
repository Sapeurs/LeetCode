package HashMap.problem11;

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