package exojdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import com.afcepf.paques.entities.Oeuf;

public class App {

	public static void main(String[] args) {

		//chargement de la base
//		try {
//			Class.forName("com.mysql.jdbc.Driver");  //nom complet de la classe qu'on veut charger  
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

		//paramètres de connexion 
		String bdd = "jdbc:mysql://localhost:3306/paques";
		String username = "root";
		String password = ""; 
		Connection cnx = null;
		try {
			cnx = DriverManager.getConnection(bdd, username, password); //objet de java.sql, renvoie une connection en fonction du driver chargé
			// création d'une commande
			Statement requete = cnx.createStatement(); 
			
			ResultSet resultat = requete.executeQuery("select * from oeuf");
			
			while(resultat.next())
			{
				Oeuf o = new Oeuf(resultat);
				System.out.println(o.toString());
			}
			
			//création d'un insert
			String libelle = "Oeuf lapin";
			String description = "Un oeuf kidnapé"; 
			double poids = 42.78; 
			Date dateLimite = new Date(Calendar.getInstance().getTime().getTime()); 
			
			PreparedStatement insert = cnx.prepareStatement("insert into oeuf (libelle,description,poids,dateLimite) values(?,?,?,?)");
			insert.setString(1, libelle);
			insert.setString(2, description);
			insert.setDouble(3, poids);
			insert.setDate(4, dateLimite);
			insert.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally
		{
			if(cnx != null)
			{
				try {
					cnx.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
