package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.user_roles;  
  
public class roleDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(user_roles p){  
    String sql="insert into user_roles(username,role) values('"+p.getUsername()+"','"+p.getRole()+"')";  
    return template.update(sql);  
}  
public int delete(String username){  
    String sql="delete from user_roles where username='"+username+"'";  
    return template.update(sql);  
}
public int deletehead(String username){  
    String sql="delete from user_roles where role='ROLE_HEAD' and username='"+username+"'";  
    return template.update(sql);  
}
public int deletework(String username){  
    String sql="delete from user_roles where role='ROLE_WORK' and username='"+username+"'";  
    return template.update(sql);  
}
public List<user_roles> getuser_roles(){  
    return template.query("select user_role_id,username,role from user_roles",new RowMapper<user_roles>(){  
        public user_roles mapRow(ResultSet rs, int row) throws SQLException {  
        	user_roles e=new user_roles();  
            e.setUser_role_id(rs.getInt(1));
        	e.setUsername(rs.getString(2));  
            e.setRole(rs.getString(3));
            return e;  
        }  
    });  
}   
}