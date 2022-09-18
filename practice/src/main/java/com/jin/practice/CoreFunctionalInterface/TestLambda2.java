package com.jin.practice.CoreFunctionalInterface;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestLambda2 {
    @Test
    public void test(){
        //Consumer接口
        happy(1000,(x)-> System.out.println("我花了"+x+"元"));

    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }

    @Test
    public void test2(){
        //Supplier接口
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    //产生指定的整数并放入集合中
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
        return list;
    }

    @Test
    public void test3(){
        //Function接口
        System.out.println(strHandler("zz", (str) -> str.toUpperCase()));
    }

    //处理字符串需求
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }

    @Test
    public void test4(){
        List<String> list = Arrays.asList("zz","ss","qqq","scde");
        //Predicate接口
        List<String> strings = filterStr(list, (str) -> {
            if (str.length() == 2) return true;
            else return false;
        });
        for (String string : strings) {
            System.out.println(string);
        }
    }

    //将满足的字符串放入到集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                strList.add(s);
            }
        }
        return strList;
    }
}
