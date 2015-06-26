package Util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbConnection {

		private static String url = "jdbc:postgresql://localhost:5432/";
		private static String user = "postgres";
		private static String passwd = "postgre";
		private static Connection laConn;
		private static Statement state;
		public static void connect(String url) 
		{
			Connection conn = null;
			DbConnection.url = "jdbc:postgresql://localhost:5432/BD_"+url;
			
			try {
				Class.forName("org.postgresql.Driver");
		      	System.out.println("Driver JDBC O.K.");
		      	conn = DriverManager.getConnection(DbConnection.url, user, passwd);
		      	System.out.println("Connexion JDBC effective !");
		      	DbConnection.laConn = conn;
				
		    }
			catch (Exception e)
			{
		      e.printStackTrace();
		    }   	
			
			
		  }
		
		public static void closeConnection () 
		{
			try {
				DbConnection.laConn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public static void insertIntoDB(String _table,String[] _colonnes, String[] _valeurs)
		{
			String _lesColonnes;
			String _lesValeurs;
			String _requeteGeneree;
			
			_requeteGeneree = "INSERT INTO " + "\""+ _table + "\" ";
			_lesValeurs = " (";
			_lesColonnes = " (";
			
			for( int i = 0; i<_colonnes.length ; i++ )
				{
					if (i == _colonnes.length - 1)
						_lesColonnes += "\""+_colonnes[i]+"\"";
					else
						_lesColonnes += "\""+_colonnes[i]+"\",";
					
				}
			_lesColonnes += ") ";
			
			for (int j = 0; j<_valeurs.length ; j++)
				{
				if (j == _valeurs.length - 1)
					_lesValeurs += "'"+_valeurs[j]+"'";
				else
					_lesValeurs += "'"+_valeurs[j]+"',";
				}
			
			_lesValeurs += ") ";
			
			_requeteGeneree = _requeteGeneree + _lesColonnes + "VALUES" + _lesValeurs + ";";
			
			//System.out.println("La requete INSERT générée est la suivante : " +_requeteGeneree);
			
			try {
				laConn.createStatement().execute(_requeteGeneree);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static ResultSet selectIntoDB(String _table,String[] _colonnes, String _where)
		{
			String _lesColonnes;
			String _requeteGeneree;
			
			_requeteGeneree = "SELECT " ;
			_lesColonnes = " ";
			if ( !_colonnes[0].equals("*"))
			{
			for( int i = 0; i<_colonnes.length ; i++ )
				{
					if (i == _colonnes.length - 1)
						_lesColonnes += "\""+_colonnes[i]+"\" ";
					else
						_lesColonnes += "\""+_colonnes[i]+"\",";
					
				}
			}
			else
			{
			_lesColonnes = "*";
			}
			if (_where != "")
				_requeteGeneree = _requeteGeneree + _lesColonnes + " FROM \"" + _table +"\" WHERE "+ _where+ ";";
			else
				_requeteGeneree = _requeteGeneree + _lesColonnes + " FROM \""+ _table + "\";";
				
			System.out.println("La requete SELECT générée est la suivante : " +_requeteGeneree);
			
			try {
				return laConn.createStatement().executeQuery(_requeteGeneree);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		
		public static void deleteIntoDB(String _table, String _where)
		{
			String _requeteGeneree;
			
			_requeteGeneree = "DELETE " ;
			if (_where != "")
				_requeteGeneree = _requeteGeneree + " FROM " + "\""+ _table + "\" " +" WHERE "+ _where+ ";";
			else
				_requeteGeneree = _requeteGeneree + " FROM " + "\""+ _table + "\";";
				
			System.out.println("La requete DELETE générée est la suivante : " +_requeteGeneree);
			
			try {
				laConn.createStatement().execute(_requeteGeneree);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		public static void updateIntoDB(String _table,String[] _colonnes,String[] valeurs, String _where)
		{
			String _lesColonnes;
			String _requeteGeneree;
			_requeteGeneree = "UPDATE " ;
			_lesColonnes = " ";

			for( int i = 0; i<_colonnes.length ; i++ )
				{
					if (i == _colonnes.length - 1)
						_lesColonnes += "\""+_colonnes[i]+"\" = '"+valeurs[i]+"'";
					else
						_lesColonnes += "\""+_colonnes[i]+"\"= '"+valeurs[i]+"',";
					
				}
			
			if (_where != "")
				_requeteGeneree = _requeteGeneree + "\"" + _table +"\" SET "+ _lesColonnes +" WHERE "+ _where+ ";";
			else
				System.out.println("DbConnection.updateIntoDB : <<La clause where n'est pas remplie>>");
				
			
			System.out.println(_requeteGeneree);
			try{
				
				laConn.createStatement().execute(_requeteGeneree);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		public static ResultSet executeSQL(String _request)
		{
			//Création d'un objet Statement
			
			
			try {
				state = DbConnection.laConn.createStatement();
				//L'objet ResultSet contient le résultat de la requête SQL
				ResultSet result = state.executeQuery(_request);
				return(result);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return(null);
		}

}
