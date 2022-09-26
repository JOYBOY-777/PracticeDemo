package com.jin.practice.ForkJoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/*
* 使用forkjoin框架实现数的累加操作
* */
public class  ForkJoinCalculate extends RecursiveTask<Long> {
    //起始点
    private Long start;
    //结束点
    private Long end;
    //拆分临界值
    private static final Long THRESHOLD = 10000l;

    public ForkJoinCalculate(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        Long length = end-start;
        //到临界值就进行最小区间的累加
        if (length<=THRESHOLD){
            Long sum = 0l;
            for (long i = start; i <= end ; i++) {
                sum+=i;
            }
            return sum;
        //不到临界值就进行拆分
        }else {
            Long middle = (start + end)/2;
            //左边到中间拆分
            ForkJoinCalculate left = new ForkJoinCalculate(start,middle);
            left.fork();//拆分子任务，同时压入线程队列
            //中间到最右边拆分
            ForkJoinCalculate right = new ForkJoinCalculate(middle+1,end);
            right.fork();
            //合并
            return left.join()+right.join();
        }
    }
}


class test{
    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0l,100000000l);
        long sum = pool.invoke(task);
        System.out.println(sum);
    }
}
