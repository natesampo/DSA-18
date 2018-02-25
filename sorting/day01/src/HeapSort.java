package sorting.day01.src;

public class HeapSort extends SortAlgorithm {
    public int size;
    public int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
    	int sinkVal = heap[i];
    	
        if(rightChild(i) < heap.length && heap[rightChild(i)] > sinkVal && heap[rightChild(i)] > heap[leftChild(i)] && rightChild(i) < size) {
        	
        	heap[i] = heap[rightChild(i)];
        	heap[rightChild(i)] = sinkVal;
        	sink(rightChild(i));
        		
        } else if(leftChild(i) < heap.length && heap[leftChild(i)] > sinkVal && leftChild(i) < size) {
        	
        	heap[i] = heap[leftChild(i)];
    		heap[leftChild(i)] = sinkVal;
    		sink(leftChild(i));
        	
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position, starting from the bottom, then
    // progressing upward
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            sink(i);
        }
    }

    /**
     * Best-case runtime: O(n)
     * Worst-case runtime: O(nlog(n))
     * Average-case runtime: O(nlog(n))
     *
     * Space-complexity: O(1)
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);

        for (int i=size-1; i>0; i--) {
        	
        	size--;
        	int root = heap[0];
        	heap[0] = heap[i];
        	heap[i] = root;
        	sink(0);
        	
        }

        return heap;
    }
}
