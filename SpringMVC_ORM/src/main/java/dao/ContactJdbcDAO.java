package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import entities.Contact;


//configure - JdbcTemplate - spring bean definition
// datasource - JdbcTemplate - DAO - controller

public class ContactJdbcDAO {
	
	@Autowired
	JdbcTemplate template;
	
	public List<Contact> getAll() {		
		return template.query("select * from contacts", new RowMapper<Contact>() {
			@Override
			public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
				Contact ct = new Contact();
				ct.setCid(rs.getInt(1));
				ct.setUid(rs.getString(2));
				//other methods
				return ct;				
			}			
		});		
	}	
	
	public int save(Contact ct) {
		return template.update("insert into contacts values(?,?,?)", ct.getUid(),ct.getPassword(),ct.getFname());
	}
}
