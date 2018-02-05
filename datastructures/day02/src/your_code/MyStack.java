package your_code;
import ADTs.StackADT;

import java.util.LinkedList;

/**
 * An implementation of the Stack interface.
 */
public class MyStack implements StackADT<Integer> {

    private LinkedList<Integer> ll;
    private MyStack max;
    private MyStack min;

    public MyStack() {
        ll = new LinkedList<>();
    }

    @Override
    public void push(Integer e) {
    	if(ll.isEmpty()) {
    		max.push(e);
    		min.push(e);
    	} else {
    		if(e > max.peek()) {
    			max.push(e);
    		} else {
    			max.push(max.peek());
    		}
    		
    		if(e < min.peek()) {
    			min.push(e);
    		} else {
    			min.push(min.peek());
    		}
    	}
        ll.addFirst(e);
    }

    @Override
    public Integer pop() {
        Integer pop = ll.removeFirst();
        max.ll.removeFirst();
        min.ll.removeFirst();
        return pop;
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public Integer peek() {
        return ll.getFirst();
    }

    public Integer maxElement() {
        return max.pop();
    }
    
    public Integer minElement() {
        return min.pop();
    }
}
