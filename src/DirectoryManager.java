/**
 * Author: lian
 * Date: 3/10/13
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DirectoryManager {

    File directory;

    public DirectoryManager() {

    }

    public DirectoryManager(String directoryPath) {

        this.directory = new File(directoryPath);
    }

    public void setDirectoryPath(String directoryPath) {
        this.directory = new File(directoryPath);
    }

    public List<String> filterByExtension(String[] extensions) {
        String[] files = this.directory.list();
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
