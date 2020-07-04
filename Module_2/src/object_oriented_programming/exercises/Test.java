package object_oriented_programming.exercises;

public class Test {
    String name;
    int age;
    Test(String name, int age){
        this.name = name;
        this.age = age;
    }
    public static void swap(Test human1, Test human2){
        Test temp = human1;
        human1 = human2;
        human2 = temp;
    }
    public static void main(String[] args) {
        Test mai = new Test("mai", 25);
        Test dat = new Test("dat", 28);
        swap(mai, dat);
        System.out.println(dat.name + " " + dat.age);
    }
}
