package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import mysql.Login_system;
public class Registartion extends JFrame{

	private JPanel contentPane;
	private JPasswordField Password;
	private JPasswordField ConfirmPass;
	private JTextField Name;
	private JTextField Username;
	private JTextField txtRegistrationPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registartion frame = new Registartion();
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
	public Registartion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 452);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(154, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setFont(new Font("Shruti", Font.BOLD, 16));
		lblName.setBounds(50, 90, 60, 32);
		contentPane.add(lblName);
		
		JLabel lblUserName = new JLabel("User name ");
		lblUserName.setFont(new Font("Shruti", Font.BOLD, 16));
		lblUserName.setBounds(50, 156, 83, 32);
		contentPane.add(lblUserName);
		
		Password = new JPasswordField();
		Password.setBounds(165, 217, 214, 32);
		contentPane.add(Password);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Shruti", Font.BOLD, 16));
		lblPassword.setBounds(50, 218, 83, 32);
		contentPane.add(lblPassword);
		
		ConfirmPass = new JPasswordField();
		ConfirmPass.setBounds(165, 281, 224, 32);
		contentPane.add(ConfirmPass);
		
		JLabel lblConfirmPassword = new JLabel(" Confirm password");
		lblConfirmPassword.setFont(new Font("Shruti", Font.BOLD, 16));
		lblConfirmPassword.setBounds(20, 282, 135, 32);
		contentPane.add(lblConfirmPassword);
		
		JButton btnUpdate = new JButton("Clear");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name.setText(null);
				Username.setText(null);
				Password.setText(null);
				ConfirmPass.setText(null);
				
			}
		});
		btnUpdate.setBackground(new Color(60, 179, 113));
		btnUpdate.setBounds(72, 358, 95, 32);
		contentPane.add(btnUpdate);
		
		JButton button = new JButton("UPdate");
		button.setFont(new Font("Tahoma", Font.BOLD, 17));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = Name.getText();
				String username = Username.getText();
				String pass = String.valueOf(Password.getPassword());
				String conpass = String.valueOf(ConfirmPass.getPassword());
				
				PreparedStatement st;
				String query = "INSERT INTO `registration`( `name`, `username`, `pass`, `conpass`) VALUES (?,?,?,?)";
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					st = con.prepareStatement(query);
					st.setString(1, name);
					st.setString(2, username);
					st.setString(3, pass);
					st.setString(4, conpass);
					
					if(st.executeUpdate()>0) {
						JOptionPane.showMessageDialog(null, "New user Add");
					}
				}catch(Exception ex) {
					System.out.println(ex);
				}
						
			}
		});
		button.setBackground(new Color(60, 179, 113));
		button.setBounds(214, 358, 111, 32);
		contentPane.add(button);
		
		JButton btnLogin = new JButton("LoGin");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Login_system Info = new Login_system();
				Info.setVisible(true);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnLogin.setBackground(new Color(60, 179, 113));
		btnLogin.setBounds(357, 358, 95, 32);
		contentPane.add(btnLogin);
		
		Name = new JTextField();
		Name.setBounds(165, 95, 209, 32);
		contentPane.add(Name);
		Name.setColumns(10);
		
		Username = new JTextField();
		Username.setColumns(10);
		Username.setBounds(165, 161, 209, 32);
		contentPane.add(Username);
		
		txtRegistrationPage = new JTextField();
		txtRegistrationPage.setEditable(false);
		txtRegistrationPage.setFont(new Font("Bodoni MT", Font.BOLD, 17));
		txtRegistrationPage.setText("                REGISTRATION  PAGE");
		txtRegistrationPage.setBackground(new Color(46, 139, 87));
		txtRegistrationPage.setBounds(86, 23, 323, 43);
		contentPane.add(txtRegistrationPage);
		txtRegistrationPage.setColumns(10);
	}
}
