package collection_framework.exercises.tree_binary;

public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(35);
        tree.insert(15);
        tree.insert(17);
        tree.insert(5);

        tree.delete(tree.root, 15);
        System.out.println(tree.search(tree.root,15));
        tree.print(tree.root);
    }
}
