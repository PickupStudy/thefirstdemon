package com.school.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    //密钥
    private static String signKey="school";
    //十二小时
    private static Long expire=43200000L;
    /**
     * 生成jwt令牌
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt=Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS256,signKey)
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .compact();
        return jwt;
    }
    /**解析令牌
     *
     */
    public static Claims parseJWT (String jwt){
        Claims claims=Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }

}
