package cyj.hello_spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component // 스프링 빈에 등록, SpringConfig에서 직접 @Bean 등록해도 됨
public class TimeTraceAop {
    @Around("execution(* cyj.hello_spring..*(..))") // 시간 측정 로직을 어떤 부분에 적용하고 싶은지 명시
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{ //기존에 작성한 시간을 측정하는 코드
        long start = System.currentTimeMillis(); // joinPoint 객체가 넘겨가면서 execute() 메서드가 호출됨
        System.out.println("Start : " + joinPoint.toString());
        try{
            return joinPoint.proceed();

        }finally {
            long finish = System.currentTimeMillis();
            long timeMs=finish-start;
            System.out.println("End : " + joinPoint.toString()+" " + timeMs + "ms");
        }
    }

}

