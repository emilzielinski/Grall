package infrastructure.controller.gamecategory;


import application.gamecategory.GameCategory;
import application.gamecategory.GameCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameCategoryDeleteController {

    private final GameCategoryService gameCategoryService;

    @Autowired
    public GameCategoryDeleteController(GameCategoryService gameCategoryService) {
        this.gameCategoryService = gameCategoryService;
    }

    @RequestMapping(value = "/admin/category/delete", method = RequestMethod.GET)
    public String delete(Model model){

        List<GameCategory> categories = gameCategoryService.findAllCategory();

        model.addAttribute("category", categories);
        return "gamecategory/delete";
    }

    @RequestMapping(value = "/admin/category/{idCategory}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable Integer idCategory){
        gameCategoryService.remove(idCategory);
        return "redirect:/admin";
    }
}
