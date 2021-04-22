package register;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.*;

public class DBConnect {
	static Connection con;


	static
	{
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/interview_track_sys", "root","shreyas");
			System.out.println("connected....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
