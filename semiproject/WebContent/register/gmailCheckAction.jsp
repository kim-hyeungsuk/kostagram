<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.SHA256"%>
<%@page import="java.io.PrintWriter"%>

<%
	//session을 이용하여 userId를 찾아서 DB에 저장된 email을 가져온다. ex) codingspecialist@naver.com

	//해당 이메일로 SHA256한 값과 code 값을 비교한다.
	String code = request.getParameter("code");
	
// 	boolean rightCode = 
// 			SHA256.getEncrypt(, "cos").equals(code) ? true : false;
 	PrintWriter script = response.getWriter();
	boolean rightCode = true;
	if(rightCode == true){
		script.println("<script>");
		script.println("alert('이메일 인증에 성공하였습니다.')");
		script.println("location.href='login.jsp'");
		script.println("</script>");
	} else{
		script.println("<script>");
		script.println("alert('이메일 인증을 실패하였습니다.')");
		script.println("location.href='error.jsp'");
		script.println("</script>");
	}
%>    