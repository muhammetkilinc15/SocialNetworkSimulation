import java.util.Date;

public class Post {
    private String content;
    private Date date;
    int likeCounter;

    public Post(String content, Date date) {
        this.content = content;
        this.date = date;

    }
    public void increaseLike() {
        this.likeCounter++;
    }
    public String toStings() {
        return "This post shared at "+this.date+" as "+this.content+" which got "+this.likeCounter+" likes\n";
    }
}
