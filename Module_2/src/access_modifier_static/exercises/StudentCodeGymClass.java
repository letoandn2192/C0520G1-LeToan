package access_modifier_static.exercises;

public class StudentCodeGymClass {
    private static StudentCodeGym[] listStudent;
    private static int count = 0;

    static {
        //count++;
        listStudent = new StudentCodeGym[10];
    }

    public void register(StudentCodeGym student){
        if(count >= 10){
            System.out.println("Warning!!! Class is full! Open new class");
        }else {
            listStudent[count] = student;
            count++;
        }
    }

    public void graduate(StudentCodeGym student){
        int id = student.getId();
        for(int i = 0; i < listStudent.length-1; i++){
            if(listStudent[i].getId() == id){
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
            //System.out.println("id: "+ listStudent[i].getId() + "\tname: " + listStudent[i].getName() + "\tdate of birth: "+ listStudent[i].getDateofbirth());
            System.out.println();
        }
    }
}
