package infrastructure.service.commentgame;

import application.DomainException;
import application.commentgame.CommentGame;
import application.commentgame.CommentGameCommand;
import application.commentgame.CommentGameService;
import application.commentgame.JdbcCommentGameRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;


public class CommentGameServiceImpl implements CommentGameService {

    private final JdbcCommentGameRepo jdbcCommentGame;

    @Autowired
    public CommentGameServiceImpl(JdbcCommentGameRepo jdbcCommentGame) {
        this.jdbcCommentGame = jdbcCommentGame;
    }

    @Override
    public List<CommentGame> getAllComment() {
        return jdbcCommentGame.getAllComments();
    }

    @Override
    public void deleteComment(Integer idComment) {
        jdbcCommentGame.delete(idComment);
    }

    @Override
    public void saveComment(String commentGameCommand, Integer idArticle) {
        if(commentGameCommand.isEmpty()){
            throw new DomainException("Nie wpisano komentarza!");
        }

        String currentDate = LocalDateTime.now().toLocalDate().toString();
        jdbcCommentGame.saveComment(new CommentGame(commentGameCommand, currentDate, idArticle));
    }

    @Override
    public List<CommentGame> getCommentByArticleId(Integer articleId) {
        return jdbcCommentGame.getCommentById(articleId);
    }
}
