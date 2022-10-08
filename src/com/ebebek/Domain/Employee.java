package com.ebebek.Domain;

import com.ebebek.Infrastructure.Utils.EmployeeUtils;

import java.util.Objects;

public class Employee {
    private int id;
    private String name;
    private Double salary;
    private int workHours;
    private int hireYear;

    public Employee() {
    }

    public Employee(int id, String name, Double salary, int workHours, int hireYear) {
        this.id = id;
        this.name = name;
        this.salary = salary + EmployeeUtils.bonus(workHours) - EmployeeUtils.tax(salary) ;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getHireYear() {
        return hireYear;
    }

    public void setHireYear(int hireYear) {
        this.hireYear = hireYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", workHours=" + workHours +
                ", hireYear=" + hireYear +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && workHours == employee.workHours && hireYear == employee.hireYear && name.equals(employee.name) && salary.equals(employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary, workHours, hireYear);
    }
}
