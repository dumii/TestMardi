package com.afcepf.paques.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Oeuf {
	
	private int id;
	private String libelle;
	private String description;
	private double poids;
	private Date dateLimite;
	public int getId() {
		return id;
	}
	
	public Oeuf(ResultSet rs) throws SQLException{
		
		this.id = rs.getInt("id");
		this.libelle = rs.getString("libelle");
		this.description = rs.getString("description");
		this.poids = rs.getDouble("poids"); 
		this.dateLimite = rs.getDate("dateLimite"); 
	}

	public Oeuf(int id, String libelle, String description, double poids,
			Date dateLimite) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.description = description;
		this.poids = poids;
		this.dateLimite = dateLimite;
	}
	
	public Oeuf(){
		
	}

	public Oeuf(String libelle, String description, double poids,
			Date dateLimite) {
		super();

		this.libelle = libelle;
		this.description = description;
		this.poids = poids;
		this.dateLimite = dateLimite;
	}

	public Oeuf(int i) {
		this.id = i; 
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPoids() {
		return poids;
	}
	public void setPoids(double poids) {
		this.poids = poids;
	}
	public Date getDateLimite() {
		return dateLimite;
	}
	public void setDateLimite(Date dateLimite) {
		this.dateLimite = dateLimite;
	} 
	
	public String toString()
	{
		return this.id +" - "+ this.libelle + " " + this.dateLimite; 
	}
	
}
