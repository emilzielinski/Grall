package application.commentgame;

public class CommentGameCommand {

    private String content;
    private String score;

    public CommentGameCommand() {
    }

    public CommentGameCommand(String content, String score) {
        this.content = content;
        this.score = score;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
