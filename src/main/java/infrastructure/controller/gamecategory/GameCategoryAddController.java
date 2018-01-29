package infrastructure.controller.gamecategory;

import application.gamecategory.GameCategoryCommand;
import application.gamecategory.GameCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class GameCategoryAddController {

    private final GameCategoryService gameCategoryService;

    @Autowired
    public GameCategoryAddController(GameCategoryService gameCategoryService) {
        this.gameCategoryService = gameCategoryService;
    }

    @RequestMapping(value = "/admin/category/add", method = RequestMethod.GET)
    public String addCategory(Model model){
        model.addAttribute(new GameCategoryCommand());
        return "gamecategory/add";
    }

    @RequestMapping(value = "/admin/category/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute @Valid GameCategoryCommand gameCategoryCommand,
                              BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return "gamecategory/add";
        } else {
            gameCategoryService.save(gameCategoryCommand);
            return "redirect:/admin";
        }
    }
}
