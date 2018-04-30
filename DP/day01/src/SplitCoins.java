package DP.day01.src;

public class SplitCoins {

	public static int splitCoins(int[] coins) {
        int total = 0;
        
        for(int i : coins) {
        	total += i;
        }
        
        //[1,1,2]
        //[[0],[0],[0]]
        
        int memo[][] = new int[coins.length][total/2 + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                memo[i][j] = -Integer.MAX_VALUE;
            }
        }

        if(total%2 == 0) {
        	return 2*recursiveFunction(coins, coins.length-1, total/2, memo);
        } else {
        	return 2*recursiveFunction(coins, coins.length-1, total/2, memo) + 1;
        }
    }

	//memo[i, j] is the minimum difference that can be achieved with the previous i coins with j total value.
    private static int recursiveFunction(int[] coins, int i, int half, int[][] memo) {
        if(i<0) {
            return half;
        } else if(memo[i][half] != -Integer.MAX_VALUE) {
            return memo[i][half];
        } else if(half < coins[i]) {
        	memo[i][half] = recursiveFunction(coins, i-1, half, memo);
        	return memo[i][half];
        } else {
        	memo[i][half] = Math.min(recursiveFunction(coins, i-1, half, memo), recursiveFunction(coins, i-1, half-coins[i], memo));
        	return memo[i][half];
        }
    }
}
