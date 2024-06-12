package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class StudentLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tx_username;
	private String anhbasic;
	private JPasswordField tx_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					StudentLogin frame = new StudentLogin();
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
	public StudentLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 384);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 10, 646, 45);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("   Create new account ");
		lblNewLabel.setIcon(new ImageIcon(StudentLogin.class.getResource("/Main/verified-account.png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Rockwell", Font.BOLD, 28));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(49, 0, 563, 45);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 95, 572, 239);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username : ");
		lblNewLabel_1.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(53, 40, 107, 29);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password : ");
		lblNewLabel_1_1.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(53, 82, 107, 29);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("  Please enter full information  !!!");
		lblNewLabel_1_2.setIcon(new ImageIcon(StudentLogin.class.getResource("/Main/text.png")));
		lblNewLabel_1_2.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(53, 121, 321, 29);
		panel_1.add(lblNewLabel_1_2);
		
		tx_username = new JTextField();
		tx_username.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		tx_username.setBounds(170, 37, 321, 32);
		panel_1.add(tx_username);
		tx_username.setColumns(10);
		
		JButton btnCreate = new JButton("Create account");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null ;
				PreparedStatement statement = null ;
				String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
			    String username = "sa";
			    String password = "123456789";
			    try {
			    	connection = DriverManager.getConnection(url ,username , password) ;
			    	String sql = "update student set mk  = ? where mahs=?" ;
			        statement = connection.prepareStatement(sql) ;
			        // Đặt giá trị cho tham số cần thực hiện 
			        String pass = new String(tx_pass.getPassword()) ;
			        statement.setString (1,pass) ;
			        statement.setString(2, tx_username.getText());
			        int n = statement.executeUpdate() ;
			        if (tx_username.getText().equals("") || pass.equals("")) {
			        	JOptionPane.showMessageDialog(null, "Null Information") ;
			        }
			        else if ( n > 0) {
			        	JOptionPane.showMessageDialog(null, "Create Successful");
			        }
			        else {
			        	JOptionPane.showMessageDialog(null, "Create Fail") ;
			        }
			        
			    } catch  (Exception e1) {
			    	System.out.println("Error" + e1.toString());
			    } finally {
			    	try {
			    		connection.close();
			    		statement.close();
			    	} catch (Exception e1) {
						
					}
			    }
				
			}
		});
		btnCreate.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnCreate.setBounds(359, 160, 132, 29);
		panel_1.add(btnCreate);
		
		JButton btnLogIn = new JButton("Log in ");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login_Version1 login = new Login_Version1() ;
				login.setVisible(true);
				dispose() ;
			}
			
		});
		btnLogIn.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnLogIn.setBounds(165, 160, 132, 29);
		panel_1.add(btnLogIn);
		
		tx_pass = new JPasswordField();
		tx_pass.setBounds(170, 79, 323, 32);
		panel_1.add(tx_pass);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome to Hclass , please enter your information and log in  .");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(57, 53, 579, 30);
		contentPane.add(lblNewLabel_2);
		}
	
}
