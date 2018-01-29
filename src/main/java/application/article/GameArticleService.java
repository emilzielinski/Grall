package application.article;

import application.article.command.GameArticleAddCommand;
import application.article.command.GameArticleEditCommand;

import java.util.List;

/**
 * Created by Damian on 03.01.2017.
 */
public interface GameArticleService {

    List<GameArticle> findAllGameArticle();

    GameArticleAddCommand findArticle(Integer id);

    void saveArticle(GameArticleAddCommand gameArticleCommand);

    void updateArticle(GameArticleAddCommand gameArticleCommand);

    void deleteArticle(Integer idArticle);

    List<GameArticleProjection> findAllGameArticleProjection();

    GameArticleProjection findArticleProjection(Integer id);

    List<GameArticleProjection> findAllGameArticleProjectionByCategory(Integer idGameCategory);
}
