package com.gl.authentication.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class ApiException  extends RuntimeException{

  private static final long serialVersionUID = 1L;
  
  public ApiException(String message){
    super(message);
  }
  
 public ApiException(String message,Throwable cause){
    super(message,cause);
  }

}
