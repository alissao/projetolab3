package agenda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.sql.*;

public class Login {

	private JFrame frmAgenda;
	private JTextField entLogin;
	private JTextField entSenha;
	private JTextField entNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAgenda.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAgenda = new JFrame();
		frmAgenda.setTitle("Agenda");
		frmAgenda.setBounds(100, 100, 411, 182);
		frmAgenda.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAgenda.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(24, 56, 46, 14);
		frmAgenda.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(0, 87, 70, 14);
		frmAgenda.getContentPane().add(lblNewLabel_1);
		
		entLogin = new JTextField();
		entLogin.setBounds(80, 53, 86, 20);
		frmAgenda.getContentPane().add(entLogin);
		entLogin.setColumns(10);
		
		entSenha = new JTextField();
		entSenha.setColumns(10);
		entSenha.setBounds(80, 84, 86, 20);
		frmAgenda.getContentPane().add(entSenha);
		
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logar();
				/*Main frame = new Main();
				frame.setVisible(true);*/
			}
		});
		Login.setBounds(80, 119, 91, 23);
		frmAgenda.getContentPane().add(Login);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(24, 25, 46, 14);
		frmAgenda.getContentPane().add(lblName);
		
		entNome = new JTextField();
		entNome.setColumns(10);
		entNome.setBounds(80, 22, 267, 20);
		frmAgenda.getContentPane().add(entNome);
	}
	public void Logar() {
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
           *select a database for use. 
           */
          stt.execute("USE agenda");
	    
	      
         /* stt.execute("INSERT INTO people (fname, lname) VALUES" + 
                  "('Joe', 'Bloggs'), ('Mary', 'Bloggs'), ('Jill', 'Hill')");*/

	     /* // the mysql insert statement         
        	stt.execute (" insert into users (id_user,login,name,password)"
	        + " values (?, cadLogin = Integer.parseInt(entLogin.getText());, ?)");*/

	      // create the mysql insert preparedstatement
	      String cadLogin = entLogin.getText();
	      String cadNome = entNome.getText();
	      String cadSenha = entSenha.getText();
	      
	      stt.executeUpdate("insert into users (name, login, password)"	      
	      		+ "values ('"	      			
	    			+ cadNome 
	    			+ "','"
	    			+ cadLogin
	    			+ "','"
	    			+ cadSenha
	    			+ "')");
			JOptionPane.showMessageDialog(null, "Dados Salvos!");

	     
	      
	      con.close();
	    }
		catch (Exception e)
        {
            e.printStackTrace();
	    }
	  }
}


