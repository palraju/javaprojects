package com.cognizant.spark.model;

import java.io.Serializable;

public class MaxRainDetails implements Serializable{

	private Double Year;
	private String month;
	private Double maxRainamount;
	
	public Double getYear() {
		return Year;
	}
	public void setYear(Double year) {
		Year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}	
	public Double getMaxRainamount() {
		return maxRainamount;
	}
	public void setMaxRainamount(Double maxRainamount) {
		this.maxRainamount = maxRainamount;
	}
	@Override
	public String toString() {
		return Year + "," + month +","+maxRainamount;
	}
	
}
