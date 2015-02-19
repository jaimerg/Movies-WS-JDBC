package com.example.library;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by albertomendezhernandez on 23/1/15.
 */
public class TematicaMapper implements RowMapper<Tematica> {

    @Override
    public Tematica mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Tematica(rs.getLong("id"),rs.getString("tematica"));
    }
}
