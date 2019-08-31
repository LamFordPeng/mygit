package org.lianxi.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.lianxi.dao.LoginDao;
import org.lianxi.entity.User;

//�������㣺����view���󣬲��ַ���Model����
//3���£�a:������װUser user = new User(name, pwd);
// 		b:����ģ�Ͳ�ĵ�¼����LoginDao.login(user);
//      c:���ݵ�¼���������Ӧ����
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// �����¼����
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("uname");
		String pwd = request.getParameter("upwd");
		User user = new User(name, pwd);

		// ����ģ�Ͳ�ĵ�¼����
		int result = LoginDao.login(user);

		if (result > 0) {
			// ��¼�ɹ�
			response.sendRedirect("welcome.jsp");
		} else {
			// ��¼ʧ�ܣ����µ�¼
			response.sendRedirect("login.jsp");
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
