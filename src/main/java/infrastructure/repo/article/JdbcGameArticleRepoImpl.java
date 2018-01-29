package infrastructure.repo.article;

import application.article.GameArticle;
import application.article.GameArticleProjection;
import application.article.JdbcGameArticleRepo;
import application.article.command.GameArticleAddCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Component
public class JdbcGameArticleRepoImpl implements JdbcGameArticleRepo {


    private final String QUERY_FIND_ARTICLE = "SELECT id_Article, Article_title, Article_content, Article_date, Article_author, id_Categories, Article_image FROM Article";

    private final String QUERY_FIND_ARTICLE_BY_ID = "SELECT id_Article, Article_title, Article_content, Article_date, Article_author, id_Categories, Article_image FROM Article WHERE id_Article = ?";

    private final String QUERY_DELETE_ARTICLE_BY_ID = "DELETE FROM Article where id_Article = ?";

    private final String QUERY_UPDATE_ARTICLE_BY_ID = "UPDATE Article Set Article_title = ?, Article_content = ?, id_Categories = ? WHERE id_Article = ?";

    private final String QUERY_SAVE_ARTICLE = "INSERT INTO Article " +
            "(Article_title, Article_content, Article_date, Article_author, id_categories, Article_image) " +
            "values (?, ?, ?, ?, ?, ?)";

    private final String QUERY_CONTENT = "SELECT a.id_Article, a.Article_title, a.Article_content as content, a.Article_author, a.Article_date, c.categories_Name, a.Article_image, avg(s.score_Number) as score "
            + "FROM Article a  "
            + "INNER JOIN Categories c on c.id_Categories = a.id_Categories "
            + "LEFT JOIN Score s on a.id_article = s.id_article  ";

    private final String QUERY_CONTENT_FOR_DASHBOARD = "SELECT a.id_Article, a.Article_title, concat(substring(a.Article_content, 1,400),'...') as content, a.Article_author, a.Article_date, c.categories_Name, a.Article_image, avg(s.score_Number) as score "
            + "FROM Article a  "
            + "INNER JOIN Categories c on c.id_Categories = a.id_Categories "
            + "LEFT JOIN Score s on a.id_article = s.id_article  ";

    private final String QUERY_ORDER = "GROUP BY a.id_Article, a.Article_title, a.Article_content, a.Article_author, a.Article_date, c.categories_Name, a.Article_image ";

    private final String QUERY_ORDER_FOR_DASHBOARD = "GROUP BY a.id_Article, a.Article_title, concat(substring(Article_content, 1,400),'...'), a.Article_author, a.Article_date, c.categories_Name, a.Article_image ";

    private final String QUERY_ALL_ARTICLEPROJECTION = QUERY_CONTENT_FOR_DASHBOARD + QUERY_ORDER_FOR_DASHBOARD + "ORDER BY 5 ASC";

    private final String QUERY_ARTICLEPROJECTION_BY_ID = QUERY_CONTENT + "where a.id_Article = ? " + QUERY_ORDER;

    private final String QUERY_ARTICLEPROJECTION_BY_CATEGORY = QUERY_CONTENT + "where a.id_categories = ? " + QUERY_ORDER;



    private final JdbcOperations repo;

    @Autowired
    public JdbcGameArticleRepoImpl(JdbcOperations repo) {
        this.repo = repo;
    }

    @Override
    public List<GameArticle> getArticles() {

        return repo.query(QUERY_FIND_ARTICLE, new GameArticleRowMapper());
    }

    @Override
    public GameArticle findArticleById(Integer id) {
        return repo.queryForObject(QUERY_FIND_ARTICLE_BY_ID, new Object[]{id}, new GameArticleRowMapper());
    }

    @Override
    public void save(final GameArticle gameArticle) {
        repo.update(QUERY_SAVE_ARTICLE,
                gameArticle.getTitle(),
                gameArticle.getContent(),
                gameArticle.getCreateDate(),
                gameArticle.getAuthor(),
                gameArticle.getIdCategory(),
                gameArticle.getImage());
    }


    @Override
    public void updateArticle(GameArticleAddCommand gameArticleCommand) {
        repo.update(QUERY_UPDATE_ARTICLE_BY_ID, gameArticleCommand.getTitle(), gameArticleCommand.getContent(), gameArticleCommand.getIdCategory(), gameArticleCommand.getId());
    }

    @Override
    public void deleteArticle(Integer idArticle) {
        repo.update(QUERY_DELETE_ARTICLE_BY_ID, idArticle);
    }

    @Override
    public List<GameArticleProjection> findArticleProjection() {
        return repo.query(QUERY_ALL_ARTICLEPROJECTION, new GameArticleProjectionRowMapper());
    }

    @Override
    public GameArticleProjection findArticleProjectionById(Integer id) {
        return repo.queryForObject(QUERY_ARTICLEPROJECTION_BY_ID, new Object[]{id}, new GameArticleProjectionRowMapper());
    }

    @Override
    public List<GameArticleProjection> findArticlesByCategory(Integer idGameCategory) {
        return repo.query(QUERY_ARTICLEPROJECTION_BY_CATEGORY, new Object[]{idGameCategory}, new GameArticleProjectionRowMapper());
    }

}