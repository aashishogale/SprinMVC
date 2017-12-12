<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form id="otpForm" modelAttribute="otp" action="generateOtp" method="post">
		<table align="center">
			<tr>
				<td><label>otp: </label></td>
				<td><form:input path="email" name="email" id="email" /></td>
			</tr>
<form:button id="login" name="otpgen">otpgen</form:button>

		</table>

	</form:form>
	
</body>
</html>