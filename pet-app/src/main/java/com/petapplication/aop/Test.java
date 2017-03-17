package com.petapplication.aop;

import com.petapplication.exception.UnauthorizedExceptionHandler;
import com.petapplication.utility.JWTUtils;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author admin
 */
@Component
@Aspect
public class Test {

    @Autowired
    private HttpServletRequest servletRequest;

    @Before("within(com.petapplication.controller.*) "
            + "&& !execution(* com.petapplication.controller.AuthenticationController.authenticate(..))")
    public void before(JoinPoint joinPoint) {
        System.out.println("join point" + joinPoint.toString());
        System.out.println("servletRequest" + servletRequest.getParameter("accessToken"));
        String accessToken = servletRequest.getParameter("accessToken");
        if (accessToken != null && !accessToken.isEmpty()) {
            JWTUtils.parseToken(accessToken);
        } else {
            throw new UnauthorizedExceptionHandler("Unauthorized access of resource");
        }

    }
//    @Before("within(com.petapplication.controller.*)")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("join point" + joinPoint.toString());
//        System.out.println(Arrays.toString(joinPoint.getArgs()));
//
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        Method method = methodSignature.getMethod();
//        System.out.println("method" + method);
//        RequestMethod[] requestMethods = method.getAnnotation(RequestMapping.class).method();
//        System.out.println("requestMethods" + requestMethods);
//    }

}
