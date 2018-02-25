package sorting.day02.src;

import java.util.Arrays;

public class TripleSum {

    public static int tripleSum(int arr[], int sum) {
        Arrays.sort(arr);
        int number = 0;
        
        for (int i=0;i<arr.length;i++) {
        	
            int startWalker = i + 1;
            int endWalker = arr.length - 1;
            
            while (startWalker < endWalker) {
                if (arr[i] + arr[startWalker] + arr[endWalker] == sum) {
                	
                    number++;
                    endWalker++;
                    
                } else if (arr[i] + arr[startWalker] + arr[endWalker] < sum)
                    startWalker++;
                else {
                    endWalker--;
                }
                
            }
        }
        
        return number;
    }
}
