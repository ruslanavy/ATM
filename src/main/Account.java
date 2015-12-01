package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.TreeSet;

public class Account {
	private double balance;
	private long cardNumber;
	private int password;

	public static void main(String... args) throws SQLException, InstantiationException, IllegalAccessException {
		 new Account(12345678912345678L, 1234, 1200).setBalance(-178);

	}

	public Account(long cardNumber, int password, double balance) throws SQLException {

		this.password = password;
		this.cardNumber = cardNumber;
		this.balance = balance;

	}

	public int getPassword() {
		return password;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public double getBalance() {
		return balance;
	}

	public boolean setBalance(double balance) throws SQLException {
		if (this.balance + balance < 0) {
			return false;
		}
		this.balance += balance;

		String updateQuery = "UPDATE ATM.Information SET balance = ?  WHERE login = ? ";

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "robotone123");
		PreparedStatement ps = conn.prepareStatement(updateQuery);
		ps.setLong(2, cardNumber);
		ps.setDouble(1, this.balance);
		ps.executeUpdate();
		return true;
	}
/*
	private static void getConnection(Connection conn) throws SQLException {
		if (conn != null) {
			// ResultSet rs = conn.getMetaData().getCatalogs();
			Statement st = conn.createStatement();
			// st.executeUpdate("DROP table ATM.Information");
			int result = st.executeUpdate(
					" CREATE table IF NOT EXISTS ATM.Information(login BIGINT(16) NOT NULL, password INT(4) NOT NULL, balance DOUBLE NOT NULL, attempts	 TINYINT(1),  PRIMARY KEY(login))");
		}
		return;
	}
*/
}
