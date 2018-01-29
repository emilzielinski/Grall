package application.score;


public class ScoreGame {

    private Integer idScore;
    private Integer scoreNumber;
    private Integer idArticle;

    public ScoreGame(Integer idScore, Integer scoreNumber, Integer idArticle) {
        this.idScore = idScore;
        this.scoreNumber = scoreNumber;
        this.idArticle = idArticle;
    }

    public Integer getIdScore() {
        return idScore;
    }

    public Integer getScoreNumber() {
        return scoreNumber;
    }

    public Integer getIdArticle() {
        return idArticle;
    }
}
