package com.project.controller;

import java.util.ArrayList;

import com.project.dao.OrderDetailsDao;
import com.project.dto.OrderDetailsDto;
import com.project.util.DBconn;
import com.project.util.Request;
import com.project.util.Response;

public class OrderDetailsUpdate implements OrderDetailsExecute {

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
		System.out.println("������ OrderID�� ProductID�� �Է��ϼ���");
		System.out.println("OrderID �Է�");
		int orderID = DBconn.inputInt();
		System.out.println("ProductID�� �Է��ϼ���.");
		int productID = DBconn.inputInt();
		System.out.println("������ Quantity�� �Է��ϼ���.");
		int quantity = DBconn.inputInt();
		OrderDetailsDto dto = new OrderDetailsDto();
		dto.setOrderID(orderID);
		dto.setProductID(productID);
		dto.setQuantity(quantity);
		request.setOrderDetailsDto(dto);
		
	}

	@Override
	public void logic(Request request, Response response) {
		OrderDetailsDto dto = request.getOrderDetailsDto();
		OrderDetailsDao dao = new OrderDetailsDao();
		int i = dao.update(dto.getQuantity(),dto.getProductID(),dto.getOrderID());
		response.setResultValue(i);


	}

	@Override
	public void outputView(Request request, Response response) {
		System.out.println("\""+request.getOrderDetailsDto().getOrderID()+"\""
				+" OrderID�� �ֹ� �� "+"\""+request.getOrderDetailsDto().getProductID()+"\""+"�� ProductID�� ������ "+
				request.getOrderDetailsDto().getQuantity()
				+"�� "+response.getResultValue()+"�� ����Ǿ����ϴ�.");

	}

}
