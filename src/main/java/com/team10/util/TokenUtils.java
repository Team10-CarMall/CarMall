package com.team10.util;

import com.sun.xml.internal.ws.resources.UtilMessages;
import io.jsonwebtoken.*;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

public class TokenUtils {

    //过期时间（一天）
    private static  long time = 1000 * 60 * 60 * 24;

    private static String signature = "team10-CarMall";
    public static String getToken(String userName,String password){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //payload
                .claim("username", userName)
                .claim("password", password)
                .setSubject("carMall")
                .setExpiration(new Date(System.currentTimeMillis() + time))
                //signature
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();
        return jwtToken;
    }

    public static Boolean checkToken(String token) {
        if (token == null) {
            return false;
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(signature).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
