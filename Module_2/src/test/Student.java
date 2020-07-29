package test;

public class Student extends Person implements Comparable<Student>{
    private String code;
    private String Name;

    public Student(String code, String name) {
        this.code = code;
        Name = name;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int compareTo(Student o) {
        return this.code.compareTo(o.getCode());
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }
}
