package com.qolsys.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.qolsys.bo.RegisterBO;
import com.qolsys.bo.UserBO;
import com.qolsys.dto.UserDTO;
@Repository("rdao")
public class RegisterDAOImpl implements RegisterDAO {
	
	private static final String FETCH_ONE_RECORD="SELECT PWD FROM USERLIST WHERE UNAME= ?";
	private static final String FETCH_ALL="SELECT UNAME,PWD FROM USERLIST";
	
	private static final String INSERT_QUERY="INSERT INTO USERLIST(UNAME,PWD) VALUES(?,?)";
	
	
	private static final String DELETE_QUERY="DELETE FROM USERLIST WHERE UNAME = ?";
	
	
	private static final String UPDATE_QUERY="UPDATE USERLIST SET PWD=? WHERE UNAME=?";
	@Autowired
	private JdbcTemplate jt;
	




	@Override
	public int insertRecord(RegisterBO bo) {
    int count=0;
    
  
System.out.println(bo.getUserid());


if(bo.getUserid()==null || bo.getPwd()==null) {
	return  0;
}
else if(bo.getUserid()=="" || bo.getPwd()=="") {
	
	return  0;
}




System.out.println("---------------hghh-----------------");

count=jt.update(INSERT_QUERY,bo.getUserid(),bo.getPwd());
		return count;
	}






	@Override
	public List<UserBO> fetchAllRecord() {
		List<UserBO>  listBO=new ArrayList<>();
		
	
		listBO=jt.query(FETCH_ALL,new  RowMapper<UserBO>() {

			@Override
			public UserBO mapRow(ResultSet rs, int rowCount) throws SQLException {
				
				UserBO  u= new UserBO();
				u.setUser(rs.getString(1));
				u.setPwd(rs.getString(2));
				
				return u;	
			}	
			
		});
		
		return listBO;
	}
	
	
	@Override
	public String fetchOneRecord(String name) {
		//UserBO  x= new UserBO();
	
	
  String s=jt.queryForObject(
				FETCH_ONE_RECORD, new Object[] { name }, String.class);
  
  System.out.println(s);
	System.out.println("fetch one record --------------");
	System.out.println(name);

  System.out.println("dfhkjggggggggggggggg");
return s;
			
		
/*		return x= jt.query(FETCH_ONE_RECORD,,new ResultSetExtractor<UserBO>(){  
		    @Override  
		     public UserBO extractData(ResultSet rs) throws SQLException,  
		            DataAccessException {  
		      
		       
		    	UserBO u=new UserBO();
		    	u.setUser(rs.getString(1));
		    	
		    	u.setPwd(rs.getString(2));
		    	
				return u;
		    }
		    });
		  */
	}
	
	
	
	
	public int deleteRecord(String name) {
		int count=0;
		
	 count=jt.update(DELETE_QUERY,name);
	 
	 return count;
		
	}
	
	
	
	
	public int updateRecord(UserBO bo) {
		int count=0;
	
		
		System.out.println("update record --------------");
	

 count=jt.update(UPDATE_QUERY, bo.getPwd(),bo.getUser());
	
 System.out.println(bo.getPwd()+"  "+bo.getUser()+"...update record --------------");
	 
	 return count;
		
	}
	
	
	
	
	
	

}
