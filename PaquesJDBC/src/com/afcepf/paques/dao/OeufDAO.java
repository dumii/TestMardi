package com.afcepf.paques.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.afcepf.paques.entities.Oeuf;

public class OeufDAO extends BaseDAO {

	
	public ArrayList<Oeuf> getAll(){
		ArrayList<Oeuf> result = new ArrayList<Oeuf>();
		Statement requete = null;
		ResultSet resultatRequete = null;
		Connection cnx = null;
		try {
			cnx = this.recupererConnection(); 
			requete = cnx.createStatement();
			resultatRequete = requete.executeQuery("select * from oeuf");
			
			while(resultatRequete.next())
			{
				result.add(new Oeuf(resultatRequete)); 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			fermetureResultSet(resultatRequete); 
			fermetureStatement(requete);
			fermetureConnection(cnx);
		}
		return result;
	}
	
	public Oeuf getById(int id){
		Oeuf result = null;
		PreparedStatement requete = null;
		ResultSet resultatRequete = null;
		Connection cnx = null;
		
		try {
			cnx = this.recupererConnection(); 
			requete = cnx.prepareStatement("select * from oeuf where id=?");
			requete.setInt(1, id);
			
			resultatRequete = requete.executeQuery();			
			
			if(resultatRequete.next())
				result = new Oeuf(resultatRequete); 
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			fermetureResultSet(resultatRequete); 
			fermetureStatement(requete);
			fermetureConnection(cnx);
		}
		return result;
	}
	
	public void insert(Oeuf oeuf){
		
		String libelle = oeuf.getLibelle();
		String description = oeuf.getDescription(); 
		double poids = oeuf.getPoids(); 
		Date dateLimite = new Date(oeuf.getDateLimite().getTime());  
		
		Connection cnx = null; 
		PreparedStatement insert = null; 
		ResultSet rs = null; 
		try{
		cnx = this.recupererConnection();
		
		insert = cnx.prepareStatement("insert into oeuf (libelle,description,poids,dateLimite) values(?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		insert.setString(1, libelle);
		insert.setString(2, description);
		insert.setDouble(3, poids);
		insert.setDate(4, dateLimite);
		insert.executeUpdate();
		
		rs =insert.getGeneratedKeys();
		if(rs.next())
		{
		
			oeuf.setId(rs.getInt(1));
		}
		//TODO : récupérer l'id de l'oeuf créé

	} catch (SQLException e) {
		e.printStackTrace();
	} 
	finally
	{
		fermetureResultSet(rs); 
		fermetureStatement(insert);
		fermetureConnection(cnx); 
	}
	}
	
	public void update (Oeuf oeuf){
		String libelle = oeuf.getLibelle();
		String description = oeuf.getDescription(); 
		double poids = oeuf.getPoids(); 
		Date dateLimite = new Date(oeuf.getDateLimite().getTime());  
		int id = oeuf.getId();

		Connection cnx = null; 
		PreparedStatement update = null; 
		try{
			cnx = this.recupererConnection();

			update = cnx.prepareStatement("update oeuf set libelle=?,description=?,poids=?,dateLimite=? where id=?");
			update.setString(1, libelle);
			update.setString(2, description);
			update.setDouble(3, poids);
			update.setDate(4, dateLimite);
			update.setInt(5, id);
			
			update.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally
		{
			fermetureStatement(update);
			fermetureConnection(cnx); 
		}
	}
	
	public void delete (int oeuf){
		//String libelle = oeuf.getLibelle();
		int id = oeuf;

		Connection cnx = null; 
		PreparedStatement delete = null; 
		try{
			cnx = this.recupererConnection();

			delete = cnx.prepareStatement("delete from oeuf where id=?");
			delete.setInt(1, id);
			
			delete.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally
		{
			fermetureStatement(delete);
			fermetureConnection(cnx); 
		}
	}
	

	
}
