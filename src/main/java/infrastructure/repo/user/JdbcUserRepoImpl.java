package infrastructure.repo.user;

import application.user.AppUser;
import application.user.JdbcUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JdbcUserRepoImpl implements JdbcUserRepo {

    private final String QUERY_SAVE_USER = "INSERT INTO users (username, password, email, enabled) VALUES (?,?,?,?)";

    private final String QUERY_FIND_USERS = "SELECT u.id, u.username, u.email, u.enabled , a.role " +
            "FROM users u " +
            "join user_roles a on u.username = a.username";

    private final String QUERY_BLOCK_USER = "UPDATE users Set enabled = ? where id=?";

    private final String QUERY_SAVE_USER_AUTHORITIES = "INSERT INTO user_roles (username, role) VALUES (?, ?)";

    private final JdbcOperations repo;

    @Autowired
    public JdbcUserRepoImpl(JdbcOperations repo) {
        this.repo = repo;
    }

    @Override
    public void saveUser(AppUser appUser) {
        repo.update(QUERY_SAVE_USER,
                appUser.getUsername(),
                appUser.getPassword(),
                appUser.getEmail(),
                appUser.isEnabled());
    }

    @Override
    public List<AppUser> findAllUsers() {
        return repo.query(QUERY_FIND_USERS, new AppUserRowMapper());
    }

    @Override
    public void blockUser(boolean userStatus, Integer idUsers) {
        repo.update(QUERY_BLOCK_USER, userStatus, idUsers);
    }

    @Override
    public void saveUserAuthorities(String username) {
        repo.update(QUERY_SAVE_USER_AUTHORITIES, username, "ROLE_USER");
    }
}