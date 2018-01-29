package application.gamecategory;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GameCategoryCommand {

    @NotNull
    @Size(min = 1, message = "Podaj nazwe kategori")
    private String categoryName;

    public GameCategoryCommand() {
    }

    public GameCategoryCommand(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
