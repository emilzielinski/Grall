package application.gamecategory;

import java.util.List;

/**
 * Created by Damian on 03.01.2017.
 */
public interface JdbcGameCategoryRepo {

    List<GameCategory> getGameCategory();

    void save(GameCategoryCommand gameCategoryCommand);

    void remove(Integer idCategory);
}
