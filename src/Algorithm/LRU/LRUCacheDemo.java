package Algorithm.LRU;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: Sapeurs
 * @date: 2021/7/8 15:55
 * @description:
 */
public class LRUCacheDemo<k, v> extends LinkedHashMap<k, v> {

    private int capacity; //容量

    /**
     * accessOrder: true：访问顺序   false：插入顺序
     */
    public LRUCacheDemo(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<k, v> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo<Object, Object> lruCacheDemo = new LRUCacheDemo<>(3);

        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(5, "q");
        System.out.println(lruCacheDemo.keySet());
    }

}