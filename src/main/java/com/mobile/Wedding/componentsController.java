package com.mobile.Wedding;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class componentsController {
    @GetMapping("/account")
    public String account(){
        return "components/account";
    }

    @GetMapping("/location")
    public String location(){
        return "components/location";
    }

    @GetMapping("/call")
    public String call(){
        return "components/call";
    }

    @GetMapping("/info")
    public String info(){
        return "components/info";
    }

    @GetMapping("/date")
    public String date(){
        return "components/date";
    }
}
