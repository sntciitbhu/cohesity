package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.project.models.Bank_Detail;
import com.project.models.Provider;  
  
public class BankDao {
	@Autowired
	JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Bank_Detail p){  
    String sql="insert into Bank_Details(IFSC_Code,Account_No) values('"+p.getIFSC_Code()+"','"+p.getAccount_No()+"')";  
    return template.update(sql);  
}  
public int update(Bank_Detail p){  
    String sql="update Bank_Details set IFSC_Code='"+p.getIFSC_Code()+"', set Account_No='"+p.getAccount_No()+"' where Bank_Detail_ID="+p.getBank_Detail_ID();  
    return template.update(sql);  
}
public int delete(int id){  
    String sql="delete from Bank_Details where ID="+id+"";  
    return template.update(sql);  
} 
public Bank_Detail checkmobile(String ifsc,String acc) {
	String sql="SELECT Bank_Detail_ID FROM Bank_Details WHERE IFSC_Code=? AND Account_No=?";
	List<Bank_Detail> l= template.query(sql,new Object[] {ifsc,acc}, new RowMapper<Bank_Detail>(){  
        public Bank_Detail mapRow(ResultSet rs, int row) throws SQLException {  
        	Bank_Detail e=new Bank_Detail();
        	e.setBank_Detail_ID(rs.getInt(1));
            return e;  
        }  
    });
	if (l.isEmpty())
		return null;
	else 
		return l.get(0);
}
public int getBank_Detail_id(Bank_Detail p){  
    String sql="select Bank_Detail_ID from Bank_Details where IFSC_Code=? and Account_No=?";  
    return template.queryForObject(sql, new Object[]{p.getIFSC_Code(),p.getAccount_No()},Integer.class);  
}  
public List<Bank_Detail> getBank_Detail(){  
    return template.query("select Bank_Detail_ID,IFSC_Code,Account_No from Bank_Details",new RowMapper<Bank_Detail>(){  
        public Bank_Detail mapRow(ResultSet rs, int row) throws SQLException {  
        	Bank_Detail e=new Bank_Detail();  
            e.setBank_Detail_ID(rs.getInt(1));  
            e.setIFSC_Code(rs.getString(2));
            e.setAccount_No(rs.getString(3));
            return e;  
        }  
    });  
}   
}