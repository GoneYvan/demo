package com.company.base;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class CommonServiceLocator {

    protected static ApplicationContext context;

    static {
        try {
            context = new ClassPathXmlApplicationContext(new String[]{"classpath*:/META-INF/spring/db/spring_*.xml",
                    "classpath*:/META-INF/spring/service/spring_*.xml"});
            ApplicationContextManager.regist(context);
        } catch (RuntimeException e) {
            ApplicationLogger.applicationLogger.error("", e);
            throw e;
        }
    }

    public static boolean hasInitFinish() {
        return context != null;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static Object getBean(String beanId) {

        return context.getBean(beanId);
    }

}
