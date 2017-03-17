package com.petapplication.utility;

import com.petapplication.entity.UserLoginInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

/**
 *
 * @author admin
 */
@Component
public class JWTUtils {

    public static final String SECRET = "dasdasdasd76sdf7fgjsdfg7dsftd7sfasdas";

    public String generateJWT(UserLoginInfo userLoginInfo) {
        String token;
        Claims claims = Jwts.claims().setSubject(userLoginInfo.getName());
        claims.put("id", userLoginInfo.getId());
        claims.put("profile", userLoginInfo.getProfileId());
        claims.put("status", userLoginInfo.getStatus());
        token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(DateUtils.addFiveMinuteToCurrentDate())
                .signWith(SignatureAlgorithm.HS256, SECRET).
                compact();
        return token;
    }

    public static void parseToken(String token) {
        Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        System.out.println("Claims"+claims.toString());

    }

}
