package infrastructure.service.gamecategory;

import application.gamecategory.GameCategory;
import application.gamecategory.GameCategoryCommand;
import application.gamecategory.GameCategoryService;
import application.gamecategory.JdbcGameCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class GameCategoryServiceImpl implements GameCategoryService {

    private final JdbcGameCategoryRepo jdbcGameCategory;

    @Autowired
    public GameCategoryServiceImpl(JdbcGameCategoryRepo jdbcGameCategory){
        this.jdbcGameCategory = jdbcGameCategory;

    }

    @Override
    public List<GameCategory> findAllCategory() {
        return jdbcGameCategory.getGameCategory();
    }

    @Override
    public void save(GameCategoryCommand gameCategoryCommand) {
        jdbcGameCategory.save(gameCategoryCommand);
    }

    @Override
    public void remove(Integer idCategory) {
        jdbcGameCategory.remove(idCategory);
    }
}
