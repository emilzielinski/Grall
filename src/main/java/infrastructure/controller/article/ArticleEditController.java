package infrastructure.controller.article;

import application.article.GameArticle;
import application.article.GameArticleService;
import application.article.command.GameArticleAddCommand;
import application.commentgame.CommentGame;
import application.commentgame.CommentGameService;
import application.gamecategory.GameCategory;
import application.gamecategory.GameCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ArticleEditController {

    private final GameArticleService gameArticleService;
    private final GameCategoryService gameCategoryService;
    private final CommentGameService commentGameService;

    @Autowired
    public ArticleEditController(GameArticleService gameArticleService, GameCategoryService gameCategoryService, CommentGameService commentGameService) {
        this.gameArticleService = gameArticleService;
        this.gameCategoryService = gameCategoryService;
        this.commentGameService = commentGameService;
    }

    @RequestMapping(value = "/admin/article/{idEditArticle}/edit", method = RequestMethod.GET)
    public String editSelectArticle(@PathVariable Integer idEditArticle, Model model) {

        GameArticleAddCommand gameArticleAddCommand = gameArticleService.findArticle(idEditArticle);
        List<GameCategory> category = gameCategoryService.findAllCategory();
        List<CommentGame> commentByArticleId = commentGameService.getCommentByArticleId(idEditArticle);


        model.addAttribute("gameArticleAddCommand", gameArticleAddCommand);
        model.addAttribute("allCategory", category);
        model.addAttribute("comments", commentByArticleId);
        return "article/edit";
    }

    @RequestMapping(value = "/admin/article/edit", method = RequestMethod.POST)
    public String editArticle(@ModelAttribute @Valid GameArticleAddCommand gameArticleAddCommand, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "article/edit";
        } else {
           gameArticleService.updateArticle(gameArticleAddCommand);
            return "redirect:/admin";
        }
    }
}
