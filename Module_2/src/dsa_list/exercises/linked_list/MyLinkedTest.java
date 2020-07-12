package dsa_list.exercises.linked_list;



public class MyLinkedTest {
    public static void main(String[] args) {
        MyLinkedList array = new MyLinkedList();
        array.addFirst(11);
        array.addFirst(12);
        array.addFirst(13);
        array.addLast(14);

        for(int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + "\t");
        }
        System.out.println();
        System.out.println("------------------");
        System.out.println(array.getFirst());
    }
}
