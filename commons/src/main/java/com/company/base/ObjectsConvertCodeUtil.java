package com.company.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Administrator on 2017/7/16 0016.
 * 控制对象的序列化和反序列化
 */
public class ObjectsConvertCodeUtil {

    /**
     * 将对象转化为字节数组
     * @param obj
     * @return
     */
    public static byte[] getObjectBytes(Object obj){
        byte[] bytes = null;
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(obj);
            bytes = bo.toByteArray();
            bo.close();
            oo.close();
        } catch (Exception e) {
//            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * 将字节数组转化为对象
     * @param bytes
     * @return
     */
    public static Object getBytesObject(byte[] bytes){
        Object obj = null;
        try {
            // bytearray to object
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);
            obj = oi.readObject();
            bi.close();
            oi.close();
        } catch (Exception e) {
//            System.out.println("translation" + e.getMessage());
            e.printStackTrace();
        }
        return obj;
    }

//    public static void main(String[] a){
//        // object
//        A aa = new A();
//        aa.name = "obj";
//        aa.age = 10;
//        byte[] bytes = getObjectBytes(aa);
//        System.out.println("序列化：" + bytes );
//        A newA = (A) getBytesObject(bytes);
//        System.out.println("反序列化：名称：" + newA.name + "  年龄：" + newA.age);
//
//        // list
//        List<A> list = new ArrayList<A>();
//        list.add(aa);
//        // 引用对象实例 （01同一对象引用）
//        aa.name = "list";
//        aa.age = 11;
//        list.add(aa);
//        list.add(new A("nextList", 12));
//        byte[] listBytes = getObjectBytes(list);
//        System.out.println("列表序列化：" + listBytes );
//        List<A> nList = (List) getBytesObject(listBytes);
//        System.out.println("列表反序列化：名称1：" + nList.get(0).name + "  年龄1：" + nList.get(0).age);
//        System.out.println("列表反序列化：名称2：" + nList.get(2).name + "  年龄2：" + nList.get(2).age);
//
//        // Map
//        HashMap map = new HashMap();
//        map.put("0", aa);
//        map.put("1", new A("map", 13));
//        byte[] mapBytes = getObjectBytes(map);
//        System.out.println("map序列化：" + mapBytes);
//        Map<String, A> nMap = (Map<String, A>) getBytesObject(mapBytes);
//        System.out.println("map反序列化：名称1：" + nMap.get("0").name + "  年龄1：" + nMap.get("0").age);
//        System.out.println("map反序列化：名称2：" + nMap.get("1").name + "  年龄2：" + nMap.get("1").age);
//        // Set
//        Set set = new HashSet();
//        set.add(aa);
//        set.add(new A("set", 14));
//        byte[] setBytes = getObjectBytes(set);
//        System.out.println("set序列化：" + setBytes);
//        Set<A> nSet = (Set<A>) getBytesObject(setBytes);
//        Iterator<A> iterator = nSet.iterator();
//        while (iterator.hasNext()){
//            A na = iterator.next();
//            System.out.println("set反序列化：名称：" + na.name + "  年龄：" + na.age);
//        }
//    }

}

//class A implements Serializable{
//    public String name;
//    public Integer age;
//    public A(String name, Integer age){
//        this.name = name;this.age = age;
//    }
//    public A(){}
//}
