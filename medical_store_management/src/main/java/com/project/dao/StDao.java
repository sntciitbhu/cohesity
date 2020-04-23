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

import com.project.models.Selling__Transaction;  
  
public class StDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(final Selling__Transaction p){  
    final String sql="insert into Selling_Transaction(Date,MS_Id,Customer_ID,Doctor_ID,product_no) values(?,?,?,?,?)";
    GeneratedKeyHolder holder=new GeneratedKeyHolder();
    template.update(new PreparedStatementCreator(){
    	
    	public PreparedStatement createPreparedStatement(Connection con)throws SQLException{
    		PreparedStatement statement=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
    		statement.setString(1, p.getDate());
    		statement.setInt(2, p.getMS_id());
    		statement.setInt(3, p.getCustomer_id());
    		statement.setInt(4, p.getDoctor_ID());
    		statement.setInt(5, p.getProduct_no());
    		return statement;
    	}
    },holder);
    return holder.getKey().intValue();
}  
public int delete(int id){  
    String sql="delete from Selling_Transaction where Transaction_ID="+id;  
    return template.update(sql);  
}
public int update(int bill,int id) {
	String sql="UPDATE Selling_Transaction SET Total_Bill="+bill+" WHERE Transaction_ID="+id;
	return template.update(sql);
}
public Selling__Transaction getSelling_TransactionById(int id){  
    String sql="select * from Selling_Transaction where Transaction_ID=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Selling__Transaction>(Selling__Transaction.class));  
}  
public List<Selling__Transaction> getSelling_Transaction(){  
    return template.query("select * from Selling_Transaction",new RowMapper<Selling__Transaction>(){  
        public Selling__Transaction mapRow(ResultSet rs, int row) throws SQLException {  
        	Selling__Transaction e=new Selling__Transaction();  
            e.setTransaction_ID(rs.getInt(1));
            e.setTotal_Bill(rs.getInt(2));
            e.setDate(rs.getString(3));
            e.setMS_id(rs.getInt(4));
            e.setCustomer_id(rs.getInt(5));
            e.setDoctor_ID(rs.getInt(6));
            e.setProduct_no(rs.getInt(7));
        	return e;  
        }  
    });  
}  
}  
