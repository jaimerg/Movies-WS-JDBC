package com.example.library;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by albertomendezhernandez on 23/1/15.
 */
public class ActorMapper implements RowMapper<Actor> {

    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Actor(rs.getLong("id"),rs.getString("first_name"),rs.getString("second_name"),rs.getString("sex"),rs.getDate("birth_date"));
    }
}
