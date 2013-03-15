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

    /**
     * construct with absolute system name
     * @param directoryPath
     */
    public DirectoryManager(String directoryPath) {
        this.directory = new File(directoryPath);
    }

    /**
     *
     * @param extensions
     * @return List<String>
     * @throws DirectoryEmptyException
     */
    public List<String> filterByExtension(String[] extensions) throws DirectoryEmptyException {
        String[] files = this.directory.list();

        if (null == files) {
            throw new DirectoryEmptyException();
        }

        List<String> images = new ArrayList<String>();

        //Paths for each image are written into ArrayList
        for (String filePath : files) {
            for (String ending : extensions) {
                if (filePath.endsWith(ending)) {
                    images.add(filePath);
                    break;
                }
            }
        }
        return images;
    }
}
