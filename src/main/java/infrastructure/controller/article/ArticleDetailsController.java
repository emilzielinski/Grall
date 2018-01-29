package infrastructure.controller.article;

import application.article.GameArticle;
import application.article.GameArticleProjection;
import application.article.GameArticleService;
import application.commentgame.CommentGame;
import application.commentgame.CommentGameCommand;
import application.commentgame.CommentGameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ArticleDetailsController {

    private final GameArticleService gameArticleService;
    private final CommentGameService commentGameService;

    public ArticleDetailsController(GameArticleService gameArticleService,CommentGameService commentGameService) {
        this.gameArticleService = gameArticleService;
        this.commentGameService = commentGameService;
    }

    @RequestMapping(value = "/dashboard/article/details/{id}")
    public String getArticleDetails(@PathVariable Integer id, Model model){

        GameArticleProjection searchArticle = gameArticleService.findArticleProjection(id);
        List<CommentGame> commentGameList = commentGameService.getCommentByArticleId(id);

        model.addAttribute("article", searchArticle);
        model.addAttribute("comments", commentGameList);
        model.addAttribute("allTypes", getScoreList());
        model.addAttribute("commentGameCommand", new CommentGameCommand());

        return "article/details";
    }

    private List<Integer> getScoreList() {
        List<Integer> scoreList = new ArrayList<>();
        scoreList.add(1);
        scoreList.add(2);
        scoreList.add(3);
        scoreList.add(4);
        scoreList.add(5);
        return scoreList;
    }
}
