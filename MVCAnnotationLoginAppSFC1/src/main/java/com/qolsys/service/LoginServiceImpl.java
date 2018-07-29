package com.qolsys.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qolsys.bo.UserBO;
import com.qolsys.dao.LoginDAOImpl;
import com.qolsys.dto.UserDTO;
@Service("service")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAOImpl dao;

	@Override
	public String verify(UserDTO dto) {
UserBO bo=null;
bo= new UserBO();

BeanUtils.copyProperties(dto, bo);

int count=dao.fetchRecord(bo);
if (count==0) {

		return "Invalid credential";
	}
else {
	
	System.out.println(count);
	System.out.println("fcgggggggggggggggggg");
	return "Valid credential";
}

}
}
