package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.project.models.In_Stock;
import com.project.models.Worker;  
  
public class WorkerDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Worker p){  
    String sql="insert into Workers(Name,Contact_No,Aadhar_No,House_No,Street,Area,Salary_per__annum,Joining_Date,MS_Id,username) values('"+p.getName()+"','"+p.getContact_No()+"','"+p.getAadhar_No()+"',"+p.getHouse_No()+",'"+p.getStreet()+"','"+p.getArea()+"',"+p.getSalary_per__annum()+",'"+p.getJoining_Date()+"',"+p.getMs_id()+",'"+p.getUsername()+"')";  
    return template.update(sql);  
}  
public int updatems(Worker p){  
    String sql="update Workers set MS_Id="+p.getMs_id()+" where Worker_ID="+p.getWorker_ID();  
    return template.update(sql);  
}
public int updatebank(Worker p){  
    String sql="update Workers set Bank_Detail_ID="+p.getBank_detail_id()+" where Worker_ID="+p.getWorker_ID();  
    return template.update(sql);  
}
public int delete(int id){  
    String sql="delete from Workers where Worker_Id="+id+"";  
    return template.update(sql);  
}  
public Worker checkUsername(String username) {
	String sql="SELECT Worker_ID FROM Workers WHERE username=?";
	List<Worker> l= template.query(sql,new Object[] {username}, new RowMapper<Worker>(){  
        public Worker mapRow(ResultSet rs, int row) throws SQLException {  
        	Worker e=new Worker();
        	e.setWorker_ID(rs.getInt(1));
            return e;  
        }  
    });
	if (l.isEmpty())
		return null;
	else 
		return l.get(0);
}
public Worker getWorkerById(int id){  
    String sql="select Worker_ID,Name,Contact_No,Aadhar_No,House_No,Street,Area,Salary_per__annum,Joining_Date,MS_Id,username from Workers where Worker_ID=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Worker>(Worker.class));  
}

public int getMSByUsername(String username){  
    String sql="select MS_Id from Workers where username=?";  
    return template.queryForObject(sql, new Object[]{username},Integer.class);  
}

public String getUsernameById(int id){  
    String sql="select username from Workers where Worker_Id=?";  
    return template.queryForObject(sql, new Object[]{id},String.class);  
}

public List<Worker> getWorker(){  
    return template.query("select * from Workers",new RowMapper<Worker>(){  
        public Worker mapRow(ResultSet rs, int row) throws SQLException {  
        	Worker e=new Worker();  
            e.setWorker_ID(rs.getInt(1));  
            e.setName(rs.getString(2));
            e.setContact_No(rs.getString(3));
            e.setAadhar_No(rs.getString(4));
            e.setHouse_No(rs.getInt(5));
            e.setStreet(rs.getString(6));
            e.setArea(rs.getString(7));
            e.setSalary_per__annum(rs.getInt(8));
            e.setJoining_Date(rs.getString(9));
            e.setMs_id(rs.getInt(10));
            e.setUsername(rs.getString(12));
            return e;  
        }  
    });  
}  
 
public List<Worker> getWorkerbyMS(int id){  
    return template.query("select * from Workers where MS_Id=?",new Object[]{id},new RowMapper<Worker>(){  
        public Worker mapRow(ResultSet rs, int row) throws SQLException {  
        	Worker e=new Worker();  
            e.setWorker_ID(rs.getInt(1));  
            e.setName(rs.getString(2));
            e.setContact_No(rs.getString(3));
            e.setAadhar_No(rs.getString(4));
            e.setHouse_No(rs.getInt(5));
            e.setStreet(rs.getString(6));
            e.setArea(rs.getString(7));
            e.setSalary_per__annum(rs.getInt(8));
            e.setJoining_Date(rs.getString(9));
            e.setMs_id(rs.getInt(10));
            e.setUsername(rs.getString(11));
            return e;  
        }  
    });  
}  
}