package com.Low_Cost.controller;

import com.Low_Cost.service.ShirtService;
import com.Low_Cost.service.TypeService;
import com.Low_Cost.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Created by Study on 14.06.2017.
 */
@Controller
public class IndexController {

    @Autowired
    private ShirtService shirtService;
    @Autowired
    private UserService userService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/")
    public String index(Model model, Principal principal, @PageableDefault Pageable pageable){

        model.addAttribute("shirt", shirtService.shirtPages(pageable));
        model.addAttribute("shirt_types", typeService.findAll());
        try {
            model.addAttribute("user", principal.getName());
        }catch (Exception e)
        {
            model.addAttribute("user", "anonymousUser");
        }
        if(principal== null || principal.getName().equals("admin")){

            return "views-base-index";
        }else {

            return "views-base-index";
        }
    }

    @PostMapping("/home")
    public String indexAfterLogin(Model model,@PageableDefault Pageable pageable,Principal principal) {


        try {
            model.addAttribute("user", principal.getName());
        }catch (Exception e)
        {
            model.addAttribute("user", "anonymousUser");
        }
        model.addAttribute("shirt", shirtService.shirtPages(pageable));
        model.addAttribute("shirt_types", typeService.findAll());

        return "views-base-index";


    }


    @PostMapping("/failureLogin")
    public String failureLogin(Model model, Principal principal){



        System.out.println("FAILURE LOGIN");
        try {
            model.addAttribute("user", principal.getName());
        }catch (Exception e)
        {
            model.addAttribute("user", "anonymousUser");
        }

        return "views-base-index";
    }
}
