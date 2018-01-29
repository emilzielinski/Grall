package infrastructure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {



    @RequestMapping("/test")
    public String getHelloPage(Model model){
        model.addAttribute("applicationName", "Graal");
        return "hello";
        //test
    }
}
