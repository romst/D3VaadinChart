package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Get randomized data for chart.
 */
public class DataGenerator {

	private final static int numberOfValues = 5;

	public static List<DataEntry> generateData(ChartType type) {

		List<DataEntry> entries = new ArrayList<DataEntry>();

		if (type == ChartType.PieChart) {
			char name = 'A';
			for (int i = 0; i < numberOfValues; i++) {
				entries.add(new DataEntry(Character.toString((char) (name + i)), (int) getRandomNumber()));
			}
		}

		return entries;
	}

	private static double getRandomNumber() {
		return Math.random() * 100;
	}

}
