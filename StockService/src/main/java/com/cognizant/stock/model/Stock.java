package com.cognizant.stock.model;

public class Stock {
	private Integer stockId;
	private String scripName;
	private String scripCode;
	private String scripInceptionDate;
	private String companyName;

	public String getScripName() {
		return scripName;
	}

	public void setScripName(String scripName) {
		this.scripName = scripName;
	}

	public String getScripCode() {
		return scripCode;
	}

	public void setScripCode(String scripCode) {
		this.scripCode = scripCode;
	}

	public String getScripInceptionDate() {
		return scripInceptionDate;
	}

	public void setScripInceptionDate(String scripInceptionDate) {
		this.scripInceptionDate = scripInceptionDate;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getStockId() {
		return stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}
}
