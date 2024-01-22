public class BlogPost {

    private String blogId;
    private String title;
    private String content;

    private String authorName;
    private String authorDesignation;
    private String status;

    public BlogPost(String blogId, String title, String content, String authorName, String authorDesignation, String status) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.status = status;
        this.authorName = authorName;
        this.authorDesignation = authorDesignation;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getContentLength() {
        return content.length();
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorDesignation() {
        return authorDesignation;
    }
}
