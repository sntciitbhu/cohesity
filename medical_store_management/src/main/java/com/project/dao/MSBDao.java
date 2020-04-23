package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Medical_Store_Branch;
import com.project.models.Worker;  
  
public class MSBDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Medical_Store_Branch p){  
    String sql="insert into Medical_Store_Branch(Major_Location,Shop_No,Street,Area) values('"+p.getMajor_Location()+"',"+p.getShop_No()+",'"+p.getStreet()+"','"+p.getArea()+"')";  
    return template.update(sql);  
}  
public int update(Medical_Store_Branch p){  
    String sql="update Medical_Store_Branch set head_worker_id="+p.getHead_Worker_id()+" where MS_Id="+p.getMS_Id();  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Medical_Store_Branch where MS_Id="+id+"";  
    return template.update(sql);  
}  
public Medical_Store_Branch getMSBById(int id){  
    String sql="select * from Medical_Store_Branch where MS_Id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Medical_Store_Branch>(Medical_Store_Branch.class));  
} 
public Medical_Store_Branch checkHeadWorker(int hid) {
	String sql="SELECT MS_Id FROM Medical_Store_Branch WHERE head_worker_id=?";
	List<Medical_Store_Branch> l= template.query(sql,new Object[] {hid}, new RowMapper<Medical_Store_Branch>(){  
        public Medical_Store_Branch mapRow(ResultSet rs, int row) throws SQLException {  
        	Medical_Store_Branch e=new Medical_Store_Branch();
        	e.setMS_Id(rs.getInt(1));
            return e;  
        }  
    });
	if (l.isEmpty())
		return null;
	else 
		return l.get(0);
}
public List<Medical_Store_Branch> getMSB(){  
    return template.query("select * from Medical_Store_Branch",new RowMapper<Medical_Store_Branch>(){  
        public Medical_Store_Branch mapRow(ResultSet rs, int row) throws SQLException {  
        	Medical_Store_Branch e=new Medical_Store_Branch();  
            e.setMS_Id(rs.getInt(1));  
            e.setMajor_Location(rs.getString(2));  
            e.setShop_No(rs.getInt(3));  
            e.setStreet(rs.getString(4));
            e.setArea(rs.getString(5));
            e.setHead_Worker_id(rs.getInt(6));
            return e;  
        }  
    });  
}  
}  
