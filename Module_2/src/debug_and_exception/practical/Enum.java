package debug_and_exception.practical;

public class Enum {
    public static void main(String[] args){
        try{
            fraction(1,0);
        }catch (ArithmeticException e){
            System.out.println("Hello");
            //e.printStackTrace();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("leo leo");
        }
        System.out.println("alo");
    }

    public static void fraction(int a, int b) throws ArithmeticException, ArrayIndexOutOfBoundsException{
        if(b == 0) {
            throw new ArithmeticException();
        }else {
            a = b;
            throw new ArrayIndexOutOfBoundsException();
        }

    }
}
