package com.lijianhua.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author 李建华
 * @date 2022/10/31
 * @comment
 */
@Aspect
public class LogAspects {

    @Pointcut("execution(public int com.lijianhua.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        System.out.println("@Before：" + joinPoint.getSignature().getName()
                + "运行。。。参数列表是：{" + Arrays.toString(joinPoint.getArgs()) + "}");
    }

    @After("com.lijianhua.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println("@After：" + joinPoint.getSignature().getName()
                + "结束。。。");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println("@AfterReturning：" + joinPoint.getSignature().getName()
                + "正常返回。。。运行结果是：{" + result + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void logException(JoinPoint joinPoint, Throwable ex) {
        System.out.println("@AfterThrowing：" + joinPoint.getSignature().getName() +
                "出现异常。。。异常信息是：{" + ex + "}");
    }
}
