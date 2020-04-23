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

import com.project.models.Medical_Store_Branch;
import com.project.models.Medical_Store_Branch;
import com.project.models.Worker;
import com.project.models.user_roles;
import com.project.dao.MSBDao;
import com.project.dao.WorkerDao;
import com.project.dao.roleDao;  
@Controller
@RequestMapping("/msb")
public class MSBController {  
    @Autowired
    JdbcTemplate template;
	@Autowired  
    MSBDao dao;//will inject dao from xml file
    @Autowired
    WorkerDao dao2;
    @Autowired
    roleDao dao3;
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/msbform")  
    public String showform(Model m){  
    	m.addAttribute("command", new Medical_Store_Branch());
    	return "msbform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("msb") Medical_Store_Branch msb){  
        dao.save(msb);  
        return "redirect:/msb/viewmsb";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewmsb")  
    public String viewmsb(Model m){  
    	final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Medical_Store_Branch> list=template.query("select m.MS_Id,Major_Location,Shop_No,m.Street,m.Area,Name,head_worker_id from Medical_Store_Branch m left outer join Workers w on m.head_worker_id=w.Worker_ID;",new ResultSetExtractor<List<Medical_Store_Branch> >(){  
	        public List<Medical_Store_Branch> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Medical_Store_Branch> list = new ArrayList<Medical_Store_Branch>();  
	            while(rs.next()){  
	               Medical_Store_Branch bt = new Medical_Store_Branch();
	               bt.setMS_Id(rs.getInt("MS_Id"));
	               bt.setMajor_Location(rs.getString("Major_Location"));
	               bt.setShop_No(rs.getInt("Shop_No"));
	               bt.setStreet(rs.getString("Street"));
	               bt.setArea(rs.getString("Area"));
	               bt.setHead_Worker_id(rs.getInt("head_worker_id"));
	               if (rs.wasNull()) {
	            	   map.put(rs.getInt("head_worker_id"),"N/A");
	               }
	               else
	            	   map.put(rs.getInt("head_worker_id"),rs.getString("Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
	    });
    	m.addAttribute("list",list);
    	m.addAttribute("map",map);
        return "viewmsb";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editmsb/{id}")  
    public String edit(@PathVariable int id, Model m){  
    	Medical_Store_Branch msb=new Medical_Store_Branch();
    	msb.setMS_Id(id);
    	List<Worker> list=dao2.getWorkerbyMS(id);  
        m.addAttribute("list",list);
    	//msb.setHead_Worker_id(-1);
        m.addAttribute("command",msb);
        return "msbeditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("msb") Medical_Store_Branch msb){  
    	int headid=template.query("select head_worker_id from Medical_Store_Branch where MS_Id=?",new Object[] {msb.getMS_Id()},new ResultSetExtractor<Integer>(){  
	        public Integer extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	int temp=0;
	        	while(rs.next()){  
	               Medical_Store_Branch bt = new Medical_Store_Branch();
	               bt.setHead_Worker_id(rs.getInt("head_worker_id"));
	               if (rs.wasNull()) {
	            	   temp=-1;
	               }  
	               else
	            	   temp=bt.getHead_Worker_id();
	            }  
	            return temp;
	        }  
	    });
    	if(headid==msb.getHead_Worker_id()) {
    		return "redirect:/msb/viewmsb";
    	}
    	if(headid!=-1) {
    		dao3.deletehead(dao2.getUsernameById(headid));
    		user_roles ur2=new user_roles();
    		ur2.setUsername(dao2.getUsernameById(headid));
            ur2.setRole("ROLE_WORK");
            dao3.save(ur2);
    	}
    	dao.update(msb);
        user_roles ur=new user_roles();
        dao3.deletework(dao2.getUsernameById(msb.getHead_Worker_id()));
        ur.setUsername(dao2.getUsernameById(msb.getHead_Worker_id()));
        ur.setRole("ROLE_HEAD");
        dao3.save(ur);
        return "redirect:/msb/viewmsb";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deletemsb/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/msb/viewmsb";  
    }   
}  
