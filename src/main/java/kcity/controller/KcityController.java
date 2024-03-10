package kcity.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kcity.dao.KcityDao;
import kcity.entity.Kcity;
import kcity.service.KcityService;
import kcity.service.KcityServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/world/kcity/*")
public class KcityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KcityService kSvc = new KcityServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		String requestUri = request.getRequestURI(); // 입력한 주소값을 받음
		String[] uri = requestUri.split("/");
		String action = uri[uri.length - 1];

		// 중복
		RequestDispatcher rd = null;
		int id = 0;

		switch (action) {
		case "list":
			// dao의 기능이 있는 serviceImpl을 통해 list 받아오기 - jsp와 연결 - jsp에 list의 속성값 넘기기 - 화면에
			// 띄우기
			List<Kcity> list = new ArrayList<Kcity>();
			list = kSvc.getKcityList();

			rd = request.getRequestDispatcher("/WEB-INF/kcity/list.jsp"); // list.jsp와 연결, 데이터(요청) 보내기
			request.setAttribute("list", list); // 보낼 데이터인 list를 "list"라는 키에 저장
			rd.forward(request, response); // jsp가 작성한 내용 화면에 띄우기-사용자가 작성할 수 있게 하기 위함-
			break;

		case "insert":
			// jsp로 이동- 값 입력 -controller로 돌아오기- jsp에서 사용자가 작성한 값 이용해 kcity 만들기 - dao의 기능이 있는
			// serviceImpl을 통해 insert 받아오기 및 insert - list 화면으로 이동
			if (method.equals("GET")) {
				rd = request.getRequestDispatcher("/WEB-INF/kcity/insert.jsp");
				rd.forward(request, response);
			} else {
				// insert.jsp에서 작성한 값들 불러오기
				String name = request.getParameter("name");
				String countryCode = request.getParameter("countryCode");
				String district = request.getParameter("district");
				int poppulation = Integer.parseInt(request.getParameter("population"));

				// 불러온 값을 Kcity 객체에 집어넣기
				Kcity kcity = new Kcity(name, countryCode, district, poppulation);
				// serviceImpl에 있는 insertKcity() 메서드를 사용해 새로운 kcity 객체 DB에 집어넣기
				kSvc.insertKcity(kcity);
				// 잘 생성되었는지 확인 위해 list.jsp로 이동
				response.sendRedirect("wb/world/kcity/list"); // 서블릿의 주소에 맞게 해야함 jsp가 아니라
			}
			break;

		case "update":
			// id로 값 불러오기 - kcity 생성 및 jsp로 보낼 수 있게 준비- jsp로 이동- 수정할 값 입력 -controller로 돌아오기- jsp에서 사용자가 작성한 값 이용해 kcity update - dao의 기능이 있는
			// serviceImpl을 통해 update 받아오기 및 update - list 화면으로 이동
			if (method.equals("GET")) {
								
				 // id로 값 불러오기
		        id = Integer.parseInt(request.getParameter("id"));
		        // id로 kcity 불러오기 및 kcity에 저장
		        Kcity kcity = kSvc.getById(id);
		        request.setAttribute("kcity", kcity);
		        // update.jsp와 연결 및 데이터 보내기
		        rd = request.getRequestDispatcher("/WEB-INF/kcity/update.jsp");
		        // jsp 창 띄우기
		        rd.forward(request, response);
				
			} else {
				// insert.jsp에서 작성한 값들 불러오기
				id = Integer.parseInt(request.getParameter("id"));
				String name = request.getParameter("name");
				String countryCode = request.getParameter("countryCode");
				String district = request.getParameter("district");
				int poppulation = Integer.parseInt(request.getParameter("population"));

				// 불러온 값을 Kcity 객체에 집어넣기
				Kcity kcity = new Kcity(id, name, countryCode, district, poppulation);
				// serviceImpl에 있는 insertKcity() 메서드를 사용해 새로운 kcity 객체 DB에 집어넣기
				kSvc.insertKcity(kcity);
				// 잘 생성되었는지 확인 위해 list.jsp로 이동
				response.sendRedirect("wb/world/kcity/list"); // 서블릿의 주소에 맞게 해야함 jsp가 아니라
			}
			break;
						
			// update.jsp에 붙이기
		case "delete":
			// 지우고 싶은 id 값을 id에 저장- kSvc 생성해 serviceImpl의 delete에 id 넣기 
			id = Integer.parseInt(request.getParameter("id"));
			kSvc.deleteKcity(id);
			response.sendRedirect("wb/world/kcity/list");
		
			break;
		}
	}

}
