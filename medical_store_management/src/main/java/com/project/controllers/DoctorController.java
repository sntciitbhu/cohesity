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

import com.project.models.Bank_Detail;
import com.project.models.Doctor;
import com.project.models.Worker;
import com.project.dao.BankDao;
import com.project.dao.DoctorDao;

@Controller
@RequestMapping("/doctor")
public class DoctorController {  
    @Autowired  
    DoctorDao dao;//will inject dao from xml file
    @Autowired
    BankDao dao3;
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/doctorform")  
    public String showform(@RequestParam(value = "error", required = false) String error,Model m){
    	if (error != null) {
			m.addAttribute("error", "Contact number exists");
		}
    	m.addAttribute("command", new Doctor());
    	return "doctorform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("Doctor") Doctor Doctor){  
    	if(dao.checkmobile(Doctor.getContact_No())!=null) {
    		return "redirect:/doctor/doctorform?error";
    	}
        dao.save(Doctor);  
        return "redirect:/doctor/viewdoctor";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewdoctor")  
    public String viewDoctor(Model m){  
        List<Doctor> list=dao.getDoctor();  
        m.addAttribute("list",list);
        return "viewdoctor";  
    }
    
    @RequestMapping(value="/editbank/{id}")  
    public String editbank(@RequestParam(value = "error", required = false) String error,@PathVariable int id, Model m){
    	if (error != null) {
			m.addAttribute("error", "Bank Details Exists");
		}
    	m.addAttribute("command",new Bank_Detail());
    	m.addAttribute("id", id);
    	m.addAttribute("recat", "doctor");
        return "editbank";  
    }
    @RequestMapping(value="/editbank/{id}", method = RequestMethod.POST)  
    public String editbank(@PathVariable int id, @ModelAttribute("b") Bank_Detail b){
    	if(dao3.checkmobile(b.getIFSC_Code(), b.getAccount_No())!=null) {
    		return "redirect:/doctor/editbank/"+id+"/?error";
    	}
    	Doctor w=new Doctor();
    	w.setDoctor_ID(id);
    	dao3.save(b);
    	w.setBank_detail_id(dao3.getBank_Detail_id(b));
    	dao.updatebank(w);
    	return "redirect:/doctor/viewdoctor";  
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletedoctor/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/doctor/viewdoctor";  
    }   
}  
