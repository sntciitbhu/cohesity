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
import com.project.models.Category;
import com.project.models.Medical_Store_Branch;
import com.project.models.Product;
import com.project.dao.ProductDao;
import com.project.dao.CategoryDao;  
@Controller
@RequestMapping("/product")
public class ProductController {  
	@Autowired
    JdbcTemplate template;
	@Autowired  
    ProductDao dao;//will inject dao from xml file
    @Autowired
    CategoryDao dao2;
      
    /*It displays a form to input data, here "command" is a reserved request attribute 
     *which is used to display object data into form 
     */  
    @RequestMapping("/productform")  
    public String showform(Model m){
    	List<Category> list = dao2.getCategory();
    	m.addAttribute("list",list);
    	m.addAttribute("command", new Product());
    	return "productform"; 
    }  
    /*It saves object into database. The @ModelAttribute puts request data 
     *  into model object. You need to mention RequestMethod.POST method  
     *  because default request is GET*/  
    @RequestMapping(value="/save",method = RequestMethod.POST)  
    public String save(@ModelAttribute("prod") Product prod){  
        dao.save(prod);  
        return "redirect:/product/viewproduct";//will redirect to viewemp request mapping  
    }  
    /* It provides list of employees in model object */  
    @RequestMapping("/viewproduct")  
    public String viewmsb(Model m){  
    	final Map<Integer,String> map=new HashMap<Integer,String>();
    	List<Product> list=template.query("select Product_ID,Name,MRP_per_unit,Company_Name,p.Category_Id,Category_Name from Product p,Category c where p.Category_Id=c.Category_Id order by Name",new ResultSetExtractor<List<Product> >(){  
	        public List<Product> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Product> list = new ArrayList<Product>();  
	            while(rs.next()){  
	               Product bt = new Product();
	               bt.setProduct_ID(rs.getInt("Product_ID"));
	               bt.setName(rs.getString("Name"));
	               bt.setMRP_per_unit(rs.getInt("MRP_per_unit"));
	               bt.setCompany_Name(rs.getString("Company_Name"));
	               bt.setCategory_id(rs.getInt("Category_Id"));
	               map.put(rs.getInt("Category_Id"),rs.getString("Category_Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
	    });  
        m.addAttribute("list",list);
        m.addAttribute("map",map);
        return "viewproduct";  
    }  
    /* It displays object data into form for the given id.  
     * The @PathVariable puts URL data into variable.*/  
    @RequestMapping(value="/editproduct/{id}")  
    public String edit(@PathVariable int id, Model m){  
    	Product prod=new Product();
    	prod.setProduct_ID(id);
    	m.addAttribute("command",prod);
        return "producteditform";  
    }  
    /* It updates model object. */  
    @RequestMapping(value="/editsave",method = RequestMethod.POST)  
    public String editsave(@ModelAttribute("prod") Product prod){  
        dao.updatemrp(prod);  
        return "redirect:/product/viewproduct";  
    }  
    /* It deletes record for the given id in URL and redirects to /viewemp */  
    @RequestMapping(value="/deleteproduct/{id}",method = RequestMethod.GET)  
    public String delete(@PathVariable int id){  
        dao.delete(id);  
        return "redirect:/product/viewproduct";  
    }   
}  
