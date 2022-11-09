package exceptionhandlings;

/**
 * It's said that an exception is thrown when there's an abrupt
 * interruption in the program that causes it to stop.
 *
 */
public class StackTrace {

    public static void main(String[] args) throws CallStackException {
        System.out.println("Calling my custom() method");
        customMethod();
        System.out.println("DONE");
    }

    private static void customMethod() throws CallStackException {
        System.out.println("Calling the error producing method.");
        produceError();
        System.out.println("DONE");
    }

    /**
     * @exception IllegalArgumentException indicates that the method has been passed an illegal argument.
     */
    private static void produceError() throws CallStackException {
        throw new CallStackException("The Argument is illegal");
    }
}
