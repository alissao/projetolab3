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
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.JFormattedTextField;

public class Cadastros extends JFrame {

	private JPanel contentPane;
	private JTextField entNomeevt;
	private JTextField entDataevt;
	private JTextField entDescricao;
	private JTextField entHoraevt;
	private JComboBox entTipoevt;
	private JTextField textField;

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
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCriarEvento = new JLabel("Nome do evento");
		lblCriarEvento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCriarEvento.setBounds(45, 14, 119, 14);
		contentPane.add(lblCriarEvento);
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(95, 107, 69, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(118, 132, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		entNomeevt = new JTextField();
		entNomeevt.setBounds(174, 11, 168, 20);
		contentPane.add(entNomeevt);
		entNomeevt.setColumns(10);
		
		entDataevt = new JTextField();
		entDataevt.setBounds(174, 104, 73, 20);
		contentPane.add(entDataevt);
		entDataevt.setColumns(10);
		
		

		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o/Local");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(85, 162, 79, 14);
		contentPane.add(lblDescrio);
		
		entDescricao = new JTextField();
		entDescricao.setBounds(174, 160, 204, 62);
		contentPane.add(entDescricao);
		entDescricao.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar Evento");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastrar();
			}
		});
		btnCadastrar.setBounds(145, 227, 146, 23);
		contentPane.add(btnCadastrar);
		
		JLabel lblHora = new JLabel("Hora");
		lblHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHora.setBounds(95, 70, 69, 20);
		contentPane.add(lblHora);
		
		entHoraevt = new JTextField();
		entHoraevt.setColumns(10);
		entHoraevt.setBounds(174, 73, 73, 20);
		contentPane.add(entHoraevt);
		
		JComboBox<String> entTipoevt = new JComboBox<String>();
		entTipoevt.addItem("--Selecionar--");
		entTipoevt.addItem("Prova");
		entTipoevt.addItem("Entrega Trabalho");
		entTipoevt.addItem("Palestra");
		entTipoevt.addItem("Outro");
		entTipoevt.setBounds(174, 129, 117, 20);
		contentPane.add(entTipoevt);
		
		JLabel lblNomeUser = new JLabel("User Name");
		lblNomeUser.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNomeUser.setBounds(45, 42, 119, 14);
		contentPane.add(lblNomeUser);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(174, 39, 168, 20);
		contentPane.add(textField);
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
	      

		      // create the mysql insert preparedstatement
		      String cadNomeevt = entNomeevt.getText();
		      String cadDataevt = entDataevt.getText();
		      String cadHoraevt = entHoraevt.getText();
		      String cadTipoevt = entTipoevt.getSelectedItem().toString();
		      String cadDescricao = entDescricao.getText();
		      
		      //JComboBoxentTipoevt.getSelectedItem();

		      
		      
		      stt.executeUpdate("insert into eventagenda (eventname, eventdate, eventstarttime, location)"	      
		      		+ "values ('"	      			
		    			+ cadNomeevt 
		    			+ "','"
		    			+ cadDataevt
		    			+ "','"
		    			+ cadHoraevt
		    			+ "','"
		    			+ cadTipoevt
		    			+ "','"
		    			+ cadDescricao
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