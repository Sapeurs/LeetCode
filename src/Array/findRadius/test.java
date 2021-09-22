package Array.findRadius;

import java.util.Arrays;

/**
 * @author: Spaeurs
 * @date: 2021/9/17 10:27
 * @description: 475. 供暖器
 * <p>
 * 冬季已经来临。你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋houses 和供暖器heaters 的位置，
 * 请你找出并返回可以覆盖所有房屋的最小加热半径。
 */
public class test {
    public static void main(String[] args) {
        System.out.println(new Solution().findRadius(new int[]{1, 3, 4, 5, 6, 7, 10}, new int[]{2, 9}));
    }
}


class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int radius = 0;
        int i = 0;
        for (int house : houses) {
            while (i < heaters.length && heaters[i] < house) {
                //一直找到处于房屋右侧的供暖器
                i++;
            }
            if (i == 0)
                radius = Math.max(radius, heaters[i] - house);
            else if (i == heaters.length)
                //最后一个供暖器
                return Math.max(radius, houses[houses.length - 1] - heaters[heaters.length - 1]);
            else
                //房屋右侧的供暖器和房屋左侧的供暖器，取小的那个
                radius = Math.max(radius, Math.min(heaters[i] - house, house - heaters[i - 1]));
        }
        return radius;
    }
}