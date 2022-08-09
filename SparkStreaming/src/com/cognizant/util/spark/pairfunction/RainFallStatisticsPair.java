package com.cognizant.util.spark.pairfunction;

import java.util.List;

import org.apache.spark.api.java.function.PairFunction;

import com.cognizant.spark.model.MaxRainDetails;
import com.cognizant.spark.model.YearWiseRainFall;

import scala.Tuple2;

public class RainFallStatisticsPair implements PairFunction<YearWiseRainFall, String, YearWiseRainFall>{
	
    static String monthArr [] = {
			"January","February","March",
			"April","May","June",
			"July", "August", "September",
			"October", "November","December"
 		};
    
	@Override
	public Tuple2<String, YearWiseRainFall> call(YearWiseRainFall t) throws Exception {
		// TODO Auto-generated method stub
		String strRow = t.getState().toUpperCase() + "," + t.getDistrict().toUpperCase();
		return new Tuple2<String, YearWiseRainFall>(strRow, calCulateAvgRainFall(t));
	}
	
	public YearWiseRainFall calCulateAvgRainFall(YearWiseRainFall row) {
		List<Double> rainAmtList = row.getMonthWiseRainFall().getRainAmount();
		Double totalRainFall = 0.0;
		MaxRainDetails maxRainDetails = new MaxRainDetails(); 
		int rec =0;
		Double maxRain = 0.0;
		int monthIndex = 0;
		Double year = 0.0;
		for (int i = 0; i < rainAmtList.size(); i++) {
			if (rainAmtList.get(i) != null) {
				totalRainFall += rainAmtList.get(i);
				if(rainAmtList.get(i) > maxRain){
					maxRain = rainAmtList.get(i);
					monthIndex = i;
					year = row.getYear();
				}
				rec++;
			}
		}
		row.setTotalRainFall(totalRainFall);
		maxRainDetails.setMaxRainamount(maxRain);
		maxRainDetails.setYear(year);
		maxRainDetails.setMonth(monthArr[monthIndex]);
		row.setMaxRainFall(maxRainDetails);
		return row;
	}

}
