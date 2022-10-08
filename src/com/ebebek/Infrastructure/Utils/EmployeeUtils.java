package com.ebebek.Infrastructure.Utils;

import com.ebebek.Domain.Employee;

public class EmployeeUtils {
    private final static double TAX = 3;
    private final static int CURRENT_YEAR = 2021;



    public static double tax(double salary) {

        if (salary< 1000){
            return 0;
        }

        return (salary/100)*TAX;
    }

    public static double bonus(double workHours) {

        if (workHours <= 40){
            return 0;
        }
        return(workHours-40)*30;
    }

    public static double raiseSalary(Employee employee) {
        int seniority = CURRENT_YEAR - employee.getHireYear();
        if (seniority < 10){
            return (employee.getSalary() - bonus(employee.getWorkHours()) - tax(employee.getSalary())) * 0.05;
        }

        if (seniority < 20){
            return (employee.getSalary() - bonus(employee.getWorkHours()) - tax(employee.getSalary()))*0.10;
        }

        return (employee.getSalary() - bonus(employee.getWorkHours()) - tax(employee.getSalary()))*0.15;
    }
}
