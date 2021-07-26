package com.socin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class DeveloperWebController {

    @RequestMapping("/developers")
    public String developers() {
        return "developers";
    }
}
