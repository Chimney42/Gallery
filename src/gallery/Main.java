package gallery; /**
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
        String imagePath = getImagePath();

        //define file extensions
        String[] extensions = new String[] {"jpg", "png", "gif"};

        List<String> images = getDirectoryFiles(imagePath, extensions);

        String[] imagePaths =  new String[images.size()];
        for (int i = 0; i < images.size(); i++) {
            imagePaths[i] = images.get(i);
        }

        HTMLPageFactory factory = new HTMLPageFactory();
        factory.createHTMLPage(imagePaths, imagePath);
    }

    /**
     * @return String
     */
    private static String getImagePath() {
        System.out.println("Please enter your image path");
        Scanner scanner = new Scanner(System.in);
        String imagePath = scanner.next();

        //default path
        if (imagePath.isEmpty()) {
            imagePath = "~/htdocs/myfoto";
        }
        return imagePath;
    }

    /**
     *
     * @param imagePath
     * @param extensions
     * @return List<String>
     */
    private static List<String> getDirectoryFiles(String imagePath, String[] extensions) {
        List<String> images;
        try {
            DirectoryManager manager = new DirectoryManager(imagePath);
            images = manager.filterByExtension(extensions);
        }
        catch (DirectoryEmptyException e) {
            e.getMessage();
            System.out.println("Please try another path");
            String newImagePath = getImagePath();
            // recursive call
            images = getDirectoryFiles(newImagePath, extensions);
        }
        return images;

    }
}
