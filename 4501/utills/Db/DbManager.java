package Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

public class DbManager {


	private String URL = "jdbc:mysql://localhost/?" + "CharacterEncoding=UTF-8&" + "serverTimezone=UTC&"
			+ "allowPublicKeyRetrieval=true&" + "allowLoadLocalInfile=true&" + "allowMultiQueries=true";

	private String ID = "root";

	private String PW = "1234";

	private Connection con;
	private Statement stmt;

	private PreparedStatement pstmt;

	public DbManager() {
		// TODO Auto-generated constructor stub
		try {
			con = DriverManager.getConnection(URL, ID, PW);

			stmt = con.createStatement();
			System.out.println("con 연결 성공");

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("con 연결 실패");
			e.printStackTrace();
		}
	}

	public int setUpdate(String sql, String... val) {
		// TODO Auto-generated method stub
		try {
			pstmt = con.prepareStatement(sql);

			for (int i = 0; i < val.length; i++) {
				pstmt.setObject(i + 1, val[i]);
			}

			System.out.println("SetUpdate 완료");

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("setUpdate 실패");
			e.printStackTrace();
			return -1;
		}
	}

	public Vector<Vector<Object>> getData(String sql, String... val) {
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		try {
			pstmt = con.prepareStatement(sql);

			for (int i = 0; i < val.length; i++) {
				pstmt.setObject(i + 1, val[i]);
			}

			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			while (rs.next()) {
				 Vector<Object> row = new Vector<>();
				 
				 for (int i = 0; i < rsmd.getColumnCount() ; i++) {
					row.add(rs.getObject(i+1) + "");
				}
				 data.add(row);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return data;
	}

}
