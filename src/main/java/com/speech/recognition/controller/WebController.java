package com.speech.recognition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {


    @RequestMapping("/index")
    public String testHello(ModelMap map){
        map.put("title", "hello world");
        return "index";
    }

}
