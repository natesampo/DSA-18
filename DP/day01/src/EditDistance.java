package DP.day01.src;

public class EditDistance {

	public static int minEditDist(String a, String b) {
        int[][] memo = new int[a.length()][b.length()];
        
        return recursiveFunction(a, b, a.length(), b.length(), memo);
    }

	//memo[i, j] is distance from each other at string index a, string index b
    private static int recursiveFunction(String a, String b, int indexA, int indexB, int[][] memo) {
        int distance = 0;

        if(indexA == 0) {
        	return indexB;
        } else if(indexB == 0) {
        	return indexA;
        } else if(memo[indexA - 1][indexB - 1] != 0) {
        	return memo[indexA - 1][indexB - 1];
        } else if (a.charAt(indexA - 1) == b.charAt(indexB - 1))
        	distance = 0;
        else {
        	distance = 1;
        }

        memo[indexA - 1][indexB - 1] = Math.min(Math.min(recursiveFunction(a, b, indexA - 1, indexB, memo) + 1, recursiveFunction(a, b, indexA, indexB - 1, memo) + 1), recursiveFunction(a, b, indexA - 1, indexB - 1, memo) + distance);
        
        return memo[indexA - 1][indexB - 1];
    }
}
