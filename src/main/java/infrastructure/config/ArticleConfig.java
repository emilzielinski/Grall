package infrastructure.config;

import application.article.GameArticleService;
import application.article.JdbcGameArticleRepo;
import application.commentgame.JdbcCommentGameRepo;
import infrastructure.service.article.GameArticleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ArticleConfig {

    @Bean
    public GameArticleService gameArticleService(JdbcGameArticleRepo gameArticle,JdbcCommentGameRepo commentGame){
        return new GameArticleServiceImpl(gameArticle,commentGame);
    }
}
