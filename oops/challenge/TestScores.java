package oops.challenge;

public class TestScores {
    private int score1;
    private int score2;
    private int score3;

    public TestScores(int score1, int score2, int score3) {
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public double sum(){
        return this.score1+this.score2+this.score3;
    }
    public double averageTestScore(){
        return sum() / 3.0;
    }
    @Override
    public String toString() {
        return "TestScores{" +
                "score1=" + score1 +
                ", score2=" + score2 +
                ", score3=" + score3 +
                '}';
    }
}
