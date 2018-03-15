package trees.day02.src;

public class TreeNode<T extends Comparable>{
    public T key;
    public TreeNode<T> leftChild;
	public TreeNode<T> rightChild;
    public boolean color;

    public TreeNode(T key) {
        this(key, RedBlackTree.RED);
    }
    public TreeNode(T key, boolean color){
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
        this.color = color;
    }
}