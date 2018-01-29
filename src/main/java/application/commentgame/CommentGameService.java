package application.commentgame;

import java.util.List;

/**
 * Created by Damian on 03.01.2017.
 */
public interface CommentGameService {
    List<CommentGame> getAllComment();

    void deleteComment(Integer id);

    void saveComment(String commentGameCommand, Integer idArticle);

    List<CommentGame> getCommentByArticleId(Integer id);
}
