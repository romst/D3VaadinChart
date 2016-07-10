package com.example;

/**
 * Data object for d3. One DataEntry is one point in a chart.
 */
public class DataEntry {
	private String x;
	private Integer y;

	public DataEntry(String x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

}
