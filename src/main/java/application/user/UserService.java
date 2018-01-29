package application.user;


import java.util.List;

public interface UserService {

    void saveUser(UserCommand userCommand);

    List<AppUser> findAllUsers();

    void blockUser(boolean userStatus, Integer idUsers);

}
