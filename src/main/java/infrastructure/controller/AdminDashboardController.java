package infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Damian on 07.01.2017.
 */
@Controller
public class AdminDashboardController {

    @RequestMapping("/admin")
    public String getAdminMainPanel(){
        return "adminPanel";
    }
}
