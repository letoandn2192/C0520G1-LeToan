package dsa_stack_queue.exercises.demerging;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        List<Employee> listEmployee = new ArrayList<>();
        listEmployee.add( new Employee("Tran Phuong Tuyen", "female", "1994/20/09"));
        listEmployee.add( new Employee("Le Toan", "male", "1993/01/02"));
        listEmployee.add( new Employee("Le Ha my", "female", "2004/09/17"));
        listEmployee.add( new Employee("Le Cuong", "male", "1967/01/05"));
        listEmployee.add( new Employee("Nguyen Thi Ngoc ha", "female", "1970/08/15"));

        System.out.println("pre-sort");
        for(int i =0; i < listEmployee.size(); i++){
            System.out.println(listEmployee.get(i));
        }

        Collections.sort(listEmployee);

        System.out.println("sort by date of birth");
        for(int i =0; i < listEmployee.size(); i++){
            System.out.println(listEmployee.get(i));
        }

        Deque<Employee> male = new LinkedList<>();
        Deque<Employee> female = new LinkedList<>();
        for(int i = 0; i < listEmployee.size(); i++){
            if("female".equals(listEmployee.get(i).getGender())){
                female.add(listEmployee.get(i));
            }else {
                male.add(listEmployee.get(i));
            }
        }
        int count = 0;
        while (!female.isEmpty()){
            listEmployee.set(count, female.pop());
            count++;
        }

        while (!male.isEmpty()){
            listEmployee.set(count, male.pop());
            count++;
        }

        System.out.println("sort by gender");
        for(int i =0; i < listEmployee.size(); i++){
            System.out.println(listEmployee.get(i));
        }
    }
}
