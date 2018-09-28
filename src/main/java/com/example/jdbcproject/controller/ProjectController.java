package com.example.jdbcproject.controller;

import com.example.jdbcproject.model.Line;
import com.example.jdbcproject.service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {

	private final LineService lineService;

	@Autowired
	public ProjectController(LineService lineService) {
		this.lineService = lineService;
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String home(@RequestParam(required = false)String id,
				@RequestParam(required = false) String value, 
				Model model) {

		model.addAttribute("line", new Line());
		model.addAttribute("searchLine", new Line());
		model.addAttribute("lines", lineService.getLines(id, value));

		return "index";
	}

	@RequestMapping(value = { "/add_line" }, method = RequestMethod.GET)
	public String addLineGet(Model model) {
		model.addAttribute("line", new Line());
		return "add_line";
	}

	@RequestMapping(value = { "/add_line" }, method = RequestMethod.POST)
	public String addLinePost(Line line, Model model) {
		lineService.insertLine(line);
		return "redirect:/";
	}

	@RequestMapping(value = { "/delete_checked" }, method = RequestMethod.POST)
	public @ResponseBody String deleteLines(@RequestBody List<Line> lines, Model model) {
		lineService.deleteLines(lines);
		return "{\"msg\":\"success\"}";
	}

	@RequestMapping(value = { "/update_line" }, method = RequestMethod.POST)
	public @ResponseBody String updateLine(@RequestBody Line line, Model model) {
		lineService.updateLine(line);
		return "{\"msg\":\"success\"}";
	}
}