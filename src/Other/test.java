package Other;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: Sapeurs
 * @date: 2021/4/4 20:07
 * @description:
 */
public class test {
    //    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long len = sc.nextLong();
//        int[] array = new int[(int) len];
//        Stack<Integer> list = new Stack<>();
//        //int n = Integer.parseInt(sc.next());
//        long n = Long.parseLong(sc.next());
//        for (int i = 0; i < len; i++) {
//            array[i] = sc.nextInt();
//        }
//        for (int i = 0; i < len; i++) {
//            array[i] = (int) n%10;
//            n/=10;
//        }
//        list.push(array[0]);
//        for (int i = 1; i < len; i++) {
//            if (!list.isEmpty()&&array[i] + list.peek() == 10){
//                list.pop();
//            }else {
//                list.push(array[i]);
//            }
//        }
//        System.out.println(list.size());
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        sc.nextLine();
        String str = sc.nextLine();
        char[] array = str.toCharArray();
        Stack<Integer> list = new Stack<>();
        list.push(array[0] - '0');
        for (int i = 1; i < len; i++) {
            if (!list.isEmpty() && array[i] - '0' + list.peek() == 10) {
                list.pop();
            } else {
                list.push(array[i] - '0');
            }
        }
        System.out.println(list.size());
    }


}