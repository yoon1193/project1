package com.project.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DBconn {
	//.getInstance()
	private DBconn() {}
	private static Connection dbConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static Scanner sc = new Scanner(System.in);
	
	public static ResultSet statementQuery(String sql) {

		try {
			if(st == null) {
				st = dbConn.createStatement();
			}
			rs = st.executeQuery(sql);
	
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}
	
	public static int statementUpdate(String sql) {
		int resultValue=0;
		DBconn.getInstance(); //�̹� �ؿ��� ������.
		try {
			if(st == null) {
				st = dbConn.createStatement();
			}
			resultValue = st.executeUpdate(sql);
//			if(n==1) {//n�� ����� ������ �ǹ��� ������ �����̸� �ε�ȣ ����
//				System.out.println("������Ʈ");
//			}
//			else {
//				System.out.println("������Ʈx");
//			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			//DBconn.dbClose();
		}
		
		return resultValue;
	}
	
	public static Connection getInstance() {
		if(dbConn == null) {
			try {
				//1. �����  DB Drive ���
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("����̹� �ε��Ϸ�");
				//2. �ش� DB ����
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "human";
				String pw ="human";
				dbConn = DriverManager.getConnection(url,user,pw);
				System.out.println("DB ���� �Ϸ�");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dbConn;
	}
	public static void dbClose() {
			try {
				if(rs != null) rs.close();
				if(st != null) st.close(); //������ ��������
				if(dbConn != null) dbConn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				rs = null;
				st = null;
				dbConn = null;
			}

			
	}
	public static int inputInt() {
		System.out.println("�����Է�>>");
		return Integer.parseInt(sc.nextLine());
	}
	public static double inputDouble() {
		System.out.println("�Ǽ��Է�>>");
		return Double.parseDouble(sc.nextLine());
	}
	
}
