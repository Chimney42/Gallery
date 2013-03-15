/**
 * Author: lian
 * Date: 3/10/13
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String picturePath = "../../htdocs/myfoto";
        DirectoryManager manager = new DirectoryManager(picturePath);

        String[] extensions = new String[] {"jpg", "png", "gif"};
        List<String> pictures = manager.filterByExtension(extensions);
        String[] picturePaths =  new String[pictures.size()];
        for (int i = 0; i < pictures.size(); i++) {
            picturePaths[i] = pictures.get(i);
        }

        HTMLPageFactory factory = new HTMLPageFactory();
        factory.createHTMLPage(picturePaths, picturePath);
    }
}
