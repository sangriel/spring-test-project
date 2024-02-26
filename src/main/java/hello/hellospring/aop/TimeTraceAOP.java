package hello.hellospring.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component //이렇게 하는 것보다 aop같은 경우는 가독성을 위해서 SpringConfig에서 설정해주는게 좋다고 함
@Aspect
public class TimeTraceAOP {

    @Around("execution(* hello.hellospring..*(..))") //실행시키는 조건을 넣는 것임, hello.hellospring 아래로는 다 적요시키겠다는 뜻
    public Object execute(ProceedingJoinPoint joinPoint) throws  Throwable {

        long start = System.currentTimeMillis();

        System.out.println("START : " + joinPoint.toString());

        try{
            return joinPoint.proceed();
        }
        finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;

            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms" );
        }

    }
}
