package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;

public class Welcome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Welcome frame = new Welcome();
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
	public Welcome() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Welcome.class.getResource("/Main/seminar.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 1371, 745);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(SystemColor.activeCaption));
		panel.setBackground(SystemColor.text);
		panel.setBounds(10, 10, 270, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("HClass");
		lblNewLabel_1.setIcon(new ImageIcon(Welcome.class.getResource("/Main/seminar.png")));
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("Rockwell", Font.BOLD, 40));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 5, 181, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Application");
		lblNewLabel_2.setForeground(SystemColor.textHighlight);
		lblNewLabel_2.setFont(new Font("Rockwell", Font.PLAIN, 16));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setBounds(74, 36, 162, 27);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new java.awt.Color(255,255,255,0));
		panel_1.setBounds(10, 188, 806, 431);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Bring every family ");
		lblNewLabel_3.setFont(new Font("Rockwell", Font.BOLD, 50));
		lblNewLabel_3.setBounds(10, 10, 530, 96);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("into your classroom ");
		lblNewLabel_3_1.setFont(new Font("Rockwell", Font.BOLD, 53));
		lblNewLabel_3_1.setBounds(10, 66, 617, 96);
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("The HClass classroom management application connects student information at school and home, simplifying student and child management activities.");
		lblNewLabel_4.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 147, 735, 34);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Applicable from class size to the entire school system.");
		lblNewLabel_4_1.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNewLabel_4_1.setBounds(10, 172, 778, 34);
		panel_1.add(lblNewLabel_4_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_Version1 login = new Login_Version1();
				login.setVisible(true);
				dispose();
			}
		});
		panel_2.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_2.setBackground(SystemColor.textHighlight);
		panel_2.setBounds(33, 268, 254, 76);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("SignIn For More");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login_Version1 login = new Login_Version1();
				login.setVisible(true);
				dispose();
			}
		});
		lblNewLabel_5.setForeground(SystemColor.text);
		lblNewLabel_5.setFont(new Font("Sylfaen", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 10, 234, 56);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Designed by Nguyen Viet Tin And Van Phuc ");
		lblNewLabel_6.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 399, 547, 22);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Welcome.class.getResource("/Main/Purple and Yellow 3D Illustration Online Course Presentation (2) (1).png")));
		lblNewLabel.setBounds(0, 0, 1377, 708);
		contentPane.add(lblNewLabel);
	}
}
