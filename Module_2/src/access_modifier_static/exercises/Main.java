package access_modifier_static.exercises;

public class Main {
    public static void main(String[] args) {
        StudentCodeGym student1 = new StudentCodeGym(111, "Le Toan", "02/01/1993");
        StudentCodeGym student2 = new StudentCodeGym(222, "Le Hung", "02/01/1990");
        StudentCodeGym student3 = new StudentCodeGym(333, "Le Quang", "02/01/1983");
        StudentCodeGym student4 = new StudentCodeGym(444, "Le Tuan", "02/01/1999");
        StudentCodeGym student5 = new StudentCodeGym(555, "Le Hanh", "02/01/1998");
        StudentCodeGym student6 = new StudentCodeGym(666, "Le Cuong", "02/01/1995");
        StudentCodeGymClass listStudent = new StudentCodeGymClass();
        listStudent.register(student1);
        listStudent.register(student2);
        listStudent.register(student3);
        listStudent.register(student4);
        listStudent.register(student5);
        listStudent.register(student6);
        listStudent.displayListStudent();
        listStudent.graduate(student3);
        listStudent.displayListStudent();
    }
}
