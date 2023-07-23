package com.inventorymanagement.commonservice.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@ConditionalOnExpression("${aspect.logging.enable} == true")
public class LoggingHandler {

    /**
     * This pointcut will find all public methods
     * inside a class annotated with @LoggableClass annotation
     */
    @Pointcut("within(@com.inventorymanagement.commonservice.annotations.LoggableClass *)")
    public void publicMethodInsideAClassAnnotatedWithLoggableClass() {
    }

    /**
     * This pointcut will find all public methods
     * annotated with @LoggableMethod annotation
     */
    @Pointcut("within(@com.inventorymanagement.commonservice.annotations.LoggableMethod *)")
    public void methodAnnotatedWithLoggableMethod() {
    }

    @Around("publicMethodInsideAClassAnnotatedWithLoggableClass() || methodAnnotatedWithLoggableMethod()")
    public Object logg(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = null;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        joinPoint.getArgs();
        try {
            proceed = joinPoint.proceed();
        } catch (Exception e) {
            log.error(e.getMessage());
            ExceptionUtils.rethrow(e);
        } finally {
            long executionTime = System.currentTimeMillis() - start;
            String inputValue = getObjectAsString(joinPoint.getArgs());
            String returnValue = getObjectAsString(proceed);
            log.info("Product Service Logging AOP - Method: {}.{}, Input value: {}, Return value: {}, Execution time:: {}ms",
                    methodSignature.getDeclaringType().getSimpleName(), methodSignature.getName(), inputValue,
                    returnValue, executionTime);
        }
        return proceed;
    }

    private String getObjectAsString(Object... args) {
        String returnValue = StringUtils.EMPTY;
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            returnValue = mapper.writeValueAsString(args);
        } catch (Exception e) {
            log.error(ExceptionUtils.getStackTrace(e));
        }
        return returnValue;
    }
}
