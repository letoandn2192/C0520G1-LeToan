package string_regex.exercises.validate_class_name;

import string_regex.practical.validate_account.ValidateAccount;

public class TestValidateClassName {
    public static void main(String[] args) {
        String[] validAccount = new String[] { "C0318G", "A1234K", "P4567L", "C0934H", "A4556I", "P4029M"  };
        String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abide" };

        for (String string : validAccount){
            System.out.println(string + " " + ValidateClassName.checkNameClass(string));
        }

        for (String string : invalidAccount){
            System.out.println(string + " " + ValidateClassName.checkNameClass(string));
        }
    }
}
