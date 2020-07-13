package collection_framework.practical;

public class BST<E extends Comparable<E>> extends AbstractTree<E>{
    protected TreeNode root;
    protected  int size;

    public BST() {
    }

    public BST(E[] element){
        for (int i = 0; i < element.length; i++)
            insert(element[i]);
    }

    @Override
    public boolean insert(Object element) {
        if (this.root == null){
            //this.root = this.createNewNode();
        }
        return false;
    }

    protected TreeNode<E> createNewNode(E element) {
        return new TreeNode<>(element);
    }

    @Override
    public void inorder() {
        inorder(this.root);
    }

    protected void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.println(root.element + " ");
        inorder(root.right);
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
