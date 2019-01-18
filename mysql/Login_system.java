package mysql;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import mysql.Form;;

public class Login_system extends JFrame {

	private JPanel contentPane;
	private JTextField Username;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_system frame = new Login_system();
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
	public Login_system() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 305);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 133, 63));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Username = new JTextField();
		Username.setBounds(143, 62, 172, 32);
		contentPane.add(Username);
		Username.setColumns(10);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblLogin.setBackground(new Color(160, 82, 45));
		lblLogin.setForeground(new Color(0, 0, 0));
		lblLogin.setBounds(161, 11, 77, 32);
		contentPane.add(lblLogin);
		
		JLabel lblUserName = new JLabel("User name");
		lblUserName.setForeground(Color.BLACK);
		lblUserName.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblUserName.setBackground(new Color(160, 82, 45));
		lblUserName.setBounds(38, 62, 77, 32);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tempus Sans ITC", Font.BOLD, 15));
		lblPassword.setBackground(new Color(160, 82, 45));
		lblPassword.setBounds(38, 120, 77, 32);
		contentPane.add(lblPassword);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});
		btnNewButton.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(38, 207, 94, 32);
		contentPane.add(btnNewButton);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					Statement stmt = con.createStatement();
					@SuppressWarnings("deprecation")
					String sql = "Select*from registration where username ='"+Username.getText()+"'and pass ='"+Password.getText().toString()+"'";
					ResultSet  rs = stmt.executeQuery(sql);
					if(rs.next()) {
						Form Info = new Form();
					Info.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null,"Incorrect Username and password!");
					con.close();
					
				}catch(Exception ex) {
					System.out.println(ex);
				}
			}
		});
		btnNext.setFont(new Font("Trebuchet MS", Font.PLAIN, 14));
		btnNext.setBackground(new Color(124, 252, 0));
		btnNext.setBounds(268, 207, 94, 32);
		contentPane.add(btnNext);
		
		Password = new JPasswordField();
		Password.setBounds(143, 120, 172, 32);
		contentPane.add(Password);
	}
}
