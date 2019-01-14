package leetcode.one00_one50;


import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    int capacity;
    Map<Integer, Integer> record;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        record = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if(!record.containsKey(key)) return -1;
        Integer value = record.get(key);
        record.remove(key);
        record.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if(record.containsKey(key)) record.remove(key);
        if(record.size() == capacity){
            record.remove(record.keySet().iterator().next());
        }
        record.put(key, value);
    }
}

public class A_146_LRUCache {
    public static  void main(String[] args){

    }

}

/*
LinkedHashMap: combine Linked list and hash table
get: get with key. Remove then insert again, to acknowledge it is recently accessed
put: if key already existed, remove. if capacity == size, remove the first one: record.remove(record.keysSet().iterator().next())

Time: O(1) for get and put
Space: except data to store cache, it is O(1)

 */
