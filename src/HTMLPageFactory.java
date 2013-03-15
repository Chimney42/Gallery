import java.io.File;

/**
 * Author: lian
 * Date: 3/10/13
 */
public class HTMLPageFactory {

    public HTMLPage[] createHTMLPage(String[] pictures, String path) {
        HTMLPage[] pages = new HTMLPage[pictures.length];
        new File(path + "/mypage").mkdir();

        for(int i = 0; i < pictures.length; i++) {
            HTMLPage page = new HTMLPage();
            page.setPageName("Picture " + (i+1));

            if(0 != i) {
                page.setLastPage("Picture " + (i));
            }
            page.setPicture(pictures[i]);

            if((pictures.length - 1) != i) {
                page.setNextPage("Picture " + (i+2));
            }

            pages[i] = page;
            page.render(path + "/mypage/");
        }
        return pages;
    }
}
