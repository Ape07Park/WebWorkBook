package kcity.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kcity.service.KcityService;
import kcity.service.KcityServiceImpl;

import java.io.IOException;

@WebServlet("/world/kcity/*")
public class KcityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KcityService kSvc = new KcityServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		String requestUri = request.getRequestURI(); // 입력한 주소값을 받음
		String[] uri = requestUri.split("/");
		String action = uri[uri.length - 1];

		// 중복
		RequestDispatcher rd = null;
		
		switch (action) {
		case "list":
			
			
		
			
		}
	}

}
