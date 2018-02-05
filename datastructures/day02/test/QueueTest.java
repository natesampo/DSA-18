import ADTs.QueueADT;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import your_code.MyPriorityQueue;
import your_code.MyQueue;

//import static org.junit.jupiter.api.Assertions.System.out.println;


public class QueueTest {

    private MyQueue queue;
    private MyPriorityQueue maxQueue;

    /**
     * @throws Exception
     */
    //@BeforeEach
    public void setUp() throws Exception {

        queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        maxQueue = new MyPriorityQueue();
        maxQueue.enqueue(1);
        maxQueue.enqueue(2);
        maxQueue.enqueue(3);
    }

    /**
     * Tests functionality of a queue
     */
    public void testQueue(QueueADT<Integer> queue) {
        int e = queue.dequeue();
        System.out.print("");
        System.out.println(e==1);

        queue.enqueue(150);
        System.out.println(queue.isEmpty()==false);

        e = queue.dequeue();
        System.out.println(e==2);
        System.out.println(queue.isEmpty()==false);

        e = queue.dequeue();
        System.out.println(e==3);
        System.out.println(queue.isEmpty()==false);

        e = queue.dequeue();
        System.out.println(e==150);
        System.out.println(queue.isEmpty()==true);
    }

    /**
     * Tests functionality of your_code.MyQueue
     */
    //@Test
    public void testMyQueue() {
    	try {
			setUp();
		} catch (Exception e) {}
        testQueue(queue);
    }

    /**
     * Tests functionality of your_code.MyPriorityQueue
     */
    //@Test
    public void testPriorityQueue() {
    	try {
			setUp();
		} catch (Exception e) {}
        maxQueue.enqueue(5);
        System.out.println(maxQueue.dequeueMax()==5);
        maxQueue.enqueue(2);
        System.out.println(maxQueue.dequeueMax()==3);
        System.out.println(maxQueue.dequeueMax()==2);
        System.out.println(maxQueue.dequeueMax()==2);
        System.out.println(maxQueue.dequeueMax()==1);
    }

    public static void main(String args[]) {
    	QueueTest queueTest = new QueueTest();
    		/*MyQueue queue = new MyQueue();
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);

            MyPriorityQueue maxQueue = new MyPriorityQueue();
            maxQueue.enqueue(1);
            maxQueue.enqueue(2);
            maxQueue.enqueue(3);*/
            
	    	queueTest.testMyQueue();
	    	queueTest.testPriorityQueue();
    }
}
