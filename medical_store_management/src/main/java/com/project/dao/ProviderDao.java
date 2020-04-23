package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Provider;
import com.project.models.Worker;
  
public class ProviderDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Provider p){  
    String sql="insert into Provider(Provider_Name,Contact_No,Godown_No,Street,Area) values('"+p.getProvider_Name()+"','"+p.getContact_No()+"',"+p.getGodown_No()+",'"+p.getStreet()+"','"+p.getArea()+"')";  
    return template.update(sql);  
}
public int updatebank(Provider p){  
    String sql="update Provider set Bank_Detail_ID="+p.getBank_detail_id()+" where Provider_ID="+p.getProvider_ID();  
    return template.update(sql);  
} 
public int delete(int id){  
    String sql="delete from Provider where Provider_ID="+id+"";  
    return template.update(sql);  
}
public Provider checkmobile(String mobile) {
	String sql="SELECT Provider_ID FROM Provider WHERE Contact_No=?";
	List<Provider> l= template.query(sql,new Object[] {mobile}, new RowMapper<Provider>(){  
        public Provider mapRow(ResultSet rs, int row) throws SQLException {  
        	Provider e=new Provider();
        	e.setProvider_ID(rs.getInt(1));
            return e;  
        }  
    });
	if (l.isEmpty())
		return null;
	else 
		return l.get(0);
}
public Provider getProvById(int id){  
    String sql="select Provider_ID,Provider_Name,Contact_No,Godown_No,Street,Area from Provider where Provider_ID=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Provider>(Provider.class));  
}  
public List<Provider> getProvider(){  
    return template.query("select Provider_ID,Provider_Name,Contact_No,Godown_No,Street,Area from Provider",new RowMapper<Provider>(){  
        public Provider mapRow(ResultSet rs, int row) throws SQLException {  
        	Provider e=new Provider();  
            e.setProvider_ID(rs.getInt(1));  
            e.setProvider_Name(rs.getString(2));  
            e.setContact_No(rs.getString(3));  
            e.setGodown_No(rs.getInt(4));
            e.setStreet(rs.getString(5));
            e.setArea(rs.getString(6));
            return e;  
        }  
    });  
}  
}  
