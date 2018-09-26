package com.example.jdbcproject.repository;

import com.example.jdbcproject.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

@Repository
public class LineJdbcRepositoryImpl implements LineRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LineJdbcRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Line> RM = (ResultSet rs, int rownumber) -> {
        Line l = new Line();
        l.setId(rs.getInt("id"));
        l.setValue(rs.getString("value"));
        return l;
    };

    @Override
    public List<Line> getAllLines() {
        return jdbcTemplate.query(buildQuery(""), RM);
    }

    @Override
    public List<Line> getLineById(int id) {
        String query = buildQuery(" WHERE id = (?)");
        return jdbcTemplate.query(query, new Object[] { id }, RM);
    }

    @Override
    public List<Line> getLineByValue(String value) {
        String query = buildQuery(" WHERE INSTR(value, ?) > 0");
        return jdbcTemplate.query(query, new Object[] { value }, RM);
    }

    private String buildQuery(String str) {
        String que1 = "SELECT * FROM line";
        String que2 = " ORDER BY id DESC";
        return new StringBuilder().append(que1).append(str).append(que2).toString();
    }

    @Override
    public void insertLine(Line line) {
        jdbcTemplate.update("INSERT INTO line(value) VALUES (?)", line.getValue());
    }
}