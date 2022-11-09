package oops.abstraction;

public abstract class Student {
    private String name;
    private Integer yearAdmitted;
    private String idNumber;


    public Student(){}
    public Student(String name, Integer yearAdmitted, String idNumber) {
        this.name = name;
        this.yearAdmitted = yearAdmitted;
        this.idNumber = idNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", yearAdmitted=" + yearAdmitted +
                ", idNumber='" + idNumber + '\'' +
                '}';
    }

    /**
     This is an abstract method without body...
     abstract methods are only declare in abstract classes.
     @return the number of remaining hours.
     */
    public abstract int getRemainingHours();
}
