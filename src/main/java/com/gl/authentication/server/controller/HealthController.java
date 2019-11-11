package com.gl.authentication.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/health")
public class HealthController {
  
  @RequestMapping(value="/")
  public String status(){
    return "OK";
  }

}
