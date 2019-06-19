package agenda;

import java.sql.Connection;
import java.sql.DriverManager;


/**
	 * Imports all entries from the java.sql library. 
	 * Improve on this by only importing needed classes. 
	 * E.g.:
	 * import java.sql.Connection
	 * import java.sql.Statement
	 * ...
	 */
	import java.sql.*;

	public class Connect
	{
	    public static void main(String[] args)
	    {

	        /**
	         * 3306 is the default port for MySQL in XAMPP. Note both the 
	         * MySQL server and Apache must be running. 
	         */
	        String url = "jdbc:mysql://localhost:3306/";

	        /**
	         * The MySQL user.
	         */
	        String user = "root";

	        /**
	         * Password for the above MySQL user. If no password has been 
	         * set (as is the default for the root user in XAMPP's MySQL),
	         * an empty string can be used.
	         */
	        String password = "";

	        try
	        {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            Connection con = DriverManager.getConnection(url, user, password);

	            Statement stt = con.createStatement();

	            /**
	             * Create and select a database for use. 
	             */
	            stt.execute("CREATE DATABASE IF NOT EXISTS agenda");
	            stt.execute("USE agenda");

	             /**
	             * Query people entries 
	             */
	            ResultSet res = stt.executeQuery("SELECT * FROM users");	
	            
	            /**
	             * Iterate over the result set from the above query
	             */
	            while (res.next())
	            {
	                System.out.println(res.getString("name"));
	            }
	            System.out.println("");

	          
	            /**
	             * Free all opened resources
	             */
	            res.close();
	            stt.close();
	            con.close();

	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	}

	

