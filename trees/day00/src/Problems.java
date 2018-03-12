package trees.day00.src;

import java.util.*;

import trees.day00.src.TreeNode;

public class Problems {

    public static BinarySearchTree<Integer> minimalHeight(List<Integer> values) {
        // TODO
        return new BinarySearchTree<>();
    }

    public static boolean isIsomorphic(trees.day00.src.TreeNode<Integer> n1, trees.day00.src.TreeNode<Integer> n2) {
        if(n1==null && n2==null) {
            return true;
        } else if (!(n1==null || n2==null) && n1.key == n2.key) {
        	if (isIsomorphic(n1.leftChild, n2.leftChild) && isIsomorphic(n1.rightChild, n2.rightChild)) {
                return true;
        	} else {
        		return (isIsomorphic(n1.leftChild, n2.rightChild) && isIsomorphic(n1.rightChild, n2.leftChild));
        	}
        }
        return false;
    }
}
