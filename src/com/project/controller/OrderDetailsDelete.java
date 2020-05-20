package com.project.controller;

import java.util.ArrayList;

import com.project.dao.OrderDetailsDao;
import com.project.dto.OrderDetailsDto;
import com.project.util.DBconn;
import com.project.util.Request;
import com.project.util.Response;

public class OrderDetailsDelete implements OrderDetailsExecute {

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
		System.out.println("삭제할 회원 번호를 입력하세요.");
		System.out.println("OrderID 입력");
		int orderID = DBconn.inputInt();
		OrderDetailsDto dto = new OrderDetailsDto();
		dto.setOrderID(orderID);
		request.setOrderDetailsDto(dto);

	}

	@Override
	public void logic(Request request, Response response) {
		OrderDetailsDto dto = request.getOrderDetailsDto();
		OrderDetailsDao dao = new OrderDetailsDao();
		int i = dao.delete(dto.getOrderID());
		response.setResultValue(i);

	}

	@Override
	public void outputView(Request request, Response response) {
		OrderDetailsDto req = request.getOrderDetailsDto();
		System.out.println("OrderID:" +req.getOrderID()+"를"+response.getResultValue()+"개 삭제하였습니다.");

	}

}
