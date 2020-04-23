package com.project.controllers;   
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.models.*;
import com.project.dao.*;
@Controller
@RequestMapping("/worker")
public class WorkerController {  
	@Autowired
	JdbcTemplate template;
	@Autowired  
    WorkerDao dao;//will inject dao from xml file
    @Autowired
    MSBDao dao2;
    @Autowired
    BankDao dao3;
    @Autowired
    usersDao dao4;
    @Autowired
    roleDao dao5;
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/workerform")  
    public String showform(@RequestParam(value = "error", required = false) String error,Model m){
    	if (error != null) {
			m.addAttribute("error", "Username Exists");
		}
    	List<Medical_Store_Branch> list = dao2.getMSB();
    	m.addAttribute("list",list);
    	m.addAttribute("command", new Worker());
    	return "workerform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("worker") Worker worker,Model m){
    	if(dao.checkUsername(worker.getUsername())!=null) {
    		return "redirect:/worker/workerform?error";
    	}
    	users user=new users();
    	user.setUsername(worker.getUsername());
    	user_roles role=new user_roles();
    	role.setUsername(worker.getUsername());
    	role.setRole("ROLE_WORK");
    	dao4.save(user);
    	dao5.save(role);
    	dao.save(worker);  
        m.addAttribute("command",user);
        return "workerpass"; 
    }
    
    @RequestMapping(value="/savepass",method = RequestMethod.POST)
    public String savepass(@ModelAttribute("user") users user) {
    	dao4.update(user);
    	return "redirect:/worker/viewworker";
    }
    /* It provides list of employees in model object */  
    @RequestMapping("/viewworker")  
    public String viewworker(Model m){  
    	final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Worker> list=template.query("select Worker_ID,Name,Contact_No,Aadhar_No,House_No,w.Street,w.Area,Salary_per__annum,Joining_Date,w.MS_Id,username,Major_Location from Workers w,Medical_Store_Branch m where w.MS_Id=m.MS_Id",new ResultSetExtractor<List<Worker> >(){  
	        public List<Worker> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Worker> list = new ArrayList<Worker>();  
	            while(rs.next()){  
	               Worker bt = new Worker();
	               bt.setWorker_ID(rs.getInt("Worker_ID"));
	               bt.setName(rs.getString("Name"));
	               bt.setContact_No(rs.getString("Contact_No"));
	               bt.setAadhar_No(rs.getString("Aadhar_No"));
	               bt.setHouse_No(rs.getInt("House_No"));
	               bt.setStreet(rs.getString("Street"));
	               bt.setArea(rs.getString("Area"));
	               bt.setSalary_per__annum(rs.getInt("Salary_per__annum"));
	               bt.setJoining_Date(rs.getString("Joining_Date"));
	               bt.setMs_id(rs.getInt("MS_Id"));
	               bt.setUsername(rs.getString("username"));
	           	   map.put(rs.getInt("MS_Id"),rs.getString("Major_Location"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
	    });  
        m.addAttribute("list",list);
        m.addAttribute("map", map);
        return "viewworker";  
    }
    @RequestMapping("/viewworker/{id}")  
    public String viewworkerbyid(@PathVariable int id,Model m){  
        List<Worker> list=dao.getWorkerbyMS(id);  
        m.addAttribute("list",list);
        return "viewworker";  
    }
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editworker/{id}")  
    public String edit(@RequestParam(value = "error", required = false) String error,@PathVariable int id, Model m){
    	if (error != null) {
			m.addAttribute("error", "Worker is Head of Some Branch");
		}
    	List<Medical_Store_Branch> list = dao2.getMSB();
    	m.addAttribute("list",list);
    	Worker w=new Worker();
    	w.setWorker_ID(id);
    	//msb.setHead_Worker_id(-1);
        m.addAttribute("command",w);
        return "workereditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("w") Worker w){
    	if(dao2.checkHeadWorker(w.getWorker_ID())!=null){
    		return "redirect:/worker/editworker/"+w.getWorker_ID()+"/?error";
    	}
        dao.updatems(w);  
        return "redirect:/worker/viewworker";  
    }
    @RequestMapping(value="/editbank/{id}")  
    public String editbank(@RequestParam(value = "error", required = false) String error,@PathVariable int id, Model m){
    	if (error != null) {
			m.addAttribute("error", "Bank Details Exists");
		}
    	m.addAttribute("command",new Bank_Detail());
    	m.addAttribute("id", id);
    	m.addAttribute("recat", "worker");
        return "editbank";  
    }
    @RequestMapping(value="/editbank/{id}", method = RequestMethod.POST)  
    public String editbank(@PathVariable int id, @ModelAttribute("b") Bank_Detail b){
    	if(dao3.checkmobile(b.getIFSC_Code(), b.getAccount_No())!=null) {
    		return "redirect:/worker/editbank/"+id+"/?error";
    	}
    	Worker w=new Worker();
    	w.setWorker_ID(id);
    	dao3.save(b);
    	w.setBank_detail_id(dao3.getBank_Detail_id(b));
    	dao.updatebank(w);
    	return "redirect:/worker/viewworker";  
    }
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteworker/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);
        dao5.delete(dao.getUsernameById(id));
        dao4.delete(dao.getUsernameById(id));
        return "redirect:/worker/viewworker";  
    }   
}  
