package array_and_method_in_array.bai_tap;

public class GopMang {
    public static void main(String[] args) {
        int[] array1 = new int[5];
        int[] array2 = new int[10];
        int[] array3 = new int[array1.length + array2.length];
        for(int i = 0; i < array1.length; i++){
            array1[i] = (int)(Math.floor(Math.random() * 100));
        }
        System.out.print("Mảng 1: ");
        for(int element:array1){
            System.out.print(element + " ");
        }
        for(int i = 0; i < array2.length; i++){
            array2[i] = (int)(Math.floor(Math.random() * 100));
        }
        System.out.println("");
        System.out.print("Mảng 2: ");
        for(int element:array2){
            System.out.print(element + " ");
        }
        for(int i = 0; i < array1.length; i++){
            array3[i] = array1[i];
        }
        for(int i = 0; i < array2.length; i++){
            array3[array1.length + i] = array2[i];
        }
        System.out.println("");
        System.out.print("Mảng 3: ");
        for(int element:array3){
            System.out.print(element + " ");
        }
    }
}
