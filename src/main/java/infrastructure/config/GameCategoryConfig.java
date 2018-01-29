package infrastructure.config;

import application.gamecategory.GameCategoryService;
import application.gamecategory.JdbcGameCategoryRepo;
import infrastructure.service.gamecategory.GameCategoryServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GameCategoryConfig {

    @Bean
    public GameCategoryService gameCategoryService(JdbcGameCategoryRepo jdbcGameCategory){
        return new GameCategoryServiceImpl(jdbcGameCategory);
    }
}
