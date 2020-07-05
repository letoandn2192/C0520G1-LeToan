package access_modifier_static.exercises;

public class StudentCodeGym {
    private int id;
    private String name;
    private String dateofbirth;
//    static int numberOfStudent = 0;

    public StudentCodeGym(int id, String name, String dateofbirth) {
        this.id = id;
        this.name = name;
        this.dateofbirth = dateofbirth;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }
}
