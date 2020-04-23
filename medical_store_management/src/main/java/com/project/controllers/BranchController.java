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
@RequestMapping("/branch")
public class BranchController{
	@Autowired
	JdbcTemplate template; 
	@Autowired
	ProductDao dao;
	@Autowired
	StockDao dao2;
	@Autowired
	WorkerDao dao3;
	@Autowired
	CustomerDao dao4;
	@Autowired
	DoctorDao docdao;
	@Autowired
	StDao stdao;
	@Autowired
	SoldDao solddao;
	@Autowired
	BtDao btdao;
	@Autowired
	BoughtDao boughtdao;
	@Autowired
	ProviderDao provdao;
	@Autowired
	MSBDao msdao;
	
	@RequestMapping("/addstock")  
    public String showform(Model m){
    	List<Product> list = dao.getProduct();
    	Map<String, String> product = new HashMap<String, String>();
    	for(Product pro:list) {
    		product.put(Integer.toString(pro.getProduct_ID()),pro.getName());
    	}
    	m.addAttribute("productlist",product);
    	m.addAttribute("command",new Stock());
    	return "addstock"; 
    }
	@PostMapping("/addstock")
	public String showform(@ModelAttribute("stock") Stock stock,Model m) {
		String[] temp= stock.getProducts();
		List<Product> list = new ArrayList<Product>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(String s:temp) {
			list.add(dao.getProductById(Integer.parseInt(s)));
			map.put(Integer.parseInt(s),0);
		}
		m.addAttribute("list",list);
		m.addAttribute("c",0);
		return "stockdetail";
	}
	@RequestMapping(value="/stockdetail", method=RequestMethod.POST)
	public String stockdetail(@RequestBody MultiValueMap<String, String> formData,Principal principle) {
		for(Map.Entry<String, List<String>> s:formData.entrySet()) {
			String test=s.getKey();
			System.out.println(test);
			if(test.compareTo("id")==0) {
				System.out.println("hello");
				In_Stock x=new In_Stock();
				int ms=dao3.getMSByUsername(principle.getName());
				x.setMS_Id(ms);
				for(String st:s.getValue()) {
					System.out.println(st);
					x.setProduct_ID(Integer.parseInt(st));
					x.setQuantity(Integer.parseInt(formData.getFirst("quantity"+st)));
					x.setBatch_No(formData.getFirst("bat"+st));
					x.setExpiry_Date(formData.getFirst("exp"+st));
					if(dao2.checkStock(x)==null)
						dao2.save(x);
					else
						dao2.updateStockplus(x);
				}
			}
		}
		return "redirect:/branch/viewstock";
	}
	
	@RequestMapping("/viewstock")  
    public String viewstock(Model m,Principal principle){
		int ms=dao3.getMSByUsername(principle.getName());
        List<In_Stock> list=dao2.getIn_StockFull(ms);
        Map<Integer,String> map=new HashMap<Integer,String>();
		for(In_Stock is:list) {
        	map.put(is.getProduct_ID(),dao.getProductById(is.getProduct_ID()).getName());
        }
		m.addAttribute("map",map);
        m.addAttribute("list",list);
        m.addAttribute("c",0);
        return "viewstock";  
    }
	@RequestMapping("/viewstockcom")  
    public String viewstockcom(Model m,Principal principle){
		int ms=dao3.getMSByUsername(principle.getName());
        List<In_Stock> list=dao2.getIn_Stock(ms);
        Map<Integer,String> map=new HashMap<Integer,String>();
		for(In_Stock is:list) {
        	map.put(is.getProduct_ID(),dao.getProductById(is.getProduct_ID()).getName());
        }
		m.addAttribute("map",map);
        m.addAttribute("list",list);
        m.addAttribute("c",0);
        return "viewstockcom";  
    }
	@RequestMapping("/viewstockless")  
    public String viewstockless(Model m,Principal principle){
		int ms=dao3.getMSByUsername(principle.getName());
        List<In_Stock> list=dao2.getIn_StockLess(ms);
        Map<Integer,String> map=new HashMap<Integer,String>();
		for(In_Stock is:list) {
        	map.put(is.getProduct_ID(),dao.getProductById(is.getProduct_ID()).getName());
        }
		m.addAttribute("map",map);
        m.addAttribute("list",list);
        m.addAttribute("c",0);
        return "viewstockcom";  
    }
	@RequestMapping("/checkcust")
	public String checkcust(@RequestParam(value = "error", required = false) String error,Model m) {
		if (error != null) {
			m.addAttribute("error", "Not Available in Stock");
		}
		m.addAttribute("command",new Customer());
		return "checkcust";
	}
	@PostMapping("/checkcust")
	public String checkcust(@ModelAttribute("cust") Customer cust,Model m,Principal principle) {
		Customer c=dao4.getCustomerByContact(cust.getContact_No());
		if(c==null) {
			m.addAttribute("command",cust);
			return "addcust";
		}
		else {
			Selling__Transaction sl=new Selling__Transaction();
			sl.setCustomer_id(c.getCustomer_ID());
			String dt=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
			System.out.println(dt);
			System.out.println("hello");
			sl.setDate(dt);
			sl.setMS_id(dao3.getMSByUsername(principle.getName()));
			List<Doctor> list= docdao.getDoctor();
			m.addAttribute("command",sl);
			m.addAttribute("list",list);
			return "sellform";
		}
	}
	
	@PostMapping("/addcust")
	public String addcust(@ModelAttribute("cust") Customer cust,Model m,Principal principle) {
		dao4.save(cust);
		Customer c=dao4.getCustomerByContact(cust.getContact_No());
		Selling__Transaction sl=new Selling__Transaction();
		sl.setCustomer_id(c.getCustomer_ID());
		String dt=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
		System.out.println(dt);
		sl.setDate(dt);
		sl.setMS_id(dao3.getMSByUsername(principle.getName()));
		List<Doctor> list= docdao.getDoctor();
		m.addAttribute("command",sl);
		m.addAttribute("list",list);
		return "sellform";
	}
	
	@PostMapping("/savesell")
	public String savesell(@ModelAttribute("st") Selling__Transaction st,Model m) {
		int key=stdao.save(st);
		List<Product> list=dao.getProduct();
		m.addAttribute("quant",st.getProduct_no());
		m.addAttribute("key",key);
		m.addAttribute("list",list);
		System.out.println(key);
		return "selldetail";
	}
	@PostMapping("/selldetail")
	public String selldetail(@RequestBody MultiValueMap<String, String> formData,Principal principle) {
		int tid=Integer.parseInt(formData.getFirst("tid"));
		int c=0;
		for(Map.Entry<String, List<String>> s:formData.entrySet()) {
			String test=s.getKey();
			System.out.println(test);
			
			if(test.compareTo("index")==0) {
				System.out.println("hello");
				//List<In_Stock> x=new ArrayList<In_Stock>();
				In_Stock x=new In_Stock();
				int ms=dao3.getMSByUsername(principle.getName());
				x.setMS_Id(ms);
				int pid=0,q=0,diff=0,bill=0,tq;
				Sold sold=new Sold();
				sold.setTransaction_ID(tid);
				int check=0;
				for(String st:s.getValue()) {
					pid=Integer.parseInt(formData.getFirst("pid"+st));
					q=Integer.parseInt(formData.getFirst("q"+st));
					List<In_Stock> list=dao2.getProductIn_Stock(ms, pid);
					tq=0;
					for(In_Stock stl:list) {
						if(q<=0)
							break;
						diff=Math.min(q,stl.getQuantity());
						if(diff>0) {
							bill+=diff*(dao.getProductById(pid).getMRP_per_unit());
							x.setProduct_ID(pid);
							x.setBatch_No(stl.getBatch_No());
							x.setQuantity(-1*diff);
							dao2.updateStockminus(x);
							c++;
							tq+=diff;
							q-=diff;
						}
					}
					if(q!=0)
						check++;
					if(tq>0) {
						sold.setProduct_ID(pid);
						sold.setQuantity(tq);
						solddao.save(sold);
					}
						
				}
				
				if(c!=0) {
					stdao.update(bill, tid);
					if(check==0)
						return "redirect:/branch/bill/"+tid;
					else
						return "redirect:/branch/bill/"+tid+"/?error";
				}
			}
			
		}
		if(c==0) {
			stdao.delete(tid);
			return "redirect:/branch/checkcust?error";
		}
		return "redirect:/branch/viewstock";
	}
	
	@RequestMapping("savebuy")
	public String savebuy(Model m,Principal principle) {
		Buying__Transaction bt=new Buying__Transaction();
		bt.setMs_id(dao3.getMSByUsername(principle.getName()));
		bt.setDate(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
		List<Provider> list=provdao.getProvider();
		m.addAttribute("command",bt);
		m.addAttribute("list",list);
		return "savebuy";
	}
	@PostMapping("savebuy")
	public String savebuy(@ModelAttribute("bt") Buying__Transaction bt,Model m) {
		int key=btdao.save(bt);
		List<Product> list = dao.getProduct();
    	Map<String, String> product = new HashMap<String, String>();
    	for(Product pro:list) {
    		product.put(Integer.toString(pro.getProduct_ID()),pro.getName());
    	}
    	Stock sk=new Stock();
    	sk.setTid(key);
    	m.addAttribute("productlist",product);
    	m.addAttribute("command",sk);
    	return "buycheck";
	}
	@PostMapping("/buycheck")
	public String buycheck(@ModelAttribute("stock") Stock stock,Model m) {
		String[] temp= stock.getProducts();
		int key=stock.getTid();
		List<Product> list = new ArrayList<Product>();
		for(String s:temp) {
			list.add(dao.getProductById(Integer.parseInt(s)));
		}
		m.addAttribute("list",list);
		m.addAttribute("key",key);
		return "buydetail";
	}
	
	@PostMapping("buydetail")
	public String buydetail(@RequestBody MultiValueMap<String, String> formData,Principal principle) {
		int tid=Integer.parseInt(formData.getFirst("tid"));
		int c=0;
		for(Map.Entry<String, List<String>> s:formData.entrySet()) {
			String test=s.getKey();
			System.out.println(test);
			
			if(test.compareTo("id")==0) {
				System.out.println("hello");
				Bought b=new Bought();
				int bill=0;
				b.setTransaction_ID(tid);
				for(String st:s.getValue()) {
					System.out.println(st);
					b.setProduct_ID(Integer.parseInt(st));
					b.setQuantity(Integer.parseInt(formData.getFirst("q"+st)));
					b.setCost_Price_per_Unit(Integer.parseInt(formData.getFirst("cp"+st)));
					boughtdao.save(b);
					c++;
					bill+=b.getQuantity()*b.getCost_Price_per_Unit();
				}
				if(c!=0) {
					btdao.update(bill, tid);
				}
			}
			
		}
		if(c==0)
			btdao.delete(tid);
		return "redirect:/branch/buytrans";
	}
	@RequestMapping("/bill/{id}")
	public String bill(@RequestParam(value = "error", required = false) String error,@PathVariable int id,Model m) {
		if (error != null) {
			m.addAttribute("error", "Few Items not Available in Stock");
		}
		Selling__Transaction st=stdao.getSelling_TransactionById(id);
		String cust=dao4.getCustomerById(st.getCustomer_id()).getName();
		String doc=docdao.getDocById(st.getDoctor_ID()).getName();
		String ms=msdao.getMSBById(st.getMS_id()).getMajor_Location();
		int totalbill=st.getTotal_Bill();
		List<Sold> sold=solddao.getSoldByTransaction(id);
		String sql="select p.Product_ID,Name,MRP_per_unit,Quantity from Product p,Sold s where p.Product_ID=s.Product_ID and s.Transaction_ID=?";
		final Map<Integer,Integer> pricemap=new HashMap<Integer,Integer>();
		Map<Integer,String> namemap=template.query(sql,new Object[] {id}, new ResultSetExtractor<Map<Integer,String> >(){
	         
	         public Map<Integer,String> extractData(ResultSet rs) throws SQLException, DataAccessException {
	            
	            Map<Integer,String> m=new HashMap<Integer,String>();
	            while(rs.next()){  
	               m.put(rs.getInt("Product_ID"), rs.getString("Name"));
	               pricemap.put(rs.getInt("Product_ID"), rs.getInt("MRP_per_unit")*rs.getInt("Quantity"));
	            }  
	            return m;  
	         }    	  
	      });
		
		m.addAttribute("cust",cust);
		m.addAttribute("doc",doc);
		m.addAttribute("ms",ms);
		m.addAttribute("sold",sold);
		m.addAttribute("namemap",namemap);
		m.addAttribute("pricemap",pricemap);
		m.addAttribute("totalbill",totalbill);
		return "bill";
	}
	@RequestMapping("buytrans")
	public String buytrans(Model m, Principal principle) {
		final Map<Integer,String> map=new HashMap<Integer,String>();
		List<Buying__Transaction> list=template.query("select Transaction_ID,Total_Bill,Date,p.Provider_ID,Provider_Name from Buying_Transaction bt, Provider p where bt.Provider_ID=p.Provider_ID and MS_Id=? order by Date desc",new Object[] {dao3.getMSByUsername(principle.getName())},new ResultSetExtractor<List<Buying__Transaction> >(){  
	        public List<Buying__Transaction> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Buying__Transaction> list = new ArrayList<Buying__Transaction>();  
	            while(rs.next()){  
	               Buying__Transaction bt = new Buying__Transaction();
	               bt.setTransaction_ID(rs.getInt("Transaction_ID"));
	               bt.setTotal_Bill(rs.getInt("Total_Bill"));
	               bt.setDate(rs.getString("Date"));
	               bt.setProvider_id(rs.getInt("Provider_ID"));
	               map.put(rs.getInt("Provider_ID"),rs.getString("Provider_Name"));
	               list.add(bt);  
	            }  
	            return list;
	        }  
	    });
		m.addAttribute("list",list);
		m.addAttribute("map",map);
		return "buytrans";
	}
	@RequestMapping("selltrans")
	public String selltrans(Model m, Principal principle) {
		final Map<Integer,String> custmap=new HashMap<Integer,String>();
		final Map<Integer,String> docmap=new HashMap<Integer,String>();
		List<Selling__Transaction> list=template.query("select Transaction_ID,Total_Bill,Date,st.Customer_ID,st.Doctor_ID,product_no,c.Name custname,d.Name docname from Selling_Transaction st, Customer c, Doctor d where st.Customer_ID=c.Customer_ID and st.Doctor_ID=d.Doctor_ID and MS_Id=? order by Date desc",new Object[] {dao3.getMSByUsername(principle.getName())},new ResultSetExtractor<List<Selling__Transaction> >(){  
	        public List<Selling__Transaction> extractData(ResultSet rs) throws SQLException,DataAccessException {  
	        	List<Selling__Transaction> list = new ArrayList<Selling__Transaction>();  
	            while(rs.next()){  
	               Selling__Transaction st = new Selling__Transaction();
	               st.setTransaction_ID(rs.getInt("Transaction_ID"));
	               st.setTotal_Bill(rs.getInt("Total_Bill"));
	               st.setDate(rs.getString("Date"));
	               st.setCustomer_id(rs.getInt("Customer_ID"));
	               st.setDoctor_ID(rs.getInt("Doctor_ID"));
	               st.setProduct_no(rs.getInt("product_no"));
	               custmap.put(rs.getInt("Customer_ID"),rs.getString("custname"));
	               docmap.put(rs.getInt("Doctor_ID"),rs.getString("docname"));
	               list.add(st);  
	            }  
	            return list;
	        }  
	    });
		m.addAttribute("list",list);
		m.addAttribute("custmap",custmap);
		m.addAttribute("docmap",docmap);
		return "selltrans";
	}
	@RequestMapping("transtock/{id}")
	public String transtock(@PathVariable int id,Model m) {
		List<Bought> Bought=boughtdao.getBoughtByTransaction(id);
		List<Product> list=new ArrayList<Product>();
		Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		for(Bought s:Bought) {
			list.add(dao.getProductById(s.getProduct_ID()));
			map.put(s.getProduct_ID(),s.getQuantity());
		}
		m.addAttribute("list",list);
		m.addAttribute("map",map);
		m.addAttribute("c",1);
        return "stockdetail"; 
		
	}
	@RequestMapping("expirestock")
	public String expirestock(Model m,Principal principle) {
		List<In_Stock> list=dao2.getIn_StockExpire(dao3.getMSByUsername(principle.getName()), DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
		Map<Integer,String> map=new HashMap<Integer,String>();
		for(In_Stock is:list) {
        	map.put(is.getProduct_ID(),dao.getProductById(is.getProduct_ID()).getName());
        }
		m.addAttribute("map",map);
		m.addAttribute("list",list);
		m.addAttribute("c",1);
		return "viewstock";
	}
	@PostMapping("expirestock")
	public String expirestock(Principal principle) {
		List<In_Stock> list=dao2.getIn_StockExpire(dao3.getMSByUsername(principle.getName()), DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now()));
		for(In_Stock is:list) {
			dao2.deleteStock(is);
		}
		return "redirect:/branch/viewstock";
	}
}
