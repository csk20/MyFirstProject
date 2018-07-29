package com.amazon.exection.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.amazon.exception.InvalidInputException;

@Provider
public class InvalidInputExceptionMapper implements
		ExceptionMapper<InvalidInputException> {

	public Response toResponse(InvalidInputException exception) {
		return Response.status(404).entity(exception.getMessage()).build();
	}

}
