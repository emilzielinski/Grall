package application.article.command;

import javax.validation.constraints.NotNull;

/**
 * Created by Damian on 10.01.2017.
 */
public class GameArticleSearchCommand {

    @NotNull(message = "Wybierz wartość")
    private Integer id;


    private String title;

    public GameArticleSearchCommand() {
    }

    public GameArticleSearchCommand(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
