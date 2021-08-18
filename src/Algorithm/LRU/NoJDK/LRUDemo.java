package Algorithm.LRU.NoJDK;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Spaeurs
 * @date: 2021/8/17 21:48
 * @description: 不使用JDK实现LRU
 */
public class LRUDemo {

    //map负责查找，构建一个虚拟的双向链表，里面是一个个Node节点，作为数据载体

    //1 构造一个Node节点，作为数据载体
    class Node<K,V>{
        K key;
        V value;
        Node<K,V> prev;
        Node<K,V> next;

        public Node(){
            this.prev = this.next = null;
        }

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }


    //2 构造一个虚拟的双向链表，里面放的就是Node节点
    class DoubleLinkedList<K,V>{
        Node<K,V> head;
        Node<K,V> tail;

        // 2.1 构造方法，搭建一个框架
        public DoubleLinkedList(){
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        // 2.2 添加到头
        public void addHead(Node<K,V> node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // 2.3 删除节点
        public void removeNode(Node<K,V> node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        // 2.4 获得最后一个节点
        public Node getLast(){
            return tail.prev;
        }
    }

    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;

    public LRUDemo(int cacheSize){
        this.cacheSize = cacheSize;//容量
        map = new HashMap<>();//用于查找
        doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key){
        if (!map.containsKey(key))
            return -1;
        Node<Integer, Integer> node = map.get(key);
        //将节点移除并添加到头结点
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);

        return node.value;
    }

    public void put(int key, int value){
        if (map.containsKey(key)){//update
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key,node);
            //将节点移除并添加到头结点
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else {
            if (map.size() == cacheSize){//容量已满
                Node<Integer,Integer> lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            //新增操作
            Node<Integer, Integer> newNode = new Node<>(key,value);
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }

    }


    public static void main(String[] args) {
        LRUDemo lruDemo = new LRUDemo(2);
        lruDemo.put(1,1);
        lruDemo.put(2,2);
        lruDemo.get(2);
        System.out.println(lruDemo.map.keySet());

        lruDemo.put(4,1);
        System.out.println(lruDemo.map.keySet());


//        lruDemo.put(3,3);
//        System.out.println(lruDemo.map.keySet());
        lruDemo.get(3);
        System.out.println(lruDemo.map.keySet());
        lruDemo.put(3,3);
        System.out.println(lruDemo.map.keySet());
        lruDemo.put(5,5);
        System.out.println(lruDemo.map.keySet());
    }

}