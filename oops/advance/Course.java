package oops.advance;

public class Course {

    private String courseName;
    private Instructor instructor;
    private TextBook textBook;

    // this used to call an overloaded constructor from another.
    public Course(String courseName){
        this.courseName=courseName;
    }
    public Course(Instructor instructor, TextBook textBook, String courseName) {
        this(courseName);
        this.instructor = new Instructor(instructor);
        this.textBook = new TextBook(textBook);
    }


    public Instructor getInstructor() {
        return new Instructor(instructor);
    }

    public TextBook getTextBook() {
        return new TextBook(textBook);
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", instructor=" + instructor +
                ", textBook=" + textBook +
                '}';
    }

    public static void main(String[] args) {
        Instructor instructor1=new Instructor("Fatu", "Tamba", "123222");
        TextBook textBook1=new TextBook("Clean Code", "Peter", "Ousmane");
        Course course=new Course(instructor1, textBook1, "Advance Java");
        System.out.println(course);
    }
}
