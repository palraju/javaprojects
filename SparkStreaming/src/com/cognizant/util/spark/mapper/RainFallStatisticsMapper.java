package com.cognizant.util.spark.mapper;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.api.java.function.FlatMapFunction;

import com.cognizant.spark.model.MonthWiseRainFall;
import com.cognizant.spark.model.YearWiseRainFall;

public class RainFallStatisticsMapper implements FlatMapFunction<String, YearWiseRainFall> {

	@Override
	public Iterable<YearWiseRainFall> call(String s) {
		return (Iterable<YearWiseRainFall>) getRainFallRow(s);
	}

	public Iterable<YearWiseRainFall> getRainFallRow(String s) {
		String[] row = s.split(",");
		YearWiseRainFall rainFallRow = new YearWiseRainFall();
		ArrayList<YearWiseRainFall> rainFallRowLst = new ArrayList<YearWiseRainFall>();
		MonthWiseRainFall monthWiseRainFall = null;
		List<Double> rainFallArray = null;

		monthWiseRainFall = new MonthWiseRainFall();
		rainFallArray = new ArrayList<Double>();
		monthWiseRainFall.setRainAmount(rainFallArray);
		rainFallRow.setMonthWiseRainFall(monthWiseRainFall);

		for (int i = 0; i < row.length; i++) {
			if (row[i] != null) {
				if (i == 0) {
					rainFallRow.setState(row[i]);
				} else if (i == 1) {
					rainFallRow.setDistrict(row[i]);
				} else if (i == 2) {
					// Create an Array List and MonthWise Rain Fall Object
					rainFallRow.setYear(new Double(row[i]));
				} else if (i < row.length - 1) {
					rainFallRow.getMonthWiseRainFall().getRainAmount().add(getRainFallAmount(row[i]));
				}
			}
		}
		rainFallRowLst.add(rainFallRow);
		return rainFallRowLst;
	}

	public Double getRainFallAmount(String amount) {
		Double rainFallAmt = null;
		System.out.println("amount:--" + amount);
		if (amount != null) {
			try {
				rainFallAmt = Double.parseDouble(amount);
			} catch (NumberFormatException e) {
				// e.printStackTrace();
			}
		}
		return rainFallAmt;
	}

}
