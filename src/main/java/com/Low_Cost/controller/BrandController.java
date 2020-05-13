package com.Low_Cost.controller;

import com.Low_Cost.entity.Brand;
import com.Low_Cost.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.awt.print.Pageable;


/**
 * Created by Study on 12.06.2017.
 */
@Controller
public class BrandController {

    @Autowired
    private BrandService brandService;


@GetMapping("/brand")
    public String brand(Model model, @PageableDefault Pageable pageable){
    model.addAttribute("brands", brandService.findAll());
    model.addAttribute("brand", new Brand());
    return  "views-admin-brand";






}

}
