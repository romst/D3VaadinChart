package com.example.d3.pie;

import java.util.List;

import com.example.DataEntry;
import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 * Object for data transfer to JavaScript file. 
 * !!!!! Variables must be public or have getter/setter methods !!!!!
 */
public class PieChartState extends JavaScriptComponentState {
	private static final long serialVersionUID = 3021126837329538014L;
	
	public List<DataEntry> data;
}
