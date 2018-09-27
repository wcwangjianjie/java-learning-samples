package com.wjj.base;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 作者：wangjj
 * @version 版本：
 * @createTime 创建时间：2018-08-09 14:43
 * @discription 类说明：反射练习
 */
public class ReflectTest {
    public static String[] NO_CHECK_FIELD = {};

    public static void main(String[] args) throws Exception {
        Student[] students = new Student[2];
        Student student = new Student("学生1");
        Student student1 = new Student("学生2");
        students[0] = student;
        students[1] = student1;
        List<String> list = new ArrayList<>();
        list.add("aaaa");
        list.add("bbbb");
        List<String[]> list2 = new ArrayList<>();
        list2.add(new String[]{"string1", "string2"});
        Teacher teacher = new Teacher("<html>aaaaaaaaa</html>", students, new String[]{"111", "2222"}, list, list2);
        reflectFilter(teacher, NO_CHECK_FIELD);
        System.out.println(teacher.getList2().get(0)[0]);
    }

    public static void reflectFilter(Object object,String[] s) throws Exception{
        Class<?> clazz = object.getClass();
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            // 获取反射类的所有字段
            Field[] fields = clazz.getDeclaredFields();
            Method[] methods = clazz.getMethods();
            for (int i = 0; i < fields.length; i++) {
                // 获取属性名称
                String name = fields[i].getName();
                System.out.println(name);

                // 获取属性的类型
                String type = fields[i].getGenericType().toString();
                System.out.println(type);

                // 如果type是引用类型，则前面包含"class"，后面跟引用的类名.例如：class(空格)java.lang.String
                fieldFilter(object, type, name);
            }
        }
    }

    /**
     * 检查是否是需要进行过滤的字段类型，如果是，则进行过滤
     * @param object class对象
     * @param genericType 属性类型
     * @param name 字段名称
     * @throws Exception
     */
    public static void fieldFilter(Object object, String genericType, String name) throws Exception {
        if (!Arrays.asList(ReflectTest.NO_CHECK_FIELD).contains(name)) {
            // 方法名称
            String methodName = name.substring(0, 1).toUpperCase() + name.substring(1);
            // 获取get方法
            Method method = object.getClass().getMethod("get" + methodName);
            switch (genericType) {
                case "class java.lang.String":
                    // 调用getter方法获取属性值
                    String value = (String) method.invoke(object);
                    System.out.println(value);
                    // .....处理开始String类型的value值........
                    // 过滤
                    value = "String过滤" + value;
                    //value = XSSUtils.xssFilteAndEncode(value, false);
                    // .....处理结束........
                    method = object.getClass().getMethod("set" + methodName, String.class);
                    method.invoke(object, value);
                    break;
                case "class [Ljava.lang.String;":
                    String[] values = (String[]) method.invoke(object);
                    for (int i=0; i<values.length; i++) {
                        values[i] = "String[]过滤" + values[i];
                        System.out.println(values[i]);
                    }
                    method = object.getClass().getMethod("set" + methodName, String[].class);
                    method.invoke(object, (Object) values);
                    break;
                case "java.util.List<java.lang.String>":
                    List<String> list = (List<String>) method.invoke(object);
                    for (int i=0; i<list.size(); i++) {
                        list.set(i, "List<String>过滤" + list.get(i));
                        System.out.println(list.get(i));
                    }
                    method = object.getClass().getMethod("set" + methodName, List.class);
                    method.invoke(object, (Object) list);
                    break;
                case "java.util.List<java.lang.String[]>":
                    List<String[]> list2 = (List<String[]>) method.invoke(object);
                    for (int i=0; i<list2.size(); i++) {
                        String[] listStringsValue = list2.get(i);
                        for (int j=0; j<listStringsValue.length; j++) {
                            listStringsValue[j] = "List<String[]>过滤" + listStringsValue[j];
                            System.out.println(listStringsValue[j]);
                        }
                    }
                    method = object.getClass().getMethod("set" + methodName, List.class);
                    method.invoke(object, (Object) list2);
                    break;
                /*case "" :
                    result = true;
                case "" :
                    result = true;
                case "" :
                    result = true;
                case "" :
                    result = true;
                case "" :
                    result = true;*/
            }
        }
    }
}

class Animal {
    public String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Teacher extends Animal {
    private String mzjol;
    // 关联字段
    private Student[] student;
    // 字符串数组
    private String[] aa;
    // 集合 List, Map...
    List<String> list;
    // 集合数组
    List<String[]> list2;
    //

    public Teacher(String mzjol, Student[] student, String[] aa, List<String> list, List<String[]> list2) {
        super("Animal");
        this.mzjol = mzjol;
        this.student = student;
        this.aa = aa;
        this.list = list;
        this.list2 = list2;
    }

    public String getMzjol() {
        return mzjol;
    }

    public void setMzjol(String mzjol) {
        this.mzjol = mzjol;
    }

    public Student[] getStudent() {
        return student;
    }

    public void setStudent(Student[] student) {
        this.student = student;
    }

    public String[] getAa() {
        return aa;
    }

    public void setAa(String[] aa) {
        this.aa = aa;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String[]> getList2() {
        return list2;
    }

    public void setList2(List<String[]> list2) {
        this.list2 = list2;
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}