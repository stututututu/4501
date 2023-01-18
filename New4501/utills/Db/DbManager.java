package Db;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Vector;

import javax.naming.spi.DirStateFactory.Result;

public class DbManager {

	private String URL = "jdbc:mysql://localhost/4501?" 
			+ "CharacterEncoding=UTF-8&" 
			+ "serverTimezone=UTC&"
			+ "allowPublicKeyRetrieval=true&" 
			+ "allowLoadLocalInfile=true&" 
			+ "useSSL=false&"
			+ "allowMultiQueries=true";

private String ID = "root";

private String PW = "1234";

private Statement stmt;

private Connection con;

private PreparedStatement pstmt;

	public DbManager() {

		try {
			con = DriverManager.getConnection(URL, ID, PW);
			stmt = con.createStatement();
			System.out.println("connecting succeed");
//			"use 4501;"
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connecting faild");
			
			// TODO: handle exception
		}
	}
	public int setData(String sql, String...val) {
		try {
			pstmt = con.prepareStatement(sql);
			for (int i = 0; i < val.length; i++) {
				pstmt.setObject(i + 1, val[i]);
			}
			System.out.println("setData 완료");
			return pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("setData fail");
			e.printStackTrace();
		}
		return -1;
	}

	public Vector<Vector<String>> getData(String sql, String...val){
		Vector<Vector<String>> data = new Vector<>();
		try {
			pstmt = con.prepareStatement(sql);
			
			for (int i = 0; i < val.length; i++) {
				pstmt.setObject(i + 1, val[i]);
			}
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				Vector<String> row = new Vector<>();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					row.add(rs.getString(i + 1));
					
				}
				data.add(row);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return data;
	}
}
