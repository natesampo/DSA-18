package your_code;

public class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node {
        Chicken val;
        Node prev;
        Node next;

        private Node(Chicken d, Node prev, Node next) {
            this.val = d;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Chicken c) {
        addLast(c);
    }

    public Chicken pop() {
        return removeLast();
    }

    public void addLast(Chicken c) {
    	Node newNode = new Node(c, tail, null);
    	if(tail != null) {
    		tail.next = newNode;
    		tail = newNode;
    	} else {
    		head = newNode;
    		tail = newNode;
    	}
    	size++;
    }

    public void addFirst(Chicken c) {
    	Node newNode = new Node(c, null, head);
    	if(head != null) {
    		head.prev = newNode;
    		head = newNode;
    	} else {
    		head = newNode;
    		tail = newNode;
    	}
    	size++;
    }

    public Chicken get(int index) {
    	Node hd = head;
    	if(index >= size) {
    		throw new IndexOutOfBoundsException("There are no chickens at " + index);
    	}
    	for(int i=0;i<size;i++) {
    		if(i==index) {
    			return hd.val;
    		}
    		hd = hd.next;
    	}
    	return null;
    }

    public Chicken remove(int index) {
    	Node hd = head;
    	int i = 0;
    	if(index >= size) {
    		throw new IndexOutOfBoundsException("There are no chickens at " + index);
    	}
    	while(hd != null) {
    		if(i==index) {
    			hd.prev.next = hd.next;
    			return hd.val;
    		}
    		i++;
    		hd = hd.next;
    	}
    	size--;
    	return null;
    }

    public Chicken removeFirst() {
    	Node tempNode = head;
    	head = head.next;
    	head.prev = null;
    	size--;
    	return tempNode.val;
    }

    public Chicken removeLast() {
    	Node tempNode = tail;
    	tail = tail.prev;
    	tail.next = null;
    	size--;
    	return tempNode.val;
    }
}