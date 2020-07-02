package array_and_method_in_array.exercises;

public class TinhTongDuongCheoChinh {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = (int)Math.floor(Math.random() * 100);
            }
        }

        System.out.println("Mảng đã khởi tạo: ");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }

        int sum1 = 0;
        for(int i = 0; i < array.length; i++){
            sum1 += array[i][i];
        }
        System.out.println("Tổng của đường chéo chính là: "+sum1);

        int sum2 = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
               if(i+j == array.length-1){
                   sum2 += array[i][j];
               }
            }
        }
        System.out.println("Tổng của đường chéo phụ là: "+sum2);
    }
}
