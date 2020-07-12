package dsa_list.practical.linkedlist_simple;

public class MyLinkedListTest {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.printList();
        System.out.println();
        ll.add(4,9);
        ll.add(4,5);
        ll.printList();
}
}
