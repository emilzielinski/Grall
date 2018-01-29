package infrastructure.controller.article;

import application.article.GameArticle;
import application.article.GameArticleService;
import application.article.command.GameArticleSearchCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


@Controller
public class ArticleSearchController {

    private final GameArticleService gameArticleService;

    @Autowired
    public ArticleSearchController(GameArticleService gameArticleService) {
        this.gameArticleService = gameArticleService;
    }

    @RequestMapping(value = "/admin/article/search", method = RequestMethod.GET)
    public String editArticle(Model model) {

        List<GameArticle> gameArticleList = gameArticleService.findAllGameArticle();

        model.addAttribute(new GameArticleSearchCommand());
        model.addAttribute("searchArticles", gameArticleList);

        return "article/search";
    }

    @RequestMapping(value = "/admin/article/search", method = RequestMethod.POST)
    public String editArticle(@ModelAttribute @Valid GameArticleSearchCommand gameArticleSearchCommand,
                              BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            List<GameArticle> gameArticleList = gameArticleService.findAllGameArticle();

            model.addAttribute("searchArticles", gameArticleList);
            return "article/search";
        }

        return "redirect:/admin/article/" + gameArticleSearchCommand.getId().toString() + "/edit";
    }
}
