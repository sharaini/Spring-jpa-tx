package db;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class databaseService {
	private JdbcTemplate jt;
	public databaseService(DataSource ds){
		this.setJt(new JdbcTemplate(ds));
	}
	public JdbcTemplate getJt() {
		return jt;
	}

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
}
