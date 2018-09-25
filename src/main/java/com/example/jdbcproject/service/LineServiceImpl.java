package com.example.jdbcproject.service;

import com.example.jdbcproject.Line;
import com.example.jdbcproject.repository.LineRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class LineServiceImpl implements LineService {

	private final LineRepository lineRepository;

	@Autowired
	public LineServiceImpl(LineRepository lineRepository) {
		this.lineRepository = lineRepository;
	}

	public List<Line> getLines(Integer id, String value) {
    	/*Фильтр устроен примерно так, как в ЭК, т е если в запросе есть id,
    	то программа ищет строку с этим id, не обращая внимания на другие условия.*/
    	if (id != null) {
			return lineRepository.getLineById(id);
		} else if (value != null && !value.isEmpty()) {
			return lineRepository.getLineByValue(value);
		} else {
			return lineRepository.getAllLines();
		}
	}

	public void insertLine(Line line) {
		lineRepository.insertLine(line);
	}
}