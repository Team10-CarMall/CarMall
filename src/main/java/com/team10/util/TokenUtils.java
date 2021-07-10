package com.team10.util;

import io.jsonwebtoken.*;

import java.util.Date;

public class TokenUtils {
    //过期时间（一天）
    private static  long time = 1000 * 60 * 60 * 24;

    private static String signature = "team10-CarMalljwod";
    public static String getToken(String userName,String password,String userId){
        JwtBuilder jwtBuilder = Jwts.builder();
        String jwtToken = jwtBuilder
                //header
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //payload
                .claim("username", userName)
                .claim("password", password)
                .claim("userId", userId)
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

    public static String getClaim(String token,String target) {
        if (token == null) {
            return "visitor";
        }
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(signature).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get(target);
    }
}
