package loop_in_java.exercises;


public class HienThiSoNGuyenToNhoHon100 {
    public static void main(String[] args) {
        int n = 2;
        String result = "";
        while (n < 100){
            boolean check = true;
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n%i == 0){
                    check = false;
                }
            }
            if(check){
                result += n + " ";
            }
            n++;
        }
        System.out.println("Dãy số nguyên tố là: "+ result);

    }
}
