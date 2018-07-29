package com.qolsys.rest;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.qolsys.command.RegisterCommand;
import com.qolsys.dto.RegisterDTO;
import com.qolsys.dto.UserDTO;
import com.qolsys.service.LoginServiceImpl;
import com.qolsys.service.RegisterServiceImpl;

@RestController
@RequestMapping("/rest")
public class LoginRestController {
	
	@Autowired
	private LoginServiceImpl service;
	
	@Autowired
	private RegisterServiceImpl rservice;
	
//	@RequestMapping(value="login.htm",method=RequestMethod.GET)
//	public String showPage(Map<String,Object> map) {
//		
//		UserCommand user=null;
//		user= new UserCommand();
//		map.put("userCmd",user);
//		return "login";	
//	}
//	
	
	@RequestMapping(value="/login",method=RequestMethod.POST, consumes = { "application/json","application/xml"
	 })
	public @ResponseBody String  loginPage(@RequestBody UserDTO dto,BindingResult errors) {
		
	//	UserDTO dto=null;
	//	dto= new UserDTO();
		
	//	BeanUtils.copyProperties(cmd, dto);
		
		String result=service.verify(dto);
	
	
		return result;
		
	
		
	}
	
/*	
	@RequestMapping(value="register.htm",method=RequestMethod.GET)
	public String formPage(Map<String,Object> map) {
		
		RegisterCommand user=null;
		user= new RegisterCommand();
		map.put("regCmd",user);
	
		return "register";	
		
	}

	
	*/
	@RequestMapping(value="/add",method=RequestMethod.POST,consumes = { "application/json","application/xml"
	 })
	public @ResponseBody String registerPage(@RequestBody RegisterCommand cmd,BindingResult errors) {
	
		RegisterDTO dto=null;
		dto= new RegisterDTO();
		BeanUtils.copyProperties(cmd, dto);
		System.out.println("--------------------------------"); 
		 System.out.println(cmd.getUserid());
		 System.out.println("--------------------------------");
	
		
		String result=rservice.save(dto);


		
		return result;
		
	}
	
	
	@RequestMapping(value="/all",method=RequestMethod.GET, produces = { "application/json","application/xml"
	 })
	public  ResponseEntity<Object>  getAll() {

				Object response = null;		
				  List<UserDTO>		 ldto=rservice.getAllUser();
				  
				if(ldto==null || ldto.size()==0) {
					response  = "No Item Records Exist.";
				}else {
					response = ldto;
				}
				return ResponseEntity.ok(response);
				
	}
	
	
	/*	
		
			for (UserDTO userDTO : ldto) {
				System.out.println("4356547376");
				System.out.println(userDTO.getUser()+" "+userDTO.getPwd());
			}		
		//map.put("ulist",ldto);
	//	System.out.println("vhkjfgkdlfdlkghdfhgkjdh");
		return ldto;	
	}*/
	
	
	
	
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET, produces = { "application/json","application/xml"
	 })
	public @ResponseBody  UserDTO getOneUser(@RequestParam("name") String name) {
	
		 
		UserDTO  udto;
			udto=rservice.getOneUser(name);
		return udto;	
	}
	

	@RequestMapping(value="/getUser/{name}",method=RequestMethod.GET, produces = { "application/json","application/xml"
	 })
	public @ResponseBody  UserDTO getUser(@PathVariable("name") String name) {
		UserDTO  udto;
			udto=rservice.getOneUser(name);
		return udto;	
	}
	
	/*
	@RequestMapping(value="delete.htm",method=RequestMethod.GET)
	public String deletePage(Map<String,Object> map,@RequestParam("user") String username ) {
	String msg=	rservice.removeUser(username);			
	map.put("success",msg);
		return "userList";	

	}
	
	
	
	@RequestMapping(value="edit.htm",method=RequestMethod.GET)
	public String showeditPage(Map<String,Object> map ,@RequestParam("user") String username) {
	
	//public String showeditPage(Map<String,Object> map,@RequestParam("user") String username ) {
	//String msg=	rservice.editUser(username);			
	//UserDTO dto= rservice.getOneUser(username);
	
	EditCommand user=null;
	user= new EditCommand();
	
	user.setUser(username);
	map.put("eCmd",user);
	
	
	System.out.println(user.getUser()+"  get method");
	
	System.out.println(user.getPwd()+"  get method");
		return "edit";	

	}
	
	
	@RequestMapping(value="edit.htm", method = RequestMethod.POST) 
	//public String displayLogin(Map<String,Object> map,@Valid @ModelAttribute("eCmd")EditCommand cmd,BindingResult errors,@RequestParam("user") String username) {
		
	public String displayLogin(Map<String,Object> map,@RequestParam("user") String username,HttpServletRequest req) {
	
	    //model.addAttribute("login", new Login()); 
	
		String s=req.getParameter("user");
		String p=req.getParameter("pwd");
		UserDTO dto=null;
		dto= new UserDTO();
		
		dto.setUser(s);  dto.setPwd(p);
		

	//	System.out.println(cmd.getPwd()+"   cmd.getPwd()");
	//	System.out.println(cmd.getUser()+"   cmd.getUser()");
		//BeanUtils.copyProperties(cmd, dto);
		
		
		//String s= dto.getUser();
		
		
		
		System.out.println(dto.getPwd()+"   dto.getPwd()");
		System.out.println(dto.getUser()+"   dto.getUser()");
		
		System.out.println(s);
		System.out.println(dto.getPwd()+"   dto.getPwd()");
		
		System.out.println(s  +" ....s..... s...   ");
		
		System.out.println(p +" ....p..... p...   ");
		String result=rservice.editUser(dto);
		
		
		
	
		map.put("result",result);
			
		
		return "result";
		
		
		//System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbbbbb");
	 //   return "UserList"; 
	}
	*/

}
