package com.rootwang.chap2;

/**
 * <p>注释</p>
 *
 * @author wanggengen
 * @version $ Id: FilterEmployeeByAge.java, v 0.1 2018/7/31 23:09 wanggengen Exp $$
 **/
public class FilterEmployeeByAge implements MyPredicate<Employee> {

    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
