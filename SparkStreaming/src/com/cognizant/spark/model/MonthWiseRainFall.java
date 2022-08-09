package com.cognizant.spark.model;

import java.io.Serializable;
import java.util.List;

public class MonthWiseRainFall implements Serializable{
	private static final long serialVersionUID = -6518931283385875469L;
	
	List<Double> rainAmount;

	public List<Double> getRainAmount() {
		return rainAmount;
	}

	public void setRainAmount(List<Double> rainAmount) {
		this.rainAmount = rainAmount;
	}

}
