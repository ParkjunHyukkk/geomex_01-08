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
	        
	        System.out.println("���̵�: " + id);
	        System.out.println("��й�ȣ: " + pw);
	        
	        if (id != null && (id.length() != 0)) {
	        	// �α��ν� "admin" üũ
	        	if (id.equals("admin")) {
	        		out.print("<html>");
	        		out.print("<body>");
	        		out.print("<font size='8'>�����ڷ� �α��� �ϼ̽��ϴ�!!</font>" );
	        		out.print("<br>");
	        		out.print("<input type=button value='ȸ������ �����ϱ�'>");
	        		out.print("<a href=\"delete.jsp\"><button>ȸ������ ����</button></a>");
	        		
	        		out.print("</html>");
	        		out.print("</body>");
	        	} else {
	        		out.print("<html>");
	        		out.print("<body>");
	        		out.print( id +" ��!! �α��� �ϼ̽��ϴ�." );
	        		out.print("</html>");
	        		out.print("</body>");	   
	        	}
	        }
	        out.close();
		}

}
