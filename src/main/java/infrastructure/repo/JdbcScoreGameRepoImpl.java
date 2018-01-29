package infrastructure.repo;

import application.score.JdbcScoreGameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

@Component
public class JdbcScoreGameRepoImpl implements JdbcScoreGameRepo {

    private final String QUERY_INSERT_SCORE = "insert into Score(score_Number, id_article) values (?,?)";

    private final String QUERY_GET_AVG = "select id_article, avg(score_Number) from Score Group by 1";

    private final JdbcOperations repo;

    @Autowired
    public JdbcScoreGameRepoImpl(JdbcOperations repo) {
        this.repo = repo;
    }

    @Override
    public void saveScore(Integer idArticle, String score) {
        repo.update(QUERY_INSERT_SCORE, new Object[]{score, idArticle});
    }
}
