package org.spoto.aop;

import java.lang.annotation.*;

//自定义的注解
@Target({ElementType.PARAMETER,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Spotp {
    String name() default "";

    String opt() default "";
}
