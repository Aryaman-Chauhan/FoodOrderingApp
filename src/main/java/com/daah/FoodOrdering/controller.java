package com.daah.FoodOrdering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@Controller
public class controller {

    //Check carefully
   /* @PostMapping("/hdfjg")
    public Item createItem(@RequestBody Item item) throws InterruptedException, ExecutionException {
        return new Item(item);
    }
*/
    @RequestMapping("/show")
    @ResponseBody
    public Item getItem(){
        Item item = new Item("Maggi","Junk",60,"10","sddfg","kbdbf");
        return item;
    }

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
