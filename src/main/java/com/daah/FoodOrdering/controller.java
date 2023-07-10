package com.daah.FoodOrdering;

import jakarta.servlet.http.HttpSession;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Controller
public class controller {
    CrudServiceItem crudServiceItem = new CrudServiceItem();
    CrudServiceVendor crudServiceVendor = new CrudServiceVendor();
    CrudServiceStudent crudServiceStudent = new CrudServiceStudent();
    CrudServiceOrder crudServiceOrder = new CrudServiceOrder();
    FirebaseFileService firebaseFileService = new FirebaseFileService();

    public controller(CrudServiceItem crudServiceItem, CrudServiceVendor crudServiceVendor, CrudServiceStudent crudServiceStudent, CrudServiceOrder crudServiceOrder, FirebaseFileService firebaseFileService) {
        this.crudServiceItem = crudServiceItem;
        this.crudServiceVendor = crudServiceVendor;
        this.crudServiceStudent = crudServiceStudent;
        this.crudServiceOrder = crudServiceOrder;
        this.firebaseFileService = firebaseFileService;
    }
//Check carefully
   /* @PostMapping("/hdfjg")
    public Item createItem(@RequestBody Item item) throws InterruptedException, ExecutionException {
        return new Item(item);
    }
*/


    @RequestMapping("/endpoint")
    public ResponseEntity<String> end(){return ResponseEntity.ok("Test get Endpoint is Working");}





    @PostMapping("/createItem")
    @ResponseBody
    public String createCRUDITEM(@RequestBody Item item) throws InterruptedException, ExecutionException
    {return crudServiceItem.createItem(item);}

    @GetMapping(value = "/getItem")
    @ResponseBody
    public Item getCRUDITEM(@RequestParam String id) throws InterruptedException, ExecutionException
    {
        Item item = crudServiceItem.getItem(id);
        return item;
    }

    @PutMapping("/updateItem")
    @ResponseBody
    public String updateCRUDITEM(@RequestBody Item item) throws InterruptedException, ExecutionException
    {return crudServiceItem.updateItem(item);}

    @PutMapping("/deleteItem")
    @ResponseBody
    public String deleteCRUDITEM(@RequestParam String id) throws InterruptedException, ExecutionException
    {return crudServiceItem.deleteItem(id);}







    @PostMapping("/createStudent")
    @ResponseBody
    public String createCRUDSTUD(@RequestParam String email, @RequestParam String pass) throws InterruptedException, ExecutionException
    {Student stud = new Student(email,pass);
        return crudServiceStudent.createStudent(stud);}

    @GetMapping("/getStudent")
    @ResponseBody
    public String getCRUDSTUD(@RequestParam String id) throws InterruptedException, ExecutionException
    {return crudServiceStudent.getStudent(id);
    }

    @PutMapping("/updateStudent")
    @ResponseBody
    public String updateCRUDSTUD(@RequestBody Student stud) throws InterruptedException, ExecutionException
    {return crudServiceStudent.updateStudent(stud);}

    @PutMapping("/deleteStudent")
    @ResponseBody
    public String deleteCRUDSTUD(@RequestParam String id) throws InterruptedException, ExecutionException
    {return crudServiceStudent.deleteStudent(id);}











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


      @RequestMapping("/testing")
    public ModelAndView gettest(HttpSession session){
       String name = "hello";
        ModelAndView mv = new ModelAndView();
        mv.addObject("obj",name);
        return mv;
    }

    @RequestMapping("/addalien")
    public ModelAndView gt(@RequestParam("aid") String myname){
        System.out.println(myname);
        ModelAndView mv = new ModelAndView("hometest");
        mv.addObject("obj",myname);
        return mv;
    }




    @PostMapping("/uploadImage")
    @ResponseBody
    public ResponseEntity create(@RequestParam(name = "file") MultipartFile file) {
        try {System.out.println("in Try statement");
            String fileName = firebaseFileService.saveTest(file);
            System.out.println("File name = " + fileName);// do whatever you want with that
        } catch (Exception e) {
            System.out.println(e);
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/down")
    @ResponseBody
    public ModelAndView down(@RequestParam("name") String fam) {
        String url = "https://firebasestorage.googleapis.com/v0/b/oop-webapp-bits.appspot.com/o/" + fam + "?alt=media&token=" + fam;
        ModelAndView mv = new ModelAndView("hometest");
        mv.addObject("url",url);
        return mv;
        /*
        try {System.out.println("in download Try statement");
            System.out.println("File name = " + fam);
            String fileName = firebaseFileService.download(String.valueOf(fam));
            System.out.println("File name = " + fam);// do whatever you want with that
        } catch (Exception e) {
            System.out.println(e);
        }
        return "help me";*/
    }



}


