package sorting.day02.src;

import java.util.HashMap;

public class LargestSubArray {
    public static int[] largestSubarray(int[] nums) {
        HashMap<Integer, Integer> checkSums = new HashMap<Integer, Integer>();
    	int[] sums = new int[nums.length+1];
    	int max = 0, maxStart = 0;
    	
    	for(int i=1;i<sums.length;i++) {
    		if(nums[i-1] == 0) {
    			sums[i] = sums[i-1]-1;
    		} else {
    			sums[i] = sums[i-1]+1;
    		}
    	}
    	
    	for(int i=0;i<sums.length;i++) {
    		if(checkSums.containsKey(sums[i])) {
    			if(i - checkSums.get(sums[i]) > max) {
    				max = i - checkSums.get(sums[i]) - 1;
    				maxStart = checkSums.get(sums[i]);
    			}
    		} else {
    			checkSums.put(sums[i], i);
    		}
    	}

    	return new int[] {maxStart, maxStart+max};
    }
}
