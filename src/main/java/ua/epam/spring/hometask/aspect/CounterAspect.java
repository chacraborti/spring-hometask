package ua.epam.spring.hometask.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class CounterAspect {

    private Map<Class<?>, Integer> counter = new HashMap<>();

    @Pointcut("execution(* ua.epam.spring.hometask.service.EventService.getById(..))")
    private void getEventById(){}


    @After("getEventById()")
    private void notifyGetEventById(JoinPoint joinPoint){
        Class<?> clazz = joinPoint.getTarget().getClass();
        if(!counter.containsKey(clazz)){
            counter.put(clazz, 0);
        }
        counter.put(clazz, counter.get(clazz)+1);
        System.out.println(joinPoint.getTarget().getClass());
    }

    @Pointcut("execution(* ua.epam.spring.hometask.domain.Event.getBasePrice(..))")
    private void getPrice(){}

    @After("getPrice()")
    private void notifyGetPrice(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget().getClass());
    }

    @Pointcut("execution(* ua.epam.spring.hometask.service.BookingService.bookTickets(..))")
    private void bookTicket(){}

    @After("bookTicket()")
    private void notifyBookTicket(JoinPoint joinPoint){
        System.out.println(joinPoint.getTarget().getClass());
    }

    public Map<Class<?>, Integer> getCounter() {
        return counter;
    }
}


