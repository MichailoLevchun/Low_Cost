package com.Low_Cost.controller;

import com.Low_Cost.entity.*;
import com.Low_Cost.service.*;
import com.Low_Cost.validator.Validator;
import com.Low_Cost.validator.userLoginValidation.UserLoginValidator;
import com.sun.org.apache.regexp.internal.RE;
import org.jboss.logging.annotations.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.soap.SOAPBinding;
import java.security.Principal;
import java.time.LocalDate;

/**
 * Created by Study on 10.06.2017.
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private ShirtService shirtService;
    @Autowired
    private BrandService brandService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private GenderService genderService;

    @Autowired
    private  OrdersService ordersService;

    @Autowired
    @Qualifier("userLoginValidator")
    private Validator validator;


    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("shirt_types", typeService.findAll());
        return "views-user-login";
    }

    @GetMapping("/addShirt")
    public String addShirt(Model model)
    {
        model.addAttribute("shirt_types", typeService.findAll());
        model.addAttribute("brands", brandService.findAll());
        model.addAttribute("genders",genderService.findAll());

        return "views-admin-addShirt";
    }

    @PostMapping("/newShirt")
    public String saveNewShirt(Model model, @RequestParam("name")String name, @RequestParam("price") int price, @RequestParam("size") int size,
                               @RequestParam("brand")int brandId,@RequestParam("type")int typeId,@RequestParam("gender")int genderId,@RequestParam("image") MultipartFile image )
    {
        model.addAttribute("shirt_types",typeService.findAll());

        Shirt shirt = new Shirt();
        shirt.setShirtName(name);
        shirt.setPrice(price);
        shirt.setSize(size);
        shirt.setBrand(brandService.findOne(brandId));
        shirt.setType(typeService.findOne(typeId));
        shirt.setGender(genderService.findOne(genderId));

        shirtService.save(shirt,image);

        model.addAttribute("shirts", shirtService.findShirtByType(typeId));

        return  "views-user-AllShirtsList";
    }


    @GetMapping("/addShirtType")
    public  String addShirtType(Model model)
    {


        model.addAttribute("shirt_types", typeService.findAll());

        return "views-admin-addShirtType";
    }

    @PostMapping("/newType")
    public  String saveShirtType(Model model, @RequestParam("name")String name)
    {


        model.addAttribute("shirt_types", typeService.findAll());

        typeService.save(new Shirt_Type(name));

        return "redirect:/addShirtType";
    }

    @GetMapping("/addBrand")
    public  String addBrand(Model model)
    {


        model.addAttribute("shirt_types", typeService.findAll());

        model.addAttribute("brands", brandService.findAll());

        return "views-admin-addBrand";
    }
    @PostMapping("/newBrand")
    public  String saveBrand(Model model, @RequestParam("name")String name)
    {


        model.addAttribute("shirt_types", typeService.findAll());

        brandService.save(new Brand(name));

        return "redirect:/addBrand";
    }
    @GetMapping("/deleteShirt/{id}/")
    public String deleteShirt(@PathVariable int id)
    {

        shirtService.delete(id);
        return "redirect:/allShirtList";
    }

    @GetMapping("/addGender")
    public  String addGender(Model model)
    {


        model.addAttribute("shirt_types", typeService.findAll());

        model.addAttribute("genders",genderService.findAll());

        return "views-admin-addGender";
    }
    @PostMapping("/newGender")
    public  String saveGender(Model model, @RequestParam("name")String name)
    {


        model.addAttribute("shirt_types", typeService.findAll());

        genderService.save(new Gender(name));

        return "redirect:/addGender";
    }

    @GetMapping("/register")
    public  String register(Model model)
    {
        model.addAttribute("shirt_types", typeService.findAll());

        return "views-user-registration";
    }

    @PostMapping("/register")
    public  String registerUser(Model model, @RequestParam("name")String name,@RequestParam("email")String email,
                                              @RequestParam("password") String password, @RequestParam("confirmPass") String confrmPass) throws Exception {
        model.addAttribute("shirt_types", typeService.findAll());


        if(!password.equals(confrmPass))
        {
            model.addAttribute("passwordException", "Passwords are not same");
            return "views-user-registration";
        }

        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);

        userService.save(user);
        return "views-user-registration";
    }

    @GetMapping("/buyShirt/{id}")
    public  String buyShirt(@PathVariable int id, Principal  principal, Model model)
    {
        if(principal.getName().equals("admin")||principal.getName()==null) {
            return "views-user-error";
        }

        User user = userService.findOne(Integer.parseInt(principal.getName()));



        int count=user.getOrders().size()-1;

        if(count==-1)
        {
            count=0;
        }



        while(true)
        {
            if(user.getOrders().size()==0)
            {
                Orders order = new Orders();
                order.setUser(user);
                order.setDate(LocalDate.now());
                user.getOrders().add(order);
                // System.out.println("OUT!");
                ordersService.update(user.getOrders().get(count));
                break;

            }else if(user.getOrders().get(count).isOpen())
            {
                //   System.out.println("OUT! 2");
                break;
            }else{
                //  System.out.println("OUT! 3 ");
                count++;
                Orders order = new Orders();
                order.setUser(user);
                order.setDate(LocalDate.now());
                user.getOrders().add(order);
                ordersService.update(user.getOrders().get(count));
                break;
            }

        }

        model.addAttribute("orders", ordersService.findOrdersByUser(userService.findOne(Integer.parseInt(principal.getName()))));
        user.getOrders().get(count).getShirts().add(shirtService.findOne(id));

        ordersService.update(user.getOrders().get(count));

        return "views-user-account";
    }

    @GetMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id)
    {
        ordersService.delete(id);

        return"redirect:/account";
    }
    @GetMapping("/account")
    public String account(Model model, Principal principal)
    {
        model.addAttribute("orders", ordersService.findOrdersByUser(userService.findOne(Integer.parseInt(principal.getName()))));
        return "views-user-account";
    }

    @GetMapping("/buy/{id}")
    public String buy(@PathVariable int id)
    {
        ordersService.findOne(id).setOpen(false);

        return"redirect:/account";
    }


}
