package oops.advance;

public class Instructor {
    private String firstName;
    private String lastName;
    private String officeNumber;

    public Instructor(String firstName, String lastName, String officeNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.officeNumber = officeNumber;
    }

    // Copy Constructor
    public Instructor(Instructor instructor) {
        this.firstName = instructor.firstName;
        this.lastName = instructor.lastName;
        this.officeNumber = instructor.officeNumber;
    }

    public void set(String firstName, String lastName, String officeNumber){
        this.firstName=firstName;
        this.lastName=lastName;
        this.officeNumber=officeNumber;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", officeNumber='" + officeNumber + '\'' +
                '}';
    }
}
