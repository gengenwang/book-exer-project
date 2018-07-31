package com.rootwang.chap2;

import org.junit.Test;
import org.openjdk.jmh.generators.core.SourceThrowableError;

import java.nio.channels.Pipe;
import java.util.*;

/**
 * <p></p>
 *
 * @author gengen.wang
 * @version $$ Id: TestLambda.java, V 0.1 2018/6/1 下午8:49 wanggengen Exp $$
 **/
public class TestLambda {

    List<Employee> emps = Arrays.asList(
            new Employee(101, "张三", 18, 9999.99),
            new Employee(102, "李四", 59, 6666.66),
            new Employee(103, "王五", 28, 3333.33),
            new Employee(104, "赵六", 8, 7777.77),
            new Employee(105, "田七", 38, 5555.55)
    );

    //原来的匿名内部类
    @Test
    public void test1() {
        Comparator<Integer> com = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        TreeSet<Integer> integers = new TreeSet<>(com);
    }

    //Lambda表达式
    @Test
    public void test2() {
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        TreeSet<Integer> ts = new TreeSet<>(comparator);
    }

    @Test
    public void test3() {
        List<Employee> employees = filterEmployees(emps);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //需求：获取当前公司中员工年龄大于35的员工信息
    public List<Employee> filterEmployees(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getAge() >= 35) {
                emps.add(employee);
            }
        }
        return emps;
    }

    //需求：获取当前公司中员工工资大于5000的员工信息
    public List<Employee> filterEmployees2(List<Employee> list) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (employee.getSalary() >= 5000) {
                emps.add(employee);
            }
        }
        return emps;
    }

    @Test
    public void test4() {
        List<Employee> employees = filterEmployee(emps, new FilterEmployeeByAge());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("---------------------------");
        List<Employee> employeeList = filterEmployee(emps, new FilterEmployeeBySalary());
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    //优化方式一：策略设计模式
    public List<Employee> filterEmployee(List<Employee> list, MyPredicate<Employee> mp) {
        List<Employee> emps = new ArrayList<>();
        for (Employee employee : list) {
            if (mp.test(employee)) {
                emps.add(employee);
            }
        }
        return emps;
    }

    //优化方式二：匿名内部类
    @Test
    public void test5() {
        List<Employee> employees = filterEmployee(emps, new MyPredicate<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    //优化方式三：Lambda 表达式
    @Test
    public void test6(){
        List<Employee> employees = filterEmployee(emps, (e) -> e.getSalary() <= 5000);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("-------------------------");
        employees.forEach(System.out :: println);
    }

    //优化方式四：stream API
    @Test
    public void test7(){
        emps.stream()
                .filter((employee -> employee.getSalary() >= 5000))
                .forEach(System.out::println);
        System.out.println("-----------------------");
        emps.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }


}
