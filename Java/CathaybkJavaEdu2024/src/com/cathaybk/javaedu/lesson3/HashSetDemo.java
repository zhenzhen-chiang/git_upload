package com.cathaybk.javaedu.lesson3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        
        Set<Student> students = new HashSet<>();
        //建立一個HashSet儲存Student物件
        students.add(new Student("Justin", "B835031"));
        students.add(new Student("Monica", "B835032"));
        students.add(new Student("Justin", "B835031"));
        //在students集合中加入Student物件 名稱是Justin 學號是B835031
        System.out.println(students);

        Set<String> strSet = new HashSet<>();
        //建立一個HashSet儲存String物件
        strSet.add("12");
        strSet.add(new String("1"));
        strSet.add(new String("1"));
        System.out.println(strSet);
        
        
        List<String>list = new ArrayList<>();
        
        list.add(new String("1"));
        list.add("1");
        list.add(new String("1"));
        list.add(new String("12"));
        list.add(new String("3"));
        System.out.println(list);
        

        System.out.println("1".equals(new String("1")));
        System.out.println(new String("1").equals(new String("1")));
    }
}
