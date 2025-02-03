package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class login {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3306/registration";
	private static Connection conn;
	private static PreparedStatement pmst;

	public static void main(String[] args) {
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter username/email:");
			String username=sc.next();
			System.out.println("enter password");
			String password=sc.next();
			String sql="select * from  registrationdetails where email=? and password=?";
			pmst=conn.prepareStatement(sql);
			pmst.setString(1,username);
			pmst.setString(2,password);
			ResultSet rs=pmst.executeQuery();
			if(rs.next()) {
				System.out.println("successfully login");
			}
			else {
				System.out.println("invalid user");
			}
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
