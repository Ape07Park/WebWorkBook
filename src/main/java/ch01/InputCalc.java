package ch01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// * borwser -> controller(둘 사이를 매개, 브라우저에서 온 요청 처리 및 view에 필요한 데이터 준비)-> view
@WebServlet("/ch01/calc/input")
public class InputCalc extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch01/calc/input.jsp"); // 서블랫과 .jsp를 연결 및 서블랫에 전달된 요청을 .jsp로 전달
		
		rd.forward(request, response); //  페이지를 이동하면서 현재페이지에서 사용하던  request와 response를 넘겨줌
	}
	
}
