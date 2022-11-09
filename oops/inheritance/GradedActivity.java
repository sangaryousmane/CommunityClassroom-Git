package oops.inheritance;

public class GradedActivity {
    private double score;

    public GradedActivity(double score) {
        this.score = score;
    }

    public GradedActivity(GradedActivity activity) {
        this.score = activity.score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public char getGrade() {
        char gradeInLetter;

        if (this.score > 90)
            gradeInLetter = 'A';
        else if (this.score >= 80)
            gradeInLetter = 'B';
        else if (this.score >= 70)
            gradeInLetter = 'C';
        else if (this.score >= 60)
            gradeInLetter = 'D';
        else
            gradeInLetter = 'F';
        return gradeInLetter;
    }
}
