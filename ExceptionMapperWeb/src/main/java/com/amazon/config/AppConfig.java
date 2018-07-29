package com.amazon.config;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.amazon.exection.mapper.InvalidInputExceptionMapper;
import com.amazon.resources.OrderResource;

@ApplicationPath("/rest/*")
public class AppConfig extends Application {
	private Set<Class<?>> classes;
	private Set<Object> singletons;

	public AppConfig() {
		classes = new HashSet<Class<?>>();
		singletons = new HashSet<Object>();
		classes.add(InvalidInputExceptionMapper.class);
		singletons.add(new OrderResource());
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}

	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
	
/*	@Override
	public Map<String, Object> getProperties() {
	
	Map<String, Object>  map= new  HashMap<String, Object>();
	
	map.put("jersey.config.server.provider.package","com.amazon.resources");
		
	
		return map;
	}*/

}
