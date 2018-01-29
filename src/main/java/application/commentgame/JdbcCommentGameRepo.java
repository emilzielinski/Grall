package application.commentgame;

import java.util.List;

/**
 * Created by Damian on 03.01.2017.
 */
public interface JdbcCommentGameRepo {

    List<CommentGame> getAllComments();

    void delete(Integer idComment);

    void saveComment(CommentGame commentGame);

    List<CommentGame> getCommentById(Integer articleId);

    void deleteArticleComment(Integer idArticle);
}
