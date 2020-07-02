package array_and_method_in_array.exercises;

public class TimGTLNTrongMang2Chieu {
    public static void main(String[] args) {
        int[][] array = new int[4][4];
        int row = 0;
        int col = 0;
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                array[i][j] = (int)(Math.floor(Math.random() * 100));
            }
        }
        System.out.println("Mảng tạo được: ");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.printf("%-3d",array[i][j]);
            }
            System.out.println("");
        }
        int max = array[0][0];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(max < array[i][j]){
                    max = array[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        System.out.println("GTLN của mảng là: "+ max + " ở vị trí "+ "["+row+"]"+ "["+col+"]");
    }
}
