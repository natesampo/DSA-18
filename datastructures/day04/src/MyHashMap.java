import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class MyHashMap<K, V> implements Map<K, V> {

    // average number of entries per bucket before we grow the map
    private static final double ALPHA = 1.0;
    // average number of entries per bucket before we shrink the map
    private static final double BETA = .25;

    // resizing factor: (new size) = (old size) * (resize factor)
    private static final double SHRINK_FACTOR = 0.5, GROWTH_FACTOR = 2.0;

    private static final int MIN_BUCKETS = 16;

    // array of buckets
    protected LinkedList<Entry>[] buckets;
    private int size = 0;

    public MyHashMap() {
        initBuckets(MIN_BUCKETS);
    }

    public class Entry implements Map.Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            value = newValue;
            return value;
        }
    }

    /**
     * given a key, return the bucket where the `K, V` pair would be stored if it were in the map.
     */
    private LinkedList<Entry> chooseBucket(Object key) {    	
        // hint: use key.hashCode() to calculate the key's hashCode using its built in hash function
        // then use % to choose which bucket to return.
        return buckets[key.hashCode() % buckets.length];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * return true if key is in map
     */
    @Override
    public boolean containsKey(Object key) {
        LinkedList<Entry> tempBucket = chooseBucket(key);
        
        for(int i=0;i<tempBucket.size();i++) {
    		Entry tempEntry = tempBucket.get(i);
    		
    		if(tempEntry.getKey() == key) {
    			return true;
    		}
    	}
        
        return false;
    }

    /**
     * return true if value is in map
     */
    @Override
    public boolean containsValue(Object value) {
    	
    	for(int i=0;i<buckets.length;i++) {
	    	LinkedList<Entry> tempBucket = buckets[i];
	    	
	    	for(int j=0;j<tempBucket.size();j++) {
	    		Entry tempEntry = tempBucket.get(j);
	    		
	    		if(tempEntry.getValue() == value) {
	    			return true;
	    		}
	    	}
    	}
    	
        return false;
    }

    @Override
    public V get(Object key) {
        
    	LinkedList<Entry> tempBucket = chooseBucket(key);
    	
    	for(int i=0;i<tempBucket.size();i++) {
    		Entry tempEntry = tempBucket.get(i);
    		
    		if(tempEntry.getKey() == key) {
    			return tempEntry.getValue();
    		}
    	}
    	
    	return null;
    }

    /**
     * add a new key-value pair to the map. Grow if needed, according to `ALPHA`.
     * @return the value associated with the key if it was previously in the map, otherwise null.
     */
    @Override
    public V put(K key, V value) {

    	V tempValue = get(key);
    	
    	LinkedList<Entry> tempBucket = chooseBucket(key);
    	
    	if(tempValue != null) {
    		for(int i=0;i<tempBucket.size();i++) {
	    		Entry tempEntry = tempBucket.get(i);
	    		
	    		if(tempEntry.getKey() == key) {
	    			V returnValue = tempEntry.getValue();
	    			tempEntry.setValue(value);
	    			return returnValue;
	    		}
	    	}
    	} else {
    		size ++;
    		tempBucket.add(new Entry(key, value));
    	}
    	
    	if(size > buckets.length*ALPHA) {
    		rehash(GROWTH_FACTOR);
    	}
    	
        return tempValue;
    }

    /**
     * Remove the key-value pair associated with the given key. Shrink if needed, according to `BETA`.
     * Make sure the number of buckets doesn't go below `MIN_BUCKETS`. Do nothing if the key is not in the map.
     * @return the value associated with the key if it was in the map, otherwise null.
     */
    @Override
    public V remove(Object key) {
    	
    	LinkedList<Entry> tempBucket = chooseBucket(key);
    	
    	for(int i=0;i<tempBucket.size();i++) {
	    	Entry tempEntry = tempBucket.get(i);
	    		
	    	if(tempEntry.getKey() == key) {
	    		V returnValue = tempEntry.getValue();
	    		tempBucket.remove(i);
	    		size --;
	    		return returnValue;
	    	}
	    }
    	
    	if(size < buckets.length*BETA) {
    		rehash(SHRINK_FACTOR);
    	}
    	
    	return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Changes the number of buckets and rehashes the existing entries.
     * If growthFactor is 2, the number of buckets doubles. If it is 0.25,
     * the number of buckets is divided by 4.
     */
    private void rehash(double growthFactor) {
    	size=0;
    	int newBuckets = (int) Math.round(Math.max(buckets.length*growthFactor, MIN_BUCKETS));
    	
    	LinkedList<Entry> tempEntries = new LinkedList<Entry>();
    	
    	for(int i=0;i<buckets.length;i++) {
    		LinkedList<Entry> tempBucket = buckets[i];
    		
    		while(!tempBucket.isEmpty()) {
    			Entry tempEntry = tempBucket.get(0);
    			
    			tempEntries.add(tempEntry);
    			tempBucket.remove(0);
    			
    		}
    		
    	}
    	
    	initBuckets(newBuckets);
    	
    	for(int i=0;i<tempEntries.size();i++) {
    		put(tempEntries.get(i).getKey(), tempEntries.get(i).getValue());
    	}
    }

    private void initBuckets(int size) {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void clear() {
        initBuckets(buckets.length);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> e : entrySet()) {
            keys.add(e.getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        for (Map.Entry<K, V> e : entrySet()) {
            values.add(e.getValue());
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<Entry> map : buckets) {
            set.addAll(map);
        }
        return set;
    }
}
