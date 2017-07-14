package com.company.base;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.Set;

/**
 * Created by Administrator on 2017/6/28 0028.
 */
public class JsonResponseUtil {

    private static Integer CODE_SUCCESS = 2000; // 请求成功
    private static Integer CODE_FAIL = 2001; // 请求失败
    private static Integer CODE_ERROR = 2002; // 请求数据出现错误


    public static JsonResponse success(Object data) {
        JsonResponse response = new JsonResponse();
        response.setCode(CODE_SUCCESS);
        response.setMsg("请求成功");
        response.setData(data);
        return response;
    }

    public static JsonResponse fail() {
        JsonResponse response = new JsonResponse();
        response.setCode(CODE_FAIL);
        response.setMsg("请求失败");
        return response;
    }

    private static void getInfo(Integer code){
        Properties prop = new Properties();
        InputStream inputStream = null;
        String fileName = "responseCode.properties";

//        try {
//            //读取属性文件
//            inputStream = JsonResponse.class.getClassLoader().getResourceAsStream(fileName);
//            prop.load(new InputStreamReader(inputStream, "UTF-8"));
//            if (inputStream == null) {
//                System.out.println("null string");
//            }
//            Set keySet = prop.keySet();
//            for (Object o : keySet) {
//                System.out.println(o + " = " + prop.get(o).toString());
//            }
//        } catch(Exception e){
//            System.out.println(e);
//        }
    }

    public static void main(String[] a){
        getInfo(1);
    }



}
