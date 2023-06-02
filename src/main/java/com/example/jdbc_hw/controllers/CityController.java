package com.example.jdbc_hw.controllers;

import com.example.jdbc_hw.dao.CityDAOImpl;
import com.example.jdbc_hw.model.City;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/City")
public class CityController {
    private final CityDAOImpl applicationDAOCity;

    public CityController(CityDAOImpl applicationDAOCity) {
        this.applicationDAOCity = applicationDAOCity;
    }

    @Operation(summary = "Получить город")
    @GetMapping("/{cityId}/city")
    public ResponseEntity<City> getCity(@PathVariable int cityId) {
        City city = applicationDAOCity.findByIdCity(cityId);
        return city != null ? ResponseEntity.ok(city) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Получить список людей проживающих в определенном городе")
    @GetMapping("/{cityId}/employees")
    public ResponseEntity<List<String>> listResponseEntity(@PathVariable int cityId) {
        List<String> employees = applicationDAOCity.employeeList(cityId);
        return ResponseEntity.ok(employees);
    }

}
