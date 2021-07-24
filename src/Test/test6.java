package Test;

/**
 * @author: Sapeurs
 * @date: 2021/5/8 15:03
 * @description:
 */
public class test6 {


    public int specialStr(String inputStr, char[] cList) {
        // write code here
        int len = inputStr.length();
        if (len == 0)
            return 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < cList.length; j++) {
                if (inputStr.charAt(i) == cList[j]) {

                }
            }
        }
        int mLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] c = inputStr.toCharArray();

        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j = l + i - 1;
                if (j >= len)
                    break;
                if (c[i] != c[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > mLen) {
                    mLen = j - i + 1;
                    begin = i;
                }
            }
        }
        String s = inputStr.substring(begin, begin + mLen);

        return 0;
    }


}
