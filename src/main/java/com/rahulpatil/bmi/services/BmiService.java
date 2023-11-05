package com.rahulpatil.bmi.services;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.rahulpatil.bmi.models.BmiMapper;
import com.rahulpatil.bmi.models.BmiModel;

@Service
public class BmiService {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<BmiModel> getBmiList() {
        return jdbcTemplate.query(
                "select * from bmi",
                new BmiMapper());
    }
}
