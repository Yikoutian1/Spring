package com.hang.mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName WebController
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/21 021 18:58
 * @Version 1.0
 */
@RestController
@RequestMapping("/index")
public class WebController {
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping("/toIndex")
    public ModelAndView toIndex(ModelAndView modelAndView) {
        modelAndView.setViewName("/index.html");
        return modelAndView;
    }

    @RequestMapping("/toBaidu")
    public ModelAndView toBaidu(ModelAndView modelAndView) {
        modelAndView.setViewName("redirect:http://www.baidu.com");
        return modelAndView;
    }
}
