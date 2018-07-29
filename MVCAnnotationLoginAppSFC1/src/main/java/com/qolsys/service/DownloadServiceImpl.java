package com.qolsys.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("dService")
public class DownloadServiceImpl implements DownloadService {
	
	public List<String> getAllFiles(){
		
		String dir="F:/Maven";
		File files[]=null;
		List<String> listFiles=null;
		
		File folder= new File(dir);
		
		if(folder.exists() && folder.isDirectory())
		{
			files=folder.listFiles();
			listFiles= new ArrayList<>();
			
			for (File file : files) {
				if(file.isFile())
				listFiles.add(file.getName());
				
			}
		}
		
		return listFiles;
		
	}

}
