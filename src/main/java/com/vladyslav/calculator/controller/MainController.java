package com.vladyslav.calculator.controller;


import com.vladyslav.calculator.entity.Calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {

    @Autowired(required=false)
    private Calculator calculator;

    Map<String, Double> arrExsp = new LinkedHashMap<>();;


    @GetMapping
    public String getMainPage() {

        return "base-layout";
    }

    @PostMapping
    public String calculate(@RequestParam String text, Model theModel) throws Exception {

        String noOpn = text;
        double result = 0;


            text = Calculator.opn(text);

            result = Calculator.calculate(text);

            arrExsp.put(noOpn, result);

        theModel.addAttribute("result", result);
        theModel.addAttribute("arrExsp", arrExsp);

        System.out.println("size" + arrExsp.size());
        return "base-layout";
    }

    @GetMapping("back")
    public String clickBackButton( Model theModel) {

        theModel.addAttribute("arrExsp", arrExsp);
        

        return "redirect:/";
    }



}
