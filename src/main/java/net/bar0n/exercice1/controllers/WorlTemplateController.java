package net.bar0n.exercice1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 * User: bar0n
 * Date: 14.04.13
 * Time: 15:22
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class WorlTemplateController {
//

    @RequestMapping("/generatedoc")
    public ModelAndView  generateDoc(@RequestParam(value = "template") String template,Model uiModel) {
        System.out.println(template);
        ModelAndView modelAndView = new ModelAndView("redirect:clients/debts");
        modelAndView.addObject("template",template);
        return modelAndView;
    }
}
