package com.daah.FoodOrdering;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	
	@RequestMapping("/")
    public String homePage(){
        return "index";
    }
	
    @RequestMapping("/Eeat")
    public String eatery() {
    	return "Eeateries";
    }
        
    @RequestMapping("/Emenu")
    public String menuEatery() {
    	return "EmenuEateries";
    }
    
    @RequestMapping("/Eorder")
    public String orderEatery() {
    	return "EorderEateries";
    }
    
    @RequestMapping("/Ustud")
    public String student() {
    	return "Ustudent";		
	}
    
    @RequestMapping("/Uorder")
    public String orderStudent() {
    	return "UorderUser";
    }
    
    @RequestMapping("/Umenu")
    public String menuStudent() {
    	return "UmenuUser";
    }
}
