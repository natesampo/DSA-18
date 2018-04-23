package graphs.day01.src;

import java.util.LinkedList;
import java.util.List;

public class Permutations {
	
	static private class Number {
		int num;
		public Number(int i) {
			num = i;
		}
	}

    public static List<List<Integer>> permutations(List<Integer> A) {
        List<Number> unused = new LinkedList<>();
        List<List<Integer>> permutations = new LinkedList<>();
        
        for(int i : A) {
        	unused.add(new Number(i));
        }
        
        getPermutations(new LinkedList<>(), unused, permutations);
        
        return permutations;
    }

    
    public static void getPermutations(List<Integer> current, List<Number> unused, List<List<Integer>> permutations) {
    	if(unused.size() == 0) {
    		permutations.add(current);
    	}
    	
    	for(int i=0;i<unused.size();i++) {
    		current.add(unused.get(i).num);
    		Number tempNum = unused.remove(i);
    		getPermutations(current, unused, permutations);
    		current.remove(0);
    		unused.add(tempNum);
    	}
    }
}