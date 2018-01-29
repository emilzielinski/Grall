package infrastructure.config;

import application.user.JdbcUserRepo;
import application.user.UserService;
import infrastructure.service.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    public UserService userService(JdbcUserRepo jdbcUserRepo){
        return new UserServiceImpl(jdbcUserRepo);
    }
}
