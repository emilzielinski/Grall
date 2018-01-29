package application.article;


public class GameArticle {

    private Integer id;
    private String title;
    private String content;
    private String createDate;
    private String author;
    private Integer idCategory;
    private String image;

    public GameArticle(String title, String content, String createDate, String author, Integer idCategory, String image) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.author = author;
        this.idCategory = idCategory;
        this.image = image;
    }

    public GameArticle(Integer id, String title, String content, String createDate, String author, Integer idCategory, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.author = author;
        this.idCategory = idCategory;
        this.image = image;

    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getIdCategory() {
        return idCategory;
    }

    public String getImage() {
        return image;
    }
}
