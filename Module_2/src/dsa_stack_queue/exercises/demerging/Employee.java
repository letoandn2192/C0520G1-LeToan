package dsa_stack_queue.exercises.demerging;

public class Employee implements Comparable<Employee>{
    private String name;
    private String gender;
    private String dateOfBirth;

    public Employee(String name, String gender, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() +" Gender: " + this.getGender() + " DateOfBirth: " + this.getDateOfBirth();
    }

    @Override
    public int compareTo(Employee o) {
        return this.getDateOfBirth().compareTo(o.getDateOfBirth());
    }
}
