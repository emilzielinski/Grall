package infrastructure.service.user;

import application.user.AppUser;
import application.user.JdbcUserRepo;
import application.user.UserCommand;
import application.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class UserServiceImpl implements UserService {

    private final JdbcUserRepo repo;

    @Autowired
    public UserServiceImpl(JdbcUserRepo repo) {
        this.repo = repo;
    }

    @Override
    public void saveUser(UserCommand userCommand) {
        repo.saveUser(new AppUser(userCommand.getUsername(), userCommand.getEmail(),userCommand.getPassword(), true));
        repo.saveUserAuthorities(userCommand.getUsername());
    }

    @Override
    public List<AppUser> findAllUsers() {
        return repo.findAllUsers();
    }

    @Override
    public void blockUser(boolean userStatus, Integer idUsers) {
        repo.blockUser(userStatus, idUsers);
    }
}
