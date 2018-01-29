package application.article.command;

import javax.validation.constraints.NotNull;

/**
 * Created by Damian on 11.01.2017.
 */
public class GameArticleEditCommand {

    @NotNull
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    private String category;

    public GameArticleEditCommand() {
    }

    public GameArticleEditCommand(Integer id, String title, String content, String category) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.category = category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
