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
     *
     * @param validFileExtensions
     * @return List<String>
     * @throws DirectoryEmptyException
     */
    public List<String> filterByExtension(List<String> validFileExtensions) throws DirectoryEmptyException {
        String[] files = this.directory.list();

        if (null == files) {
            throw new DirectoryEmptyException();
        }

        List<String> images = new ArrayList<String>();

        //Paths for each image are written into ArrayList
        for (String filePath : files) {
            //get file extension
            String extension = filePath.substring(filePath.lastIndexOf('.') + 1);

            //lookup in valid extensions
            if (validFileExtensions.contains(extension)) {
                images.add(filePath);
                break;
            }
        }
        return images;
    }
}
