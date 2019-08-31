<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="org.lianxi.dao.LoginDao" %>
<%@ page import="org.lianxi.entity.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	 <%
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		
		User user = new User(name,pwd);
		
		LoginDao dao = new LoginDao();
		int result = dao.login(user);
		if(result>0){
			out.print("登录成功");
		}else if(result == 0){
			out.print("用户名或密码有误");
			//response.sendRedirect("index.jsp");
		}else{
			out.print("系统异常");
		} 
	%>
</body>
</html>