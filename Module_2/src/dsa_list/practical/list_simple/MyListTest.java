package dsa_list.practical.list_simple;

public class MyListTest {
    public static void main(String[] args) {
        MyList array = new MyList();
        array.addLast(1);
        array.addLast(3);
        array.addLast(2);
        array.addLast(4);
        System.out.println("Before-Array:");
        for(int i =0; i < array.getSize(); i++){
            System.out.print(array.get(i)+"\t");
        }
        System.out.println("\n"+"After-Array:");
        array.addFirst(7);
        array.addFirst(8);
        array.addFirst(9);


        for(int i =0; i < array.getSize(); i++){
            System.out.print(array.get(i)+"\t");
        }
    }
}
