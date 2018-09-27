package com.example.jdbcproject.service;

import com.example.jdbcproject.model.Line;
import java.util.List;

public interface LineService {
    List<Line> getLines(String id, String value);
    void insertLine(Line line);
    void deleteLines(List<Line> lines);
}
