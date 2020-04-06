package com.vladyslav.calculator.controller;


import com.vladyslav.calculator.entity.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MainController {

    @Autowired(required=false)
    private Calculator calculator;

    private  Map<String, Double> arrExsp = new LinkedHashMap<>();

    private int a = 10;


    @GetMapping
    public String getMainPage(HttpSession session) {
        session.setAttribute("a" ,a);
        return "base-layout";
    }

    @PostMapping
    public String calculate(@RequestParam String text, Model theModel) {

        String noOpn = text;
        double result = 0;
        String message= "Недопустимое значение";

        try {
            text = Calculator.opn(text);
        } catch (Exception e) {
            theModel.addAttribute("message", message);
        }

        try {
            result = Calculator.calculate(text);
        } catch (Exception e) {

            theModel.addAttribute("message", message);
        }

        arrExsp.put(noOpn, result);
        theModel.addAttribute("result",result);
        System.out.println("size" + arrExsp.size());
        return "base-layout";
    }

}
