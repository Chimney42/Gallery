package gallery; /**
 * Author: lian
 * Date: 3/10/13
 */

import gallery.exception.DirectoryEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DirectoryManager {

    File directory;

    public DirectoryManager(String directoryPath) {

        this.directory = new File(directoryPath);
    }

    public List<String> filterByExtension(String[] extensions) throws DirectoryEmptyException {
        String[] files = this.directory.list();

        if (null == files) {
            throw new DirectoryEmptyException();
        }

        List<String> pictures = new ArrayList<String>();

        for (String filePath : files) {
            for (String ending : extensions) {
                if (filePath.endsWith(ending)) {
                    pictures.add(filePath);
                    break;
                }
            }
        }
        return pictures;
    }
}
