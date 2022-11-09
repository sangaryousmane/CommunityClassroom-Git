package chapter7arrays;

public class Rainfall {


    private double[] rainfalls;

    public Rainfall(double[] rainfalls) {
        this.rainfalls = rainfalls;
    }

    // total of yearly rainfall
    public int totalOfYearlyRainfall() {
        int year = 0;
        for (double rainfall : rainfalls) {
            year += rainfall;
        }
        return year;
    }

    // Average yearly rainfall
    public int averageYearlyRainfall() {
        int total = 0;
        for (double rainfall : rainfalls) {
            total += rainfall;
        }
        return total / rainfalls.length;
    }

    // Month with most rainfall
    public double mostRainfall() {
        double max = rainfalls[0];
        for (double rainfall : rainfalls) {
            if (rainfall > max) {
                max = rainfall;
            }
        }
        return max;
    }

    // Month with less rainfall
    public double lessRainfall() {
        double min = rainfalls[0];
        for (double rainfall : rainfalls) {
            if (rainfall < min) {
                min = rainfall;
            }
        }
        return min;
    }

}
