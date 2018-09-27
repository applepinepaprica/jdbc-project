package com.example.jdbcproject.model;

import java.util.Objects;

public class Line {
	
	private Integer id;
	private String value;

	public Line () { }

	public void setId(int id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Line line = (Line) o;
		return id == line.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}