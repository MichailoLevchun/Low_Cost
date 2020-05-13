package com.Low_Cost.controller;

import com.Low_Cost.entity.Shirt;
import com.Low_Cost.service.BrandService;
import com.Low_Cost.service.GenderService;

import com.Low_Cost.service.ShirtService;
import com.Low_Cost.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.jws.WebParam;


/**
 * Created by Study on 10.06.2017.
 */

@Controller
public class ShirtController {
    @Autowired
    private BrandService brandService;
    @Autowired
    private GenderService genderService;
    @Autowired
    private ShirtService shirtService;


    @Autowired
    private TypeService typeService;

  @GetMapping("/allShirtList")
    public String shirt(Model model, Pageable pageable){

      try {
          model.addAttribute("shirt_types", typeService.findAll());
      }
      catch (NullPointerException e)
      {
          System.out.println("EXEPTION");
      }

      model.addAttribute("shirts", shirtService.findAll());

      return "views-user-AllShirtsList";
  }

  @GetMapping("/shirts/{id}")
  public  String shirts(@PathVariable int id, Model model)
  {

      try {
          model.addAttribute("shirt_types", typeService.findAll());
      }
      catch (NullPointerException e)
      {
          System.out.println("EXEPTION");
      }

      model.addAttribute("shirts", shirtService.findShirtByType(id));

      return  "views-user-AllShirtsList";
  }





}
