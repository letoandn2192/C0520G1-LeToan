package test.hashmap;

public class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int hashCode() {
        return 5* name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Student otherStudent = (Student) obj;
        if (this.age == otherStudent.getAge()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

//    @Override
//    public int compareTo(Student student) {
//        return this.age - student.age;
//    }
}
