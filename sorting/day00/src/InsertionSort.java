
public class InsertionSort extends SortAlgorithm {
	/**
	 * Use the insertion sort algorithm to sort the array
	 *
	 * TODO Best-case runtime: Worst-case runtime: Average-case runtime:
	 *
	 * Space-complexity:
	 */
	@Override
	public int[] sort(int[] array) {
		
		int walker = 0, tempValue = 0;
		int[] returnArray = new int[array.length];
		
		while(array.length > walker) {
			
			if(walker == 0) {
				returnArray[walker] = array[walker];
			} else {
				
				tempValue = array[walker];
				
				for(int i=walker;i>=0;i--) {

					if(i==0) {
						returnArray[i] = tempValue;
					} else if(returnArray[i - 1] > tempValue) {
						
						returnArray[i] = returnArray[i - 1];
						
					} else {
						
						returnArray[i] = tempValue;
						break;
						
					}
				}
			}
			
			walker++;
			
		}
		
		return returnArray;
	}
}