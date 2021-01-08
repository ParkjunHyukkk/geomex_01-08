package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	protected void doPost(
			HttpServletRequest request, 
			HttpServletResponse response
	    ) throws ServletException, IOException {
			System.out.println("doPost");
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html;charset=utf-8");
	        PrintWriter out = response.getWriter();
	        
	        String id = request.getParameter("id");
	        String pw = request.getParameter("pw");
	        
	        System.out.println("아이디: " + id);
	        System.out.println("비밀번호: " + pw);
	        
	        if (id != null && (id.length() != 0)) {
	        	// 로그인시 "admin" 체크
	        	if (id.equals("admin")) {
	        		out.print("<html>");
	        		out.print("<body>");
	        		out.print("<font size='8'>관리자로 로그인 하셨습니다!!</font>" );
	        		out.print("<br>");
	        		out.print("<input type=button value='회원정보 수정하기'>");
	        		out.print("<a href=\"delete.jsp\"><button>회원정보 삭제</button></a>");
	        		
	        		out.print("</html>");
	        		out.print("</body>");
	        	} else {
	        		out.print("<html>");
	        		out.print("<body>");
	        		out.print( id +" 님!! 로그인 하셨습니다." );
	        		out.print("</html>");
	        		out.print("</body>");	   
	        	}
	        }
	        out.close();
		}

}
