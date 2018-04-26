package DP.day00.src;

import java.util.HashMap;

public class LongestIncreasingSubsequence {

    // Runtime: O(n^2)
    // Space: O(N)
    public static int LIS(int[] A) {
    	HashMap<Integer, Integer> memo = new HashMap<>();
    	int longest = 0;
    	
    	for(int i=0;i<A.length;i++) {
    		longest = Math.max(recursiveFunction(i, A, memo), longest);
    	}
    	
    	return longest;
    }
    
    private static int recursiveFunction(int i, int[] A, HashMap<Integer, Integer> memo) {
    	int returnNum = 1;
    	
    	if(i<=0) {
    		return 0;
    	} else if(memo.containsKey(i)) {
    		return memo.get(i);
    	} else {
    		for(int j=0;j<i;j++) {
    			if(A[j]<A[i]) {
    				returnNum = Math.max(recursiveFunction(j, A, memo) + 1, returnNum);
    				memo.put(i, returnNum);
    			}
    		}
    	}
    	
    	return returnNum;
    }
}