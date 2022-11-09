package oops.inheritance;

public class CurvedActivity extends GradedActivity {
    private double rawScore;
    private double percentage;

    public CurvedActivity(double percentage) {
        super(percentage);
        this.percentage = percentage;
        this.rawScore = 0.0;
    }

    public double getPercentage() {
        return percentage;
    }

    public double getRawScore() {
        return rawScore;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    // For a method to be overridden, it has to have the same signature with the base class type.
    @Override
    public void setScore(double rawScore) {
        super.setScore(rawScore * percentage);
        this.rawScore = rawScore;
    }

    public void setRawScore(double rawScore) {
        this.rawScore = rawScore;
    }
}
