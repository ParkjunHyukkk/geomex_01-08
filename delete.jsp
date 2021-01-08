<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="DeleteService" method="post">
		<div>
			<fieldset>
				<legend>
					<h1>회원삭제 페이지</h1>
				</legend>
				<table>
					<tr>
						<td>아이디</td>
						<td><input placeholder="아이디 입력" type="text" name="id"></td>
					</tr>
						<td colspan=2><input type="submit" value="삭제"><input
							type="reset" value="초기화"></td>
					</tr>
				</table>

			</fieldset>
		</div>
	</form>
</body>
</html>