package collection_framework.practical.binary_tree;

public interface Tree<E> {

    public boolean insert(E element);

    public void inOrder();

    public void postOrder();

    public void preOrder();

    public void breathFirst();

    public boolean search(E element);

    public int getSize();
}
