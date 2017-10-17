package exception;

/**
 * Created by msav on 10/17/2017.
 */
public class MissingProjectTypeException extends RuntimeException{

    public MissingProjectTypeException() {
        super("Project type has to be set!");
    }
}
