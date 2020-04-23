package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Category;  
  
public class CategoryDao {
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Category p){  
    String sql="insert into Category(Category_Name) values('"+p.getCategory_Name()+"')";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Category where Category_Id="+id;  
    return template.update(sql);  
}  
public Category getCategoryById(int id){  
    String sql="select * from Category where Category_Id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Category>(Category.class));  
}  
public List<Category> getCategory(){  
    return template.query("select Category_Name,Category_Id from Category",new RowMapper<Category>(){  
        public Category mapRow(ResultSet rs, int row) throws SQLException {  
        	Category e=new Category();  
            e.setCategory_Name(rs.getString(1));
            e.setCategory_Id(rs.getInt(2));
        	return e;  
        }  
    });  
}  
}  
