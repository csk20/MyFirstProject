package com.qolsys.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qolsys.bo.RegisterBO;
import com.qolsys.bo.UserBO;
import com.qolsys.dao.LoginDAOImpl;
import com.qolsys.dao.RegisterDAOImpl;
import com.qolsys.dto.RegisterDTO;
import com.qolsys.dto.UserDTO;
@Service("rservice")
public class RegisterServiceImpl implements RegisterService {
	
	

	@Autowired
	private RegisterDAOImpl rdao;


	@Override
	public String save(RegisterDTO dto) {
		
		RegisterBO bo=null;
		bo= new RegisterBO();
		 int count=0;
		BeanUtils.copyProperties(dto, bo);
		
List<UserBO> listBO=rdao.fetchAllRecord();


for (UserBO userBO : listBO) {	
	 
	 System.out.println(bo.getUserid());
	 
	 System.out.println(userBO.getUser());
		
if(bo.getUserid().equals(userBO.getUser())) {
	
	return  "User Already Registered";

} 
}

				 count	=rdao.insertRecord(bo);	
		if (count==0) {
				return "Registration failure";
			}
		else {
			return "Registetration successful";
			
			
		}		
		
	
	}






	@Override
	public List<UserDTO> getAllUser() {
		
		List<UserDTO>  ldto=new ArrayList<>();
		
		List<UserBO>  listBO;
		
		
		 listBO=rdao.fetchAllRecord();
		 
		// BeanUtils.copyProperties(listBO,ldto);
		 for (UserBO userBO : listBO) {
				
			 UserDTO u= new UserDTO();
			 
			 u.setUser(userBO.getUser());
			 u.setPwd(userBO.getPwd());
			 ldto.add(u);	
		 }	 
		
		return ldto;
	}


	
	

	@Override
	public UserDTO getOneUser(String name) {
		
		UserDTO udto=new UserDTO();
		String  uBO;
		uBO=rdao.fetchOneRecord(name);
udto.setUser(name);
udto.setPwd(uBO);

System.out.println(name+"  get one user");
System.out.println();
		
		return udto;
	}




	@Override
	public String removeUser(String name) {
		int count=0;
	 count=rdao.deleteRecord(name);

		if(count==0) return "Unable to delete  user";
		else return "User deleted successfully";
	}
	
	
	@Override
	public String editUser(UserDTO dto) {
		int count=0;
		
		UserBO ubo=new UserBO();
		
	ubo.setUser(dto.getUser());
	
	ubo.setPwd(dto.getPwd());
	
	String name=dto.getUser();
	
	String pass=dto.getPwd();
	
	
	if(pass==null || pass=="") { 
		return "Password should not be Empty";
	}
		System.out.println(name+"---name------ ");
		System.out.println("edit user ---------------");
		

		
		String old_pass=rdao.fetchOneRecord(name);
		 
		System.out.println(old_pass +"-----pass---- ");
	
	
		
	 count=rdao.updateRecord(ubo);

		if(count==0) { 
			return "Unable to Update  user";
		}
		
		else 
		{
			return "Edited successfully";
		}
		
		
	}
	
	
	
}
