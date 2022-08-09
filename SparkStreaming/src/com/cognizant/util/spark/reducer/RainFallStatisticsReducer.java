package com.cognizant.util.spark.reducer;

import org.apache.spark.api.java.function.Function2;

import com.cognizant.spark.model.MaxRainDetails;
import com.cognizant.spark.model.YearWiseRainFall;

public class RainFallStatisticsReducer implements Function2<YearWiseRainFall, YearWiseRainFall, YearWiseRainFall>{
	@Override
	public YearWiseRainFall call(YearWiseRainFall v1, YearWiseRainFall v2) throws Exception {
		MaxRainDetails maxRainFall =  v2.getMaxRainFall();
		YearWiseRainFall rainFallRow = new YearWiseRainFall();
		rainFallRow.setDistrict(v1.getDistrict());
		rainFallRow.setState(v1.getState());
		rainFallRow.setTotalRainFall(v1.getTotalRainFall() + v2.getTotalRainFall());						
		if(v1.getMaxRainFall().getMaxRainamount() > v2.getMaxRainFall().getMaxRainamount()){
			maxRainFall = v1.getMaxRainFall();
		}
		rainFallRow.setMaxRainFall(maxRainFall);
		return rainFallRow;
	}

}
