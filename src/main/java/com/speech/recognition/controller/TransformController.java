package com.speech.recognition.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transform")
public class TransformController {

    @RequestMapping("/transformChineseToEmoji")
    public String transformChineseToEmoji(){
        return "";
    }

}
