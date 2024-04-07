package by.anastasia.task2.exception;

public class PlantException extends Exception{
    public PlantException() {
        super();
    }

    public PlantException(String message) {
        super(message);
    }

    public PlantException(String message, Throwable cause) {
        super(message, cause);
    }

    public PlantException(Throwable cause) {
        super(cause);
    }
}
