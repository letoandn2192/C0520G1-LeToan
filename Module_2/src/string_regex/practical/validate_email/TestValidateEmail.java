package string_regex.practical.validate_email;

public class TestValidateEmail {
    public static final String[] validEmail = new String[] { "a@gmail.com", "ab@yahoo.com", "abc@hotmail.com" };
    public static final String[] invalidEmail = new String[] { "@gmail.com", "ab@gmail.", "@#abc@gmail.com" };

    public static void main(String[] args) {
        for(String element: validEmail){
            System.out.println( element + " : " + ValidateEmail.checkValidateEmail(element));
        }

        for(String element: invalidEmail){
            System.out.println( element + " : " + ValidateEmail.checkValidateEmail(element));
        }
    }
}
