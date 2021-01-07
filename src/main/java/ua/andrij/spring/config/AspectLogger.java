package ua.andrij.spring.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class AspectLogger {

    private Logger logger;

    @Pointcut("execution(* ua.andrij.spring.controllers.*.*(..))")
    public void controllers() {
    }

    @Pointcut("execution(* ua.andrij.spring.dao.*.*(..))")
    public void dao() {
    }

    @Before("controllers() || dao()")
    public void controllerMethodBeginning(JoinPoint joinPoint) {
        logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
        if (joinPoint.getArgs().length != 0) {
            String args = Arrays.toString(joinPoint.getArgs());
            logger.debug("Method {}() was called with args {}", joinPoint.getSignature().getName(), args);
            return;
        }
        logger.debug("Method {}() was called...", joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "controllers() || dao()", returning = "retVal")
    public void controllerMethodAfter(JoinPoint joinPoint, Object retVal) {
        logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

        logger.debug("Method {}() returns=\"{}\"", joinPoint.getSignature().getName(), retVal);
    }
}
