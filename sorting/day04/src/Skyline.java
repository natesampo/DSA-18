package sorting.day04.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Skyline {

    public static class Point {
        public int x;
		public int y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static class Building {
        private int l, r, h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static ArrayList<Point> skyline(Building[] B) {
    	ArrayList<Point> returnList = new ArrayList<Point>();
    	/*HashMap<Integer, Integer> maxHeight = new HashMap<Integer, Integer>();
    	int maxR = 0, minL = B[0].l;
        
    	for(Building tempBuilding : B) {
    		
    		if(tempBuilding.r > maxR) {
    			maxR = tempBuilding.r;
    		}
    		
    		if(tempBuilding.l < minL) {
    			minL = tempBuilding.l;
    		}
    		
    		for(int i=tempBuilding.l;i<tempBuilding.r;i++) {
    			
    			if(maxHeight.containsKey(i)) {
    				if(tempBuilding.h > maxHeight.get(i)) {
    					maxHeight.put(i, tempBuilding.h);
    				}
    			} else {
    				maxHeight.put(i, tempBuilding.h);
    			}
    			
    		}
    		
    	}
    	
    	for(int i=minL;i<maxR;i++) {
    		
    		if(maxHeight.get(i) == null) {
    			maxHeight.put(i, 0);
    		}
    		
    		if(i == minL) {
    			returnList.add(new Point(i, maxHeight.get(i)));
    		} else if(maxHeight.get(i) != returnList.get(returnList.size()-1).y) {
    			returnList.add(new Point(i, maxHeight.get(i)));
    		}
    		
    	}
    	
    	returnList.add(new Point(maxR, 0));
    	
        return returnList;*/
    	
    	int currentHeight = 0, leftWalker = 0, rightWalker = 0, tempHeight = 0;
    	
    	if(B.length == 1) {
    		returnList.add(new Point(B[0].l, B[0].h));
    		returnList.add(new Point(B[0].r, 0));
    	} else {
    		ArrayList<Point> leftList = skyline(Arrays.copyOfRange(B, 0, B.length/2)), rightList = skyline(Arrays.copyOfRange(B, B.length/2, B.length));
    		int maxR = Math.max(leftList.get(leftList.size()-1).x, rightList.get(rightList.size()-1).x);
    		for(int i=0;i<=maxR;i++) {
    			
    			if(leftList.size()-1 > leftWalker && leftList.get(leftWalker+1).x == i) {
    				leftWalker++;
    			}
    			
    			if(rightList.size()-1 > rightWalker && rightList.get(rightWalker+1).x == i) {
    				rightWalker++;
    			}
    			
    			Point tempLeft = leftList.get(leftWalker), tempRight = rightList.get(rightWalker);
    			if(tempLeft.x <= i && tempRight.x <= i) {
    				tempHeight = Math.max(tempLeft.y, tempRight.y);
    			} else if(tempLeft.x <= i) {
    				tempHeight = tempLeft.y;
    			} else if(tempRight.x <= i) {
    				tempHeight = tempRight.y;
    			}
    			
    			if(tempHeight != currentHeight) {
    				returnList.add(new Point(i, tempHeight));
    				currentHeight = tempHeight;
    			}
    		}
    	}
    	
    	return returnList;
    }
}
