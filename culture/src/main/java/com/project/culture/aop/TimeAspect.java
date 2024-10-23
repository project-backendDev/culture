package com.project.culture.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeAspect {

    @Around("execution(* com.project.culture.movie.MovieUserController.movieList(..)")
    public Object checkExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis(); // 시작 시간

        Object proceed = joinPoint.proceed(); // 메소드 실행

        long endTime = System.currentTimeMillis(); // 종료 시간
        long duration = endTime - startTime; // 실행 시간

        System.out.println(joinPoint.getSignature() + " executed in " + duration + " milliseconds");
        
        return proceed;
    }
}
