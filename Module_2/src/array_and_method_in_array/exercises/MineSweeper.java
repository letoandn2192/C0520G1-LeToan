package array_and_method_in_array.exercises;

public class MineSweeper {
    public static void main(String[] args) {
        String[][] map = {{"*", ".", "*", ".", "."}, {"*", ".", "*", ".", "."}, {"*", "*", "*", ".", "."}};
        for(int i = 0; i < map.length; i++){
            for(int j =0; j < map[i].length; j++) {
                if (map[i][j].equals("*")) {
                    System.out.print("* ");
                } else {
                    int check = 0;
                    ////////////////////////////////////////UP BORDER/////////////////////////////////////////////
                    if (i - 1 >= 0 && j - 1 >= 0 && map[i-1][j-1].equals("*") ) {
                        check++;
                    }
                    if (i - 1 >= 0 && map[i-1][j].equals("*") ) {
                        check++;
                    }
                    if (i - 1 >= 0 && j + 1 < map[i].length && map[i-1][j+1].equals("*") ) {
                        check++;
                    }
                    ////////////////////////////////////SIZE BORDER//////////////////////////////////////////////
                    if (j - 1 >= 0 && map[i][j-1].equals("*")) {
                        check++;
                    }
                    if (j + 1 < map[i].length && map[i][j-1].equals("*")) {
                        check++;
                    }
                    ///////////////////////////////////////DOWN BORDER////////////////////////////////////////////
                    if (i + 1 < map.length && j - 1 >= 0 && map[i+1][j-1].equals("*") ) {
                        check++;
                    }
                    if (i + 1 < map.length && map[i+1][j].equals("*") ) {
                        check++;
                    }
                    if (i + 1 < map.length && j + 1 < map[i].length && map[i+1][j+1].equals("*") ) {
                        check++;
                    }
                    System.out.print(String.valueOf(check) + " ");
                }
            }
            System.out.println();
        }
    }
}
