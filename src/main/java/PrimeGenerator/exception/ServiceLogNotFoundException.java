// If an user requests logs for a particular which is not available in our database. Then, this class will handle those requests
// by logging the error in console log.
// The user will get an error in form of an JSON object that describe it as "Internal Server Error."

package PrimeGenerator.exception;

public class ServiceLogNotFoundException extends RuntimeException {

    public ServiceLogNotFoundException(Long id) {
        super("Could not find log with id = " + id);
    }
}
