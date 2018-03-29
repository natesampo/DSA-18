package trees.day03.src.divide_and_conquer;

public class PeakFinding {

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakOneD(int i, int[] nums) {
        if (i > 0 && nums[i] < nums[i - 1])
            return -1;
        if (i < nums.length - 1 && nums[i] < nums[i + 1])
            return 1;
        return 0;
    }

    // Return -1 if left is higher, 1 if right is higher, 0 if peak
    private static int peakX(int x, int y, int[][] nums) {
        if (x > 0 && nums[y][x] < nums[y][x - 1])
            return -1;
        if (x < nums[0].length - 1 && nums[y][x] < nums[y][x + 1])
            return 1;
        return 0;
    }

    // Return -1 if up is higher, 1 if down is higher, 0 if peak
    private static int peakY(int x, int y, int[][] nums) {
        if (y > 0 && nums[y][x] < nums[y - 1][x])
            return -1;
        if (y < nums.length - 1 && nums[y][x] < nums[y + 1][x])
            return 1;
        return 0;
    }

    // These two functions return the index of the highest value along the X or Y axis, with the given
    // value for the other axis. Searches between hi (exclusive) and lo (inclusive)
    private static int maxXIndex(int y, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int x = lo; x < hi; x++) {
            if (maxIndex == -1 || nums[y][x] > nums[y][maxIndex])
                maxIndex = x;
        }
        return maxIndex;
    }

    private static int maxYIndex(int x, int lo, int hi, int[][] nums) {
        int maxIndex = -1;
        for (int y = lo; y < hi; y++) {
            if (maxIndex == -1 || nums[y][x] > nums[maxIndex][x])
                maxIndex = y;
        }
        return maxIndex;
    }


    public static int findOneDPeak(int[] nums) {
    	int head = 0, tail = nums.length;
        while (head < tail) {
            int mid = (head + tail) / 2;
            int side = peakOneD(mid, nums);
            
            if (side == 0) {
            	return mid;
            } else if (side == -1) {
            	tail = mid;
            } else if (side == 1) {
            	head = mid + 1;
            }
        }
        return 0;
    }

    public static int[] findTwoDPeak(int[][] nums) {
    	int xHead = 0, xTail = nums[0].length, yHead = 0, yTail = nums.length, counter = -1;
    	
        while (xHead < xTail && yHead < yTail) {
        	counter ++;
        	
            if (counter % 2 == 0) {
            	
                int xMid = (xHead + xTail) / 2;
                int yMax = maxYIndex(xMid, yHead, yTail, nums);
                int peak = peakX(xMid, yMax, nums);
                if (peak == 0) {
                    return new int[]{yMax, xMid};
                } else if (peak == -1) {
                    xTail = xMid;
                } else if (peak == 1) {
                    xHead = xMid + 1;
                }
                
            } else {
            	
                int yMid = (yHead + yTail) / 2;
                int xMax = maxXIndex(yMid, yHead, yTail, nums);
                int peak = peakY(xMax, yMid, nums);
                if (peak == 0) {
                    return new int[]{yMid, xMax};
                } else if (peak == -1) {
                    yTail = yMid;
                } else if (peak == 1) {
                    yHead = yMid + 1;
                }
                
            }
        }
        
        return new int[0];
    }

}
