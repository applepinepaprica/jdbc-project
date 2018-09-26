package com.example.jdbcproject.service;

import com.example.jdbcproject.model.Line;
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
		List<Line> lines;

    	/*Фильтр устроен примерно так, как в ЭК, т е если в запросе есть id,
    	то программа ищет строку с этим id, не обращая внимания на другие условия.*/
    	if (id != null) {
			lines = lineRepository.getLineById(id);
		} else if (value != null && !value.isEmpty()) {
			lines = lineRepository.getLineByValue(value);
		} else {
			lines = lineRepository.getAllLines();
		}

		return lines;
	}

	public void insertLine(Line line) {
		lineRepository.insertLine(line);
	}
}