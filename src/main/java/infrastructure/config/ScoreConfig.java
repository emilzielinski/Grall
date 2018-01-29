package infrastructure.config;

import application.score.JdbcScoreGameRepo;
import application.score.ScoreGameService;
import infrastructure.service.score.ScoreGameServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScoreConfig {

    @Bean
    public ScoreGameService scoreGameService(JdbcScoreGameRepo scoreGameRepo){
        return new ScoreGameServiceImpl(scoreGameRepo);
    }
}
