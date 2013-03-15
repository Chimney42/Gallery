package gallery.exception;

/**
 * Created with IntelliJ IDEA.
 * User: lian
 * Date: 3/15/13
 * Time: 3:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class DirectoryEmptyException extends Exception {

    public DirectoryEmptyException() {
        super("Directory is empty");
    }
}
