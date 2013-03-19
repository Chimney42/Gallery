package gallery;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Author: lian
 * Date: 3/10/13
 */
public class HTMLPageFactory {

    private String sourcePath;
    private String destinationPath;

    public HTMLPageFactory(String sourcePath) {
        super();
        this.setSourcePath(sourcePath);
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public void createDestinationFolder() {
        //create new folder in imagePath "mypage"
        this.destinationPath = this.sourcePath + "/mypage";
        new File(this.destinationPath).mkdir();
    }

    public void createHTMLPagesFromList(List<String> imageNames) {
        for (int i = 0; i <imageNames.size(); i++) {
            HTMLPage page = this.createHTMLPageWithName("image " + (i + 1));
            page.setImage(imageNames.get(i));

            //not on first iteration
            if(0 != i) {
                page.setLastPage("image " + (i));
            }

            //not on last iteration
            if((imageNames.size() - 1) != i) {
                page.setNextPage("image " + (i+2));
            }

            //assemble html
            page.build();

            //physically create file on harddrive
            this.render(page);
        }
    }

    private void render(HTMLPage page) {
        try {
            //create HTML file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.destinationPath + page.getPageName() + ".html"));
            //insert markup
            bufferedWriter.write(page.getHtml());
            //close buffer
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
            System.out.println(page.getPageName() + ".html could not be created");
        }


    }

    private HTMLPage createHTMLPageWithName(String name) {
        HTMLPage page = new HTMLPage();
        //create generic names
        page.setPageName(name);

        return page;
    }
}
