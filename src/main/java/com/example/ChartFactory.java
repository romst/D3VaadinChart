package com.example;

import java.util.List;

import com.example.d3.pie.PieChart;
import com.vaadin.ui.AbstractJavaScriptComponent;

/**
 * Factory for charts. 
 */
public class ChartFactory {
	
	/**
	 * Returns a valid chart Component for a specific ChartType.
	 */
	public static AbstractJavaScriptComponent getChart(ChartType type) {

		AbstractJavaScriptComponent chart;

		List<DataEntry> data = DataGenerator.generateData(type);

		switch (type) {
		case PieChart:
			chart = new PieChart(data);
			break;
		default:
			chart = null;
			break;
		}

		return chart;
	}
}
