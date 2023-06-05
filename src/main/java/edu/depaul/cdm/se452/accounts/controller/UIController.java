package edu.depaul.cdm.se452.accounts.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    @RequestMapping(value = "/customer/login")
    public String Customer(){
        return "Login";
    }

    @RequestMapping(value ="/customer/signup")
    public String Customer1(){return "SignUp";}
}
