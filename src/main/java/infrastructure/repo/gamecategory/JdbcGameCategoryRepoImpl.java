package infrastructure.repo.gamecategory;

import application.gamecategory.GameCategory;
import application.gamecategory.GameCategoryCommand;
import application.gamecategory.JdbcGameCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JdbcGameCategoryRepoImpl implements JdbcGameCategoryRepo {

    private final String QUERY_FIND_CATEGORY = "select id_Categories, categories_Name from Categories";
    private final String QUERY_INSERT_CATEGORY = "insert into Categories (categories_Name) values (?)";
    private final String QUERY_DELETE_CATEGORY = "DELETE FROM Categories WHERE id_Categories = ?";



    private final JdbcOperations repo;

    @Autowired
    public JdbcGameCategoryRepoImpl(JdbcOperations repo) {
        this.repo = repo;
    }

    @Override
    public List<GameCategory> getGameCategory() {
        return repo.query(QUERY_FIND_CATEGORY, new GameCategoryRowMapper());
    }

    @Override
    public void save(GameCategoryCommand gameCategoryCommand) {
        repo.update(QUERY_INSERT_CATEGORY, new Object[]{gameCategoryCommand.getCategoryName()});
    }

    @Override
    public void remove(Integer idCategory) {
        repo.update(QUERY_DELETE_CATEGORY, new Object[]{idCategory});
    }
}
