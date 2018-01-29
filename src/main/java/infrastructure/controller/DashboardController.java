package infrastructure.controller;

import application.article.GameArticle;
import application.article.GameArticleProjection;
import application.article.GameArticleService;
import application.gamecategory.GameCategory;
import application.gamecategory.GameCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 02.01.2017.
 */
@Controller
public class DashboardController {

    private final GameCategoryService serviceCategory;
    private final GameArticleService gameArticleService;

    @Autowired
    public DashboardController(GameCategoryService serviceCategory,GameArticleService gameArticleService){
        this.serviceCategory = serviceCategory;
        this.gameArticleService = gameArticleService;
    }

    @RequestMapping(value = "/article")
    public String getDashboard(Model model){

        List<GameCategory> categoryList = serviceCategory.findAllCategory();
        List<GameArticleProjection> gameArticleList = gameArticleService.findAllGameArticleProjection();

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("gameArticleList", gameArticleList);

        return "dashboard";
    }

    @RequestMapping(value = "/byCategory/{idGameCategory}")
    public String getDashboardByCategory(@PathVariable Integer idGameCategory, Model model){

        List<GameCategory> categoryList = serviceCategory.findAllCategory();
        List<GameArticleProjection> gameArticleList = gameArticleService.findAllGameArticleProjectionByCategory(idGameCategory);

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("gameArticleList", gameArticleList);

        return "dashboard";
    }

    @RequestMapping(value = "/")
    public String getContact(){
        return "contact";
    }
}
