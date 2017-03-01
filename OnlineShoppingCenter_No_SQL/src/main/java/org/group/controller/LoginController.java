package org.group.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
//    @Autowired
//    private UserDaoImpl userService;
//    private User user;

    @ModelAttribute(value = "subject")
    public Subject subject() {
        return SecurityUtils.getSubject();
    }

    @RequestMapping(value = {"/login","/login.html"}, method = RequestMethod.GET)
    protected String Glogin() {
        return "login";
    }

    @RequestMapping(value = {"/login","/login.html"}, method = RequestMethod.POST)
    protected String Plogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model)  {
        System.out.println("HERE");
        System.out.println("username"+ username);
        System.out.println("password"+password);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try{
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("Suc"+"1");
            model.addAttribute("Suc",true);
            return "login";
        } catch (IncorrectCredentialsException e) {
            System.out.println("Suc"+"1");
            model.addAttribute("Suc",true);
            return "login";
        } catch (AuthenticationException e) {
            model.addAttribute("Suc",true);
            return "login";
        }
        model.addAttribute("Suc", false);
        return "/loginsuccess";
    }
}
