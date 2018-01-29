package infrastructure.controller.user;

import application.user.AppUser;
import application.user.UserCommand;
import application.user.UserService;
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
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String addUser(Model model){
        model.addAttribute("userCommand", new UserCommand());
        return "user/registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String addUser(@ModelAttribute @Valid UserCommand userCommand, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "user/registration";
        }
        userService.saveUser(userCommand);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String allUsers(Model model){
        List<AppUser> appUserList = userService.findAllUsers();

        model.addAttribute("appUsers", appUserList);

        return "user/list";
    }

    @RequestMapping(value = "/admin/users/block/{idUser}", method = RequestMethod.POST)
    public String blockUser(@PathVariable Integer idUser){
        userService.blockUser(false, idUser);
        return "redirect:/admin/users";
    }

    @RequestMapping(value = "/admin/users/unblock/{idUser}", method = RequestMethod.POST)
    public String unblockUser(@PathVariable Integer idUser){
        userService.blockUser(true, idUser);
        return "redirect:/admin/users";
    }
}
