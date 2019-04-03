package anway.somani.artic_blog;

/*
 * - title
 * - content
 * - author name
 * - date
 * - time
 * - tag1
 * - tag2
 * - url
 */

public class BlogInstance {

    private int title;
    private int  author_name;
    private int content;
    private String blogurl;

    public BlogInstance(int title, int author_name, int content, String blogurl) {
        this.title = title;
        this.author_name = author_name;
        this.content = content;
        this.blogurl = blogurl;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getAuthor_name() {
        return author_name;
    }

    public String getBlogurl() {
        return blogurl;
    }

    public void setBlogurl(String blogurl) {
        this.blogurl = blogurl;
    }

    public void setAuthor_name(int author_name) {
        this.author_name = author_name;
    }

    public int getContent() {
        return content;
    }

    public void setContent(int content) {
        this.content = content;
    }
}
