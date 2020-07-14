package collection_framework.practical.binary_tree;

import java.util.Deque;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size;

    public BST() {
    }

    public BST(E[] element) {
        for (int i = 0; i < element.length; i++)
            insert(element[i]);
    }

    public TreeNode<E> getRoot() {
        return this.root;
    }

    public void setRoot(TreeNode<E> root) {
        this.root = root;
    }

    @Override
    public void search(Object element) {
        search(this.root, (E) element);
    }

    public boolean search(TreeNode root, E element) {
        if (root == null) {
            return false;
        }
        if(root.element == element){
            return true;
        }
        if (element.compareTo((E) root.element) < 0) {
            return search(root.left, element);
        }
        return search(root.right, element);
    }

    public void delete(E element){
        System.out.println(delete(this.root, element));
    }

    public boolean delete(TreeNode root, E element){
        if(root == null){
            return false;
        }else if (element.compareTo((E)root.element) < 0){
            delete(root.left, element);
        }else if(element.compareTo( (E)root.element) > 0){
            delete(root.right, element);
        }else {
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.left == null){
                root = root.right;
            }else if(root.right == null){
                root =  root.left;
            }else {
                root.element = findMinValue(root.right);
                delete(root.right, (E)root.element);
            }
        }
        return true;
    }

    public E findMinValue(TreeNode root){
        E min = (E) root.element;
        while (root.left != null){
            min = (E) root.left.element;
            root = root.left;
        }
        return min;
    }

    @Override
    public boolean insert(Object e) {
        E element = (E) e;
        if (this.root == null) {
            this.root = this.createNewNode(element);
        } else {
            TreeNode<E> parent = null;
            TreeNode<E> current = this.root;
            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false;
                }
            }

            if (element.compareTo(parent.element) < 0) {
                parent.left = this.createNewNode(element);
            } else {
                parent.right = this.createNewNode(element);
            }
        }
        size++;
        return true;
    }

    protected TreeNode<E> createNewNode(E element) {
        return new TreeNode<>(element);
    }

    @Override
    public void postOrder() {
        postOrder(this.root);
    }

    protected void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preOrder() {
        preOrder(this.root);
    }

    @Override
    public void breathFirst() {
        breathFirst(this.root);
    }

    public void breathFirst(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        treeNodeDeque.add(root);
        while (!treeNodeDeque.isEmpty()) {
            TreeNode current = treeNodeDeque.getFirst();
            System.out.print(treeNodeDeque.poll().element + " ");
            if (current.left != null) {
                treeNodeDeque.add(current.left);
            }
            if (current.right != null) {
                treeNodeDeque.add(current.right);
            }
        }
    }

    protected void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.element + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    @Override
    public void inOrder() {
        inOrder(this.root);
    }

    protected void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.element + " ");
        inOrder(root.right);
    }

    @Override
    public int getSize() {
        return this.size;
    }
}
