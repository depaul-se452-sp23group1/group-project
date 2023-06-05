package edu.depaul.cdm.se452.transaction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//Controller mapping to UI
public class MainController {
    @RequestMapping(value = "/transactions/index")
    public String transact() {
        return "trindex"; //start page for transactions
    }

}



