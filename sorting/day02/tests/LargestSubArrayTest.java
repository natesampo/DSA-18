package sorting.day02.tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

import sorting.day02.src.LargestSubArray;

public class LargestSubArrayTest {
    @Test
    public void testlargestSubarray1() {
        assertArrayEquals(new int[]{1, 6}, LargestSubArray.largestSubarray(new int[]{1, 0, 1, 1, 1, 0, 0}));
    }

    @Test
    public void testlargestSubarray2() {
        assertArrayEquals(new int[]{0, 5}, LargestSubArray.largestSubarray(new int[]{1, 0, 1, 1, 0, 0}));
    }

    @Test
    public void testlargestSubarray3() {
        assertArrayEquals(new int[]{0, 11}, LargestSubArray.largestSubarray(new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void testlargestSubarray4() {
        assertArrayEquals(new int[]{0, 11}, LargestSubArray.largestSubarray(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}));
    }

    @Test
    public void testlargestSubarray5() {
    	//System.out.println("{" + LargestSubArray.largestSubarray(new int[]{1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1})[0] + ", " + LargestSubArray.largestSubarray(new int[]{1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1})[1] + "}");
        assertArrayEquals(new int[]{5, 10}, LargestSubArray.largestSubarray(new int[]{1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1}));
    }
}
