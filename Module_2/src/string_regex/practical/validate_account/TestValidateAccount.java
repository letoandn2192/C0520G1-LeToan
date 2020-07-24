package string_regex.practical.validate_account;

import string_regex.practical.validate_email.ValidateEmail;

import java.util.Scanner;

public class TestValidateAccount {
    public static void main(String[] args) {
        String[] validAccount = new String[] { "123abc_", "_abc123", "______", "123456","abcdefgh" };
        String[] invalidAccount = new String[] { ".@", "12345", "1234_", "abcde" };

        for (String string : validAccount){
            System.out.println(string + " " + ValidateAccount.checkValidateAccount(string));
        }

        for (String string : invalidAccount){
            System.out.println(string + " " + ValidateAccount.checkValidateAccount(string));
        }
    }
}
