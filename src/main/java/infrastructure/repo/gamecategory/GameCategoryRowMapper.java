package infrastructure.repo.gamecategory;

import application.gamecategory.GameCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GameCategoryRowMapper implements RowMapper<GameCategory>{

    public GameCategory mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new GameCategory(rs.getInt("id_Categories"), rs.getString("categories_Name"));
    }
}
