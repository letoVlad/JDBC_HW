package com.example.jdbc_hw.controllers;


import com.example.jdbc_hw.dao.CityDAOImpl;
import com.example.jdbc_hw.dao.EmployeeDAOImpl;
import com.example.jdbc_hw.model.City;
import com.example.jdbc_hw.model.Employee;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
    private final EmployeeDAOImpl applicationDAOEmployee;

    public EmployeeController(EmployeeDAOImpl applicationDAOEmployee) {
        this.applicationDAOEmployee = applicationDAOEmployee;
    }

    @Operation(summary = "Добавить нового сотрудника")
    @PostMapping
    public Employee addNewEmployee(@RequestBody Employee employee) {
        applicationDAOEmployee.addEmployee(employee);
        return employee;
    }

    @Operation(summary = "Получить сотрудника")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        Employee employee = applicationDAOEmployee.findById(id);
        return employee != null ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Удалить сотрудника")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteIngredients(@PathVariable int id) {
        return applicationDAOEmployee.deleteId(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Получить всех сотрудников")
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> allEmployee = applicationDAOEmployee.getAllEmployee();
        return ResponseEntity.ok(allEmployee);
    }

    @Operation(summary = "Редактировать сотрудника")
    @PutMapping("/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee employee1 = applicationDAOEmployee.editEmployee(id, employee);
        return employee1 != null ? ResponseEntity.ok(employee1) : ResponseEntity.notFound().build();
    }
}
