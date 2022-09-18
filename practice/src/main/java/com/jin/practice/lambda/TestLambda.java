package com.jin.practice.lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda {
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



}
