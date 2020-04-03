package com.vladyslav.calculator.controller;

import com.vladyslav.calculator.entity.Calculator;
import org.springframework.beans.factory.ObjectFactory;
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

    @GetMapping
    public String getMainPage() {

        return "base-layout";
    }

    @PostMapping
    public String calculate(@RequestParam String text, Model theModel) {

        String noOpn = text;
        Map<String, Double> arrExsp = null;
        double result = 0;
        
        try {

            text = Calculator.opn(text);
        } catch (Exception e) {
            System.out.println("Нельзя так");
        }
        try {
           
            System.out.println( result = Calculator.calculate(text));
            arrExsp = new LinkedHashMap<>();
            arrExsp.put(noOpn, result);
            arrExsp.forEach((k,v) -> System.out.println(k + "=" + v)); // только для отслеживания
        } catch (Exception e) {
            System.out.println("Нельзя так");
        }

        theModel.addAttribute("result", result);
        theModel.addAttribute("arrExsp", arrExsp);
        return "base-layout";
    }

  



}
