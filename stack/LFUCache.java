package stack;

import java.util.*;

public class LFUCache {

    Map<Integer, int[]> cache; // key -> {value, freq}
    Map<Integer, LinkedList<Integer>> freqListMap; // freq -> keys
    int minFreq;
    int capacity;

    public LFUCache(int capacity) {
        cache = new HashMap<>();
        freqListMap = new HashMap<>();
        minFreq = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        int[] freqArr = cache.get(key);
        int value = freqArr[0];
        int newFreq = changeFrequency(key);

        cache.put(key, new int[]{value, newFreq});
        return value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            int[] freqArr = cache.get(key);
            int newFreq = changeFrequency(key);
            cache.put(key, new int[]{value, newFreq});
            return;
        }

        if (cache.size() >= capacity) {
            // Evict least frequently used key
            LinkedList<Integer> keys = freqListMap.get(minFreq);
            int evictKey = keys.removeFirst();
            cache.remove(evictKey);
        }

        // Insert new key with freq = 1
        cache.put(key, new int[]{value, 1});
        updateFreqListMap(1, key);
        minFreq = 1; // reset minFreq to 1 for new key
    }

    private int changeFrequency(int key) {
        int[] freqArr = cache.get(key);
        int oldFreq = freqArr[1];
        int newFreq = oldFreq + 1;

        // remove key from old frequency list
        freqListMap.get(oldFreq).remove(Integer.valueOf(key));
        if (freqListMap.get(oldFreq).isEmpty() && oldFreq == minFreq) {
            minFreq++;
        }

        // add key to new frequency list
        updateFreqListMap(newFreq, key);
        return newFreq;
    }

    private void updateFreqListMap(int freq, int key) {
        freqListMap.computeIfAbsent(freq, f -> new LinkedList<>()).add(key);
    }
}
