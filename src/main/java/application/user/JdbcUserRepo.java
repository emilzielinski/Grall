package application.user;

import java.util.List;


public interface JdbcUserRepo {

    void saveUser(AppUser appUser);

    List<AppUser> findAllUsers();

    void blockUser(boolean userStatus, Integer idUsers);

    void saveUserAuthorities(String username);
}
