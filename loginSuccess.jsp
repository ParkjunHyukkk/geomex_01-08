<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies(); // ��Ű ���� ���� �迭 ���·� �޾ƿ´�.
		for (int i = 0; i < cookies.length; i++) {
			if (!cookies[i].getName().equals("JSESSIONID")) {
				System.out.println(cookies[i].getValue());
				out.print(cookies[i].getName() + " : ");
				out.print(cookies[i].getValue() + "<br>");
			}
		}
	%>
</body>
</html>