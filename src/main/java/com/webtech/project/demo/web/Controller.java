package com.webtech.project.demo.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @GetMapping(path = "/")
    public ModelAndView helloWorldPage(){
        return new ModelAndView("helloworld");
    }

}
