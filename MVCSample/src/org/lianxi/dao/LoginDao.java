package org.lianxi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lianxi.entity.User;

//模型层：用于处理登录（用于查询数据库）
//封装逻辑的模型——功能

public class LoginDao {
	public static int login(User user) {
		// boolean flag = false;// 登录成功与否的标识
		int flag = -1;// -1：系统异常 0：用户名或密码有误 1：登录成功
		int result = -1;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practice?useUnicode=true&characterEncoding=UTF8&serverTimezone=GMT",
					"root", "root");
			String sql = "select count(*) from login where uname=? and upwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getPwd());
			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
			}

			if (result > 0) {
				flag = 1;
			} else {
				flag = 0;// 登录失败（用户名或密码有误）
			}

			return flag;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			flag = -1;
			return flag;
		} catch (SQLException e) {
			e.printStackTrace();
			flag = -1;
			return flag;
		} catch (Exception e) {
			e.printStackTrace();
			flag = -1;
			return flag;
		} finally {

			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
