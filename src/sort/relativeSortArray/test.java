package sort.relativeSortArray;


import java.util.*;

/**
 * @author: Sapeurs
 * @date: 2021/7/11 21:17
 * @description: 1122. 数组的相对排序
 *
 * 给你两个数组，arr1 和 arr2，
 *
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1
 * 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 */
public class test {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = {2, 1, 4, 3, 9, 6};
        int[] result = solution.relativeSortArray(arr1, arr2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}


class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr2.length == 0) {
            return null;
        }
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        ArrayList<Integer> arrayList3 = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            arrayList1.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = arrayList1.size() - 1; j >= 0; j--) {
                if (arrayList1.get(j) == arr2[i]) {
                    arrayList3.add(arr2[i]);
                    arrayList1.remove(j);
                }
            }
        }
        arrayList1.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (Integer i : arrayList1
        ) {
            arrayList3.add(i);
        }
        int[] ints = new int[arrayList3.size()];
        for (int i = 0; i < arrayList3.size(); i++) {
            ints[i] = arrayList3.get(i);
        }
        return ints;
    }
}

class Solution2 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int num : arr1) {
            list.add(num);
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        list.sort((x, y) -> {
            if (map.containsKey(x) || map.containsKey(y))
                return map.getOrDefault(x, 1001) - map.getOrDefault(y, 1001);
            return x - y;
        });
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}