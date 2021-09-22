package sort.topKFrequent;

import java.util.*;

/**
 * @author: Spaeurs
 * @date: 2021/9/17 21:34
 * @description: 692. 前K个高频单词
 * <p>
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 */
public class test {
}


class Solution {
    //Hash表+排序
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        List<String> res = new ArrayList<>();
        map.forEach((key, value) -> res.add(key));
        res.sort((o1, o2) -> map.get(o1).equals(map.get(o2)) ?
                o1.compareTo(o2) : map.get(o2) - map.get(o1));
        return res.subList(0, k);
    }

    //优先级队列
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue().equals(o2.getValue())
                ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k)
                queue.poll();
        }
        ArrayList<String> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            res.add(queue.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}