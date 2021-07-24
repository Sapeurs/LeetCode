package sort.problem4;

import java.util.*;


/**
 * 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * <p>
 * （这里，平面上两点之间的距离是欧几里德距离。）
 */


public class test {
    public static void main(String[] args) {

    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {

        Map<int[], Integer> hashMap = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            hashMap.put(points[i], points[i][0] * points[i][0] + points[i][1] * points[i][1]);
        }

        ArrayList<Map.Entry<int[], Integer>> list = new ArrayList<>(hashMap.entrySet());

        list.sort(new Comparator<Map.Entry<int[], Integer>>() {
            @Override
            public int compare(Map.Entry<int[], Integer> o1, Map.Entry<int[], Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        int[][] result = new int[k][2];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}


class Solution2 {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
        return Arrays.copyOfRange(points, 0, K);
    }
}