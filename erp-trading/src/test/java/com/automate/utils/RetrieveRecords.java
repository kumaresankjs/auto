package com.automate.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class RetrieveRecords extends TradingBaseUtilityClass {

	public static ArrayList<String> executeSQLQueryList(String sqlQuery) {
		propertyFile("jdbc");
		jdbcDriver = property.getProperty("driver");
		dbUrl = property.getProperty("database");
		dbUser = property.getProperty("dbUser");
		dbPassword = property.getProperty("dbPassword");
		Connection con = null;
		ArrayList<String> resultValue = new ArrayList<String>();

		try {
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

			Statement retrieve = con.createStatement();
			ResultSet resultSet = retrieve.executeQuery(sqlQuery);
			try {
				while (resultSet.next()) {
					int columnCount = resultSet.getMetaData().getColumnCount();
					StringBuilder builder = new StringBuilder();
					for (int i = 1; i <= columnCount; i++) {
						builder.append(resultSet.getString(i).trim() + " ");
					}
					String reqValue = builder.substring(0, builder.length() - 1);
					resultValue.add(reqValue);
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (NullPointerException ex) {
				System.out.println("No records founds" + ex.getStackTrace());
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException ex) {
						System.out.println("SQL Exception" + ex.getStackTrace());
					}
				}
			}
		} catch (SQLException | ClassNotFoundException ex) {
			System.out.println("Exception encountered- " + ex.getStackTrace());
		}
		return resultValue;
	}
}
