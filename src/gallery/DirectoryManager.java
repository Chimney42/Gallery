package gallery;
/**
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
     * @param sourcePath
     */
    public DirectoryManager(String sourcePath) {
        this.directory = new File(sourcePath);
    }

    /**
     *
     * @param validFileExtensions
     * @return List<String>
     * @throws DirectoryEmptyException
     */
    public List<String> filterByExtension(String[] validFileExtensions) throws DirectoryEmptyException {
        String[] files = this.directory.list();

        if (null == files) {
            throw new DirectoryEmptyException();
        }

        List<String> images = new ArrayList<String>();

        //Paths for each image are written into ArrayList
        for (String fileName : files) {
            for (String extension : validFileExtensions) {
                if (fileName.endsWith(extension)) {
                    images.add(fileName);
                    break;
                }
            }
        }
        return images;
    }
}
