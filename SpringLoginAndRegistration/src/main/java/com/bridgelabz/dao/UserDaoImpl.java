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

import com.bridgelabz.model.Login;
import com.bridgelabz.model.Otp;
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

	public boolean register(User user) {
		String sql = "insert into register1(name,password,lastname,email,location) values(?,?,?,?,?)";

		String password = encryptor.encode(user.getPassword());
		int a = jdbcTemplate.update(sql,
				new Object[] { user.getFname(), password, user.getLname(), user.getEmail(), user.getLocation() });
		if (a == 0) {
			logger.warn("registration unsuccesful");
			return false;

		} else {
			logger.info("registration successful");
			return true;
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



	public void generateOtp(Otp otp,int randomNo) {
		String sql = "insert into otp(email,otp) values(?,?)";
		jdbcTemplate.update(sql,
				new Object[] {otp.getEmail(),randomNo});
		

		}
	public Otp validateUser(String email,int otp) {

		String sql = "select * from otp";
		List<Otp> otps = jdbcTemplate.query(sql, new OtpMapper());
		Iterator<Otp> itr = otps.iterator();
		while (itr.hasNext()) {
			Otp otplist = itr.next();
			if(otplist.getEmail().equals(email)&&otplist.getOtp()==otp) {
				return otplist;
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
	
	
	class OtpMapper implements RowMapper<Otp> {
		public Otp mapRow(ResultSet rs, int arg1) throws SQLException {
		Otp otp=new Otp();

		
			otp.setEmail(rs.getString("email"));
			otp.setOtp(rs.getInt("otp"));

			return otp;
		}


}
