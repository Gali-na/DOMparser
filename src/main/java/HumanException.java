public class HumanException extends Exception{
    public HumanException() {
    }

    public HumanException(String message) {
        super(message);
    }

    public HumanException(String message, Throwable cause) {
        super(message, cause);
    }

    public HumanException(Throwable cause) {
        super(cause);
    }
}
