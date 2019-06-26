package agenda;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JFormattedTextField;

public class Cadastros extends JFrame {

	private JPanel contentPane;
	private JTextField entNomeevt;
	private JTextField entDataevt;
	private JTextField entDescricao;
	private JTextField entHoraevt;
	private JTextField entLocalevt;
	private JTextField entUserevt;
	private String[] options = {"Type of Event", "Meeting", "Workshop", "Lecture"};
	private JComboBox<String> cmbTipoEvt = new JComboBox<String>(options); 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastros frame = new Cadastros();
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
	public Cadastros() {
		setTitle("Register Events");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCriarEvento = new JLabel("Event Name");
		lblCriarEvento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCriarEvento.setBounds(10, 14, 73, 14);
		contentPane.add(lblCriarEvento);
		
		JLabel lblNewLabel = new JLabel("Date");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(241, 39, 50, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Location");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 67, 69, 14);
		contentPane.add(lblNewLabel_1);
		
		entNomeevt = new JTextField();
		entNomeevt.setBounds(93, 11, 139, 20);
		contentPane.add(entNomeevt);
		entNomeevt.setColumns(10);
		
		entDataevt = new JTextField();
		entDataevt.setBounds(301, 36, 73, 20);
		contentPane.add(entDataevt);
		entDataevt.setColumns(10);
		
		

		
		JLabel lblDescrio = new JLabel("Description");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(20, 129, 63, 14);
		contentPane.add(lblDescrio);
		
		entDescricao = new JTextField();
		entDescricao.setBounds(10, 154, 414, 62);
		contentPane.add(entDescricao);
		entDescricao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Register Event");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastrar();
			}
		});
		btnCadastrar.setBounds(145, 227, 146, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblHora = new JLabel("Time");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(242, 11, 45, 20);
		contentPane.add(lblHora);
		
		entHoraevt = new JTextField();
		entHoraevt.setColumns(10);
		entHoraevt.setBounds(301, 11, 73, 20);
		contentPane.add(entHoraevt);
		
		entLocalevt = new JTextField();
		entLocalevt.setColumns(10);
		entLocalevt.setBounds(93, 64, 139, 20);
		contentPane.add(entLocalevt);
		
		JLabel lblNomeUser = new JLabel("User Name");
		lblNomeUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeUser.setBounds(20, 39, 63, 14);
		contentPane.add(lblNomeUser);
		
		entUserevt = new JTextField();
		entUserevt.setColumns(10);
		entUserevt.setBounds(93, 36, 139, 20);
		contentPane.add(entUserevt);
		

		cmbTipoEvt.setBounds(241, 63, 183, 22);
		contentPane.add(cmbTipoEvt);
		/*String teste;
		teste = entTipoevt.getSelectedItem().toString();*/
		
	}
		
	public void Cadastrar() {
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
	      

		      
	          /*java.util.Date date = new java.util.Date();
	          long t = date.getTime();
	          java.sql.Date sqlDate = new java.sql.Date(t);
	          java.sql.Time sqlTime = new java.sql.Time(t);*/ 
	          
	          // create the mysql insert preparedstatement
		      String cadNomeevt = entNomeevt.getText();
		      String cadUserevt = entUserevt.getText();
		      String cadDataevt = entDataevt.getText();
		      String cadHoraevt = entHoraevt.getText();
		      String cadLocalevt = entLocalevt.getText();
		      String cadDescricao = entDescricao.getText();
		      Integer cadTipoEvento = cmbTipoEvt.getSelectedIndex();
		      
		      
		      //JComboBoxentTipoevt.getSelectedItem();

		      
		      
		      stt.executeUpdate("insert into eventagenda (eventname, username, eventdate, eventstarttime, description, location, id_eventtype)"	      
		      		+ "values ('"	      			
		    			+ cadNomeevt 
		    			+ "','"
		    			+ cadUserevt
		    			+ "',STR_TO_DATE('"
		    			+ cadDataevt
		    			+ "', '%d/%m/%Y'),'"
		    			+ cadHoraevt
		    			+ "','"
		    			+cadDescricao
		    			+ "','"
		    			+ cadLocalevt
		    			+ "',"
		    			+ cadTipoEvento.toString()
		    			+ ");");
				JOptionPane.showMessageDialog(null, "Registry saved!");
				/*+ cadDataevt
    			+ "', '%d/%m/%Y'),'"*/

		     
		      
		      con.close();
		    } 
			catch (SQLIntegrityConstraintViolationException e) 
			{
		    	JOptionPane.showMessageDialog(null, "You can't register same types of events on the same day!");
		    } 
			catch (Exception e)
	        {
	            e.printStackTrace();
		    }
		  }
	}