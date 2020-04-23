package com.project.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;

import com.project.models.Customer;
import com.project.models.In_Stock;  
  
public class StockDao {  
	@Autowired
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(In_Stock p){  
    String sql="insert into In_Stock(Product_ID,MS_Id,Expiry_Date,Batch_No,Quantity) values("+p.getProduct_ID()+","+p.getMS_Id()+",'"+p.getExpiry_Date()+"','"+p.getBatch_No()+"',"+p.getQuantity()+")";  
    return template.update(sql);  
}
public In_Stock checkStock(In_Stock p) {
	String sql="SELECT Product_ID FROM In_Stock WHERE Product_ID=? AND MS_Id=? AND Batch_No=?";
	List<In_Stock> l= template.query(sql,new Object[] {p.getProduct_ID(),p.getMS_Id(),p.getBatch_No()}, new RowMapper<In_Stock>(){  
        public In_Stock mapRow(ResultSet rs, int row) throws SQLException {  
        	In_Stock e=new In_Stock();
        	e.setProduct_ID(rs.getInt(1));
            return e;  
        }  
    });
	if (l.isEmpty())
		return null;
	else 
		return l.get(0);
}
public int updateStockminus(In_Stock p) {
	String sql="UPDATE In_Stock SET Quantity=Quantity"+p.getQuantity()+" WHERE Product_ID="+p.getProduct_ID()+" AND MS_Id="+p.getMS_Id()+" AND Batch_No='"+p.getBatch_No()+"'";
	return template.update(sql);
}
public int updateStockplus(In_Stock p) {
	String sql="UPDATE In_Stock SET Quantity=Quantity+"+p.getQuantity()+" WHERE Product_ID="+p.getProduct_ID()+" AND MS_Id="+p.getMS_Id()+" AND Batch_No='"+p.getBatch_No()+"'";
	return template.update(sql);
}
public int deleteStock(In_Stock p) {
	String sql="delete from In_Stock WHERE Product_ID="+p.getProduct_ID()+" AND MS_Id="+p.getMS_Id()+" AND Batch_No='"+p.getBatch_No()+"'";
	return template.update(sql);
}
public List<In_Stock> getProductIn_Stock(int mid,int pid){
	String dt=DateTimeFormatter.ofPattern("yyyy-MM-dd").format(LocalDate.now());
    return template.query("SELECT Quantity,Batch_No FROM In_Stock WHERE MS_Id=? AND Product_ID=? AND Expiry_Date > ? ORDER BY Expiry_Date",new Object[] {mid,pid,dt},new RowMapper<In_Stock>(){  
        public In_Stock mapRow(ResultSet rs, int row) throws SQLException {  
        	In_Stock e=new In_Stock();
        	e.setQuantity(rs.getInt(1));
        	e.setBatch_No(rs.getString(2));
            return e;  
        }  
    });  
}
public List<In_Stock> getIn_Stock(int id){  
    return template.query("SELECT Product_ID,SUM(Quantity) FROM In_Stock WHERE MS_Id=? GROUP BY Product_ID",new Object[] {id},new RowMapper<In_Stock>(){  
        public In_Stock mapRow(ResultSet rs, int row) throws SQLException {  
        	In_Stock e=new In_Stock();
        	e.setProduct_ID(rs.getInt(1));
        	e.setQuantity(rs.getInt(2));
            return e;  
        }  
    });  
}
public List<In_Stock> getIn_StockLess(int id){  
    return template.query("SELECT Product_ID,SUM(Quantity) FROM In_Stock WHERE MS_Id=? GROUP BY Product_ID having SUm(Quantity)<6",new Object[] {id},new RowMapper<In_Stock>(){  
        public In_Stock mapRow(ResultSet rs, int row) throws SQLException {  
        	In_Stock e=new In_Stock();
        	e.setProduct_ID(rs.getInt(1));
        	e.setQuantity(rs.getInt(2));
            return e;  
        }  
    });  
}
public List<In_Stock> getIn_StockFull(int id){  
    return template.query("SELECT Product_ID,Quantity,Batch_No,Expiry_Date,MS_Id FROM In_Stock WHERE MS_Id=?",new Object[] {id},new RowMapper<In_Stock>(){  
        public In_Stock mapRow(ResultSet rs, int row) throws SQLException {  
        	In_Stock e=new In_Stock();
        	e.setProduct_ID(rs.getInt(1));
        	e.setQuantity(rs.getInt(2));
        	e.setBatch_No(rs.getString(3));
        	e.setExpiry_Date(rs.getString(4));
        	e.setMS_Id(rs.getInt(5));
            return e;  
        }  
    });  
}
public List<In_Stock> getIn_StockExpire(int id,String today){  
    return template.query("SELECT Product_ID,Quantity,Batch_No,Expiry_Date,MS_Id FROM In_Stock WHERE MS_Id=? AND Expiry_Date<?",new Object[] {id,today},new RowMapper<In_Stock>(){  
        public In_Stock mapRow(ResultSet rs, int row) throws SQLException {  
        	In_Stock e=new In_Stock();
        	e.setProduct_ID(rs.getInt(1));
        	e.setQuantity(rs.getInt(2));
        	e.setBatch_No(rs.getString(3));
        	e.setExpiry_Date(rs.getString(4));
        	e.setMS_Id(rs.getInt(5));
            return e;  
        }  
    });  
}
}  
