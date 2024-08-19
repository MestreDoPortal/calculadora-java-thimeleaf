package com.example.calculadora.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.ui.Model;


@Controller
public class calculadora {

    @GetMapping("/")
    public String set() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return "index";
    }

    @PostMapping("/calculo")
    public String calcular(@RequestParam("num1")double num1,
                            @RequestParam("num2")double num2,
                            @RequestParam("opcoes")Character opcoes,
                            Model model){
    double res;
    res=0;
    switch (opcoes) {
        case '+':
            res=num1+num2;
            break;
        case '-':
            res=num1-num2;
            break;
        case '/':
            res=num1/num2;
            break;
        case 'x':
            res=num1*num2;
            break;
        default:
            break;
    }    
    model.addAttribute("res", res);
    return "index";
    }
    
    
}
