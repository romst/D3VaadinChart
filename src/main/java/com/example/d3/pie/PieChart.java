package com.example.d3.pie;

import java.util.List;

import com.example.DataEntry;
import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;

@JavaScript({ "vaadin://d3/d3.min.js", "vaadin://d3/piechart.js" })
public class PieChart extends AbstractJavaScriptComponent {
	private static final long serialVersionUID = 394413051371268690L;

	public PieChart(List<DataEntry> data) {
		getState().data = data;
	}

	@Override
	protected PieChartState getState() {
		return (PieChartState) super.getState();
	}
}
