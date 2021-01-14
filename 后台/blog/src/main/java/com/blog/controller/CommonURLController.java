package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;


@Controller
public class CommonURLController {

    @RequestMapping("/hello")
    public void index(HttpSession session,HttpServletResponse response) {
    	System.out.println("进入到了controller");
    }
}
