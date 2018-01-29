package application.commentgame;

/**
 * Created by Damian on 03.01.2017.
 */
public class CommentGame {

    private Integer id;
    private String comment;
    private String commentDate;
    private Integer idArticle;

    public CommentGame(String comment, String commentDate, Integer idArticle) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.idArticle = idArticle;
    }

    public CommentGame(Integer id, String comment, String commentDate, Integer idArticle) {
        this.id = id;
        this.comment = comment;
        this.commentDate = commentDate;
        this.idArticle = idArticle;
    }

    public Integer getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public Integer getIdArticle() {
        return idArticle;
    }
}
