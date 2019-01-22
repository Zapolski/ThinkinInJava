package by.zapolski.tasks;

import java.util.ArrayList;

public class Task8_page458 {

    public static void printHierarchy(Class clazz){
        if (clazz==null) return;
        System.out.println(clazz.getName());
        printHierarchy(clazz.getSuperclass());
    }

    public static void main(String[] args) {
        //printHierarchy(new ArrayList<String>().getClass());
        printHierarchy(java.util.ArrayList.class);

    }
}
