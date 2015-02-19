/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.library;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 *
 */
public class MovieMapper implements RowMapper<Movie>{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Movie(rs.getLong("id"), rs.getString("title"), null, rs.getInt("numSells"), rs.getInt("publishedDate"), null);
    }
    
}
