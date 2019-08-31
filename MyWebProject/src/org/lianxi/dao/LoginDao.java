package org.lianxi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lianxi.entity.User;

public class LoginDao {
	private static final String url = "jdbc:mysql://localhost:3306/practice?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT";
	private static final String username = "root";
	private static final String password = "root";

	// public int login(String name, String pwd) {// ����1��¼�ɹ���0��¼ʧ�ܣ�-1�����쳣
	public int login(User user) {// ����1��¼�ɹ���0��¼ʧ�ܣ�-1�����쳣
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// �������������ؾ����������
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, username, password);

			// String name = request.getParameter("uname");
			// String pwd = request.getParameter("upwd");

			// ����sql��ִ�У���ɾ�ġ��飩
			String sql = "select count(*) from login where uname=? and upwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPwd());

			rs = pstmt.executeQuery();

			int count = -1;

			if (rs.next()) {
				count = rs.getInt(1);
			}
			// ��¼�ɹ�����1����¼ʧ�ܷ���0
			if (count > 0) {
				return 1;
			} else {
				return 0;
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
