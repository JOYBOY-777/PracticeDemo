package com.jin.practice.TestMethodRef;

import com.jin.practice.lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestSteam2 {
    List<Employee> emps = Arrays.asList(
            new Employee("张c三",26,58795.00, Employee.Status.BUSY),
            new Employee("张a三",26,58795.00, Employee.Status.FREE),
            new Employee("张s三",26,58795.00, Employee.Status.VOCATION),
            new Employee("张s三",21,58795.00, Employee.Status.BUSY)
    );
    @Test
    public void test(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
    }

    @Test
    public void test1(){
        //获取工资的总和
        Double reduce = emps.stream()
                .map(Employee::getSalary)
                .reduce((double) 0, (e1, e2) -> e1 + e2);
        System.out.println(reduce);
        //一个参数的重载方法
        Optional<Double> aDouble = emps.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(aDouble.get());
    }

    @Test
    public void test2(){
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println("==========================");
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        System.out.println("===========================");
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
    }

    @Test
    public void test3(){
        Long collect = emps.stream()
                .collect(Collectors.counting());
        System.out.println(collect);
        System.out.println("====================");
        Double collect1 = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect1);
    }




























}
