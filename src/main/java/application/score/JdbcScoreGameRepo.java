package application.score;


public interface JdbcScoreGameRepo {

    void saveScore(Integer idArticle, String score);
}
