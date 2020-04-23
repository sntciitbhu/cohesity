package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Sold;  
  
public class SoldDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Sold p){  
    String sql="insert into Sold(Transaction_ID,Product_ID,Quantity) values("+p.getTransaction_ID()+","+p.getProduct_ID()+","+p.getQuantity()+")";  
    return template.update(sql);  
}  
 
public List<Sold> getSoldByTransaction(int id){  
    return template.query("select Quantity,Product_ID,Transaction_ID from Sold where Transaction_ID=?",new Object[] {id},new RowMapper<Sold>(){  
        public Sold mapRow(ResultSet rs, int row) throws SQLException {  
        	Sold e=new Sold();
        	e.setQuantity(rs.getInt(1));
        	e.setProduct_ID(rs.getInt(2));
        	e.setTransaction_ID(rs.getInt(3));
            return e;  
        }  
    });  
}  
}  
