package it.ads.formazione;

import java.sql.*;
import java.io.*;
import java.util.*;



public class Clients {
	String path = "C:/Users/zzsm415/workspace/ProvaCorso1/client.txt";	
	Connection connection = null;
	Statement stmt;
	 
	 String first_name;
	 String last_name;
	 String address;
	 String city;
	 //id, first_name, last_name, address, city
	 public Clients (int id, String first_name, String last_name, String address, String city){
			
			this.first_name = first_name;
			this.last_name = last_name;
			this.address = address;
			this.city=city;
		}
	 
	 	public Clients (){
	 		
	 	}
	 
	
	public void lettura(String file) throws IOException {


		FileReader f;
		
	
	    f=new FileReader(path);

	    BufferedReader b;
	    b=new BufferedReader(f);

	    String s;

	    while(true) {
	      s=b.readLine();
	     
	      if(s==null)
	        break;
	      System.out.println("\n"+s);
	    }
		b.close();
	
}	

public List<Clients> findAll() throws SQLException{
		Statement statement = connection.createStatement();
		List clients = new ArrayList(); 
		String sql=null;
		//
		 
		ResultSet resultSet = statement.executeQuery(sql);
		while ( resultSet.next() ) {
			int id = resultSet.getInt("id");
		 	String  first_name = resultSet.getString("name");
		 	String  last_name = resultSet.getString("lastname");
		 	String  address = resultSet.getString("address");
		 	String  city = resultSet.getString("city");
		 	
		 	Clients clienti = new Clients (id, first_name, last_name, address, city);
		 	
		 	
	       
		 	clients.add(clienti);
	        
	     }
		
		 return clients;
	//ritorna un array list di tipo clients
	
		
	}






}	

		
