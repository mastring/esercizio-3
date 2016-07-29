package it.ads.formazione;
import java.io.*;
import java.util.List;
import java.sql.*;
public class ProvaCorso1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String path = "C:/Users/zzsm415/workspace/ProvaCorso1/client.txt";
		Clients clients = new Clients();
		File file1 = new File(path);
		if (file1.exists()){
		      System.out.println("Il file "+ path + " esiste");
		} else {
			try {
				FileOutputStream file = new FileOutputStream(path);
		    	} catch (IOException e) {
		    		System.out.println("Errore: " + e);
		    		System.exit(1);
		    	}
		}
			

	

		String contenuto = "Mario;Rossi;Via del Corso 11;Roma\nAlberto;Verdi;Via del Tritone 100;Roma\nGennaro;Caputo;Via del Miglio 78;Milano";
	    try {
	    	File file = new File(path);
	    	FileWriter fw = new FileWriter(file);
	    	fw.write(contenuto);
	    	fw.flush();
	    	fw.close();
	    	}
	    	catch(IOException e) { 
	    		e.printStackTrace();
	    	}

	
	   
    	try {
     		Connection connection = null;
     		Statement stmt;
     		Class.forName("org.sqlite.JDBC");
     		connection = DriverManager.getConnection("jdbc:sqlite:Clients.db");
     		System.out.println("Opened database successfully");

     		stmt = connection.createStatement();
     		String sql =  "CREATE TABLE CLIENTS " + "(ID ," +  " FIRST NAME, " + " LAST NAME, " + " ADDRESS, " + " CITY)"; 
     		stmt.executeUpdate(sql);

     		stmt.close();
     		connection.close();
  
    		} catch ( Exception e ) {
    			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    			System.exit(0);
    		} 
    	System.out.println("Table created successfully");
	
	   
	   
	
      // lettura da file
      
    	char [] in = new char [1000];
    	int size = 0;
    	try {
        //File file = new File(path);
        FileReader fr = new FileReader(path);

        size = fr.read(in);

        System.out.print("Caratteri presenti: "	+ size + "\n");

        System.out.print("Il contenuto del file è il seguente:\n");

        for(int i=0; i<size; i++) {
        	System.out.print(in[i]);
        	fr.close();
        }

      	}

      
      	catch(IOException e) { 
      		e.printStackTrace();
      	}
    	
    	
    	clients.lettura(path);
	
	}
}

