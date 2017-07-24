package com.company.base;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class ApplicationLogger {

    // warn 级别及以上日志输出
    public static Log applicationLogger = LogFactory.getLog("applicationLogger");
    // debug级别到warn级别日志输出
    public static Log monitorLogger = LogFactory.getLog("monitorLogger");

//    public static void main(String[] args){
//
//        applicationLogger.warn("warn application");
//        applicationLogger.error("error application");
//
//        monitorLogger.debug("debug monitor");
//        monitorLogger.info("info monitor");
//        monitorLogger.warn("warn monitor");
//    }
}
