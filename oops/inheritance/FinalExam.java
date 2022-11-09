package oops.inheritance;

public class FinalExam extends GradedActivity{
    private int numQuestions;
    private int numMissed;
    private double pointsEach;

    public FinalExam(FinalExam finalExam) {
        super(finalExam.pointsEach); // This is called from the superclass
        this.numMissed = finalExam.numMissed;
        this.numQuestions = finalExam.numQuestions;
        this.pointsEach = finalExam.pointsEach;
    }
    public FinalExam(int missed, int numQuestions){
        super(new GradedActivity(missed)); // This is called from the superclass
        this.numMissed=missed;
        this.numQuestions=numQuestions;

        pointsEach=100.0/numQuestions;
        double numericScore=100.0 - (missed*pointsEach);
        setScore(numericScore);

    }

    @Override
    public String toString() {
        return "FinalExam{" +
                "numQuestions=" + numQuestions +
                ", numMissed=" + numMissed +
                ", pointsEach=" + pointsEach +
                '}';
    }

    public double getPointsEach() {
        return pointsEach;
    }

    public int getNumMissed() {
        return numMissed;
    }

    public int getNumQuestions() {
        return numQuestions;
    }
}
