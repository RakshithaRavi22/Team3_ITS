package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.*;

public class DBConnect {
	public static Connection con;


	static
	{
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interview_track_sys", "root","root123");
			System.out.println("connected....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
