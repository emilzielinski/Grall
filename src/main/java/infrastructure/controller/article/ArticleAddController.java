package infrastructure.controller.article;

import application.article.GameArticleService;
import application.article.command.GameArticleAddCommand;
import application.gamecategory.GameCategory;
import application.gamecategory.GameCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;


@Controller
public class ArticleAddController {

    private final GameArticleService gameArticleService;
    private final GameCategoryService gameCategoryService;

    @Autowired
    public ArticleAddController(GameArticleService gameArticleService, GameCategoryService gameCategoryService) {
        this.gameArticleService = gameArticleService;
        this.gameCategoryService = gameCategoryService;
    }

    @RequestMapping(value = "/admin/article/add", method = RequestMethod.GET)
    public String addArticle(Model model) {

        List<GameCategory> gameCategories = gameCategoryService.findAllCategory();

        model.addAttribute("gameCategories", gameCategories);
        model.addAttribute(new GameArticleAddCommand());

        return "article/add";
    }

    @RequestMapping(value = "/admin/article/add", method = RequestMethod.POST)
    public String addArticle(@ModelAttribute @Valid GameArticleAddCommand gameArticleAddCommand,
                             BindingResult bindingResult,
                             @RequestParam("multipartFile") MultipartFile file, Model model) throws IOException {

        if (bindingResult.hasErrors()) {

            List<GameCategory> gameCategories = gameCategoryService.findAllCategory();
            model.addAttribute("gameCategories", gameCategories);

            return "article/add";
        } else {
            String fileName = gameArticleAddCommand.getTitle()+ "_" + file.getOriginalFilename() + LocalDateTime.now().toString();
            gameArticleAddCommand.setPicture(fileName);
            gameArticleService.saveArticle(gameArticleAddCommand);


            Path path = Paths.get("src/main/resources/static/images/", fileName);
            File savedFile = path.toFile();

            if(savedFile.createNewFile()){
                OutputStream outStream = new FileOutputStream(savedFile);
                outStream.write(file.getBytes());
            }

            return "redirect:/admin";
        }
    }
}
