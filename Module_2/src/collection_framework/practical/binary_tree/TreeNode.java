package collection_framework.practical.binary_tree;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> right;
    protected TreeNode<E> left;

    public TreeNode(E element) {
        this.element = element;
    }
}
