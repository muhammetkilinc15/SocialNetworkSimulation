import java.util.Date;

public class Post {
    private String content;
    private Date date;
    int likeCounter;

    // constructor method
    public Post(String content, Date date) {
        this.content = content;
        this.date = date;
        this.likeCounter=0;
    }
    // This method increases likes for a post
    public void increaseLike() {
        this.likeCounter++;
    }
    // This method returns information about the content of the post,
    // the date it was shared, and the number of likes.
    public String toStings() {
        return "This post shared at "+this.date+" as "+this.content+" which got "+this.likeCounter+" likes\n";
    }
}
