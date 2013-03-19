package gallery;
/**
 * Author: lian
 * Date: 3/10/13
 */

import gallery.exception.InvalidDirectoryException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Get image path by user input
        DirectoryManager directoryManager = getDirectoryManager();

        //define file extensions
        List<String> validFileExtensions = new ArrayList<String>();
        validFileExtensions.add("jpg");
        validFileExtensions.add("gif");
        validFileExtensions.add("png");

        List<File> images = getValidFilesFromDirectory(directoryManager, validFileExtensions);
        String destinationPath = directoryManager.createDestinationFolder();
        directoryManager.copyFilesToDestinationFolder(images);
        HTMLPageFactory factory = new HTMLPageFactory(destinationPath);
        factory.createHTMLPagesFromList(images);
    }

    private static DirectoryManager getDirectoryManager() {

        DirectoryManager directoryManager = new DirectoryManager();

        try {
            directoryManager.setDirectory(getSourcePath());
        } catch (InvalidDirectoryException e) {
            System.out.println(e.getMessage());
            directoryManager = getDirectoryManager();
        }
        return directoryManager;
    }

    /**
     * @return String
     */
    private static String getSourcePath() {
        System.out.println("Please enter your image source path");
        Scanner scanner = new Scanner(System.in);
        String sourcePath = scanner.next();

        return sourcePath;
    }

    /**
     *
     * @param manager
     * @param extensions
     * @return List<String>
     */
    private static List<File> getValidFilesFromDirectory(DirectoryManager manager, List<String> extensions) {
        List<File> images = manager.filterByExtension(extensions);
        return images;

    }
}
