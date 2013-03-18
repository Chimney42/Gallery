package gallery;
/**
 * Author: lian
 * Date: 3/10/13
 */

import gallery.exception.DirectoryEmptyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Get image path by user input
        String sourcePath = getSourcePath();

        //define file extensions
        List<String> validFileExtensions = new ArrayList<String>();
        validFileExtensions.add("jpg");
        validFileExtensions.add("gif");
        validFileExtensions.add("png");

        List<String> imageNames = getValidFilesFromDirectory(sourcePath, validFileExtensions);

        HTMLPageFactory factory = new HTMLPageFactory();
        factory.createHTMLPage(imageNames, sourcePath);
    }

    /**
     * @return String
     */
    private static String getSourcePath() {
        System.out.println("Please enter your image path");
        Scanner scanner = new Scanner(System.in);
        String sourcePath = scanner.next();

        //default path
        if (sourcePath.isEmpty()) {
            sourcePath = "C:/htdocs/myfoto";
        }
        return sourcePath;
    }

    /**
     *
     * @param sourcePath
     * @param extensions
     * @return List<String>
     */
    private static List<String> getValidFilesFromDirectory(String sourcePath, List<String> extensions) {
        List<String> imageNames;
        try {
            DirectoryManager manager = new DirectoryManager(sourcePath);
            imageNames = manager.filterByExtension(extensions);
        }
        catch (DirectoryEmptyException e) {
            e.getMessage();
            System.out.println("Please try another path");
            String newSourcePath = getSourcePath();
            // recursive call
            imageNames = getValidFilesFromDirectory(newSourcePath, extensions);
        }
        return imageNames;

    }
}
