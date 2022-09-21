package com.jin.practice.TestMethodRef;

import com.jin.practice.lambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TestStream {
    List<Employee> emps = Arrays.asList(
            new Employee("张三",26,58795, Employee.Status.BUSY),
                new Employee("张三",26,58795, Employee.Status.FREE),
                new Employee("张三",26,58795, Employee.Status.VOCATION),
                new Employee("张三",26,58795, Employee.Status.BUSY)
        );
    @Test
    public void test(){
        //1.通过集合Collection系列集合获取
        Stream<Employee> stream = emps.stream();
        //2.通过Arrays.stream获取
        Employee[] emp = new Employee[10];
        Stream<Employee> stream1 = Arrays.stream(emp);
        //3.通过stream中静态方法of获取流
        Stream<String> stream2 = Stream.of("a", "b", "c");
        //4.创建无限流
        Stream<Integer> stream3 = Stream.iterate(0, (x) -> x + 2);
        //5.生成流
        Stream.generate(()->Math.random())
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void test2(){
         emps.stream()
                 //过滤操作里面传进去一个断言型的接口
                 .filter(e->e.getAge()>25)
                 //跳过符合条件的两个参数并输出剩下的部分
                 .skip(2)
                 //截取符合条件的前两个
                 .limit(2)
                 //去重操作
                 .distinct()
                 //遍历操作，里面传进去一个消费者类型接口
                 .forEach(System.out::println);
    }

    @Test
    public void test3(){
        List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    @Test
    public void test4(){
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    @Test
    public void test5(){
        List<Object> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);

        List<Object> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list2.add(1);
        list2.add(list);
        list2.addAll(list);
        System.out.println(list2);
    }

    @Test
    public void test6(){
        List<String> list = Arrays.asList("aa","bb","fff","dd","ee");
        list.stream()
                //自然排序
                .sorted()
                //按照字符串长短排序
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::print);
    }








}
