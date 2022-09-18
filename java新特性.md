# lambda表达式

## 基础语法

我感觉这个lambda表达式就是实现接口的一种方式，用简洁的方式重写接口里面的内容，利用接口里面的功能

在java8中的lambda表达式通过->来把表达式拆分成为两部分：

1. 表达式的参数列表,实际上对应的就是**接口中抽象方法的参数列表**
2. 表达式中需要执行的功能，实际上就是需要对这个接口中的抽象方法的实现功能



**语法格式**

1. 无参无返回值

   ```java
   ()->System.out.print("xxx")
   //以Runnable接口为例子
    public class TestLambda {
       @Test
       public void test(){
           Runnable r = () -> System.out.println(66666);
       }
   }
   ```

2. 有参无返回值

   ```java
       //2.有参无返回值
       @Test
       public void test2(){
           Consumer c = (x) -> System.out.println(x);
           c.accept(11);
       }
   
       //2.有参无返回值，有一个参数小括号可以不写
       @Test
       public void test2(){
           Consumer c = x -> System.out.println(x);
           c.accept(11);
       }
   
   ```

3. 有两个以上参数，有返回值，方法体有多行

   ```java
       //3.有两个以上参数有返回值,并且实现体中有多条语句
       @Test
       public void test3(){
           Comparator<Integer> com = (x,y)->{
               System.out.println("我要开始比较了");
               return Integer.compare(x,y);
           };
       }
   
      //如果有多个参数，并且方法体中只有一条语句的话大括号还有return都可以不写
       @Test
       public void test3(){
           Comparator<Integer> com = (x,y)->Integer.compare(x,y);
       }
   ```

   

































