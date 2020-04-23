package com.project.controllers;   
import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.dao.CategoryDao;
import com.project.models.Category;   

@Controller
@RequestMapping("/category")
public class CategoryController {  
    @Autowired  
    CategoryDao dao;//will inject dao from xml file
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/categoryform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Category());
    	return "categoryform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("cat") Category cat){  
        dao.save(cat);  
        return "redirect:/category/viewcategory";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewcategory")  
    public String viewCategory(Model m){  
        List<Category> list=dao.getCategory();  
        m.addAttribute("list",list);
        return "viewcategory";  
    }  
    @RequestMapping(value="/deletecategory/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/category/viewcategory";  
    }   
}  
