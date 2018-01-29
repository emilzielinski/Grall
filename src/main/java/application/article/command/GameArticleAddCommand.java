package application.article.command;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Damian on 08.01.2017.
 */
public class GameArticleAddCommand {


    private Integer id;

    @NotNull(message = "Podaj tytuł")
    @Size(min = 1, message = "Podaj tytuł")
    private String title;

    @NotNull(message = "Podaj opis")
    @Size(min = 1, message = "Podaj tytuł")
    private String content;

    @NotNull(message = "Błędna wartość")
    @NumberFormat
    private Integer idCategory;

    private String picture;

    private MultipartFile multipartFile;

    public GameArticleAddCommand() {
    }

    public GameArticleAddCommand(Integer id,String title, String content, Integer idCategory) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.idCategory = idCategory;
    }

    public GameArticleAddCommand(Integer id,String title, String content, Integer idCategory,String picture) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.idCategory = idCategory;
        this.picture = picture;
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

    public Integer getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Integer idCategory) {
        this.idCategory = idCategory;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture){
        this.picture = picture;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public boolean isEmpty() {
        return this.getTitle() == null && this.getContent() == null && this.getIdCategory() == null;
    }
}
