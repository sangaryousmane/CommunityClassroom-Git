package chapter7arrays;

import java.util.ArrayList;
import java.util.List;

public class DriverExam {
    private char[] correctAnswers = {
            'B', 'D', 'A', 'A', 'C',
            'A', 'B', 'A', 'C', 'D',
            'B', 'C', 'D', 'A', 'D',
            'C', 'C', 'B', 'D', 'A'};
    private char[] studentsAnswers = new char[correctAnswers.length];
    private double passingMark = 65.5;
    private int studentLength = studentsAnswers.length;

    public DriverExam(char[] studentsAnswers) {
        this.studentsAnswers = studentsAnswers;


    }

    // This method checks whether the student has passed.
    // Comparing the passing mark with the student totalPercent score.
    public boolean hasPassed() {
        double percent = (totalCorrect() * 100.0) / correctAnswers.length;
        return percent >= passingMark;
    }

    // This method returns the total correct answers of a student.
    // It loops through all the student answers and compare each with the correct answers
    public int totalCorrect() {
        int correctCount = 0;
        for (int index = 0; index < studentLength; index++) {
            if (studentsAnswers[index] == correctAnswers[index])
                correctCount++;
        }
        return correctCount;
    }

    // This method returns the total incorrect answers of a student
    public int totalInCorrect() {
        int InCorrectCount = 0;
        for (int index = 0; index < studentLength; index++) {
            if (studentsAnswers[index] != correctAnswers[index])
                InCorrectCount++;
        }
        return InCorrectCount;
    }

    // This method returns an array of all the missed questions...
    public int[] questionsMissed() {
        List<Integer> missed = new ArrayList<>();
        for (int i = 0; i < studentLength; i++) {
            if (studentsAnswers[i] != correctAnswers[i]) {
                missed.add(i + 1);
            }
        }
        int[] questionsMissed = new int[missed.size()];
        for (int i = 0; i < questionsMissed.length; i++) {
            questionsMissed[i] = missed.get(i);
        }
        return questionsMissed;
    }
}
