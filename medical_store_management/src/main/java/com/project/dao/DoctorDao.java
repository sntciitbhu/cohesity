package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Doctor;
import com.project.models.Provider;
  
public class DoctorDao { 
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Doctor p){  
    String sql="insert into Doctor(Clinic_Name,Name,Contact_No,Major_Location,Commision_per__recommendation) values('"+p.getClinic_Name()+"','"+p.getName()+"','"+p.getContact_No()+"','"+p.getMajor_Location()+"',"+p.getCommision_per__recommendation()+")";  
    return template.update(sql);  
}
public int updatebank(Doctor p){  
    String sql="update Doctor set Bank_Detail_ID="+p.getBank_detail_id()+" where Doctor_ID="+p.getDoctor_ID();  
    return template.update(sql);  
} 
public int delete(int id){  
    String sql="delete from Doctor where Doctor_ID="+id+"";  
    return template.update(sql);  
}  
public Doctor checkmobile(String mobile) {
	String sql="SELECT Doctor_ID FROM Doctor WHERE Contact_No=?";
	List<Doctor> l= template.query(sql,new Object[] {mobile}, new RowMapper<Doctor>(){  
        public Doctor mapRow(ResultSet rs, int row) throws SQLException {  
        	Doctor e=new Doctor();
        	e.setDoctor_ID(rs.getInt(1));
            return e;  
        }  
    });
	if (l.isEmpty())
		return null;
	else 
		return l.get(0);
}
public Doctor getDocById(int id){  
    String sql="select Doctor_ID,Clinic_Name,Name,Contact_No,Major_Location,Commision_per__recommendation from Doctor where Doctor_ID=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Doctor>(Doctor.class));  
}  
public List<Doctor> getDoctor(){  
    return template.query("select Doctor_ID,Clinic_Name,Name,Contact_No,Major_Location,Commision_per__recommendation from Doctor",new RowMapper<Doctor>(){  
        public Doctor mapRow(ResultSet rs, int row) throws SQLException {  
        	Doctor e=new Doctor();  
            e.setDoctor_ID(rs.getInt(1));  
            e.setClinic_Name(rs.getString(2));  
            e.setName(rs.getString(3));  
            e.setContact_No(rs.getString(4));
            e.setMajor_Location(rs.getString(5));
            e.setCommision_per__recommendation(rs.getInt(6));
            return e;  
        }  
    });  
}  
}  
