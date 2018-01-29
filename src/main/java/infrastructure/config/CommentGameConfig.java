package infrastructure.config;

import application.commentgame.CommentGameService;
import application.commentgame.JdbcCommentGameRepo;
import infrastructure.service.commentgame.CommentGameServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CommentGameConfig {

    @Bean
    public CommentGameService commentGameService(JdbcCommentGameRepo jdbcCommentGame){
        return new CommentGameServiceImpl(jdbcCommentGame);
    }
}
