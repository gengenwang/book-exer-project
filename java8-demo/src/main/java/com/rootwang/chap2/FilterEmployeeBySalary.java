package com.rootwang.chap2;

/**
 * <p>注释</p>
 *
 * @author wanggengen
 * @version $ Id: FilterEmployeeBySalary.java, v 0.1 2018/7/31 23:16 wanggengen Exp $$
 **/
public class FilterEmployeeBySalary implements MyPredicate<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getSalary() >= 5000;
    }
}
