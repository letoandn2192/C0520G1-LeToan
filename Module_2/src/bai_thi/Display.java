package bai_thi;

public class Display {
    public static String mainMenu(){
        return  "*************************MENU*****************************" + "\n" +
                "*              1. Add New Product.                       *" + "\n" +
                "*              2. Delete Product.                        *" + "\n" +
                "*              3. Show Product.                          *" + "\n" +
                "*              4. Search Information of Product.         *" + "\n" +
                "*              5. Exit.                                  *" + "\n" +
                "**********************************************************";
    }

    public static String addProductMenu(){
        return  "1. Add Import Product." + "\n" +
                "2. Add Export Product." + "\n" +
                "3. Back to Menu." + "\n" +
                "4. Exit.";
    }
}
