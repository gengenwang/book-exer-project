package com.rootwang.chap2;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * <p></p>
 *
 * @author gengen.wang
 * @version $$ Id: TestLambda.java, V 0.1 2018/6/1 下午8:49 wanggengen Exp $$
 **/
public class TestLambda {

    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> integers = new TreeSet<>(com);
    }

    //Lambda表达式
    @Test
    public void test2(){
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    //需求：获取当前公司中员工年龄大于35的员工信息



}
