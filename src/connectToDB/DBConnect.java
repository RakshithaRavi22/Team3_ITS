package connectToDB;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.util.*;

public class DBConnect {
	Connection con;
	
	public DBConnect()
	{
		try
		{
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/its", "root","shreyas");
			System.out.println("connected....");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
