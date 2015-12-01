package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.omg.Messaging.SyncScopeHelper;

public class Main {

	private final static String QUERY_BALANCE = "SELECT balance FROM ATM.Information WHERE login = ? AND password = ?";
	private final static String QUERY_LOGIN = "SELECT password, attempts FROM ATM.Information WHERE login = ?";
	private int fullCash = 500000000;

	public static void main(String ... args) throws SQLException{
		long cardNumber = 0;
		int password = 0;
		
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "robotone123");
		PreparedStatement statement = conn.prepareStatement(QUERY_BALANCE);
		statement.setLong(1, cardNumber);
		
		ResultSet rs = statement.executeQuery();
		while(rs.next()){
		}
		conn.close();
	}
	
}
