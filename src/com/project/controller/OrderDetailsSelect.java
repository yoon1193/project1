package com.project.controller;

import java.util.ArrayList;

import com.project.dao.OrderDetailsDao;
import com.project.dto.OrderDetailsDto;
import com.project.util.Request;
import com.project.util.Response;

public class OrderDetailsSelect implements OrderDetailsExecute {

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
		System.out.println("��� ������ ���");

	}

	@Override
	public void logic(Request request, Response response) {
		OrderDetailsDao dao = new OrderDetailsDao();
		response.setArrOrderDetailsDto(dao.select());

	}

	@Override
	public void outputView(Request request, Response response) {
		if(response != null) {
			ArrayList<OrderDetailsDto> dtos = response.getArrOrderDetailsDto();
			System.out.println("�����ʹ� ������ �����ϴ�.");
			for(OrderDetailsDto dto:dtos) {
				System.out.println(dto);
			}
		}else {
			System.out.println("�����Ͱ� �����ϴ�.");
		}

	}

}
