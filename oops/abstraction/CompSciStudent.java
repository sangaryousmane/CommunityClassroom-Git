package oops.abstraction;

public class CompSciStudent extends Student implements Details {

    // Required hours
    private final int MATH_HRS = 20;
    private final int GEN_EDU_HRS = 60;
    private final int COMP_HRS = 40;


    // Hours taken
    private int math_hrs;
    private int gen_edu_hrs;
    private int comp_hrs;


    public CompSciStudent(String name, Integer year, String idNumber) {
        super(name, year, idNumber);
    }

    public CompSciStudent(int math_hrs, int gen_edu_hrs, int comp_hrs) {
        this.math_hrs = math_hrs;
        this.gen_edu_hrs = gen_edu_hrs;
        this.comp_hrs = comp_hrs;
    }

    @Override
    public int getRemainingHours() {
        int totalRequiredHrs = (MATH_HRS + GEN_EDU_HRS + COMP_HRS);
        return totalRequiredHrs - (gen_edu_hrs + math_hrs + comp_hrs);
    }

    public int getMath_hrs() {
        return math_hrs;
    }

    public void setMath_hrs(int math_hrs) {
        this.math_hrs = math_hrs;
    }

    public int getGen_edu_hrs() {
        return gen_edu_hrs;
    }

    public void setGen_edu_hrs(int gen_edu_hrs) {
        this.gen_edu_hrs = gen_edu_hrs;
    }

    public int getComp_hrs() {
        return comp_hrs;
    }

    public void setComp_hrs(int comp_hrs) {
        this.comp_hrs = comp_hrs;
    }

    @Override
    public String toString() {
        return "CompSciStudent{" + super.toString() +
                "math_hrs=" + this.math_hrs +
                ", gen_edu_hrs=" + this.gen_edu_hrs +
                ", comp_hrs=" + this.comp_hrs +
                '}';
    }

    @Override
    public void supporter() {
        System.out.println("My supporter name is Fanta Sidibe born in " + countryOfBirth);
    }

    @Override
    public double cube(int a) {
        return a * a * a;
    }
}
