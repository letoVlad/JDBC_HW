package com.example.jdbc_hw.dao;



import com.example.jdbc_hw.model.Employee;

import java.util.List;


public interface EmployeeDAO {
    Employee addEmployee(Employee employee);
    Employee findById(Integer id);
    Boolean deleteId(Integer id);
    List<Employee> getAllEmployee();
    Employee editEmployee(Integer id, Employee employee);


}
