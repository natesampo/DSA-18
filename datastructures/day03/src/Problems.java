import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
    	
        List<Integer> l = new LinkedList<>();
        int walker = 0;
        int tempK = k;
        
        	while(l.size() < A.length-tempK) {
        		
        		if(A.length-walker<k) {
        			
        			for(int i=walker;i<A.length;i++) {
        				l.add(A[i]);
        			}
        			
        		} else {
        			
        			int tempMin = 10;
        			int tempMinIndex = 0;
        			
        			for(int i=0;i<=k;i++) {
        				if(k != 1) {
        					
		        			if(A[i + walker]<tempMin) {
		        					
		        				tempMin = A[i + walker];
		        				tempMinIndex = i + walker;
		        					
		        			}
        				} else {
        					
        					for(int j=walker;j<A.length;j++) {
        						
        						if(A[j]<tempMin) {
		        					
    		        				tempMin = A[j];
    		        				tempMinIndex = j;
    		        					
    		        			}
        					}
        					
        				}
        			}
        			
        			l.add(tempMin);
        			k -= tempMinIndex - walker;
        			walker = tempMinIndex + 1;
        			
        		}
        	}
        	
        return l;
    }

    public static boolean isPalindrome(Node n) {
    	
    	Node runner = n;
    	Node walker = n;
    	Node n2;
    	
    	if(n == null || n.next == null) {
			
			return true;
			
		} else if(n.next.next == null) {
			
			return (n.val == n.next.val);
			
		}
    	
    	while(true) {
    		
    		runner = runner.next.next;
    		
    		if(runner.next == null) {
    			
    			n2 = walker.next.next;
    			walker.next = null;
    			break;
    			
    		} else if(runner.next.next == null) {
    			
    			n2 = walker.next.next;
    			walker.next.next = null;
    			break;
    			
    		}
    		
    		walker = walker.next;
    		
    	}
    	
    	Node tempNode1 = null;
    	Node tempNode2 = null;
    	
    	if(n2.next != null) {
    		
	    	tempNode1 = n2;
	    	n2 = n2.next;
	    	tempNode1.next = null;
	    	tempNode2 = tempNode1;
	    	
    	}
    	
    	while(true) {
    		
    		if(n2.next == null) {
    			
    			n2.next = tempNode1;
    			break;
    			
    		} else {
    			
    			tempNode1 = n2;
    			n2 = n2.next;
    			tempNode1.next = tempNode2;
    			tempNode2 = tempNode1;
    			
    		}
    	}
    	
    	while(n.next != null) {
    		
    		if(n.val != n2.val) {
    			return false;
    		}
    		
    		n = n.next;
    		n2 = n2.next;
    		
    	}
    	
    	return true;
    }

    public static String infixToPostfix(String s) {
    	
    	String postFix = "";
    	String sub;
    	Stack<String> subs = new Stack<String>();
    	
    	while(s.contains(")")) {
    		
    		int tempIndex = s.indexOf(")");
    		sub = s.substring(tempIndex - 8, tempIndex+1);
    		
    		subs.push(sub);
    		
    		s = s.replace(sub, "a");
    		
    	}
    	
    	while(!subs.isEmpty()) {
    		
    		String tempStr = subs.pop();
    		tempStr = tempStr.substring(2, tempStr.length()-2);    		
    		tempStr += " " + tempStr.charAt(tempStr.length()-3);
    		tempStr = tempStr.substring(0,2) + tempStr.substring(4, 7);
    		
    		if(postFix.isEmpty()) {
    			postFix += tempStr;
    		} else {
    			postFix = postFix.replace("a", tempStr);
    		}
    		
    	}
    	
    	return postFix;
    }

}
