package com.dma.springboot.starter.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class UserAspect {

    private static final Logger logger = LoggerFactory.getLogger(UserAspect.class);

    @Before("execution(* com.dma.springboot.starter.service.UserService.findById(..))")
    public void findByIdBefore(JoinPoint joinPoint){
        logger.info("Executing Before findById advice");
    }

    @After("execution(* com.dma.springboot.starter.service.UserService.findById(..))")
    public void findByIdAfter(JoinPoint joinPoint){
        logger.info("Executing After findById advice");
    }

}
