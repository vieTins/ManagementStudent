package Main;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.data.time.TimeTableXYDataset;

import Score.Grade;
import Score.GradeDao;
import Student.StudentInformation;
import manage.Student;
import manage.StudentModify;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class Login_Version1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txUser;
	private JPasswordField password;
	private PropertyChangeSupport support;
	static String text ;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Login_Version1 frame = new Login_Version1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login_Version1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login_Version1.class.getResource("/Main/seminar.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 1376, 734);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new java.awt.Color(255,255,255,0));
		panel.setBounds(697, 155, 631, 484);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("SIGNIN NOW");
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 45));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(62, 32, 559, 63);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Username : ");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(23, 135, 141, 41);
		panel.add(lblNewLabel_2);
		
		txUser = new JTextField();
		txUser.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		txUser.setBounds(138, 135, 416, 41);
		panel.add(txUser);
		txUser.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password : ");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Sylfaen", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(23, 231, 141, 41);
		panel.add(lblNewLabel_2_1);
		
		password = new JPasswordField();
		password.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		password.setBounds(138, 231, 416, 41);
		panel.add(password);
		StudentInformation std = new StudentInformation() ;
		GradeDao dDao = new GradeDao() ;
		JButton btnNewButton = new JButton("SignIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null ;
				PreparedStatement statement = null ;
				String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
			    String username = "sa";
			    String password = "123456789";
				try {
					connection = DriverManager.getConnection(url, username , password);
				    
					// Querry 
					String  sql = "select * from student where mahs =? and mk =?" ;	
					statement = connection.prepareStatement(sql) ;
					statement.setString (1,txUser.getText()) ;
					String pass = new String(Login_Version1.this.password.getPassword()) ;
			        statement.setString(2, pass);
			        ResultSet resultSet = statement.executeQuery();
			        if (txUser.getText().equals("") || pass.equals("")) {
			        		JOptionPane.showMessageDialog(null, "Please enter full information") ;
			        }
			        else if (resultSet.next()) {
			        	JOptionPane.showMessageDialog(null, "Log In Successful") ;
			        	Student sv = new StudentModify().getSinhVienById(txUser.getText());
			        	if (sv == null) {
			        		JOptionPane.showMessageDialog(null, "NO INFORMATION" , "ERROR" , JOptionPane.ERROR_MESSAGE) ;
			        	} else {
			        		std.setModel(sv);
			        		Grade g = dDao.getOndeGradeBySv(sv.getMahs()) ;
			        		if (g!= null) {
			        			std.setScore(g) ;
			        		}
			        		else {
			        			JOptionPane.showMessageDialog(null, "YOUR SCORE NULL","NOTIFICATION" ,JOptionPane.INFORMATION_MESSAGE); 
                                  std.resetScore() ;
			        		}
				        	std.setVisible(true) ;
				        	dispose() ;
			        	}
			        	
			  
			        }
			        else if (txUser.getText().equals("admin") && pass.equals("1234")) {
			        	Menu menu = new Menu() ;
			        	menu.setVisible(true) ;
			        	dispose() ;
			        }
			        else {
			        	JOptionPane.showMessageDialog(null, "Log In Fail") ;
			        }
				    
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {	
					if (statement != null) {
						try {
							statement.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(232, 299, 239, 41);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("Do not have an account ?");
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(23, 388, 161, 23);
		panel.add(lblNewLabel_5);
		
		
		
		JLabel lblNewLabel_6 = new JLabel("Click here . ");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Welcome welcome = new Welcome();
				welcome.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(288, 411, 134, 41);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_5_1 = new JLabel("Do you want to return to the home page?");
		lblNewLabel_5_1.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_5_1.setBounds(23, 421, 255, 23);
		panel.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_6_1 = new JLabel("Create Account .");
		lblNewLabel_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StudentLogin stdlogin = new StudentLogin() ;
				stdlogin.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_6_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_6_1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lblNewLabel_6_1.setBounds(194, 382, 161, 33);
		panel.add(lblNewLabel_6_1);	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new java.awt.Color(255,255,255,0));
		panel_1.setBounds(10, 10, 442, 74);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("HClass");
		lblNewLabel_3.setIcon(new ImageIcon(Login_Version1.class.getResource("/Main/seminar.png")));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(SystemColor.inactiveCaptionText);
		lblNewLabel_3.setFont(new Font("Rockwell", Font.BOLD, 35));
		lblNewLabel_3.setBounds(-19, 10, 194, 44);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Connect love");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.BOLD, 17));
		lblNewLabel_4.setBounds(160, 45, 232, 19);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login_Version1.class.getResource("/Main/Purple and Yellow 3D Illustration Online Course Presentation (3) (1).png")));
		lblNewLabel.setBounds(0, 0, 1376, 708);
		contentPane.add(lblNewLabel);
		support = new PropertyChangeSupport(this);
		
	}
}
