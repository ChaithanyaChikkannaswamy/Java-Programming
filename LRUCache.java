/*
* Question: https://leetcode.com/problems/lru-cache/
* Date: 06/07/2021
*/

class LRUCache {
    LinkedHashMap<Integer, Integer> map;
    int capacity;
    
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(){
            protected boolean removeEldestEntry(Map.Entry eldest){
                return size() > capacity;
            }
        };
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer val = map.get(key);
        if(val == null)
            return -1;
        map.remove(key);
        map.put(key,val);
        return val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
            map.remove(key);
        
        map.put(key,value);
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
