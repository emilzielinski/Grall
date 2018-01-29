package application.gamecategory;

import application.gamecategory.GameCategory;

import java.util.List;

/**
 * Created by Damian on 02.01.2017.
 */

public interface GameCategoryService {

    List<GameCategory> findAllCategory();

    void save(GameCategoryCommand gameCategoryCommand);

    void remove(Integer idCategory);
}
