package sorting.day03.src;

import java.util.LinkedList;

import sorting.day03.src.RadixSort;

public class Problems {

    public static void sortNumsBetween100s(int[] A) {
        for(int i=0;i<A.length;i++) {
        	A[i] += 100;
        }
        
        RadixSort.radixSort(A, 10);
        
        for(int i=0;i<A.length;i++) {
        	A[i] -= 100;
        }
    }

    /**
     * @param n the character number, 0 is the rightmost character
     * @return
     */
    private static int getNthCharacter(String s, int n) {
        return s.charAt(s.length() - 1 - n) - 'a';
    }


    /**
     * Use counting sort to sort the String array according to a character
     *
     * @param n The digit number (where 0 is the least significant digit)
     */
    public static void countingSortByCharacter(String[] A, int n) {
    	LinkedList<String>[] L = new LinkedList[26];
        for (int i = 0; i < 26; i++)
            L[i] = new LinkedList<>();
        for (String i : A) {
        	L[getNthCharacter(i, n)].add(i);
        }
        int j = 0; // index in A to place numbers
        for (LinkedList<String> list : L) {
        	for(int i=0;i<list.size();i++) {
        		A[j] = list.get(i);
        		j++;
        	}
        }
    }

    /**
     * @param stringLength The length of each of the strings in S
     */
    public static void sortStrings(String[] S, int stringLength) {
    	int k = S[0].length();
        for (int i = 1; i < S.length; i++) {
        	if((S[i].length())>k) {
        		k = S[i].length();
        	}
        }
        
        for(int i=0;i<k;i++) {
        	countingSortByCharacter(S, i);
        }
    }

    /**
     * @param A The array to count swaps in
     */

    public static int countSwaps(int[] A) {
        // TODO
        return 0;
    }

}