package com.ebebek.Infrastructure.DataAccess;

import com.ebebek.Domain.Employee;
import com.ebebek.Infrastructure.Interfaces.IEmployeeDAO;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    private List<Employee> employees;

    public EmployeeDAO() {
        this.employees = new ArrayList<Employee>();

        this.employees.add(new Employee(
                1,"Batuhan", 13000.0, 45,2021
        ));
        this.employees.add(new Employee(
                2,"Pepee", 15000.0, 8,2020
        ));
        this.employees.add(new Employee(
                3,"Keloğlan", 22000.0, 8,2018
        ));
        this.employees.add(new Employee(
                1,"Bilgecan Dede", 28000.0, 8,2012
        ));
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee findById(int id) {
        return employees.stream().filter(emp -> emp.getId() == id).findAny().orElse(null);
    }

    @Override
    public Employee findByName(String name) {
        return employees.stream().filter(emp -> emp.getName() == name).findAny().orElse(null);
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        Employee currentEmployee = employees.stream().filter(emp -> emp.getName() == employee.getName()).findAny().orElse(null);
        if (currentEmployee == null){
            return false;
        }
        this.employees.add(employee);
        return true;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        Employee currentEmployee = employees.stream().filter(emp -> emp.getId() == employee.getId()).findAny().orElse(null);
        if (currentEmployee == null){
            return false;
        }
        this.employees.set(this.employees.indexOf(currentEmployee),employee);

        return true;
    }



    @Override
    public boolean deleteEmployee(int id) {
        Employee currentEmployee = employees.stream().filter(emp -> emp.getId() == id).findAny().orElse(null);
        if (currentEmployee == null){
            return false;
        }
        this.employees.remove(currentEmployee);
        return false;
    }
}
