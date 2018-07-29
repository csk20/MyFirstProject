package com.qolsys.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.qolsys.bo.UserBO;
@Repository("dao")
public class LoginDAOImpl implements LoginDAO {
	
	
	private static final String AUTH_QUERY="SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PWD=?";
	
	@Autowired
	private JdbcTemplate jt;
	@Override
	public int fetchRecord(UserBO bo) {
		
		
		if(bo.getUser()==null || bo.getPwd()==null) {
			return  0;
		}
		else if(bo.getUser()=="" || bo.getPwd()=="") {
			
			return  0;
		}
		
	int count=0;
count=jt.queryForObject(AUTH_QUERY, Integer.class,bo.getUser(),bo.getPwd());
		


		return count;
}
	}
	
	


