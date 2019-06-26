package agenda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ExibeConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField campoconsulta;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExibeConsulta frame = new ExibeConsulta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExibeConsulta() {
		setTitle("Check Events");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/**
		 * Adds an ActionListenner to the button with the method for querying the database.
		 */
		JButton Consultar = new JButton("I'm lucky");
		Consultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Consultar();
			}
		});
		Consultar.setBounds(171, 101, 91, 23);
		contentPane.add(Consultar);
		
		campoconsulta = new JTextField();
		campoconsulta.setBounds(118, 70, 200, 20);
		contentPane.add(campoconsulta);
		campoconsulta.setColumns(10);
		
		JLabel lblDigiteUmNome = new JLabel("Search the event by name");
		lblDigiteUmNome.setBounds(144, 45, 163, 14);
		contentPane.add(lblDigiteUmNome);
	}
		

	
	
	
	@SuppressWarnings("deprecation")
	public void Consultar(){
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
	      
	      /**
	       * creates the array that the project documentation asks for.
	       */
	      String[] StringList = new String[6];
	      
	      final char CR  = (char) 0x0D;
	      final char LF  = (char) 0x0A;
	      
			try
		    {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	          Connection con = DriverManager.getConnection(url, user, password);	          
	         
	          /**
	           *select a database for use. 
	           */
	          Statement stt = con.createStatement();
	          stt.execute("USE agenda"); 
	          
	          /**
	           * get the data from the input to query the database. In this case, we filter by the Event Name
	           */
	          String name= campoconsulta.getText();	         
	          String query =" select * from eventagenda where eventname like '"+name+"%'";
	          ResultSet rs = stt.executeQuery(query);
	          
	          /**
	           * populates the array with the query's ResultSet	
	           */
	          while(rs.next()) {	          		
	        	  StringList[0] = rs.getString("eventname");
	        	  StringList[1] = rs.getString("username");
	        	  StringList[2] = rs.getDate("eventdate").toString();
	        	  StringList[3] = rs.getString("eventstarttime");
	        	  StringList[4] = rs.getString("description");
	        	  StringList[5] = rs.getString("location");
	          		
	          		
	          		
	          		
	          		
	          		/**
	          		 * concatenates the string that goes on the message dialog
	          		 */
	          		JOptionPane.showMessageDialog(null, " Event name: " + StringList[0] + CR + LF +
	          											" Created by: " + StringList[1] + CR + LF +
	          											" Date: " + StringList[2] + CR + LF +
	          											" Hour: " + StringList[3] + CR + LF +
	          											" Description: " + StringList[4] + CR + LF +
	          											" Where: " + StringList[5]);
	          		//System.out.format("%s, %s, %s, %s, %s, %s |", cadNomeevt, cadUserevt, cadDataevt, cadHoraevt, cadDescricao, cadLocalevt );
	          	}
	          	stt.close();

		     
		      
		      con.close();
		    }
			catch (Exception e)
	        {
	            e.printStackTrace();
		    }
		  }
}

