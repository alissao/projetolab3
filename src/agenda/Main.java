package agenda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastros frame = new Cadastros();
				frame.setVisible(true);
			}
		});
		btnCadastrar.setBounds(102, 127, 91, 66);
		contentPane.add(btnCadastrar);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExibeConsulta frame = new ExibeConsulta();
				frame.setVisible(true);
			}
		});
		btnConsultar.setBounds(240, 127, 91, 66);
		contentPane.add(btnConsultar);
		
		JPanel panel = new JPanel();
		panel.setBounds(117, 92, 196, 24);
		contentPane.add(panel);
		
		JLabel lblMenu = new JLabel("Bem Vindo!");
		panel.add(lblMenu);
		
		JLabel lblNewLabel = new JLabel("@");
		panel.add(lblNewLabel);
	}
	public void Consultar(){
		 
	      String url = "jdbc:mysql://localhost:3306/";

	      String user = "root";
	     
	      String password = "";
	      
			try
		    {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
	          Connection con = DriverManager.getConnection(url, user, password);	          
	          
	          Statement stt = con.createStatement();
	          String query = "Select * from tabela";
	          ResultSet rs = stt.executeQuery(query);
	          
	          	//trocar nomes de acordo com a tabela
	          	while(rs.next()) {
	          		int id = rs.getInt("id");
	          		String first_name = rs.getString("first_name");
	          		Date dateCreated = rs.getDate("date_created");
	          		boolean isAdmin = rs.getBoolean("is_admin");
	          		int num_points = rs.getInt("num_points");
	          		
	          		System.out.format("%s, %s, %s, %s, %s", id, first_name, dateCreated, isAdmin, num_points);
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
