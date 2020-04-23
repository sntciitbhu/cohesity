package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Bought;  
  
public class BoughtDao {
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Bought p){  
    String sql="insert into Bought(Transaction_ID,Product_ID,Quantity,Cost_Price_per_Unit) values("+p.getTransaction_ID()+","+p.getProduct_ID()+","+p.getQuantity()+","+p.getCost_Price_per_Unit()+")";  
    return template.update(sql);  
}  
 
public List<Bought> getBoughtByTransaction(int id){  
    return template.query("select Quantity,Cost_Price_per_Unit,Product_ID,Transaction_ID from Bought where Transaction_ID=?",new Object[] {id},new RowMapper<Bought>(){  
        public Bought mapRow(ResultSet rs, int row) throws SQLException {  
        	Bought e=new Bought();
        	e.setQuantity(rs.getInt(1));
        	e.setCost_Price_per_Unit(rs.getInt(2));
        	e.setProduct_ID(rs.getInt(3));
        	e.setTransaction_ID(rs.getInt(4));
            return e;  
        }  
    });  
}  
}  
