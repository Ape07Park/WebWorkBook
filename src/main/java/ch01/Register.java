package ch01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ch01/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 입력한 jsp와 연결 및 요청을 jsp로 보냄
		RequestDispatcher rd = request.getRequestDispatcher("/ch01/registerForm.jsp");
		// jsp가 작성한 내용 브라우저로 전달
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 전달되는 데이터의 key를 통해 value 추출
		String pwd = request.getParameter("pwd");
		String pwd2 = request.getParameter("pwd2");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		String uid = request.getParameter("uid");

		User user = new User(uid, uname, pwd, email);
		
		// jsp에 전달할 데이터의 key, value 세팅
		request.setAttribute("user", user);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch01/registerResult.jsp");
		rd.forward(request, response);
	}

}
