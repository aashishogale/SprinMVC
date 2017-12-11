package com.bridgelabz.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bridgelabz.controller.LoginController;
import com.bridgelabz.model.Login;
import com.bridgelabz.model.User;

/**
 * @author aashish
 *
 *
 */

@Repository
public class UserDaoImpl implements UserDao {
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

	@Autowired
	DataSource datasource;
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	BCryptPasswordEncoder encryptor;

	public void register(User user) {
		String sql = "insert into register1(name,password,lastname,email,location) values(?,?,?,?,?)";

		String password = encryptor.encode(user.getPassword());
		int a = jdbcTemplate.update(sql,
				new Object[] { user.getFname(), password, user.getLname(), user.getEmail(), user.getLocation() });
		if (a == 0) {
			logger.warn("registration unsuccesful");

		} else {
			logger.info("registration successful");
		}
	}

	public User validateUser(Login login) {

		String sql = "select * from register1";
		List<User> users = jdbcTemplate.query(sql, new UserMapper());
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getEmail().equals(login.getEmail())
					&& encryptor.matches(login.getPassword(), user.getPassword())) {
				return user;
			}

		}
		logger.warn("user not present");
		return null;
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
