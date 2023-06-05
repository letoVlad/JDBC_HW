package com.example.jdbc_hw.mappers;


import com.example.jdbc_hw.model.City;
import com.example.jdbc_hw.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String firstName = rs.getString("first_name");
        String lastName = rs.getString("last_name");
        String gender = rs.getString("gender");
        int age = rs.getInt("age");
      //  City city = rs.getObject("city_id");
        return new Employee(id, firstName, lastName, gender, age, null);
    }
}
