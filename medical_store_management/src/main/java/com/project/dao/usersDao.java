package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.users;  
  
public class usersDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(users p){  
    String sql="insert into users(username) values('"+p.getUsername()+"')";  
    return template.update(sql);  
}
public int update(users p) {
	String sql="update users set password='"+p.getPassword()+"' where username='"+p.getUsername()+"'";
	return template.update(sql);
}
public int delete(String username){  
    String sql="delete from users where username='"+username+"'";  
    return template.update(sql);  
}    
public List<users> getusers(){  
    return template.query("select username from users",new RowMapper<users>(){  
        public users mapRow(ResultSet rs, int row) throws SQLException {  
        	users e=new users();  
            e.setUsername(rs.getString(1));  
            e.setPassword(rs.getString(2));
            return e;  
        }  
    });  
}   
}