package db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public class Manager {
	private JdbcTemplate jt;
	public User user;
	
	public Manager(databaseService ds){
		this.jt=ds.getJt();
	}
	public User getUser(int id){
		return jt.queryForObject("select * from user where id=?", new Object[]{id},new UserMapper());
	}
	@Transactional
	public boolean addUser(User user){
		int result=jt.update("insert into user values(?,?)", new Object[]{user.getId(),user.getUsername()});
		return (result>0)?true:false;
	}
	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.REQUIRES_NEW)
	public List<User> queryUsers(){
		return jt.query("select * from user",new UserResult());
	}
	
	private static final class UserResult implements ResultSetExtractor<List<User>>{

		public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
			// TODO Auto-generated method stub
			List<User> testUsers = new ArrayList<User>();			
			while (rs.next()) {	
				 User user = null;
				 if(rs.getString("USERNAME").contains("test")){
					 user = new User();
					 user.setId(rs.getInt("id"));
			         user.setUsername(rs.getString("username"));
			         testUsers.add(user);
				 }						 
			}				
			return testUsers;
		}
		
	}
}
