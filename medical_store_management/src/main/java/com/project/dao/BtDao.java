package com.project.dao;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.project.models.Buying__Transaction;  
  
public class BtDao { 
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(final Buying__Transaction p){  
    final String sql="insert into Buying_Transaction(Date,MS_Id,Provider_ID) values(?,?,?)";
    GeneratedKeyHolder holder=new GeneratedKeyHolder();
    template.update(new PreparedStatementCreator(){
    	
    	public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
    		PreparedStatement statement=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		statement.setString(1, p.getDate());
    		statement.setInt(2, p.getMs_id());
    		statement.setInt(3, p.getProvider_id());
    		return statement;
    	}
    },holder);
    return holder.getKey().intValue();
}  
public int delete(int id){  
    String sql="delete from Buying_Transaction where Transaction_ID="+id;  
    return template.update(sql);  
}
public int update(int bill,int id) {
	String sql="UPDATE Buying_Transaction SET Total_Bill="+bill+" WHERE Transaction_ID="+id;
	return template.update(sql);
}
public Buying__Transaction getBuying_TransactionById(int id){  
    String sql="select * from Buying_Transaction where Transaction_ID=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Buying__Transaction>(Buying__Transaction.class));  
}  
public List<Buying__Transaction> getBuying_Transaction(){  
    return template.query("select * from Buying_Transaction",new RowMapper<Buying__Transaction>(){  
        public Buying__Transaction mapRow(ResultSet rs, int row) throws SQLException {  
        	Buying__Transaction e=new Buying__Transaction();  
            e.setTransaction_ID(rs.getInt(1));
            e.setTotal_Bill(rs.getInt(2));
            e.setDate(rs.getString(3));
            e.setMs_id(rs.getInt(4));
            e.setProvider_id(rs.getInt(5));
            return e;  
        }  
    });  
}  
}  
