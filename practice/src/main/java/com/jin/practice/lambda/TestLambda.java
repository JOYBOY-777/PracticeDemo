package com.jin.practice.lambda;

import org.junit.Test;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class TestLambda {
    List<Employee> emp = Arrays.asList(
            new Employee("张三",26,58795, Employee.Status.BUSY),
            new Employee("张三",26,58795, Employee.Status.FREE),
            new Employee("张三",26,58795, Employee.Status.VOCATION),
            new Employee("张三",26,58795, Employee.Status.BUSY)
    );


    @Test
    //1.实现接口无参无返回值
    public void test(){
        Runnable r = () -> System.out.println(66666);
        r.run();
    }

    //2.有参无返回值
    @Test
    public void test2(){
        Consumer c = (x) -> System.out.println(x);
        c.accept(11);
    }

    //3.有两个以上参数有返回值,并且实现体中有多条语句
    @Test
    public void test3(){
        Comparator<Integer> com = (x,y)->{
            System.out.println("我要开始比较了");
            return Integer.compare(x,y);
        };
    }

    @Test
    public void test4(){
        Collections.sort(emp,(e1,e2)->{
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getSalary(),e2.getSalary());
            }
        });

        for (Employee employee : emp) {
            System.out.println(employee);
        }
    }
}
