package stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    Map<Integer, Integer> cache;
    LinkedList<Integer> order;
    int capacity;

    public LRUCache(int capacity) {
       this.cache = new HashMap<>();
       this.capacity = capacity;
       this.order = new LinkedList<>();
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
          order.remove((Integer) key);
          order.addFirst(key);
          return cache.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
      if (cache.containsKey(key)) {
        cache.put(key, value);
        order.remove((Integer) key);
        order.addFirst(key);
      } else {
        if (cache.size() < capacity) {
            cache.put(key, value);
            order.addFirst(key);
        } else {
            int lruKey = order.removeLast();
            cache.remove(lruKey);
            cache.put(key, value);
            order.addFirst(key);
        }
      }
    }

}