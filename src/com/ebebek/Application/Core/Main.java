package com.ebebek.Application.Core;

import com.ebebek.Domain.Employee;
import com.ebebek.Infrastructure.DataAccess.EmployeeDAO;
import com.ebebek.Infrastructure.Utils.EmployeeUtils;

public class Main {

    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        //get initial employee infos
        Employee employee = employeeDAO.findByName("Batuhan");

        System.out.println(employee.toString());

        //update employee salary
        employee.setSalary(employee.getSalary()+EmployeeUtils.raiseSalary(employee));
        employeeDAO.updateEmployee(employee);

        //get updated employee infos
        employee = employeeDAO.findByName("Batuhan");
        System.out.println(employee.toString());

    }
}
