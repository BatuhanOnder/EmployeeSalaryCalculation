package com.ebebek.Infrastructure.Interfaces;

import com.ebebek.Domain.Employee;

import java.util.List;

public interface IEmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);


    Employee findByName(String name);

    boolean insertEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(int id);
}
