package Test.thoughtWorks;

/**
 * @author: Spaeurs
 * @date: 2021/9/4 14:49
 * @description:
 */
public class test1 {
    public static void main(String[] args) {
        char ch = 'b';
        int i = 0;
        while (ch>='a'&&ch<='z'){
            ch++;
            i++;
        }
        System.out.println(i);

        Node node3 = new Node(34, null);
        Node node2 = new Node(5, node3);
        Node node1 = new Node(12, node2);

        Node head = node1;
        head = head.next;

    }
}

class Node {
    int data;	//represents the data present within the node
    Node next;	//represents the reference to the next node, can be NULL
    //Constructor
    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}