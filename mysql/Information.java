package mysql;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.*;
import java.awt.Color;
import java.awt.Font;

public class Information extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Information frame = new Information();
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
	public Information() {
		setBackground(new Color(102, 102, 153));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 369);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 496, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("LOAD student info");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

		
				try {	
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","");
					String query = "SELECT * FROM `student`";
					PreparedStatement st = con.prepareStatement(query);
					ResultSet rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
			}catch(Exception ex) {
				System.out.println(ex);
			}	
			}
		});
		btnNewButton.setBounds(264, 11, 269, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblInformationTable = new JLabel("INFORMATION TABLE");
		lblInformationTable.setBackground(new Color(102, 204, 51));
		lblInformationTable.setFont(new Font("Sylfaen", Font.BOLD, 16));
		lblInformationTable.setBounds(68, 21, 226, 21);
		contentPane.add(lblInformationTable);
	}
}
