package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Product;  
  
public class ProductDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Product p){  
    String sql="insert into Product(Name,MRP_per_unit,Company_Name,Category_Id) values('"+p.getName()+"',"+p.getMRP_per_unit()+",'"+p.getCompany_Name()+"',"+p.getCategory_id()+")";  
    return template.update(sql);  
}  
public int updatemrp(Product p){  
    String sql="update Product set MRP_per_unit="+p.getMRP_per_unit()+" where Product_ID="+p.getProduct_ID();  
    return template.update(sql);  
}

public int delete(int id){  
    String sql="delete from Product where Product_ID="+id;  
    return template.update(sql);  
}  
public Product getProductById(int id){  
    String sql="select * from Product where Product_ID=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Product>(Product.class));  
}  
public List<Product> getProduct(){  
    return template.query("select Product_ID,Name,MRP_per_unit,Company_Name,Category_Id from Product order by Name",new RowMapper<Product>(){  
        public Product mapRow(ResultSet rs, int row) throws SQLException {  
        	Product e=new Product();  
            e.setProduct_ID(rs.getInt(1));
            e.setName(rs.getString(2));
            e.setMRP_per_unit(rs.getInt(3));
            e.setCompany_Name(rs.getString(4));
            e.setCategory_id(rs.getInt(5));
        	return e;  
        }  
    });  
}   
}