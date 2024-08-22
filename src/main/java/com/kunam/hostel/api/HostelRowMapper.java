package com.kunam.hostel.api;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HostelRowMapper implements RowMapper<Hostel> {
    @Override
    public Hostel mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Hostel user = new Hostel();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setCity(rs.getString("city"));
        // Set other fields as necessary
        return user;
    }
}
