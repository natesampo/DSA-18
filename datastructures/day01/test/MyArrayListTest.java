// import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.assertTrue;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

public class MyArrayListTest {
    MyArrayList cows = new MyArrayList();

    private static final Cow DELILAH = new Cow("Delilah", 10, "blue");
    private static final Cow GEORGY = new Cow("Georgy", 8, "green");
    private static final Cow LILY = new Cow("Lily", 4, "yellow");
    private static final Cow JIMY = new Cow("Jimi", 13, "black");
    private static final Cow JAQUAN = new Cow("Jaquan", 10, "transparent");
    private static final Cow LEGOS = new Cow("Legos", 400, "rainbow");

    //@BeforeEach
    public void setUp() throws Exception{
        cows = new MyArrayList(4);
        cows.add(DELILAH);
        cows.add(GEORGY);
        cows.add(LILY);
        cows.add(JIMY);
    }

    // @Test
    public void testSize(){
        System.out.println(4==cows.size());
    }

    // @Test
    public void testGet(){
    	System.out.println(GEORGY==cows.get(1));
    	System.out.println(LILY==cows.get(2));
    }

    // @Test
    public void testRemove(){
        cows.remove(1);
        cows.remove(1);
        System.out.println(2==cows.size());
        System.out.println(JIMY==cows.get(1));
    }

    // @Test
    public void testAddIndex(){
        cows.add(1,JAQUAN);
        cows.add(1,LEGOS);
        System.out.println(6==cows.size());
        System.out.println(JAQUAN==cows.get(2));
    }

    // @Test
    public void testAddIndexThrows(){
        cows.add(4,JAQUAN);
        System.out.println(5==cows.size());
        boolean error = false;
        try {
            cows.add(6,JAQUAN);
        } catch(IndexOutOfBoundsException e) {
            error = true;
        }
        System.out.println(error);
    }

    // @Test
    public void testRemoveThrows(){
        boolean error = false;
        try {
            cows.remove(4);
        } catch(IndexOutOfBoundsException e) {
            error = true;
        }
        System.out.println(error);
    }

    // @Test
    public void testResize(){
        MyArrayList resizeCows = new MyArrayList();
        for (int i = 0; i < 1000; i++) {
            String name = "Cow" + i;
            int age = i;
            String color = "Color" + i;
            resizeCows.add(new Cow(name,age,color));
        }

        System.out.println(1000==resizeCows.size());
        System.out.println(new Cow("Cow996", 996, "Color996")==resizeCows.get(996));
    }
    public static void main(String args[]) throws Exception {
    	MyArrayListTest tests = new MyArrayListTest();
    	tests.setUp();
    	try {
    		tests.testSize();
    	} catch(Exception e) {
    		System.out.println("Test 1 failed due to " + e);
    	}
    	tests.setUp();
    	try {
    		tests.testGet();
    	} catch(Exception e) {
    		System.out.println("Test 2 failed due to " + e);
    	}
    	tests.setUp();
    	try {
    		tests.testRemove();
    	} catch(Exception e) {
    		System.out.println("Test 3 failed due to " + e);
    	}
    	tests.setUp();
    	try {
    		tests.testAddIndex();
    	} catch(Exception e) {
    		System.out.println("Test 4 failed due to " + e);
    	}
    	tests.setUp();
    	try {
    		tests.testAddIndexThrows();
    	} catch(Exception e) {
    		System.out.println("Test 5 failed due to " + e);
    	}
    }
}
