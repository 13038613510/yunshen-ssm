package org.spoto.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {

    public static Object getBean(String name) {
        String s = "applicationContext.xml";
        ApplicationContext conf = new ClassPathXmlApplicationContext(s);
        Object bean = conf.getBean(name);
        return bean;
    }

}
