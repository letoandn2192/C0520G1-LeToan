package collection_framework.practical;

public interface Tree<E> {

    public boolean insert(E element);

    public void inorder();

    public int getSize();
}
