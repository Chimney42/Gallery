package gallery.exception;

/**
 * Author: lian
 * Date: 3/15/13
 */
public class DirectoryEmptyException extends Exception {

    public DirectoryEmptyException() {
        super("Directory is empty");
    }
}
