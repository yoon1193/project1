package com.project.controller;

import java.util.ArrayList;
import java.util.Date;

import com.project.dao.OrderDetailsDao;
import com.project.dto.OrderDetailsDto;
import com.project.util.DBconn;
import com.project.util.Request;
import com.project.util.Response;

public class OrderDetailsInsert implements OrderDetailsExecute {

	@Override
	public void execute() {
		OrderDetailsDto request = new OrderDetailsDto(); 
		ArrayList<Integer> reponse = new ArrayList<>();

	}

	@Override
	public void execute(Request request, Response response) {
		inputView(request,response);
		logic(request,response);
		outputView(request,response);
	}

	@Override
	public void inputView(Request request, Response response) {
		System.out.println("OrderID를 입력하세요.");
		int orderID = DBconn.inputInt();
		System.out.println("ProductID를 입력하세요.");
		int productID = DBconn.inputInt();
		System.out.println("UnitPrice(가격)을 입력하세요.");
		double unitPrice = DBconn.inputDouble();
		System.out.println("Quantity(수량)을 입력하세요.");
		int quantity = DBconn.inputInt();
		System.out.println("Discount(할인율)을 입력하세요");
		double discount = DBconn.inputDouble();
		OrderDetailsDto dto = new OrderDetailsDto(); 
		dto.setOrderID(orderID);
		dto.setProductID(productID);
		dto.setUnitPrice(unitPrice);
		dto.setQuantity(quantity);
		dto.setDiscount(discount);
		request.setOrderDetailsDto(dto);
	}

	@Override
	public void logic(Request request, Response response) {
		OrderDetailsDto dto = request.getOrderDetailsDto();
		OrderDetailsDao dao = new OrderDetailsDao();
		int i = dao.insert(dto);
		response.setResultValue(i);

	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println(response.getResultValue());

	}

}
