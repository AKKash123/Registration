package mysql;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import mysql.Information;
import net.proteanit.sql.DbUtils;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class Form extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField roll;
	private JTextField scode;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form frame = new Form();
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
	public Form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 509);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(143, 188, 143));
		contentPane.setForeground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentDatabase = new JLabel("STUDENT DATABASE");
		lblStudentDatabase.setForeground(new Color(139, 0, 0));
		lblStudentDatabase.setBackground(new Color(128, 128, 0));
		lblStudentDatabase.setFont(new Font("Times New Roman", Font.BOLD, 28));
		lblStudentDatabase.setBounds(144, 29, 306, 40);
		contentPane.add(lblStudentDatabase);
		
		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setBounds(35, 188, 153, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblStudentRoll = new JLabel("Student Roll");
		lblStudentRoll.setForeground(new Color(128, 0, 0));
		lblStudentRoll.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblStudentRoll.setBounds(35, 152, 153, 25);
		contentPane.add(lblStudentRoll);
		
		JLabel lblSubjectCode = new JLabel("Subject Code");
		lblSubjectCode.setForeground(new Color(128, 0, 0));
		lblSubjectCode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSubjectCode.setBounds(35, 224, 153, 25);
		contentPane.add(lblSubjectCode);
		
		JLabel lblParentsCellph = new JLabel("Parents' Cell_ph:");
		lblParentsCellph.setForeground(new Color(128, 0, 0));
		lblParentsCellph.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblParentsCellph.setBounds(35, 256, 153, 25);
		contentPane.add(lblParentsCellph);
		
		name = new JTextField();
		name.setBounds(153, 192, 362, 20);
		contentPane.add(name);
		name.setColumns(10);
		
		roll = new JTextField();
		roll.setColumns(10);
		roll.setBounds(153, 150, 362, 20);
		contentPane.add(roll);
		
		scode = new JTextField();
		scode.setColumns(10);
		scode.setBounds(153, 224, 177, 20);
		contentPane.add(scode);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(163, 260, 253, 20);
		contentPane.add(phone);
		
		JButton btnAdddata = new JButton("ADD_DATA");
		btnAdddata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Name = name.getText();
				String Roll = roll.getText();
				String Code = scode.getText();
				String Phone = phone.getText();
				
				PreparedStatement st;
				String query = "INSERT INTO `student`(`roll`, `name`, `code`, `phone`) VALUES (?,?,?,?)";
				
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					st = con.prepareStatement(query);
					st.setString(1, Roll);
					st.setString(2, Name);
					st.setString(3, Code);
					st.setString(4, Phone);
					
					if(st.executeUpdate()>0) {
						
						JOptionPane.showMessageDialog(null,"Add_Student");
					}
					
			}catch(Exception ex) {
				System.out.println(ex);
			}	
			}
		});
		btnAdddata.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdddata.setBackground(new Color(46, 139, 87));
		btnAdddata.setForeground(new Color(0, 191, 255));
		btnAdddata.setBounds(35, 320, 128, 30);
		contentPane.add(btnAdddata);
		
		JButton btnRemovedata = new JButton("REMOVE_DATA");
		btnRemovedata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				roll.setText(null);
				name.setText(null);
				scode.setText(null);
				phone.setText(null);
				
			}
		});
		btnRemovedata.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemovedata.setForeground(new Color(0, 191, 255));
		btnRemovedata.setBackground(new Color(46, 139, 87));
		btnRemovedata.setBounds(221, 318, 161, 30);
		contentPane.add(btnRemovedata);
		
		
		
		JButton btnNewButton = new JButton("View_DATA");
		btnNewButton.setBackground(new Color(233, 150, 122));
		btnNewButton.setForeground(new Color(100, 149, 237));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Information in = new Information();
				in.setVisible(true);
			}
		});
		btnNewButton.setBounds(403, 320, 147, 31);
		contentPane.add(btnNewButton);
	}
}
