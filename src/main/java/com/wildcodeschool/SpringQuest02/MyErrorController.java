package com.wildcodeschool.SpringQuest02;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MyErrorController implements ErrorController{
    
    @GetMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        return request.getAttribute(RequestDispatcher.ERROR_MESSAGE).toString();
    }
}
