package collection_framework.practical.binary_tree;

import java.util.Comparator;

public class TreeNode<E>  {
    protected E element;
    protected TreeNode<E> right;
    protected TreeNode<E> left;

    public TreeNode(E element) {
        this.element = element;
    }
}
