package DP.day01.src;

public class DungeonGame {

	public static int minInitialHealth(int[][] map) {
        int[][] memo = new int[map.length][map[0].length];
        int position = map.length + map[0].length-3;
        memo[map.length-1][map[0].length-1] = 1-map[map.length-1][map[0].length-1];
        
        //memo[i, j] is the hp required so far at position i, j.
        while(position>-1) {
            for(int i=0;i<=Math.min(position,map.length-1);i++) {
                int j = position-i;
                if(j>=0 && j<map[0].length) {
                    int right = Integer.MAX_VALUE;
                    int down = Integer.MAX_VALUE;
                    if(i < map.length-1) {
                        down = Math.max(0, memo[i+1][j]-map[i][j]);
                    }
                    if(j < map[0].length-1) {
                        right = Math.max(0, memo[i][j+1]-map[i][j]);
                    }
                    memo[i][j] = Math.min(down, right);
                }
            }
            position -= 1;
        }
        
        return memo[0][0];
    }
}