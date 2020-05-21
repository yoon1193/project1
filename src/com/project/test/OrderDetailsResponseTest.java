package com.project.test;

import java.util.Scanner;

import com.project.controller.OrderDetailsDelete;
import com.project.controller.OrderDetailsExecute;
import com.project.controller.OrderDetailsInsert;
import com.project.controller.OrderDetailsSelect;
import com.project.controller.OrderDetailsUpdate;
import com.project.util.Request;
import com.project.util.Response;



public class OrderDetailsResponseTest {

	public static void main(String[] args) {
		System.out.println("0>>Insert, 1>>Update, 2>>Delete, 3>>Select");
		Scanner sc = new Scanner(System.in);
		int select = sc.nextInt();
		OrderDetailsExecute ode = null;
		Response response = new Response();
		Request request = new Request();
		
		switch(select) {
		case 0:
			ode = new OrderDetailsInsert();
			break;
		case 1:
			ode = new OrderDetailsUpdate();
			break;
		case 2:
			ode = new OrderDetailsDelete();
			break;
		case 3:
			ode = new OrderDetailsSelect();
		default:
			break;
		}
		ode.execute(request, response);
		System.out.println("Á¾·á");

	}

}
