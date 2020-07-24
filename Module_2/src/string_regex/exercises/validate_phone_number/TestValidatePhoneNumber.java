package string_regex.exercises.validate_phone_number;

public class TestValidatePhoneNumber {
    public static void main(String[] args) {
        String[] validAccount = new String[] { "(84)-(0978489648)" };
        String[] invalidAccount = new String[] { "(a8)-(22222222)" };

        for (String string : validAccount){
            System.out.println(string + " " + ValidatePhoneNumber.checkPhoneNumber(string));
        }

        for (String string : invalidAccount){
            System.out.println(string + " " + ValidatePhoneNumber.checkPhoneNumber(string));
        }
    }
}
