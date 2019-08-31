package org.lianxi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.lianxi.entity.User;

//ģ�Ͳ㣺���ڴ����¼�����ڲ�ѯ���ݿ⣩
//��װ�߼���ģ�͡�������

public class LoginDao {
	public static int login(User user) {
		// boolean flag = false;// ��¼�ɹ����ı�ʶ
		int flag = -1;// -1��ϵͳ�쳣 0���û������������� 1����¼�ɹ�
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
				flag = 0;// ��¼ʧ�ܣ��û�������������
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
