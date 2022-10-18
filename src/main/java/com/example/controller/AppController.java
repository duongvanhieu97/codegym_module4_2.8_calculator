package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
    @GetMapping("/calculator")
    public ModelAndView getIndexO() {
        ModelAndView modelAndView = new ModelAndView("appCalculator");
        return modelAndView;
    }

    @GetMapping("/appcalculator")
    public ModelAndView calculator(
            @RequestParam(name = "op_1") float op1,
            @RequestParam(name = "op_2") float op2,
            @RequestParam(name = "operator") String operator) {

        ModelAndView modelAndView = new ModelAndView("appCalculator");
        float result = 0;
        String message = "Success";
        switch (operator) {
            case "add":
                result = op1 + op2;
                break;
            case "sub":
                result = op1 - op2;
                break;
            case "mul":
                result = op1 * op2;
                break;
            case "div":
                if (op2 == 0) {
                    message = "Cannot division to zero";

                } else
                    result = op1 / op2;
                break;
            default:
        }
        modelAndView.addObject("result", result);
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}
