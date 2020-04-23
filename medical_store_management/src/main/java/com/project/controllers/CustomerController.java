package com.project.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.dao.CustomerDao;
import com.project.models.Customer;   

@Controller
@RequestMapping("/customer")
public class CustomerController {  
    @Autowired  
    CustomerDao dao;//will inject dao from xml file
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/customerform")  
    public String showform(@RequestParam(value = "error", required = false) String error,Model m){ 
    	if (error != null) {
			m.addAttribute("error", "Contact number exists");
		}
    	m.addAttribute("command", new Customer());
    	return "customerform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cust") Customer cust){ 
    	if(dao.checkmobile(cust.getContact_No())!=null) {
    		return "redirect:/customerform?error";
    	}
        dao.save(cust);  
        return "redirect:/customer/viewcustomer";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewcustomer")  
    public String viewcustomer(Model m){  
        List<Customer> list=dao.getCustomer();  
        m.addAttribute("list",list);
        return "viewcustomer";  
    }  
    @RequestMapping(value="/deletecustomer/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/customer/viewcustomer";  
    }   
}  
