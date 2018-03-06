package sorting.day03.src;

import java.util.HashMap;

public class CountingSort {

    /**
<<<<<<< HEAD
     * Use counting sort to sort positive integer array A.
     * Runtime: O(k+n)
=======
     * Use counting sort to sort non-negative integer array A.
     * Runtime: TODO
>>>>>>> upstream/master
     *
     * k: maximum element in array A
     */
    public static void countingSort(int[] A) {
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        int max = 0, min = 0, walker = 0;
    	
    	for(int i=0;i<A.length;i++) {
    		if(counter.containsKey(A[i])) {
    			counter.put(A[i], counter.get(A[i])+1);
    		} else {
    			counter.put(A[i], 1);
    		}
    		
    		if(i==0) {
    			max = A[i];
    			min = A[i];
    		} else {
    			if(A[i] > max) {
    				max = A[i];
    			} else if(A[i] < min) {
    				min = A[i];
    			}
    		}
    	}
    	
    	for(int i=min;i<=max;i++) {
    		
    		if(counter.get(i) != null) {
    			
    			for(int j=0;j<counter.get(i);j++) {
    				A[walker] = i;
    				walker++;
    			}
    		}
    		
    	}
    }
}