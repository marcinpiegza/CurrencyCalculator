package pl.project.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.calculator.model.User;
import pl.project.calculator.service.UserService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginViev() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute @Valid User user, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()){
            return register();
        }else{
            session.setAttribute("currentUser",userService.addUser(user));
            return redirectToStartPage();
        }
    }
    private String redirectToStartPage(){
        return "start";
    }


}
