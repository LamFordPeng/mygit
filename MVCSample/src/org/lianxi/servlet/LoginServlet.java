package org.lianxi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lianxi.dao.LoginDao;
import org.lianxi.entity.User;

//控制器层：接受view请求，并分发给Model处理
//3件事：a:数据组装User user = new User(name, pwd);
// 		b:调用模型层的登录功能LoginDao.login(user);
//      c:根据登录结果进行相应处理
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 处理登录请求
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		User user = new User(name, pwd);

		// 调用模型层的登录功能
		int result = LoginDao.login(user);

		if (result > 0) {
			// 登录成功
			response.sendRedirect("welcome.jsp");
		} else {
			// 登录失败，重新登录
			response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
