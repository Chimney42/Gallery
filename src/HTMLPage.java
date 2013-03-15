import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Author: lian
 * Date: 3/10/13
 */
public class HTMLPage {

    private String template;
    private String pageName;
    private String lastPage;
    private String picture;
    private String nextPage;
    private String html;

    public HTMLPage() {
        this.template = "<html>" +
                            "<head><div align='center'>!!pageName!!</div></head>" +
                                "<body>" +
                                    "<div align='center'><table>" +
                                        "<tr>" +
                                            "<th>!!lastPage!!</th>" +
                                            "<th>!!picture!!</th>" +
                                            "<th>!!nextPage!!</th>" +
                                        "</tr>" +
                                "</table></div>" +
                            "</body>" +
                        "</html>";
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void setLastPage(String lastPage) {
        this.lastPage = "<a href='" + lastPage + ".html'>" + lastPage + "</a>";
    }

    public void setNextPage(String nextPage) {
        this.nextPage = "<a href='" + nextPage + ".html'>" + nextPage + "</a>";
    }

    public void setPicture(String picturePath) {
        this.picture = "<img src='../" + picturePath + "'></img>";
    }

    protected void render(String path) {
        this.html = this.template.replaceAll("!!pageName!!", this.pageName);

        if(this.lastPage != null) {
            this.html = this.html.replaceAll("!!lastPage!!", this.lastPage);
        } else {
            this.html = this.html.replaceAll("!!lastPage!!", "");
        }

        this.html = this.html.replaceAll("!!picture!!", this.picture);

        if(this.nextPage != null) {
            this.html = this.html.replaceAll("!!nextPage!!", this.nextPage);
        } else {
            this.html = this.html.replaceAll("!!nextPage!!", "");
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + this.pageName + ".html"));
            bufferedWriter.write(this.html);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
