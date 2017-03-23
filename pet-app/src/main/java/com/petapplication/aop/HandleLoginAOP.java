package com.petapplication.aop;

import com.petapplication.exception.UnauthorizedExceptionHandler;
import com.petapplication.utility.JWTUtils;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author admin
 */
@Component
@Aspect
public class HandleLoginAOP {

    @Autowired
    private HttpServletRequest servletRequest;

    @Before("within(com.petapplication.controller.*) "
            + "&& !execution(* com.petapplication.controller.AuthenticationController.authenticate(..))")
    public void handelTokenBasedAuth(JoinPoint joinPoint) {
        String accessToken = servletRequest.getParameter("accessToken");
        if (accessToken != null && !accessToken.isEmpty()) {
            JWTUtils.parseToken(accessToken);
        } else {
            throw new UnauthorizedExceptionHandler("Unauthorized access of resource");
        }
    }

    @Pointcut("execution(* *(..)) && within(com.petapplication..*)")
    public void logging() {
    }

    @Before("logging()")
    public void logBefore(JoinPoint joinPoint) {
        Logger LOG = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        LOG.info("METHOD NAME : {}", joinPoint.getSignature().getName());
        LOG.info("ARGUMENTS : {}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterThrowing(pointcut = "logging()", throwing = "e")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
        Logger LOG = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        LOG.error("AN EXCEPTION HAS BEEN THROWN IN : {}()", joinPoint.getSignature().getName());
        LOG.error("CAUSE : {}", e.getCause());
        LOG.error("MESSAGE : {}", e.getMessage());
    }

    @AfterReturning(pointcut = "logging()", returning = "object")
    public void logAfterReturning(JoinPoint joinPoint, Object object) {
        Logger LOG = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        LOG.info("EXITING FROM METHOD : {}()", joinPoint.getSignature().getName());
        LOG.info("RETURN VALUE : {}", object);
    }

}
