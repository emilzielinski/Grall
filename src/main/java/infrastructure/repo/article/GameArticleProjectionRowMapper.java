package infrastructure.repo.article;

import application.article.GameArticleProjection;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Damian on 17.01.2017.
 */
public class GameArticleProjectionRowMapper implements RowMapper<GameArticleProjection> {
    @Override
    public GameArticleProjection mapRow(ResultSet resultSet, int i) throws SQLException {
        return new GameArticleProjection(
                resultSet.getInt("id_Article"),
                resultSet.getString("Article_title"),
                resultSet.getString("content"),
                resultSet.getString("Article_author"),
                resultSet.getString("Article_date"),
                resultSet.getString("categories_Name"),
                resultSet.getString("Article_image"),
                resultSet.getDouble("score"));
    }
}
