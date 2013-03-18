package gallery;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Author: lian
 * Date: 3/10/13
 */
public class HTMLPage {

    private String template;
    private String pageName;
    private String lastPage;
    private String image;
    private String nextPage;
    private String html;

    // default template
    public HTMLPage() {
        this.template = "<html>" +
                            "<head><title>!!pageName!!</title></head>" +
                                "<body>" +
                                    "<div align='center'><table>" +
                                        "<tr>" +
                                            "<th>!!lastPage!!</th>" +
                                            "<th>!!image!!</th>" +
                                            "<th>!!nextPage!!</th>" +
                                        "</tr>" +
                                "</table></div>" +
                            "</body>" +
                        "</html>";
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    //build link to last image
    public void setLastPage(String lastPage) {
        this.lastPage = "<a href='" + lastPage + ".html'>" + lastPage + "</a>";
    }

    //build link to next image
    public void setNextPage(String nextPage) {
        this.nextPage = "<a href='" + nextPage + ".html'>" + nextPage + "</a>";
    }

    //build image tags for image
    public void setImage(String imageName) {
        this.image = "<img src='../" + imageName + "'></img>";
    }

    protected void render(String path) {
        //replace placeholders with built elements

        this.html = this.template.replaceAll("!!pageName!!", this.pageName);

        if(this.lastPage != null) {
            this.html = this.html.replaceAll("!!lastPage!!", this.lastPage);
        } else {
            this.html = this.html.replaceAll("!!lastPage!!", "");
        }

        this.html = this.html.replaceAll("!!image!!", this.image);

        if(this.nextPage != null) {
            this.html = this.html.replaceAll("!!nextPage!!", this.nextPage);
        } else {
            this.html = this.html.replaceAll("!!nextPage!!", "");
        }
        //

        try {
            //create HTML file
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + this.pageName + ".html"));
            //insert markup
            bufferedWriter.write(this.html);
            //close buffer
            bufferedWriter.close();
        } catch (IOException e) {
            e.getMessage();
            System.out.println(this.pageName + ".html could not be created");
        }

    }
}
