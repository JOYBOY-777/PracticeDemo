package com.jin.practice.TestMethodRef;

import com.jin.practice.lambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestSteam2 {
    List<Employee> emps = Arrays.asList(
            new Employee("张c三",26,558795.00, Employee.Status.BUSY),
            new Employee("张a三",86,58795.00, Employee.Status.FREE),
            new Employee("张444三",46,58795.00, Employee.Status.FREE),
            new Employee("张7985三",26,58795.00, Employee.Status.FREE),
            new Employee("张s三",36,58795.00, Employee.Status.VOCATION),
            new Employee("张s三",21,587.00, Employee.Status.BUSY)
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
        System.out.println("====================");
        Double collect2 = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect2);
        System.out.println("====================");
        Optional<Employee> collect3 = emps.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect3.get());
    }

    @Test
    public void test4(){
        Map<Employee.Status, List<Employee>> collect = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
        System.out.println("================================");
        Map<Employee.Status, Map<String, List<Employee>>> map = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else return "老年";
                })));
        System.out.println(map);
    }

    @Test
    public void test5(){
        Map<Boolean, List<Employee>> collect = emps.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 8000));
        System.out.println(collect);
        System.out.println("===========================");
        DoubleSummaryStatistics collect1 = emps.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(collect1.getMax());
        System.out.println(collect1.getAverage());
        System.out.println("=====================");
        String collect2 = emps.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(collect2);
    }





















    }





























