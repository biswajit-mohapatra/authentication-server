package com.gl.authentication.server.payload;

import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class SignupRequest  implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @NotBlank
  @Size(min=4,max=50)
  private String name;
  
  @NotBlank
  @Size(min=3,max=20)
  private String userName;
  
  @NotBlank
  @Size(max=50)
  @Email
  private String email;
  
  @NotBlank
  @Size(min=6,max=15)
  private String password;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  
}
