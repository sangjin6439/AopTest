package com.example.aoptest.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Slf4j
@Aspect
public class TraceAspect {

    //파일 위치로 설정해야 함
    @Before("@annotation(com.example.aoptest.annotation.Trace)")
    public void doTrace(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        // joinPoint.getSignature() 실행되는 메서드를 알려줌
        // args 메서드에 전달되는 인자들을 나타낸다
        log.info("[trace] {} args={}", joinPoint.getSignature(), args);
    }
}
