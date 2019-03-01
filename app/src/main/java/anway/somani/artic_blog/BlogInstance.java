package anway.somani.artic_blog;

/*
 * - title
 * - content
 * - author name
 * - date
 * - time
 * - tag1
 * - tag2
 */

public class BlogInstance {

    public int id;
    public String title;
    public String content;
    public String author_name;
    public String date;
    public String time;
    public String tag1;
    public String tag2;

    public BlogInstance(int id, String title, String content, String author_name, String date, String time, String tag1, String tag2) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author_name = author_name;
        this.date = date;
        this.time = time;
        this.tag1 = tag1;
        this.tag2 = tag2;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getTag1() {
        return tag1;
    }

    public String getTag2() {
        return tag2;
    }
}
