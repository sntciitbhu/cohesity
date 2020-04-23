package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Customer;
import com.project.models.Provider;  
  
public class CustomerDao { 
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Customer p){  
    String sql="insert into Customer(Contact_No,Name) values('"+p.getContact_No()+"','"+p.getName()+"')";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Customer where Customer_ID="+id;  
    return template.update(sql);  
}  
public Customer checkmobile(String mobile) {
	String sql="SELECT Customer_ID FROM Customer WHERE Contact_No=?";
	List<Customer> l= template.query(sql,new Object[] {mobile}, new RowMapper<Customer>(){  
        public Customer mapRow(ResultSet rs, int row) throws SQLException {  
        	Customer e=new Customer();
        	e.setCustomer_ID(rs.getInt(1));
            return e;  
        }  
    });
	if (l.isEmpty())
		return null;
	else 
		return l.get(0);
}
public Customer getCustomerById(int id){  
    String sql="select * from Customer where Customer_ID=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Customer>(Customer.class));  
}
public Customer getCustomerByContact(String cn) {
	String sql="SELECT * FROM Customer WHERE Contact_No=?";
	List<Customer> l= template.query(sql,new Object[] {cn}, new RowMapper<Customer>(){  
        public Customer mapRow(ResultSet rs, int row) throws SQLException {  
        	Customer e=new Customer();  
            e.setName(rs.getString(1));
        	e.setCustomer_ID(rs.getInt(2));  
            e.setContact_No(rs.getString(3));  
            return e;  
        }  
    });
	if (l.isEmpty())
		return null;
	else 
		return l.get(0);
}
public List<Customer> getCustomer(){  
    return template.query("select Name,Customer_ID,Contact_No from Customer",new RowMapper<Customer>(){  
        public Customer mapRow(ResultSet rs, int row) throws SQLException {  
        	Customer e=new Customer();  
            e.setName(rs.getString(1));
        	e.setCustomer_ID(rs.getInt(2));  
            e.setContact_No(rs.getString(3));  
            return e;  
        }  
    });  
}  
}  
