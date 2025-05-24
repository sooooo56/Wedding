package com.mobile.Wedding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/SeojunHaeun")
    public String SeojunHaeun(){
        return "SeojunHaeun";
    }

    @GetMapping("/")
    public String root(){
        return "redirect:/SeojunHaeun";
    }

}
