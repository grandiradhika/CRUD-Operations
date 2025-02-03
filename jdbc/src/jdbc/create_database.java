package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class create_database {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String username="root";
	private static final String Password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
	
	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName(Driver);
		    conn=DriverManager.getConnection(url,username,Password);
		    System.out.println("enter db name:");
			String sql="create database " +sc.next();
			pmst=conn.prepareStatement(sql);
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("successfully created");
			}
			else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			
			
		} catch (Exception e) {
			System.out.println("db already exist");
			
		}
	}
	

}
