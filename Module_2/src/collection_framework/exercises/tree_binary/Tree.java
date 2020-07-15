package collection_framework.exercises.tree_binary;

public class Tree<E> {
    protected Tree left;
    protected Tree right;
    protected E element;

    public Tree(E element) {
        this.element = element;
    }
}
