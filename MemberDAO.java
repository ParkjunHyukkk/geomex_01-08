package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;




public class MemberDAO {

	private ResultSet rs; // �ʵ�� �⺻������ ��ü�� �����ϸ� NULL���� ����.
	private PreparedStatement psmt;
	private Connection conn;

	private void getConnection() {
		try {
			Class.forName("org.postgresql.Driver");

			String db_url = "jdbc:postgresql://localhost/login";
			String db_id = "postgres";
			String db_pw = "1234";

			conn = DriverManager.getConnection(db_url, db_id, db_pw);
		} catch (ClassNotFoundException e) { // ã�� �� ���� DB ���� ���� ó��
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int join(MemberDTO dto) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "insert into mymember values(?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			psmt.setString(3, dto.getTel());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) { // ��� DB���� SQL���� ������ ó��
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}

	public MemberDTO login(MemberDTO dto) {

		MemberDTO info = null;

		String l_id = null;
		String l_pw = null;
		String l_tel = null;

		try {
			getConnection();

			String sql = "select * from mymember where id = ? and pw = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery();

			if (rs.next()) {
				l_id = rs.getString(1);
				l_pw = rs.getString(2);
				l_tel = rs.getString(3);

				info = new MemberDTO(l_id, l_pw, l_tel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return info;
	}
	
	public int delete(MemberDTO dto) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "delete from mymember where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) { // ��� DB���� SQL���� ������ ó��
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	public int update(MemberDTO dto) {

		int cnt = 0;

		try {
			getConnection();

			String sql = "update member set tel = ? where tel = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getTel());
			psmt.setString(2, dto.getTel());
			cnt = psmt.executeUpdate();
		} catch (SQLException e) { // ��� DB���� SQL���� ������ ó��
			e.printStackTrace();
		} finally {
			close();
		}

		return cnt;
	}
	
	
	
}
