package com.example.jdbc_hw.mappers;


import com.example.jdbc_hw.model.City;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper implements RowMapper<City> {
    @Override
    public City mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String city_name = rs.getString("city_name");
        return new City(id, city_name);
    }
}
