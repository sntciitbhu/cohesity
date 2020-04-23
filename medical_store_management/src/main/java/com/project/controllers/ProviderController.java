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
import com.project.models.Provider;
import com.project.dao.BankDao;
import com.project.dao.ProviderDao;

@Controller
@RequestMapping("/provider")
public class ProviderController {  
    @Autowired  
    ProviderDao dao;//will inject dao from xml file
    @Autowired
    BankDao dao3;
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/providerform")  
    public String showform(@RequestParam(value = "error", required = false) String error,Model m){
    	if (error != null) {
			m.addAttribute("error", "Contact number exists");
		}
    	m.addAttribute("command", new Provider());
    	return "providerform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("Provider") Provider Provider){
    	if(dao.checkmobile(Provider.getContact_No())!=null) {
    		return "redirect:/provider/providerform?error";
    	}
        dao.save(Provider);  
        return "redirect:/provider/viewprovider";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewprovider")  
    public String viewProvider(Model m){  
        List<Provider> list=dao.getProvider();  
        m.addAttribute("list",list);
        return "viewprovider";  
    }
    
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editbank/{id}")  
    public String editbank(@RequestParam(value = "error", required = false) String error,@PathVariable int id, Model m){
    	if (error != null) {
			m.addAttribute("error", "Bank Details Exists");
		}
    	m.addAttribute("command",new Bank_Detail());
    	m.addAttribute("id", id);
    	m.addAttribute("recat", "provider");
        return "editbank";  
    }
    @RequestMapping(value="/editbank/{id}", method = RequestMethod.POST)  
    public String editbank(@PathVariable int id, @ModelAttribute("b") Bank_Detail b){
    	if(dao3.checkmobile(b.getIFSC_Code(), b.getAccount_No())!=null) {
    		return "redirect:/provider/editbank/"+id+"/?error";
    	}
    	Provider w=new Provider();
    	w.setProvider_ID(id);
    	dao3.save(b);
    	w.setBank_detail_id(dao3.getBank_Detail_id(b));
    	dao.updatebank(w);
    	return "redirect:/provider/viewprovider";  
    }
    /* It updates model object. */  
     
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteprovider/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/provider/viewprovider";  
    }   
}  
