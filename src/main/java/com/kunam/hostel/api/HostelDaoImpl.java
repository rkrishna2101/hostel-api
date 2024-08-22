package com.kunam.hostel.api;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class HostelDaoImpl implements HostelDao {

    private JdbcTemplate jdbcTemplate;

    public HostelDaoImpl() {
        this.jdbcTemplate = new DatabaseConnection().jdbcTemplate();
    }

    private RowMapper<Hostel> rowMapper = new RowMapper<Hostel>() {
        public Hostel mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Hostel user = new Hostel();
            user.setId(rs.getLong("id"));
            user.setName(rs.getString("name"));
            user.setCity(rs.getString("city"));
            return user;
        }
    };

    @Override
    public List<Hostel> findAll() {
        return jdbcTemplate.query("SELECT * FROM hostel", new HostelRowMapper());
    }

    @Override
    public Hostel findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM hostel WHERE id = ?", new Object[]{id}, new HostelRowMapper());
    }

    @Override
    public void save(Hostel hostel) {
        jdbcTemplate.update("INSERT INTO hostel (name, city) VALUES (?, ?)", hostel.getName(), hostel.getCity());
    }

    @Override
    public void update(Hostel hostel) {
        jdbcTemplate.update("UPDATE users SET name = ?, city = ? WHERE id = ?", hostel.getName(), hostel.getCity(), hostel.getId());
    }

    @Override
    public void deleteById(int id) {
        jdbcTemplate.update("DELETE FROM hostel WHERE id = ?", id);
    }
}
