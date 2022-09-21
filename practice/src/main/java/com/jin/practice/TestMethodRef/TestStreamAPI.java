package com.jin.practice.TestMethodRef;

import com.jin.practice.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestStreamAPI {
    List<Employee> emps = Arrays.asList(
            new Employee("张三",26,58795, Employee.Status.BUSY),
            new Employee("张三",26,58795, Employee.Status.FREE),
            new Employee("张三",26,58795, Employee.Status.VOCATION),
            new Employee("张三",26,58795, Employee.Status.BUSY)
    );
    @Test
    public void test(){
    }
}
