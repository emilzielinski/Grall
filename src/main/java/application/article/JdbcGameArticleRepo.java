package application.article;

import application.article.command.GameArticleAddCommand;
import application.article.command.GameArticleEditCommand;

import java.util.List;

/**
 * Created by Damian on 03.01.2017.
 */
public interface JdbcGameArticleRepo {

    List<GameArticle> getArticles();

    GameArticle findArticleById(Integer id);

    void save(GameArticle gameArticle);

    void updateArticle(GameArticleAddCommand gameArticleCommand);

    void deleteArticle(Integer idArticle);

    List<GameArticleProjection> findArticleProjection();

    GameArticleProjection findArticleProjectionById(Integer id);

    List<GameArticleProjection> findArticlesByCategory(Integer idGameCategory);
}
