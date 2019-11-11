package com.gl.authentication.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends RuntimeException{

  private static final long serialVersionUID = 1L;
  
  ResourceNotFoundException(String message){
    super(message);
  }
  
  ResourceNotFoundException(String message,Throwable cause){
    super(message,cause);
  }

}
