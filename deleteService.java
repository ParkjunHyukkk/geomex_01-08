package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.MemberDTO;

/**
 * Servlet implementation class deleteService
 */
@WebServlet("/DeleteService")
public class deleteService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		

		System.out.println(request.getParameter("tel"));
		MemberDTO dto = new MemberDTO(id);
		MemberDAO dao = new MemberDAO();
		int cnt = dao.delete(dto);

	//	response.sendRedirect("main.jsp");
	}

}
