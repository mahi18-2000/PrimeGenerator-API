package PrimeGenerator.exception;

public class ServiceLogNotFoundException extends RuntimeException {

    public ServiceLogNotFoundException(Long id) {
        super("Could not find log with id = " + id);
    }
}
