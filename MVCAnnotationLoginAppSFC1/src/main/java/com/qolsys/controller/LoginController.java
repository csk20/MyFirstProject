package com.qolsys.controller;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qolsys.command.EditCommand;
import com.qolsys.command.RegisterCommand;
import com.qolsys.command.UploadCommand;
import com.qolsys.command.UserCommand;
import com.qolsys.dto.RegisterDTO;
import com.qolsys.dto.UserDTO;
import com.qolsys.service.DownloadServiceImpl;
import com.qolsys.service.LoginServiceImpl;
import com.qolsys.service.RegisterServiceImpl;

@Controller
public class LoginController {
	
	
	@Autowired
	private LoginServiceImpl service;
	
	@Autowired
	private RegisterServiceImpl rservice;
	
	@Autowired
	private DownloadServiceImpl dservice;
	
	@RequestMapping(value="login.htm",method=RequestMethod.GET)
	public String showPage(Map<String,Object> map) {
		
		UserCommand user=null;
		user= new UserCommand();
		map.put("userCmd",user);
		return "login";	
	}
	
	
	@RequestMapping(value="login.htm",method=RequestMethod.POST)
	public String processPage(Map<String,Object> map,@Valid @ModelAttribute("userCmd")UserCommand cmd,BindingResult errors) {
		
		UserDTO dto=null;
		dto= new UserDTO();
		
		BeanUtils.copyProperties(cmd, dto);
		
		String result=service.verify(dto);
		map.put("result",result);
			
		
		return "result";	
		
	}
	
	
	@RequestMapping(value="register.htm",method=RequestMethod.GET)
	public String formPage(Map<String,Object> map) {
		
		RegisterCommand user=null;
		user= new RegisterCommand();
		map.put("regCmd",user);
	
		return "register";	
		
	}

	
	
	@RequestMapping(value="register.htm",method=RequestMethod.POST)
	public String registerPage(Map<String,Object> map,@Valid @ModelAttribute("regCmd")RegisterCommand cmd,BindingResult errors) {
	
		RegisterDTO dto=null;
		dto= new RegisterDTO();
		BeanUtils.copyProperties(cmd, dto);
		System.out.println("--------------------------------"); 
		 System.out.println(cmd.getUserid());
		 System.out.println("--------------------------------");
	
		
		String result=rservice.save(dto);
		map.put("result",result);

		
		return "register";	
		
	}
	
	
	@RequestMapping(value="list.htm",method=RequestMethod.GET)
	public String userPage(Map<String,Object> map) {
	
		 
		 List<UserDTO>  ldto;
			ldto=rservice.getAllUser();
			for (UserDTO userDTO : ldto) {
				System.out.println("4356547376");
				System.out.println(userDTO.getUser()+" "+userDTO.getPwd());
			}		
		map.put("ulist",ldto);
		System.out.println("vhkjfgkdlfdlkghdfhgkjdh");
		return "userList";	
	}
	
	
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
	
	@RequestMapping(value="upload.htm",method=RequestMethod.GET)
	public void uploadPage(@ModelAttribute("uploadCmd")UploadCommand cmd) {
		
	}
	
	
	@RequestMapping(value="upload.htm",method=RequestMethod.POST)
	public String uploadPage(Map<String,Object> map,@Valid @ModelAttribute("uploadCmd")UploadCommand cmd,BindingResult errors) throws IOException {
		
	/*	UserDTO dto=null;
		dto= new UserDTO();
		
		BeanUtils.copyProperties(cmd, dto);
		
		String result=service.verify(dto);
		map.put("result",result);
			
		
		return "result";*/	
		String dir="F:/xyz";
		File destinationDir=null;
		InputStream is=null;
		OutputStream os=null;
		String fname=null;
		MultipartFile file=null;
		destinationDir= new File(dir);
		if(!destinationDir.exists())
			destinationDir.mkdirs();
		file=cmd.getFile();
		fname=file.getOriginalFilename();
		
		is=file.getInputStream();
		
		os=new FileOutputStream(destinationDir.getAbsolutePath()+"/"+fname);
		
		IOUtils.copy(is, os);
		is.close();
		os.close();
		map.put("file1", fname);
	return "success";
}
	@RequestMapping(value="home.htm",method = RequestMethod.GET)
	public String downloadList(Map<String,Object>  map) {
		List<String> list=null;
		
		list=dservice.getAllFiles();
		map.put("fileList",list);
		return "download";
		
	}
	
	@RequestMapping(value="xyz.htm",method = RequestMethod.GET)
	public void download(@RequestParam("file") String file,HttpServletResponse response) throws IOException {
		
		InputStream  is=null;
		OutputStream os=null;

		is= new FileInputStream("F:/Maven/"+file);

	os=	response.getOutputStream();
	      response.setHeader("Content-Disposition", "attachment;filename=" + file);
	     
		IOUtils.copy(is, os);
		is.close();
		os.close();
	}//method
	
	@RequestMapping(value = "/report.htm", method = RequestMethod.GET)
	public String getExcel(Map<String,Object>  map,HttpServletRequest req) {
		 List<UserDTO>  ldto;
			ldto=rservice.getAllUser();
			 if(req.getParameter("type").equalsIgnoreCase("excel")){
				 map.put("userList", ldto);
				 return "ExcelView";
			 }
			 else{
				 map.put("userList", ldto);
				 return "PdfView";
			 }
			
		
	}

	

}
