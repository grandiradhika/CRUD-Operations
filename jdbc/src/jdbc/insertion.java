package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
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
			String sql="insert into registrationdetails(name,email,password) values(?,?,?)";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter name:" );
			pmst.setString(1, sc.next());
			System.out.println("enter email:");
			pmst.setString(2, sc.next());
			System.out.println("enter password");
			pmst.setString(3, sc.next());
			int i=pmst.executeUpdate();
			if(i>0) {
				System.out.println("data is inserted");
			}
			else {
				System.out.println("error");
			}
			conn.close();
			pmst.close();
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
