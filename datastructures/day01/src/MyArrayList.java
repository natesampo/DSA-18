public class MyArrayList {
    private Cow[] elems;
    private int size;

    // Runtime: O(1)
    public MyArrayList(int capacity) {
    	elems = new Cow[capacity];
    	size = 0;
    }

    // Runtime: O(1)
    public MyArrayList() {
        elems = new Cow[10];
        size = 0;
    }

    // Runtime: O(1)
    public void add(Cow c) {
    	if(elems.length == size) {
    		elems = grow();
    	}
    	elems[size] = c;
    	size ++;
    }

    public Cow[] grow() {
    	Cow[] newCows = new Cow[elems.length*2];
    	System.arraycopy(elems,0,newCows,0,elems.length);
		return newCows;
    }
    
    public Cow[] shrink() {
    	Cow[] newCows = new Cow[(int) (elems.length/2)];
    	System.arraycopy(elems,0,newCows,0,elems.length);
		return newCows;
    }
    
    // Runtime: O(n)
    /*public int size() {
        for(int i=0;i<elems.length;i++) {
        	if(elems[i] == null) {
        		return i;
        	}
        }
        return elems.length;
    }*/
    
    public int size() {
    	return size;
    }

    // Runtime: O(1)
    public Cow get(int index) {
        if(index > elems.length) {
        	throw new IndexOutOfBoundsException("There are no cows at " + index);
        } else {
        	return elems[index];
        }
    }

    // Runtime: O(n)
    public Cow remove(int index) {
    	if(index > elems.length) {
        	throw new IndexOutOfBoundsException("There are no cows at " + index);
        } else {
        	Cow tempCow = elems[index];
	    	for(int i=0;i<elems.length-1;i++) {
	    		if(i>=index) {
	    			elems[i] = elems[i + 1];
	    		}
	    	}
	    	elems[elems.length - 1] = null;
	    	size--;
	    	if((int) (elems.length/4) == size) {
	    		elems = shrink();
	    	}
	    	return tempCow;
        }
    }

    // Runtime: O(n)
    public void add(int index, Cow c) {
    	if(index > size) {
        	throw new IndexOutOfBoundsException("Can't add a cow at " + index);
        } else {
        	if(elems.length == size) {
        		elems = grow();
        	}
        	for(int i=elems.length-1;i>=index;i--) {
        		elems[i] = elems[i-1];
        	}
        	elems[index] = c;
        	size++;
        }
    }
}
