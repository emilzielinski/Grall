package infrastructure.repo.article;

import java.sql.ResultSet;
import java.sql.SQLException;

import application.article.GameArticle;
import org.springframework.jdbc.core.RowMapper;


public class GameArticleRowMapper implements RowMapper<GameArticle> {

    public GameArticle mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new GameArticle(rs.getInt("id_Article")
                , rs.getString("Article_title")
                , rs.getString("Article_content")
                , rs.getString("Article_date")
                , rs.getString("Article_author")
                , rs.getInt("id_Categories")
                , rs.getString("Article_image"));
    }
}