package infrastructure.controller.article;

import application.article.GameArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ArticleDeleteController {

    private final GameArticleService gameArticleService;

    @Autowired
    public ArticleDeleteController(GameArticleService gameArticleService) {
        this.gameArticleService = gameArticleService;
    }

    @RequestMapping(value = "/admin/article/{idArticle}/delete", method = RequestMethod.POST)
    public String deleteArticle(@PathVariable Integer idArticle){
        gameArticleService.deleteArticle(idArticle);
        return "redirect:/admin";
    }
}
