package JUC.ReadWriteLockDemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: Spaeurs
 * @date: 2021/8/17 15:54
 * @description: 读写锁使用方式示例
 */
public class Cache {

    static Map<String, Object> map = new HashMap<>();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    static Lock r = rwl.readLock();
    static Lock w = rwl.writeLock();

    //获取一个key对应的value
    public static Object get(String key){
        //设置读锁
        r.lock();
        try {
            return map.get(key);
        }finally {
            r.unlock();
        }
    }

    //设置key对应的value，并返回旧的value
    public static Object put(String key, Object value){
        //设置写锁
        w.lock();
        try {
            return map.put(key,value);
        }finally {
            w.unlock();
        }
    }

    //清空所有内容
    public static void clear(){
        w.lock();
        try {
            map.clear();
        }finally {
            w.unlock();
        }
    }
}