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
    CrudServiceItem crudServiceItem;
    CrudServiceVendor crudServiceVendor;
    CrudServiceStudent crudServiceStudent;
    CrudServiceOrder crudServiceOrder;
    FirebaseFileService firebaseFileService;

    public controller(CrudServiceItem crudServiceItem, CrudServiceVendor crudServiceVendor, CrudServiceStudent crudServiceStudent, CrudServiceOrder crudServiceOrder, FirebaseFileService firebaseFileService) {
        this.crudServiceItem = crudServiceItem;
        this.crudServiceVendor = crudServiceVendor;
        this.crudServiceStudent = crudServiceStudent;
        this.crudServiceOrder = crudServiceOrder;
        this.firebaseFileService = firebaseFileService;
    }


    @RequestMapping("/endpoint")
    public ResponseEntity<String> end(){return ResponseEntity.ok("Test get Endpoint is Working");}



//ITEM CALLS

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

     public void updateItemURL(String name,String url) throws ExecutionException, InterruptedException {
        Item item = getCRUDITEM(name);
        item.setItemPic(url);
        updateCRUDITEM(item);
        //return crudServiceItem.updateItem(item);

    }

    @PutMapping("/uploadItemPic")
    @ResponseBody
    public void updateITEMPIC(String name,String url) throws ExecutionException, InterruptedException {
        Item item = getCRUDITEM(name);
        item.setItemPic(url);
        updateCRUDITEM(item);
        //return crudServiceItem.updateItem(item);

    }



   //STUDENT CALLS

    @PostMapping("/createStudent")
    @ResponseBody
    public String createCRUDSTUD(@RequestBody Student stud) throws InterruptedException, ExecutionException
    {System.out.println("Email is = " + stud.getEmail() +"\n Name is = "+ stud.getName()+"\n Pass is = "+stud.getPass());
        return crudServiceStudent.createStudent(stud);}

    @GetMapping("/getStudent")
    @ResponseBody
    public Student getCRUDSTUD(@RequestParam String id) throws InterruptedException, ExecutionException
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






 //VENDOR CALL

    @PostMapping("/createVendor")
    @ResponseBody
    public String createCRUDVENDOR(@RequestBody Vendor vendor) throws InterruptedException, ExecutionException
    {return crudServiceVendor.createVendor(vendor);}
    @GetMapping(value = "/getVendor")
    @ResponseBody
    public Vendor getCRUDVENDOR(@RequestParam String id) throws InterruptedException, ExecutionException
    {
        Vendor vendor = crudServiceVendor.getVendor(id);
        return vendor;
    }

    @PutMapping("/updateVendor")
    @ResponseBody
    public String updateCRUDVENDOR(@RequestBody Vendor vendor) throws InterruptedException, ExecutionException
    {return crudServiceVendor.updateVendor(vendor);}

    @PutMapping("/deleteVendor")
    @ResponseBody
    public String deleteCRUDVENDOR(@RequestParam String id) throws InterruptedException, ExecutionException
    {return crudServiceVendor.deleteVendor(id);}

    @PutMapping("/uploadVendorPic")
    @ResponseBody
    public void updateVendorURL(String name,String url) throws ExecutionException, InterruptedException {

        Vendor vendor = getCRUDVENDOR(name);
        vendor.setShopPic(url);
        updateCRUDVENDOR(vendor);
        //return crudServiceItem.updateItem(item);

    }

    @PutMapping("/uploadVendorQr")
    @ResponseBody
    public void updateVendorQRURL(String name,String url) throws ExecutionException, InterruptedException {
        Vendor vendor = getCRUDVENDOR(name);
        vendor.setQrCode(url);
        updateCRUDVENDOR(vendor);
        //return crudServiceItem.updateItem(item);

    }



    //ORDER CALL

    @PostMapping("/createOrder")
    @ResponseBody
    public String createCRUDORDER(@RequestBody Order order) throws InterruptedException, ExecutionException
    {return crudServiceOrder.createOrder(order);}
    @GetMapping(value = "/getOrder")
    @ResponseBody
    public Order getCRUDORDER(@RequestParam String id) throws InterruptedException, ExecutionException
    {
        Order order = crudServiceOrder.getOrder(id);
        return order;
    }

    @PutMapping("/updateOrder")
    @ResponseBody
    public String updateCRUDORDER(@RequestBody Order order) throws InterruptedException, ExecutionException
    {return crudServiceOrder.updateOrder(order);}

    @PutMapping("/deleteOrder")
    @ResponseBody
    public String deleteCRUDORDER(@RequestParam String id) throws InterruptedException, ExecutionException
    {return crudServiceOrder.deleteOrder(id);}






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


    /*
    @RequestMapping("/addalien")
    public ModelAndView gt(@RequestParam("aid") String myname){
        System.out.println(myname);
        ModelAndView mv = new ModelAndView("hometest");
        mv.addObject("obj",myname);
        return mv;
    }

*/

//SAME FOR ALL
    @PostMapping("/uploadImage")
    @ResponseBody
    public String create(@RequestParam(name = "file") MultipartFile file) {
        try {System.out.println("in Try statement");
            String fileName = firebaseFileService.saveTest(file);
            System.out.println("File name = " + fileName);// do whatever you want with that
            String url = "https://firebasestorage.googleapis.com/v0/b/oop-webapp-bits.appspot.com/o/" + fileName + "?alt=media&token=" + fileName;
        return url;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
//Same for all
    @GetMapping("/showImage")
    @ResponseBody
    public ModelAndView down(@RequestParam("name") String fam) {
        String url = "https://firebasestorage.googleapis.com/v0/b/oop-webapp-bits.appspot.com/o/" + fam + "?alt=media&token=" + fam;
        ModelAndView mv = new ModelAndView("hometest");
        mv.addObject("url",url);
        mv.addObject("vendorname","rahul");
        return mv;
    }

    @RequestMapping("/khol")
    public String khol(){return "UmenuUser";}

    @RequestMapping("/query")
    @ResponseBody
    public void query() throws ExecutionException, InterruptedException { crudServiceItem.getItemQuery();}

}


