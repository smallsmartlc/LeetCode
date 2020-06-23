package Leetcode.smart;

import java.util.LinkedHashMap;
import java.util.Map;

public class work0146 {
	public static void main(String[] args) {
		 LRUCache obj = new LRUCache(3);
		 obj.put(2,2);
		 int param_1 = obj.get(2);
		 obj.put(1,1);
		 System.out.println(param_1);
	}
}
class LRUCache extends LinkedHashMap<Integer, Integer>{
	private int capacity;
    public LRUCache(int capacity) {
		super(capacity, 0.75F, true);
	    this.capacity = capacity;
    }
    
    public int get(int key) {
    	return super.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
    	super.put(key, value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity; 
    }
}