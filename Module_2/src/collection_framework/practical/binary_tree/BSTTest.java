package collection_framework.practical.binary_tree;

public class BSTTest {
    public static void main(String[] args) {
        Integer[] array = {60, 55, 100, 45, 57, 67, 107, 59, 101};
        BST<Integer> tree = new BST<>(array);

        System.out.println("inOrder (sorted): ");
        tree.inOrder();
        System.out.println();
        System.out.println("postOrder (sorted): ");
        tree.postOrder();
        System.out.println();
        System.out.println("preOrder (sorted): ");
        tree.preOrder();
        System.out.println();
        System.out.println("breathFirst (sorted): ");
        tree.breathFirst();

        System.out.println();
        System.out.println("-------------------------------------------");
        tree.delete(60);
        System.out.println("breathFirst (sorted): ");
        tree.breathFirst();
        System.out.println();

        System.out.println(tree.search(57));
    }
}
