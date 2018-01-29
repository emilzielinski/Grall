package application.gamecategory;

/**
 * Created by Damian on 02.01.2017.
 */
public class GameCategory {

    private Integer idGameCategory;
    private String name;

    public GameCategory(Integer idGameCategory, String name) {
        this.idGameCategory = idGameCategory;
        this.name = name;
    }

    public Integer getIdGameCategory() {
        return idGameCategory;
    }

    public String getName() {
        return name;
    }
}
