package com.project.util;

import java.util.ArrayList;

import com.project.dto.OrderDetailsDto;

public class Response {
	
	ArrayList<OrderDetailsDto> arrOrderDetailsDto = null;
	private int resultValue = 0;

	public ArrayList<OrderDetailsDto> getArrOrderDetailsDto() {
		return arrOrderDetailsDto;
	}
	public void setArrOrderDetailsDto(ArrayList<OrderDetailsDto> arrOrderDetailsDto) {
		this.arrOrderDetailsDto = arrOrderDetailsDto;
	}
	public int getResultValue() {
		return resultValue;
	}
	public void setResultValue(int resultValue) {
		this.resultValue = resultValue;
	}

}
