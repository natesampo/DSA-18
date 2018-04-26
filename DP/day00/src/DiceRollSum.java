package DP.day00.src;

import java.util.HashMap;

public class DiceRollSum {

    // Runtime: O(N)
    // Space: O(N)
    public static int diceRollSum(int N) {
    	HashMap<Integer, Integer> memo = new HashMap<>();
    	
    	if(N==0) {
    		return 1;
    	} else {
    		return(recursiveFunction(N, memo));
    	}
    }

    private static int recursiveFunction(int sum, HashMap<Integer, Integer> memo) {
    	int returnNum = 0;

        if(sum < 0) {
        	return 0;
        } else if(sum == 0) {
        	return 1;
        } else if(memo.containsKey(sum)) {
        	return memo.get(sum);
        } else {
        	for(int i=1;i<7;i++) {
        		returnNum += recursiveFunction(sum-i, memo);
        		memo.put(sum, returnNum);
        	}
        }

        return returnNum;
    }
}
