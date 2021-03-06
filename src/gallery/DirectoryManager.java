package gallery;
/**
 * Author: lian
 * Date: 3/10/13
 */

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class DirectoryManager {

    private File directory;
    private String destinationPath;

    /**
     * construct with absolute system name
     * @param sourcePath
     */
    public void setDirectory(String sourcePath) throws InvalidDirectoryException {
        File directory = new File(sourcePath);

        if (!directory.isDirectory()) {
            throw new InvalidDirectoryException();
        } else {
            this.directory = directory;
        }
    }

    /**
     * @param validFileExtensions
     * @return List<String>
     * @throws InvalidDirectoryException
     */
    public List<File> filterByExtension(List<String> validFileExtensions) {
        File[] files = this.directory.listFiles();

        List<File> images = new ArrayList<File>();

        //Paths for each image are written into ArrayList
        for (File file : files) {
            //get file extension
            String filePath = file.getPath();
            String extension = filePath.substring(filePath.lastIndexOf('.') + 1);

            //lookup in valid extensions
            if (validFileExtensions.contains(extension)) {
                images.add(file);
            }
        }
        return images;
    }

    public String createDestinationFolder() {
        //create new folder in imagePath "mypage"
        this.setDestinationPath("C:\\htdocs\\myfoto\\");
        new File(this.destinationPath).mkdir();

        return this.destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public void copyFilesToDestinationFolder(List<File> files) {
        for (int i = 0; i < files.size(); i++) {
            try {
                Files.copy(files.get(i).toPath(), new File(this.destinationPath + files.get(i).getName()).toPath());
            } catch (IOException e) {
                System.out.println(e.getMessage() + " could not be copied");
            }
        }
    }
}
