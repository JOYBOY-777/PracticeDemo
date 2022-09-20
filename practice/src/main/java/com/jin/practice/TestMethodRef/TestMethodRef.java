package com.jin.practice.TestMethodRef;

import com.jin.practice.lambda.Employee;
import org.junit.Test;


import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class TestMethodRef {
    @Test
    public void test(){
        PrintStream ps = System.out;
        Consumer<String> con = (x)-> System.out.println(x);
        Consumer<String> con1 = (x)-> ps.println(x);
        Consumer<String> con2 = System.out::println;
    }

    @Test
    public void test1(){
        Employee emp = new Employee();
        emp.setName("韩立");
        Supplier<String> sup = ()-> emp.getName();
        System.out.println(sup.get());

        Supplier<String> sup1 = emp::getName;
        System.out.println(sup1.get());
    }

    @Test
    public void test2(){
        Comparator<Integer> comp = (x,y)->Integer.compare(x,y);
        Comparator<Integer> com = Integer::compare;
    }

    @Test
    public void test3(){
        BiPredicate<String,String> bi = (x,y)->x.equals(y);
        BiPredicate<String,String> bip = String::equals;
    }

    @Test
    public void test4(){
        Supplier<Employee> sup = () -> new Employee();
        Supplier<Employee> sup1 = Employee::new;
    }

    @Test
    public void test5(){
        Function<Integer,String[]> fun = (x)->new String[x];
        Function<Integer,String[]> fun1 = String[]::new;
    }
}
