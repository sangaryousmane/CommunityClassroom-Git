package exceptionhandlings;

public class InvalidTestScore extends Exception{

    public InvalidTestScore(String message) {
        super(message);
    }
}
