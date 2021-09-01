package Test.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author: Sapeurs
 * @date: 2021/9/1 8:54
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        String[] strings = s.split(" ");
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = Integer.parseInt(strings[i]);
//        }
//        for (int i = 0; i < n - 1; i++) {
//            int[] tmp = Arrays.copyOf(nums, n - i);
//            for (int j = 0; j < n - i - 1; j++) {
//                nums[j] = tmp[j+1]-nums[j];
//            }
//        }
//        System.out.println(nums[0]%(Math.pow(10,9)+7));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(strings[i]));
        }
        while (list.size()!=1){

            int size = list.size() - 1;
            for (int i = 0; i < size; i++) {
                list.set(i,list.get(i+1)- list.get(i)%((int)Math.pow(10,9)+7));
            }
            list.remove(size);
        }
        System.out.println(list.get(0));
    }

}
