package org.app.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorMapperController implements ErrorController {
    @RequestMapping(value = "/error")
    public String error() {
        return "index.html";
    }

    @Override
    public String getErrorPath() {
        return "/";
    }
}
