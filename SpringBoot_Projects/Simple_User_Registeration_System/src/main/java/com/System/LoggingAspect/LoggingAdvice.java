package com.System.LoggingAspect;

import java.time.Duration;
import java.time.Instant;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAdvice {
	
	@Before("within(com.System.Service.*)")
	public void testing(JoinPoint jp){
		//advice goes here
		log.info("The method " + jp.getSignature().toString() + " is about to run");
	}
	
	@AfterReturning("within(com.System.Service.*)")
	public void afterReturning(JoinPoint jp) {
		//advice goes here
		log.info("The method " + jp.getSignature().toString() + " has ran");
	}
	
	
	@AfterThrowing(pointcut = "within(com.System.Service.*)", throwing = "ex")
	public void afterThrowingError(JoinPoint jp, Throwable ex) {
		//advice goes here
		log.error("Exception in method: " + jp.getSignature().toShortString(), ex);
	}
	
    
    @Around("annotation(com.System.Config.TrackExecutionTime)")
    public void executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
    	log.info(joinPoint.getSignature().toString() + " method execution start");
        Instant start = Instant.now();
        joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        log.info("Time took to execute the method : "+timeElapsed);
        log.info(joinPoint.getSignature().toString() + " method execution end");
    }
	

}
