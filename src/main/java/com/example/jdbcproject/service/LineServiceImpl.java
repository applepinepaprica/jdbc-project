package com.example.jdbcproject.service;

import com.example.jdbcproject.model.Line;
import com.example.jdbcproject.repository.LineRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@Service
public class LineServiceImpl implements LineService {

	private final LineRepository lineRepository;

	@Autowired
	public LineServiceImpl(LineRepository lineRepository) {
		this.lineRepository = lineRepository;
	}

	@Override
	public List<Line> getLines(String id, String value) {
		List<Line> lines;

    	/*Фильтр устроен примерно так, как в ЭК, т е если в запросе есть id,
    	то программа ищет строку с этим id, не обращая внимания на другие условия.*/
		if (id != null && !id.isEmpty()) {
			Set<Line> linesSet = new HashSet<>();
			String[] array = id.split("[ ,]+");

			for (String str : array) {
				int i;

				try {
					i = Integer.parseInt(str);
				}
				catch (NumberFormatException e) {
					//do nothing
					break;
				}
				linesSet.addAll(lineRepository.getLineById(i));
			}
			lines = new ArrayList<>(linesSet);
		} else if (value != null && !value.isEmpty()) {
			lines = lineRepository.getLineByValue(value);
		} else {
			lines = lineRepository.getAllLines();
		}

		return lines;
	}

	@Override
	public void insertLine(Line line) {
		lineRepository.insertLine(line);
	}

	@Override
	public void deleteLines(List<Line> lines){
		for (Line line: lines) {
			lineRepository.deleteLine(line);
		}
	}

	@Override
	public void updateLine (Line line) {
		lineRepository.updateLine(line);
	}
}