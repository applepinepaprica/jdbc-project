package com.example.jdbcproject.repository;

import com.example.jdbcproject.model.Line;
import java.util.List;

public interface LineRepository {
    List<Line> getAllLines();
    List<Line> getLineById(int id);
    List<Line> getLineByValue(String value);
    void insertLine(Line line);
    void deleteLine(Line line);
}
