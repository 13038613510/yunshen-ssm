package org.spoto.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service("aopDemo")
public class AopDemo {

    //前置方法
    public void beforeFun(JoinPoint joinPoint) throws Exception{
        Spotp spotp = hasClass(joinPoint);
        if (spotp != null){

            String name = spotp.name();
            String opt = spotp.opt();
            //执行业务代码
            System.out.println("beforeFun:name=" + name + ",opt=" + opt);
        }else {
            //没写注解
        }
    }

    //后置方法
    public void afterFun(JoinPoint joinPoint) throws Exception{
        Spotp spotp = hasClass(joinPoint);
        if (spotp != null){

            String name = spotp.name();
            String opt = spotp.opt();
            //不等于空，等于写了注解，执行业务代码
            System.out.println("afterFun:name=" + name + ",opt=" + opt);
        }else {
            //不写注解
        }
    }

    //判断是否有指定注解
    public Spotp hasClass(JoinPoint joinPoint) throws Exception{
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class<?> targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        for (Method method : methods){
            if (method.getName().equals(methodName)){
                Class<?>[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length){
                    //以上代码获取到B方法
                    //method就是B方法
                    //去查看B方法上是否有指定注解（Spoto)结果有两种可能（找到，没找到）
                    Spotp s = method.getAnnotation(Spotp.class);
                    return s;
                }
            }
        }
        return null;
    }

}
