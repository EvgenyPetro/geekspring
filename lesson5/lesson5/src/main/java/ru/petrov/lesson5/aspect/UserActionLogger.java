package ru.petrov.lesson5.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class UserActionLogger {

    @Before("@annotation(TrackUserAction) && args(id)")
    public void userActionLogger(JoinPoint joinPoint, Long id) {
        log.error("Был вызван метод {} с аргументом {}", joinPoint.getSignature().getName(), id);
    }
}
