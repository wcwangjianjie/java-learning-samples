package com.wjj.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author 作者：wangjj
 * @version 版本：
 * @createTime 创建时间：2018-08-09 14:43
 * @discription 类说明：反射练习
 */
public class ReflectTest {
    public static String[] NO_CHECK_FIELD = {"zhhq.content", "zhhq.mainFx", "weixinnews.content", "kpdt.content", "zhhq.yhFx", "zhhq.xsFx",
            "zhhq.esfFx", "building.info", "news.neirong", "zhhq.fyFx", "mzjol", "kw4", "kw5", "kw6", "kw7", "kw8", "kw9"};

    public static void main(String[] args) throws Exception {
        Person person = new Person(1, "汪剑杰", 27, "中国", "mzjol");
        reflectFilter(person, NO_CHECK_FIELD);
        System.out.println(person.getNational());
        System.out.println(person.getName());
    }

    public static void reflectFilter(Object object,String[] s) throws Exception{
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            // 获取反射类的所有字段
            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getMethods();
            for (int i = 0; i < fields.length; i++) {
                // 字段名
                String name = fields[i].getName();
                //System.out.println(name);

                // 将属性的首字符大写，方便构造get，set方法
                String methodName = name.substring(0, 1).toUpperCase() + name.substring(1);
                String type = fields[i].getGenericType().toString(); // 获取属性的类型
                // 如果type是引用类型，则前面包含"class"，后面跟引用的类名.例如：class(空格)java.lang.String
                if (type.equals("class java.lang.String") && !Arrays.asList(s).contains(name)) {
                    Method method = object.getClass().getMethod("get" + methodName);
                    // 调用getter方法获取属性值
                    String value = (String) method.invoke(object);
                    System.out.println(value);
                    // .....处理开始String类型的value值........
                    // 过滤
                    value = value + "|字段过滤";
                    //value = XSSUtils.xssFilteAndEncode(value, false);
                    // .....处理结束........
                    method = object.getClass().getMethod("set" + methodName, String.class);
                    method.invoke(object, value);
                }
            }
        }
    }
}

class Animal {
    public long id;
    public int age;
    public String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Person extends Animal {
    private String national;
    private String mzjol;

    public Person(long id, String name, int age, String national, String mzjol) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.national = national;
        this.mzjol = mzjol;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getMzjol() {
        return mzjol;
    }

    public void setMzjol(String mzjol) {
        this.mzjol = mzjol;
    }
}
