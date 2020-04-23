package com.project.controllers;   
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import java.security.Principal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

import com.project.models.*;
import com.project.dao.*;

@Controller
@RequestMapping("/admin")
public class AdminController{
	@Autowired
	JdbcTemplate template;
	@RequestMapping("transdate")
	public String transdate() {
		return "transdate";
	}
	@PostMapping("providerpay")
	public String providerpay(@RequestBody MultiValueMap<String, String> formData,Model m) {
		final Map<Integer,Bank_Detail> bankmap=new HashMap<Integer,Bank_Detail>();
		final Map<Integer,Integer> cntmap=new HashMap<Integer,Integer>();
		final Map<Integer,Integer> totalmap=new HashMap<Integer,Integer>();
		List<Provider> list=template.query("select p.Provider_ID,p.Provider_Name,count(p.Provider_ID) as cnt,sum(Total_Bill) as total,p.Bank_Detail_ID,IFSC_Code,Account_no from Buying_Transaction bt,(Provider p left join Bank_Details bd on p.Bank_Detail_ID=bd.Bank_Detail_ID) where bt.Provider_ID=p.Provider_ID and bt.Date > ? and bt.Date < ? group by p.Provider_ID",new Object[] {formData.getFirst("startdate"),formData.getFirst("enddate")},new ResultSetExtractor<List<Provider> >(){  
	        public List<Provider> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Provider> list = new ArrayList<Provider>();  
	            while(rs.next()){  
	               Provider bt = new Provider();
	               Bank_Detail bd=new Bank_Detail();
	               bt.setProvider_ID(rs.getInt("Provider_ID"));
	               bt.setProvider_Name(rs.getString("Provider_Name"));
	               bt.setBank_detail_id(rs.getInt("Bank_Detail_ID"));
	               if (rs.wasNull()) {
	            	   bd.setIFSC_Code("N/A");
	            	   bd.setAccount_No("N/A");
	            	   bankmap.put(rs.getInt("Bank_Detail_ID"),bd);
	               }
	               else {
	            	   bd.setIFSC_Code(rs.getString("IFSC_Code"));
	            	   bd.setAccount_No(rs.getString("Account_No"));
	            	   bankmap.put(rs.getInt("Bank_Detail_ID"),bd);
	               }
	               cntmap.put(rs.getInt("Provider_ID"),rs.getInt("cnt"));
	               totalmap.put(rs.getInt("Provider_ID"),rs.getInt("total"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
	    });
    	m.addAttribute("list",list);
    	m.addAttribute("map",bankmap);
    	m.addAttribute("cntmap",cntmap);
    	m.addAttribute("totalmap",totalmap);
        return "providerpay"; 
	}
	@PostMapping("doctorpay")
	public String doctorpay(@RequestBody MultiValueMap<String, String> formData,Model m) {
		final Map<Integer,Bank_Detail> bankmap=new HashMap<Integer,Bank_Detail>();
		final Map<Integer,Integer> cntmap=new HashMap<Integer,Integer>();
		final Map<Integer,Integer> totalmap=new HashMap<Integer,Integer>();
		List<Doctor> list=template.query("select st.Doctor_ID,d.name,count(st.Doctor_ID) as cnt,count(st.Doctor_ID)*Commision_per__recommendation as total,d.Bank_Detail_ID,IFSC_Code,Account_No from Selling_Transaction st,(Doctor d left join Bank_Details bd on d.Bank_Detail_ID=bd.Bank_Detail_ID) where st.Doctor_ID=d.Doctor_ID and st.Date > ? and st.Date < ? group by st.Doctor_ID",new Object[] {formData.getFirst("startdate"),formData.getFirst("enddate")},new ResultSetExtractor<List<Doctor> >(){  
	        public List<Doctor> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Doctor> list = new ArrayList<Doctor>();  
	            while(rs.next()){  
	               Doctor bt = new Doctor();
	               Bank_Detail bd=new Bank_Detail();
	               bt.setDoctor_ID(rs.getInt("Doctor_ID"));
	               bt.setName(rs.getString("name"));
	               bt.setBank_detail_id(rs.getInt("Bank_Detail_ID"));
	               if (rs.wasNull()) {
	            	   bd.setIFSC_Code("N/A");
	            	   bd.setAccount_No("N/A");
	            	   bankmap.put(rs.getInt("Bank_Detail_ID"),bd);
	               }
	               else {
	            	   bd.setIFSC_Code(rs.getString("IFSC_Code"));
	            	   bd.setAccount_No(rs.getString("Account_No"));
	            	   bankmap.put(rs.getInt("Bank_Detail_ID"),bd);
	               }
	               cntmap.put(rs.getInt("Doctor_ID"),rs.getInt("cnt"));
	               totalmap.put(rs.getInt("Doctor_ID"),rs.getInt("total"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
	    });
		//System.out.println(bankmap.get(2).getIFSC_Code());
    	m.addAttribute("list",list);
    	m.addAttribute("map",bankmap);
    	m.addAttribute("cntmap",cntmap);
    	m.addAttribute("totalmap",totalmap);
        return "doctorpay"; 
	}
}