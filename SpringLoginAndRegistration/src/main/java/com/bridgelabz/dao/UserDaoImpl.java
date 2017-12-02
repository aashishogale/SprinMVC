package com.bridgelabz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	  DataSource datasource;
	  @Autowired
	  JdbcTemplate jdbcTemplate;
	  public void register(User user) {
	    String sql = "insert into register1(name,password,lastname,email,location) values(?,?,?,?,?)";
	    jdbcTemplate.update(sql, new Object[] { user.getFname(), user.getPassword(), 
	    user.getLname(), user.getEmail() ,user.getLocation()});
	    }
	    public User validateUser(Login login) {
	    String sql = "select * from register1 where email='" + login.getEmail() + "' and password='" + login.getPassword()
	    + "'";
	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	    return users.size() > 0 ? users.get(0) : null;
	    }
	
	  }
	  class UserMapper implements RowMapper<User> {
	  public User mapRow(ResultSet rs, int arg1) throws SQLException {
	    User user = new User();
	    
	    user.setPassword(rs.getString("password"));
	    user.setFname(rs.getString("name"));
	    user.setLname(rs.getString("lastname"));
	    user.setEmail(rs.getString("email"));
	    user.setLocation(rs.getString("location"));
	 
	    return user;
	  }


}
