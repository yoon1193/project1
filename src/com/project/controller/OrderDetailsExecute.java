package com.project.controller;

import com.project.util.Request;
import com.project.util.Response;

public interface OrderDetailsExecute {
	public void execute();
	public void execute(Request request,Response response);
	public void inputView(Request request,Response response);
	public void logic(Request request,Response response);
	public void outputView(Request request,Response response);


}
