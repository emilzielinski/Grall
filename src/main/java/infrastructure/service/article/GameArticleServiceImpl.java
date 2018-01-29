package infrastructure.service.article;

import application.DomainException;
import application.article.GameArticle;
import application.article.GameArticleProjection;
import application.article.GameArticleService;
import application.article.JdbcGameArticleRepo;
import application.article.command.GameArticleAddCommand;
import application.commentgame.JdbcCommentGameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.List;


public class GameArticleServiceImpl implements GameArticleService {

    private final JdbcGameArticleRepo gameArticle;
    private final JdbcCommentGameRepo commentGame;

    @Autowired
    public GameArticleServiceImpl(JdbcGameArticleRepo gameArticle,JdbcCommentGameRepo commentGame) {
        this.gameArticle = gameArticle;
        this.commentGame = commentGame;
    }

    @Override
    public List<GameArticle> findAllGameArticle() {
        return gameArticle.getArticles();
    }

    @Override
    public GameArticleAddCommand findArticle(Integer id) {
        GameArticle articleById = gameArticle.findArticleById(id);

        return new GameArticleAddCommand(articleById.getId(), articleById.getTitle(), articleById.getContent(), articleById.getIdCategory());
    }

    @Override
    public void saveArticle(GameArticleAddCommand gameArticleCommand) {

        if(gameArticleCommand.isEmpty()){
            throw new DomainException("Brak artykułu do zapisu");
        }

        String createArticleDate = LocalDateTime.now().toLocalDate().toString();
        String author = SecurityContextHolder.getContext().getAuthentication().getName();

        GameArticle article = new GameArticle(
                gameArticleCommand.getTitle(),
                gameArticleCommand.getContent(),
                createArticleDate,
                author,
                gameArticleCommand.getIdCategory(),
                gameArticleCommand.getPicture()
        );

        gameArticle.save(article);
    }

    @Override
    public void updateArticle(GameArticleAddCommand gameArticleCommand) {
        gameArticle.updateArticle(gameArticleCommand);
    }

    @Override
    public void deleteArticle(Integer idArticle) {
        commentGame.deleteArticleComment(idArticle);
        gameArticle.deleteArticle(idArticle);
    }

    @Override
    public List<GameArticleProjection> findAllGameArticleProjection() {
        return gameArticle.findArticleProjection();
    }

    @Override
    public GameArticleProjection findArticleProjection(Integer id) {
        return gameArticle.findArticleProjectionById(id);
    }

    @Override
    public List<GameArticleProjection> findAllGameArticleProjectionByCategory(Integer idGameCategory) {
        return gameArticle.findArticlesByCategory(idGameCategory);
    }
}
