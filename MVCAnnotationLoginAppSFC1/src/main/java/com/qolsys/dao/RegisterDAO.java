package com.qolsys.dao;

import java.util.List;

import com.qolsys.bo.RegisterBO;
import com.qolsys.bo.UserBO;

public interface RegisterDAO {
	
	         public  int insertRecord(RegisterBO bo);
	         
	         
	         public  List<UserBO> fetchAllRecord();
	         
	         public String fetchOneRecord(String name);

	         public int updateRecord(UserBO bo);
}
