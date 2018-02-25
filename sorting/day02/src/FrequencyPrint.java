package sorting.day02.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyPrint {

    public static String frequencyPrint(String s) {
        String[] words = s.split(" ");
    	HashMap<String, Integer> frequency = new HashMap<String, Integer>();
    	String returnString = "";
    	
    	for(int i=0;i<words.length;i++) {
    		if(frequency.containsKey(words[i])) {
    			frequency.put(words[i], frequency.get(words[i])+1);
    		} else {
    			frequency.put(words[i], 1);
    		}
    	}
    	
    	Map<Integer, ArrayList<String>> frequency1 = new HashMap<Integer, ArrayList<String>>();
        for(String tempString : frequency.keySet()) {
        	int tempFrequency = frequency.get(tempString);
        	if(frequency1.containsKey(tempFrequency)) {
        		ArrayList<String> tempList = frequency1.get(tempFrequency);
        		tempList.add(tempString);
        		frequency1.put(tempFrequency, tempList);
        	} else {
        		ArrayList<String> tempList = new ArrayList<String>();
        		tempList.add(tempString);
        		frequency1.put(tempFrequency, tempList);
        	}
        }
        
        ArrayList<String> returnList = new ArrayList<String>();
        for (int i=0;i<words.length;i++) {
        	if(frequency1.containsKey(i)) {
        		returnList = frequency1.get(i);
        		for(int j=0;j<returnList.size();j++) {
        			for(int k=0;k<i;k++) {
        				returnString += returnList.get(j) + " ";
        			}
        		}
        	}
        }
        
        return returnString;
    }

}
