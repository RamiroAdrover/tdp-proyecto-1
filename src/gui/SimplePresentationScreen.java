package gui;



import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;

import javax.swing.ImageIcon;


import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JTextField textfieldLU;
	private JTextField textFieldLastname;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldGithubURL;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Image icon = Toolkit.getDefaultToolkit().getImage("/images/tdp.png"); 
        setIconImage(icon); 
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(620, 270));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 420, 200);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 11));
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		//Labels
		JLabel lblLU = new JLabel("LU");
		lblLU.setBounds(23, 11, 29, 21);
		lblLU.setFont(new Font("Arial", Font.BOLD, 13));
		tabInformation.add(lblLU);
		
		JLabel lblLastname =new JLabel("Apellido");
		lblLastname.setFont(new Font("Arial", Font.BOLD, 13));
		lblLastname.setBounds(23, 42, 66, 21);
		tabInformation.add(lblLastname);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setFont(new Font("Arial", Font.BOLD, 13));
		lblName.setBounds(23, 73, 66, 21);
		tabInformation.add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 13));
		lblEmail.setBounds(23, 100, 66, 21);
		tabInformation.add(lblEmail);
		
		JLabel lblGithubUrl = new JLabel("Github URL");
		lblGithubUrl.setFont(new Font("Arial", Font.BOLD, 13));
		lblGithubUrl.setBounds(23, 132, 78, 21);
		tabInformation.add(lblGithubUrl);
		
		JLabel lblPhoto = new JLabel("");
		lblPhoto.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPhoto.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource(studentData.getPathPhoto())).getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
		lblPhoto.setBounds(436, 24, 192, 181);
	
		contentPane.add(lblPhoto);
		
		//get current time and change the format
		LocalTime now = LocalTime.now();
		String formattedTime = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		
		//get current date and change the format
		LocalDate today = LocalDate.now();
		String formattedDate = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
		JLabel lblmensage = new JLabel("Esta ventana fue generada el "+formattedDate+" a las "+formattedTime);
		lblmensage.setBounds(15, 206, 556, 14);
		contentPane.add(lblmensage);
		
		
		//Textfields
		textfieldLU = new JTextField();
		textfieldLU.setFont(new Font("Arial", Font.PLAIN, 13));
		textfieldLU.setEditable(false);
		textfieldLU.setBounds(109, 11, 289, 20);
		textfieldLU.setText(String.valueOf(studentData.getId()));
		tabInformation.add(textfieldLU);
		textfieldLU.setColumns(10);
		
		textFieldLastname = new JTextField();
		textFieldLastname.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldLastname.setEditable(false);
		textFieldLastname.setColumns(10);
		textFieldLastname.setBounds(109, 42, 289, 20);
		textFieldLastname.setText(studentData.getLastName());
		tabInformation.add(textFieldLastname);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldName.setEditable(false);
		textFieldName.setColumns(10);
		textFieldName.setBounds(109, 73, 289, 20);
		textFieldName.setText(studentData.getFirstName());
		tabInformation.add(textFieldName);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(109, 100, 289, 20);
		textFieldEmail.setText(studentData.getMail());
		tabInformation.add(textFieldEmail);
		
		textFieldGithubURL = new JTextField();
		textFieldGithubURL.setFont(new Font("Arial", Font.PLAIN, 13));
		textFieldGithubURL.setEditable(false);
		textFieldGithubURL.setColumns(10);
		textFieldGithubURL.setBounds(109, 132, 289, 20);
		textFieldGithubURL.setText(studentData.getGithubURL());
		tabInformation.add(textFieldGithubURL);
		contentPane.add(tabbedPane);
		
		
	}
}
