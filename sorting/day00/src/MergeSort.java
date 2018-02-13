import java.util.Arrays;

public class MergeSort extends SortAlgorithm {

	private static final int INSERTION_THRESHOLD = 10;

	/**
	 * This is the recursive step in which you split the array up into a left and a
	 * right portion, sort them, and then merge them together. Use Insertion Sort if
	 * the length of the array is <= INSERTION_THRESHOLD
	 *
	 * TODO Best-case runtime: Worst-case runtime: Average-case runtime:
	 *
	 * Space-complexity:
	 */
	@Override
	public int[] sort(int[] array) {
		if(array.length <= INSERTION_THRESHOLD) {
			InsertionSort insertionSort = new InsertionSort();
			return insertionSort.sort(array);
		} else {
			return merge(sort(Arrays.copyOfRange(array, 0, array.length/2)), sort(Arrays.copyOfRange(array, array.length/2, array.length)));
		}
	}

	/**
	 * Given two sorted arrays a and b, return a new sorted array containing all
	 * elements in a and b. A test for this method is provided in `SortTest.java`
	 */
	public int[] merge(int[] a, int[] b) {
		int[] newArray = new int[a.length + b.length];
		int walkerA = 0, walkerB = 0, counter = 0;
		
		while(counter < a.length + b.length) {
			
			if(walkerA < a.length && walkerB < b.length) {
				if(a[walkerA] > b[walkerB]) {
					newArray[counter] = b[walkerB];
					walkerB++;
				} else {
					newArray[counter] = a[walkerA];
					walkerA++;
				}
			} else if(walkerA < a.length) {
				newArray[counter] = a[walkerA];
				walkerA++;
			} else if(walkerB < b.length) {
				newArray[counter] = b[walkerB];
				walkerB++;
			}
			
			counter++;
			
		}
		
		return newArray;
	}

}
