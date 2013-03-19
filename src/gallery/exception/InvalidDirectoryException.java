package gallery.exception;

/**
 * Author: lian
 * Date: 3/15/13
 */
public class InvalidDirectoryException extends Exception {

    public InvalidDirectoryException() {
        super("Directory does not exist");
    }
}
