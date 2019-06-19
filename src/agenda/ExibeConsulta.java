package agenda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ExibeConsulta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

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
		setTitle("Agenda");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Aluno");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(105, 47, 96, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(211, 44, 104, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEvento = new JLabel("Evento");
		lblEvento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEvento.setBounds(105, 72, 96, 14);
		contentPane.add(lblEvento);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(211, 69, 104, 20);
		contentPane.add(textField_1);
		
		JLabel lblDatahora = new JLabel("data/hora");
		lblDatahora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDatahora.setBounds(105, 103, 96, 14);
		contentPane.add(lblDatahora);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(211, 100, 104, 20);
		contentPane.add(textField_2);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTipo.setBounds(105, 131, 96, 14);
		contentPane.add(lblTipo);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(211, 128, 104, 20);
		contentPane.add(textField_3);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescrio.setBounds(105, 159, 96, 14);
		contentPane.add(lblDescrio);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(211, 159, 104, 84);
		contentPane.add(textField_4);
	}
}
