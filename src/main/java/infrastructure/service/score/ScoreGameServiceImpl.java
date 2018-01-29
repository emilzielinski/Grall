package infrastructure.service.score;

import application.score.JdbcScoreGameRepo;
import application.score.ScoreGameService;
import org.springframework.beans.factory.annotation.Autowired;


public class ScoreGameServiceImpl implements ScoreGameService {

    private final JdbcScoreGameRepo jdbcScoreGameRepo;

    @Autowired
    public ScoreGameServiceImpl(JdbcScoreGameRepo jdbcScoreGameRepo) {
        this.jdbcScoreGameRepo = jdbcScoreGameRepo;
    }

    @Override
    public void saveScore(Integer idArticle, String score) {
        jdbcScoreGameRepo.saveScore(idArticle, score);
    }
}
