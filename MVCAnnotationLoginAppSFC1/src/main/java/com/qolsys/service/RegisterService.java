package com.qolsys.service;

import java.util.List;

import com.qolsys.bo.UserBO;
import com.qolsys.dto.RegisterDTO;
import com.qolsys.dto.UserDTO;

public interface RegisterService {
	
	public String save(RegisterDTO dto);
	
	
	public List<UserDTO> getAllUser();
	
	
	public String removeUser(String username);
	public String editUser(UserDTO dto) ;
	
	public UserDTO getOneUser(String name);
}
