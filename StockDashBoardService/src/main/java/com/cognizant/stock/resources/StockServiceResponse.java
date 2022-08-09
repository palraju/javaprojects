package com.cognizant.stock.resources;

import java.util.Collection;

public class StockServiceResponse<T> {
	private T data;
	private Collection<T> dataList;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Collection<T> getDataList() {
		return dataList;
	}

	public void setDataList(Collection<T> collection) {
		this.dataList = collection;
	}

}
