package infrastructure.repo.commentgame;

import application.commentgame.CommentGame;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;



public class CommentGameRowMapper implements RowMapper<CommentGame> {

    public CommentGame mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new CommentGame(rs.getInt("id_Comment"),
                rs.getString("comments_Content"),
                rs.getString("comments_Date"),
                rs.getInt("id_Article"));
    }
}