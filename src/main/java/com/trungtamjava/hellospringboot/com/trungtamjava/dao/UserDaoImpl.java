//package com.trungtamjava.hellospringboot.com.trungtamjava.dao;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.swing.Spring;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.EmptyResultDataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.trungtamjava.hellospringboot.com.trungtamjava.model.User;
//
//import ch.qos.logback.core.joran.conditional.IfAction;
//
//@Repository
//
//public class UserDaoImpl implements UserDao {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@Override
//	public void addUser(User user) {
//		String sql = "insert into users(u_id,u_name,u_username, u_password,u_role) values(?,?,?,?,?)";
//		jdbcTemplate.update(sql, user.getId(), user.getName(), user.getUsername(), user.getPassword(), user.getRole());
//	}
//
//	@Override
//	public void updateUser(User user) {
//		String sql = "update users u_name = ?, u_username=?, u_password = ?,  u_role = ? where u_id = ?";
//		jdbcTemplate.update(sql, user.getName(), user.getUsername(), user.getPassword(), user.getRole(), user.getId());
//	}
//
//	@Override
//	public void deleteUser(int id) {
//		String sql = "delete from users where u_id = ?";
//		jdbcTemplate.update(sql, id);
//
//	}
//
//	@Override
//	public User getUserById(int id) {
//		try {
//			String sql = "select * from users where u_id = ?";
//			return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
//				@Override
//				public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//					User user = new User();
//					user.setId(rs.getInt("u_id"));
//					user.setName(rs.getString("u_name"));
//					user.setUsername(rs.getString("u_username"));
//					user.setPassword(rs.getString("u_password"));
//					user.setRole(rs.getString("u_role"));
//					return user;
//				}
//			}, new Object[] { id });
//		} catch (EmptyResultDataAccessException e) {
//			return null;
//		}
//	}
//
//	@Override
//	public List<User> getAllUsers() {
//		String sql = "select * from users";
//		return jdbcTemplate.query(sql, new RowMapper<User>() {
//			@Override
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//				User user = new User();
//				user.setId(rs.getInt("u_id"));
//				user.setName(rs.getString("u_name"));
//				user.setUsername(rs.getString("u_username"));
//				user.setPassword(rs.getString("u_password"));
//				user.setRole(rs.getString("u_role"));
//				return user;
//			}
//		});
//	}
//
//}
