package com.cognizant.spark.model;

import java.io.Serializable;

public class YearWiseRainFall implements Serializable {

	private static final long serialVersionUID = -4628347028900545173L;
	
	private String state;
	private String district;
	private MonthWiseRainFall monthWiseRainFall;
	private MaxRainDetails maxRainFall;
	private Double totalRainFall;
	private Double year;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public MonthWiseRainFall getMonthWiseRainFall() {
		return monthWiseRainFall;
	}

	public void setMonthWiseRainFall(MonthWiseRainFall monthWiseRainFall) {
		this.monthWiseRainFall = monthWiseRainFall;
	}

	public MaxRainDetails getMaxRainFall() {
		return maxRainFall;
	}

	public void setMaxRainFall(MaxRainDetails maxRainFall) {
		this.maxRainFall = maxRainFall;
	}

	public Double getTotalRainFall() {
		return totalRainFall;
	}

	public void setTotalRainFall(Double totalRainFall) {
		this.totalRainFall = totalRainFall;
	}

	public Double getYear() {
		return year;
	}

	public void setYear(Double year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "[" + state + "," + district + "," + maxRainFall + "," + totalRainFall + "]";
	}

}
