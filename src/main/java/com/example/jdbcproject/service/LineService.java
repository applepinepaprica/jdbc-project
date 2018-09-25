package com.example.jdbcproject.service;

import com.example.jdbcproject.Line;
import java.util.List;

public interface LineService {
    List<Line> getLines(Integer id, String value);
    void insertLine(Line line);
}
