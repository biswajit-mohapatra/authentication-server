package com.gl.authentication.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
public class BadRequestException  extends RuntimeException{

  private static final long serialVersionUID = 1L;
  
  BadRequestException(String message){
    super(message);
  }
  
  BadRequestException(String message,Throwable cause){
    super(message,cause);
  }

}
