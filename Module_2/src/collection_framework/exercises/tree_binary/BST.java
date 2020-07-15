package collection_framework.exercises.tree_binary;

import java.util.Deque;
import java.util.LinkedList;

public class BST<E extends Comparable<E>> {
    protected Tree<E> root;

    ////////insert element/////////////////////////////
    public void insert(E element) {
        if (this.root == null) {
            this.root = new Tree<>(element);
        } else {
            Tree<E> current = this.root;
            Tree<E> parent = null;
            while (current != null) {
                if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else {
                    return;
                }
            }

            if (element.compareTo(parent.element) > 0) {
                parent.right = new Tree<>(element);
            } else {
                parent.left = new Tree<>(element);
            }
        }
    }

    //////////////////////////Print element//////////////////////////////
    public void print(Tree root) {
        if (root == null) {
            return;
        }
        Deque<Tree> queue = new LinkedList<>();
        queue.add(this.root);
        while (!queue.isEmpty()) {
            Tree<E> current = queue.peek();
            System.out.print(queue.poll().element + " ");
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    /////////////////////////////Delete//////////////////////////////
    public Tree<E> delete(Tree root, E element) {
        if (root == null) {
            return null;
        } else if (element.compareTo((E) root.element) < 0) {
            root.left = delete(root.left, element);
        } else if (element.compareTo((E) root.element) > 0) {
            root.right = delete(root.right, element);
        } else {
            if (root.right == null && root.left == null) {
                return null;
            } else if (root.right == null) {
                root = root.left;
            } else if (root.left == null) {
                root = root.right;
            } else {
                root.element = findMinvalue(root.right);
                root.right = delete(root.right, (E) root.element);
            }
        }
        return root;
    }

    public E findMinvalue(Tree root) {
        E min = (E) root.element;
        while (root.left != null) {
            min = (E) root.left.element;
            root = root.left;
        }
        return min;
    }

    public boolean search(Tree root, E element) {
        if (root == null) {
            return false;
        } else if (root.element == element) {
            return true;
        } else if (element.compareTo((E) root.element) < 0) {
            return search(root.left, element);
        } else {
            return search(root.right, element);
        }
    }

}
