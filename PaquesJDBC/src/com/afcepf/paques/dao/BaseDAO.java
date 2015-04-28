package com.afcepf.paques.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class BaseDAO {
	
	static {  //executer une seule fois quand l'appli sera chargée sur le serveur
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected Connection recupererConnection(){
		Connection connexion = null;
		String bdd = "jdbc:mysql://localhost:3306/paques";
		String username = "root";
		String password = ""; 
		try {
				connexion = DriverManager.getConnection(bdd,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return connexion; 
	}
	
	protected void fermetureResultSet(ResultSet rs)
	{
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void fermetureStatement(Statement st){
		try {
			if(st != null)
				st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void fermetureConnection(Connection cnx){
		try {
			if(cnx != null)
				cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
