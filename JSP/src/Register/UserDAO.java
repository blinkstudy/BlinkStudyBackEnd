package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import User.RegisterUser;

public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static UserDAO instance;

	public static UserDAO getInstance() {
		if (instance == null)
			instance = new UserDAO();
		return instance;
	}

	public UserDAO() {
		try {
			String dbURL = "jdbc:mariadb://localhost:3305/core?serverTimezone=UTC&useSSL=false";
			String dbID = "root";
			String dbPassword = "dpwl5904";
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int login(String userID, String userPassword) {
		String SQL = "SELECT ID FROM userinfo WHERE ID=? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if (rs.next()) {

				if (rs.getString(1).equals(userPassword)) {
					return 1;// �α��� ����
				} else {
					return 0; // ��й�ȣ ����ġ
				}
			}
			return -1;// ���̵� ����

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2;// �����ͺ��̽� ����
	}

	public int join(RegisterUser user) {
		
		String SQL = "SELECT ID FROM userinfo WHERE ID=? ";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, user.getID());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return -1;// �ߺ��� ���̵� ����
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SQL="INSERT INTO userinfo (ID, interest, password) VALUES (?, ?, ?)";
		try {
			pstmt=conn.prepareStatement(SQL);
			pstmt.setString(1,user.getID());
			pstmt.setInt(2, user.getInterest());
			pstmt.setString(3,user.getPassword());
			
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;//�����ͺ��̽� ����
	}
}
