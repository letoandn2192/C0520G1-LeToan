package access_modifier_static.exercises;
import java.util.ArrayList;

public class StudentCodeGymClass {
    private static StudentCodeGym[] listStudent;
    //private static ArrayList<StudentCodeGym> listStudent;
    private static int count = 0;

    static {
        listStudent = new StudentCodeGym[10];
        //listStudent = new ArrayList<StudentCodeGym>();
    }

    public int getSize(){
        //return listStudent.size();
        return count;
    }

    public int getIdStudent(int arg){
        //return listStudent.get(arg).getId();
        return listStudent[arg].getId();
    }

    public String getNameStudent(int arg){
        //return listStudent.get(arg).getName();
        return listStudent[arg].getName();
    }

    public String getDateOfBirthStudent(int arg){
        //return listStudent.get(arg).getDateofbirth();
        return listStudent[arg].getDateofbirth();
    }

    ////////////////////////////////////////////NORMAL WAY///////////////////////////////////////////////////////////
    public void register(StudentCodeGym student){
        if(count >= 10){
            System.out.println("Warning!!! Class is full! Open new class");
        }else {
            System.out.println("Welcome to "+ student.getName()+" ^-^ !!!");
            listStudent[count] = student;
            count++;
        }
    }

    public void graduate(int id){
        for(int i = 0; i < listStudent.length-1; i++){
            if(listStudent[i].getId() == id){
                System.out.println("Congratulate "+ listStudent[i].getName()+" ^-^ !!!");
                for(int j = i; j < listStudent.length-1; j++){
                    listStudent[j] = listStudent[j+1];
                }
                break;
            }
        }
        listStudent[listStudent.length-1] = null;
        count--;
    }

    public void displayListStudent(){
        System.out.printf("%-5s%-5s%-15s%s","", "Id", "Name", "Date of Birth");
        System.out.println();
        for(int i = 0; i < count; i++){
            System.out.printf("%-5d%-5d%-15s%s",i+1, listStudent[i].getId(), listStudent[i].getName(), listStudent[i].getDateofbirth());
            System.out.println();
        }
    }

    ///////////////////////////////////////ARRAY LIST WAY///////////////////////////////////////////////////////////////
//        public void register(StudentCodeGym student){
//            System.out.println("Welcome to "+ student.getName()+" ^-^ !!!");
//            listStudent.add(student);
//    }
//
//        public void graduate(int id){
//            for (int i = 0; i < listStudent.size(); i++){
//                if(id == listStudent.get(i).getId()){
//                    listStudent.remove(i);
//                    break;
//                }
//            }
//    }
//
//        public void displayListStudent(){
//        System.out.printf("%-5s%-5s%-15s%s","", "Id", "Name", "Date of Birth");
//        System.out.println();
//        for(int i = 0; i < listStudent.size(); i++){
//            System.out.printf("%-5d%-5d%-15s%s",i+1, listStudent.get(i).getId(), listStudent.get(i).getName(), listStudent.get(i).getDateofbirth());
//            System.out.println();
//        }
//    }

}
