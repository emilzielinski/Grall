package infrastructure.repo.user;

import application.user.AppUser;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AppUserRowMapper implements RowMapper<AppUser> {


    @Override
    public AppUser mapRow(ResultSet resultSet, int i) throws SQLException {
        return new AppUser(resultSet.getInt("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getBoolean("enabled"),
                resultSet.getString("role"));
    }
}
