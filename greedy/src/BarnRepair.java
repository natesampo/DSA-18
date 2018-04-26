package greedy.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BarnRepair {
    public static int solve(int M, int[] occupied) {
    	int blockedStalls = occupied.length;
    	
    	if (M == 1) {
    		return M;
    	}
        Arrays.sort(occupied);

        ArrayList<Integer> gaps = new ArrayList<>();

        for (int stallIndex = 0; stallIndex < occupied.length-1; stallIndex++) {
            if (occupied[stallIndex] + 1 != occupied[stallIndex+1]) {
                gaps.add(occupied[stallIndex+1] - occupied[stallIndex]);
            }
        }
        Collections.sort(gaps);
        int overBudget = gaps.size() + 1 - M;
        while (overBudget > 0) {
            blockedStalls += gaps.get(overBudget);
            overBudget--;
        }
        return blockedStalls;
    }
}