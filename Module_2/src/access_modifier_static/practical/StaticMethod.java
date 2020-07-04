package access_modifier_static.practical;

public class StaticMethod {
    public static void main(String[] args) {
        Student student = new Student("hien");
        Student.change();
        Student.setCollege("Mai");
        student.display();
    }

}

class Student{
    private static int id = 0;
    private String name;
    private static String college = "Jame";

    Student(String name){
        this.name = name;
        id++;
    }
    static void change(){
        college = "Ada";
    }

    void display(){
        System.out.println(id + " Hieen map " + college);
    }

    public static void setCollege(String abc) {
        college = abc;
    }
}