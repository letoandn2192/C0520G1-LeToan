package access_modifier_static.exercises;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isExist;
        StudentCodeGym student1 = new StudentCodeGym(111, "Le Toan", "02/01/1993");
        StudentCodeGym student2 = new StudentCodeGym(222, "Le Hung", "02/01/1990");
        StudentCodeGym student3 = new StudentCodeGym(333, "Le Quang", "02/01/1983");
        StudentCodeGymClass listStudent = new StudentCodeGymClass();
        listStudent.register(student1);
        listStudent.register(student2);
        listStudent.register(student3);
        while (true) {
            System.out.println("Menu");
            System.out.println("1. Add New Student.");
            System.out.println("2. Delete Student.");
            System.out.println("3. Display All Student.");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    int addId;
                    do {
                        isExist = false;
                        System.out.print("Enter student's id: ");
                        addId = input.nextInt();
                        for (int i = 0; i < listStudent.getSize(); i++) {
                            if (listStudent.getIdStudent(i) == addId) {
                                System.out.println("Id da co. Nhap lai!!!");
                                isExist = true;
                                break;
                            }
                        }
                    } while (isExist);
                    System.out.print("Enter student's name: ");
                    String addName = input.nextLine();
                    addName = input.nextLine();
                    System.out.print("Enter student's date of birth: ");
                    String addDate = input.nextLine();
                    StudentCodeGym student = new StudentCodeGym(addId, addName, addDate);
                    listStudent.register(student);
                    break;
                case 2:
                    isExist = false;
                    System.out.println("Enter id you want to delete: ");
                    int delId = input.nextInt();
                    char confirm;
                    int index = 0;
                    for (int i = 0; i < listStudent.getSize(); i++) {
                        if (delId == listStudent.getIdStudent(i)) {
                            isExist = true;
                            index = i;
                        }
                    }
                    if (isExist) {
                        System.out.println("You want to remove this student!!!");
                        System.out.println(listStudent.getIdStudent(index) + " " + listStudent.getNameStudent(index) + " " + listStudent.getDateOfBirthStudent(index));
                        System.out.print("Yes or No: ");
                        confirm = input.next().charAt(0);
                        if (confirm == 'y' || confirm == 'Y') {
                            listStudent.graduate(delId);
                            break;
                        } else {
                            System.out.println("Nothing change");
                        }
                    } else {
                        System.out.println("No exist this student.");
                    }
                    break;
                case 3:
                    listStudent.displayListStudent();
                    break;
                default:
                    System.out.println("Invalid value!!!");
            }
        }
    }
}
