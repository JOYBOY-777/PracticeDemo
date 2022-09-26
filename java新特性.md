# lambda表达式

## 基础语法

我感觉这个lambda表达式就是实现接口的一种方式，用简洁的方式重写接口里面的内容，利用接口里面的功能，就是我用最少的力气来使用接口里面的功能

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

方法引用：若Lambda体中的内容**有方法已经实现了**，我们可以使用方法引用，或者这个方法引用就是Lambda表达式的另外一种表现的形式,总体来说就是::前面的对象或者类调用了后面的方法,使用别人写好的，不用自己写

为什么叫方法引用？就是方法体中引用别人写好的方法来直接实现，不用自己写，前提是前后参数列表和返回值一致

**方法引用语法格式**

1. 对象::实例方法名

   ```java
    @Test
       public void test(){
           PrintStream ps = System.out;
           Consumer<String> con = (x)-> System.out.println(x);
           Consumer<String> con1 = (x)-> ps.println(x);
           Consumer<String> con2 = System.out::println;
       }
   ```

   发现System.out这个对象已经实现了println方法，那么就直接这样写，但是要可以这么写的条件是：通过Lambda表达式来实现的接口中的**参数列表还有返回值类型**要与方法引用中的方法**参数列表还有返回值相同**

   例子：

   ```java
    @Test
       public void test1(){
           Employee emp = new Employee();
           emp.setName("韩立");
           Supplier<String> sup = ()-> emp.getName();
           System.out.println(sup.get());
   
           Supplier<String> sup1 = emp::getName;
           System.out.println(sup1.get());
       }
   ```

2. **类::静态方法名**

   ```java
   @Test
       public void test2(){
           Comparator<Integer> comp = (x,y)->Integer.compare(x,y);
           Comparator<Integer> com = Integer::compare;
   }
   ```

   或者入参就是实现体中静态方法的参数

3. 类::实例方法名

```java
 @Test
    public void test3(){
        BiPredicate<String,String> bi = (x,y)->x.equals(y);
        BiPredicate<String,String> bip = String::equals;
    }
```

```java
@Test
       public void test3(){
           List<String> list = Arrays.asList("aa","bb","cc","dd","ee");
           list.stream()
               	//注意下面两种的区别
                   .map((x)->x.toUpperCase())
                   .map(String::toUpperCase)
                   .forEach(System.out::println);
       }
```

当发现方法体中的参数**前后一个是方法的调用者，后一个是方法的参数时就可以用这种方式**，也就是类名::**实例**方法,**或者是这个参数又完全的参与到后面的方法调用中，传进去一个参数，又用这个参数调用类中已经写好我的方法，这种情况也可以用类名::实例方法** ,**总之就是参数就是该方法的调用者就能这么写**,前面出现的参数又调用了后面已经写好的方法



**构造器引用与数组引用语法格式**

1. 构造器引用：

   ```java
   //ClassName::new   
   		@Test
             public void test4(){
                 Supplier<Employee> sup = () -> new Employee();
                 Supplier<Employee> sup1 = Employee::new;
             }
   ```

​        调用无参构造来实现，调用的那个构造器取决于使用前面接口中的参数  

2. 数组引用：

   ```java
   @Test
       public void test5(){
           Function<Integer,String[]> fun = (x)->new String[x];
           Function<Integer,String[]> fun1 = String[]::new;
       }
   ```

    就是创建数组用的



# Stream流

## 创建Stream流

```java
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
```

## 筛选与切片

```java
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
```

## 映射(map flatMap)

map:接收一个Function接口，将元素转化成其他元素或提取信息，这个Function会被用到**每个**元素上，并将其映射成一个新的元素，就是将每个元素都拿出来并用到这个函数上，然后**产生一个新流**并且得到结果

flatMap:如果出现流中还有好多流的格式，那么用这个后就不用循环遍历了，直接忽视里面的流，把里面流中的元素拿到外面，避免了双层遍历Stream<Stream<Character>>

```java
@Test
    public void test4(){
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
```

就跟下面的代码意思差不多

```java
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
```

排序：

```java
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
```

## 查找与匹配

1. allMatch:检查是否匹配所有元素

   ```java
   @Test
       public void test(){
           //查看员工状态是否都是忙碌
           System.out.println(emps.stream()
                   .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY)));
       }
   ```

2. anyMatch:检查是否有一个元素匹配

   ```java
   //查看员工有没有处于忙碌状态的
   System.out.println(emps.stream()
                   .anyMatch((e)->e.getStatus().equals(Employee.Status.BUSY)));
   ```

3. noneMatch:检查是否一个元素都不匹配

   ```java
   //查看是否一个元素都不匹配
   System.out.println(emps.stream()
                   .noneMatch((e)->e.getStatus().equals(Employee.Status.BUSY)));
   ```

4. findFirst:返回第一个元素

   ```java
   //返回流中第一个元素
   System.out.println(emps.stream()
                   .findFirst()
                   .get());
   ```

5. findAny:返回当前流中的任意元素

   ```java
   //随便返回流中的一个元素
   System.out.println(emps.stream()
                   .findAny()
                   .get());
   ```

6. count:返回流中元素的总个数

   ```java
   //返回流中个数
   System.out.println(emps.stream()
                   .count());
   ```

7. max:返回流中最小值

   ```java
   System.out.println(emps.stream()
                   .max(Comparator.comparingDouble(Employee::getAge))
                   .get());
   ```

   注意返回的是一个Optional用get取出里面的值

8. min:返回流中最大值

   ```java
   System.out.println(emps.stream()
                   .min(Comparator.comparingDouble(Employee::getAge))
                   .get());
   ```


## 规约与收集

**reduce**

1. reduce:可以将流中元素反复结合起来，得到一个值

   ```java
       @Test
       public void test(){
           List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9);
           Integer reduce = list.stream()
                   .reduce(0, (x, y) -> x + y);
           System.out.println(reduce);
       }
   ```

   得到结果45

   获取工资的总和：

   ```java
       @Test
       public void test1(){
           //获取工资的总和
           Double reduce = emps.stream()
                   //映射工资
                   .map(Employee::getSalary)
                   .reduce((double) 0, (e1, e2) -> e1 + e2);
           System.out.println(reduce);
       }
   ```

   ```java
           //一个参数的重载方法
           Optional<Double> aDouble = emps.stream()
                   .map(Employee::getSalary)
                   .reduce(Double::sum);
           System.out.println(aDouble.get());
   ```

   因为最后获取到的值有可能是空的



**collect**:用于给stream中的元素做汇总

```java
    @Test
    public void test2(){
        emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
```

把名字提取出来之后放到一个List集合中

```java
			emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
```

放到set中去重

```java
 emps.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new))
                .forEach(System.out::println);
```

放到自定义集合中去以hashset举例

 ```java
 Long collect = emps.stream()
                .collect(Collectors.counting());
 ```

获取总数

```java
 Double collect1 = emps.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
```

获取薪水平均值

```java
 Double collect2 = emps.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect2);
```

获取工资总和

```java
Optional<Employee> collect3 = emps.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect3.get());
```

获取最大值

```java
Optional<Employee> collect3 = emps.stream()
                .collect(Collectors.minBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(collect3.get());
```

获取最小值，这两种做法其实还不如直接用stream().min/max

```java
    @Test
    public void test4(){
        Map<Employee.Status, List<Employee>> collect = emps.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(collect);
    }
```

通过员工的状态分组，注意前面的接收条件

















