package trees.day01.src;

import java.util.HashMap;

public class Problems {

    public static int leastSum(int[] A) {
    	HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        int sum = 0, rightDigit = 0, leftDigit = 0;
        
        rightDigit = A.length/2;
        leftDigit = A.length - rightDigit;
        
        for(int i=0;i<A.length;i++) {
        	if(count.containsKey(A[i])) {
        		count.put(A[i], count.get(A[i])+1);
        	} else {
        		count.put(A[i], 1);
        	}
        }
        
        for(int i=0;i<10;i++) {
        	if(count.get(i) != null) {
	        	for(int j=0;j<count.get(i);j++) {
	        		if(rightDigit > leftDigit) {
	        			sum += Math.pow(10, rightDigit-1) * i;
	        			rightDigit--;
	        		} else {
	        			sum += Math.pow(10, leftDigit-1) * i;
	        			leftDigit--;
	        		}
        		}
        	}
        }
        
        return sum;
    }
}
