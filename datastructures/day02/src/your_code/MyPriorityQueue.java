package your_code;



/**
 * An implementation of a priority Queue
 */
public class MyPriorityQueue {
	
    private int[] q;
    private int size=0;
    private Node head = null;
    
    private class Node {
        int val;
        Node prev;
        Node next;

        private Node(int d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }
    }

    public void enqueue(int item) {
    	if(head==null) {
    		Node newNode = new Node (item, null, null);
    		head = newNode;
    	}
    	Node walker = head;
    	while(walker != null && walker.val > item) {
    		walker = walker.next;
    	}
    	Node newNode = new Node(item, walker.prev, walker);
    	if(walker.prev != null) {
    		walker.prev.next = newNode;
    	}
    	walker.prev = newNode;
    	if(newNode.val > head.val) {
    		head = newNode;
    	}
    	size ++;
    }

    /**
     * Return and remove the largest item on the queue.
     */
    
    public int dequeueMax() {
    	if(head!=null) {
	    	Node tempNode = head;
	        head = head.next;
	        if(head != null) {
	        	head.prev = null;
	        }
	        size--;
	        return tempNode.val;
    	} else {
    		System.out.println("No items to dequeue");
    		return 0;
    	}
    }
}