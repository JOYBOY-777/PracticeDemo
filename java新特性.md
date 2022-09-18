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



**需要函数式接口的支持**

函数式接口：也就是接口中只有**一个抽象方法**的接口就是函数式接口

lambda简单使用：年龄一样按照名字比较，年龄不一样按照薪水比较

```java
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
```



## 四大内置核心函数式接口

**1.Consumer<T>**:消费者接口（有去无回）

​	void accept(T t);

``` java
    @Test
    public void test(){
        //Consumer接口
        happy(1000,(x)-> System.out.println("我花了"+x+"元"));

    }

    public void happy(double money, Consumer<Double> con){
        con.accept(money);
    }
```

**2.Supplier<T>**:生产者接口

​	T get();

```java
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
```



**3.Function<T,R>**:函数式接口,把T传进来进行一些操作从而返回一个R出来,用于做一些数据处理的接口

​	R apply(T t);

```java
    @Test
    public void test3(){
        //Function接口
        System.out.println(strHandler("zz", (str) -> str.toUpperCase()));
    }

    //处理字符串需求
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }
```



**4.Predicate<T>:**断言型接口,是一个判断型接口，传进去一个t进行一些判断返回是否正确

​	boolean test(T t);

```java
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
```



## 方法引用与构造器引用

































