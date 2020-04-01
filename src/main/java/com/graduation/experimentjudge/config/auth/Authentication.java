package com.graduation.experimentjudge.config.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.graduation.experimentjudge.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Date;


/**
 * @author kurizcan
 */
@Component
public class Authentication {

    @Value("${info.secret}")
    public String secret;

    private static final long TOKEN_EXPIRED_TIME =  60 * 60;

    private final Logger logger = LoggerFactory.getLogger(Authentication.class);

    private final Algorithm algorithm = Algorithm.HMAC256(secret);

    public Authentication() throws UnsupportedEncodingException {

    }


    /**
     * 生成 token
     * @param user
     * @return
     */
    public String createToken(User user) {
        String token = "";
        Date now = new Date(System.currentTimeMillis());
        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();

        try {
            token = JWT.create()
                    .withClaim("uid", user.getId())
                    .withClaim("type", user.getType())
                    .withIssuedAt(now)
                    .withNotBefore(now)
                    .withExpiresAt(new Date(nowMillis + TOKEN_EXPIRED_TIME))
                    .sign(algorithm);
            logger.info("create token {} success", token);
        } catch (JWTCreationException ignore) {
            logger.error("token create fail");
        }
        return token;
    }

    /**
     * 测试是否过期
     * @param token
     * @return
     */
    public boolean validToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
        } catch (UnsupportedEncodingException exception){
            //UTF-8 encoding not supported
        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            logger.info("token: {} is invalid", token);
            return false;
        }
        return true;
    }

    /**
     * 获取类型
     * @param token
     * @return
     */
    public int getTypeFormToken(String token) {
        int type = JWT.decode(token).getClaim("type").asInt();
        logger.info("get type {} from token {}", type, token);
        return type;
    }

    /**
     * 获取用户 id
     * @param token
     * @return
     */
    public int getIdFormToken(String token) {
        int id = JWT.decode(token).getClaim("id").asInt();
        logger.info("get id {} from token {}", id, token);
        return id;
    }

}
