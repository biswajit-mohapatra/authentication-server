package com.gl.authentication.server.security;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenManager {

  private static final Logger logger = LoggerFactory.getLogger(JwtTokenManager.class);

  @Value("${app.jwtSecret}")
  private String secret;

  @Value("${app.jwtExpirationInMs}")
  private int expirationInMs;

  @SuppressWarnings("deprecation")
  public String generateToken(Authentication authentication) {

    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

    Date now = new Date();
    
    System.out.println(">>>>>>>>>>>>>>>>expirationInMs>>>>>>>>>>>>"+expirationInMs);
    System.out.println(">>>>>>>>>>>>>>>>secret>>>>>>>>>>>>"+secret);

    Date expiryDate = new Date(now.getTime() + expirationInMs);

    return Jwts.builder().setSubject(Long.toString(userPrincipal.getId())).setIssuedAt(new Date())
        .setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, secret).compact();

  }


  public Long getUserIdFromToken(String token) {
    Claims claim = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    return Long.parseLong(claim.getSubject());
  }

  public boolean validateToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(secret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException ex) {
      logger.error("Invalid JWT signature");
    } catch (MalformedJwtException ex) {
      logger.error("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
      logger.error("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
      logger.error("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
      logger.error("JWT claims string is empty.");
    }
    return false;
  }

}
