package infrastructure.controller.commentgame;

import application.commentgame.CommentGameCommand;
import application.commentgame.CommentGameService;
import application.score.ScoreGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class CommentGameController {

    private final CommentGameService commentGameService;
    private final ScoreGameService scoreGameService;

    @Autowired
    public CommentGameController(CommentGameService commentGameService,ScoreGameService scoreGameService) {
        this.commentGameService = commentGameService;
        this.scoreGameService = scoreGameService;
    }

    @RequestMapping(value = "/dashboard/article/{idArticle}/comment/add", method = RequestMethod.POST)
    public String addComment(@PathVariable Integer idArticle, @ModelAttribute CommentGameCommand commentGameCommand,Model model) {

        commentGameService.saveComment(commentGameCommand.getContent(),idArticle);
        scoreGameService.saveScore(idArticle, commentGameCommand.getScore());

        return "redirect:/dashboard/article/details/{idArticle}";
    }

    @RequestMapping(value = "/admin/article/{idGame}/comment/{idComment}/delete", method = RequestMethod.POST)
    public String deleteComment(@PathVariable("idGame") Integer idGame,@PathVariable("idComment") Integer idComment) {

        commentGameService.deleteComment(idComment);

        return "redirect:/admin/article/{idGame}/edit";
    }
}
