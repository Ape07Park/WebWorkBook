package ch01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch01/calc/input2")
public class InputCalc2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num1"); // num1이라는 키에 해당하는 값을 가져와서 String num1에 저장
		String num2 = request.getParameter("num2");
		
		System.out.println(num1);
		System.out.println(num2);
		
		response.sendRedirect("/index"); // 처리 끝나고 "/index"로 이동 
		
	}

}
