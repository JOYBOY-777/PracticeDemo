package com.jin.practice.TestMethodRef;

import com.jin.practice.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestStreamAPI {
    List<Employee> emps = Arrays.asList(
            new Employee("张c三",26,58795.00, Employee.Status.BUSY),
            new Employee("张a三",26,58795.00, Employee.Status.FREE),
            new Employee("张s三",26,58795.00, Employee.Status.VOCATION),
            new Employee("张三",21,58795.00, Employee.Status.BUSY)
    );
    @Test
    public void test(){
        System.out.println(emps.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY)));
        System.out.println(emps.stream()
                .anyMatch((e)->e.getStatus().equals(Employee.Status.BUSY)));
        System.out.println(emps.stream()
                .noneMatch((e)->e.getStatus().equals(Employee.Status.BUSY)));
        System.out.println(emps.stream()
                .findFirst()
                .get());
        System.out.println(emps.stream()
                .findAny()
                .get());
        System.out.println(emps.stream()
                .count());
        System.out.println(emps.stream()
                .max(Comparator.comparingDouble(Employee::getAge))
                .get());
        System.out.println(emps.stream()
                .min(Comparator.comparingDouble(Employee::getAge))
                .get());
        emps.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
    }

}
