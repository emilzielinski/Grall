package infrastructure.repo.commentgame;

import application.commentgame.CommentGame;
import application.commentgame.CommentGameCommand;
import application.commentgame.JdbcCommentGameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JdbcCommentGameRepoImpl implements JdbcCommentGameRepo {

    private final String QUERY_COMMENT_BY_ARTICLE_ID = "select id_Comment, comments_Content, comments_Date, id_Article from Comments where id_Article = ?";
    private final String QUERY_COMMENT = "select id_Comment, comments_Content, comments_Date, id_Article from Comments";
    private final String QUERY_DELETE_COMMENT = "DELETE FROM Comments where id_Comment = ?";
    private final String QUERY_INSERT_COMMENT = "INSERT INTO Comments (comments_Content,comments_Date,id_Article) values (?,?,?)";
    private final String QUERY_DELETE_COMMENT_FOR_ARTICLE = "DELETE FROM Comments where id_Article = ?";

    private final JdbcOperations repo;

    @Autowired
    public JdbcCommentGameRepoImpl(JdbcOperations repo) {
        this.repo = repo;
    }

    @Override
    public List<CommentGame> getAllComments() {
        return repo.query(QUERY_COMMENT, new CommentGameRowMapper());
    }

    @Override
    public void delete(Integer idComment) {
        repo.update(QUERY_DELETE_COMMENT, new Object[]{idComment});
    }

    @Override
    public void saveComment(CommentGame commentGame) {
        repo.update(QUERY_INSERT_COMMENT, new Object[]{commentGame.getComment(), commentGame.getCommentDate(), commentGame.getIdArticle()});
    }

    @Override
    public List<CommentGame> getCommentById(Integer articleId) {
        return repo.query(QUERY_COMMENT_BY_ARTICLE_ID, new Object[]{articleId}, new CommentGameRowMapper());
    }

    @Override
    public void deleteArticleComment(Integer idArticle) {
        repo.update(QUERY_DELETE_COMMENT_FOR_ARTICLE, new Object[]{idArticle});
    }
}
