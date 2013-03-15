package gallery;

import java.io.File;

/**
 * Author: lian
 * Date: 3/10/13
 */
public class HTMLPageFactory {

    public void createHTMLPage(String[] images, String path) {
        //create new folder in imagePath "mypage"
        new File(path + "/mypage").mkdir();

        //for each image
        for(int i = 0; i < images.length; i++) {
            HTMLPage page = new HTMLPage();
            //create generic names
            page.setPageName("image " + (i+1));

            //not on first iteration
            if(0 != i) {
                page.setLastPage("image " + (i));
            }

            page.setImage(images[i]);

            //not on last iteration
            if((images.length - 1) != i) {
                page.setNextPage("image " + (i+2));
            }

            //create HTML pages in above created folder
            page.render(path + "/mypage/");
        }
    }
}
