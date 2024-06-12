package Student;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import Main.Login_Version1;
import Main.Menu;
import Score.Grade;
import Score.GradeDao;
import manage.ExcelFile;
import manage.Schedule;
import manage.Student;
import manage.StudentModify;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class StudentInformation extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tx_id;
	private JTextField tx_name;
	private JTextField tx_dob;
	private JTextField tx_gender;
	private JTextField tx_ethnicgroup;
	private JTextField tx_religion;
	private JTextField tx_tn;
	private JTextField tx_mail;
	private JTextField tx_ltcb;
	private JTextField tx_lthdt;
	private JTextField tx_gt;
	private JTextField tx_ta;
	private JTextField tx_csdl;
	private JTextField tx_gdtc;
	private JTextField tx_tbc;
	private JTextField tx_xl;
	private JLabel lbanhthe ;
	private JLabel lb_anhthe;
	private JLabel pn_welcome;
	private JTextField tx_diachi;
    private Login_Version1 login ;
	private JTextPane textPane_error;
	private Menu menu;
	private JTable table;
	DefaultTableModel tableModle;
	private List<Schedule> scheduleList;
	private JTextArea chatArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					 StudentInformation frame = new StudentInformation();
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
	public StudentInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1046, 588);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.disabledShadow"));
		panel.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
		panel.setBounds(10, 10, 185, 531);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel pnInfor = new JPanel();
		pnInfor.setBackground(UIManager.getColor("Button.highlight"));
		pnInfor.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnInfor.setBounds(0, 151, 185, 58);
		panel.add(pnInfor);
		pnInfor.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INFORMATION");

		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 185, 58);
		pnInfor.add(lblNewLabel);
		
		JPanel pndiem = new JPanel();
		
		pndiem.setBorder(new LineBorder(new Color(0, 0, 0)));
		pndiem.setBackground(Color.WHITE);
		pndiem.setBounds(0, 219, 185, 58);
		panel.add(pndiem);
		pndiem.setLayout(null);
		
		JLabel lblYourScore = new JLabel("YOUR SCORE ");
		lblYourScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourScore.setForeground(new Color(220, 20, 60));
		lblYourScore.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblYourScore.setBounds(0, 0, 185, 58);
		pndiem.add(lblYourScore);
		
		JPanel pndx = new JPanel();
		pndx.setBorder(new LineBorder(new Color(0, 0, 0)));
		pndx.setBackground(Color.WHITE);
		pndx.setBounds(0, 287, 185, 58);
		panel.add(pndx);
		pndx.setLayout(null);
		
		JLabel lblLogOut = new JLabel("LOG OUT");
		lblLogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "DO YOU WANT TO LOG OUT ?") ;
				if (input == 0) {
					Login_Version1 login = new Login_Version1();
					login.setVisible(true) ;
					dispose() ;
				}
			}
		});
		lblLogOut.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut.setForeground(new Color(220, 20, 60));
		lblLogOut.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblLogOut.setBounds(0, 0, 185, 58);
		pndx.add(lblLogOut);
		
		JLabel lblNewLabel_5 = new JLabel("ACCOUNT STUDENT ");
		lblNewLabel_5.setForeground(new Color(0, 0, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(0, 441, 185, 23);
		panel.add(lblNewLabel_5);
		
		 pn_welcome = new JLabel("");
		 pn_welcome.setForeground(new Color(220, 20, 60));
		 pn_welcome.setHorizontalAlignment(SwingConstants.CENTER);
		pn_welcome.setFont(new Font("Times New Roman", Font.BOLD, 17));
		pn_welcome.setBounds(0, 478, 185, 43);
		panel.add(pn_welcome);
		
		JLabel lblNewLabel_6 = new JLabel(" OPTION  | ");
		lblNewLabel_6.setForeground(new Color(65, 105, 225));
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_6.setBounds(0, 90, 83, 23);
		panel.add(lblNewLabel_6);
		
		JLabel tx_thaydoi = new JLabel("Information");
		tx_thaydoi.setForeground(new Color(255, 0, 0));
		tx_thaydoi.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		tx_thaydoi.setBounds(81, 88, 104, 36);
		panel.add(tx_thaydoi);
		
		JLabel lblNewLabel_7 = new JLabel("HClass");
		lblNewLabel_7.setForeground(new Color(65, 105, 225));
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lblNewLabel_7.setBounds(10, 10, 165, 58);
		panel.add(lblNewLabel_7);
		
		JPanel pn_error = new JPanel();
		pn_error.setLayout(null);
		pn_error.setBorder(new LineBorder(new Color(0, 0, 0)));
		pn_error.setBackground(Color.WHITE);
		pn_error.setBounds(0, 355, 185, 58);
		panel.add(pn_error);
		
		JLabel lblLogOut_1 = new JLabel("ERROR");
		
		lblLogOut_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogOut_1.setForeground(new Color(220, 20, 60));
		lblLogOut_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblLogOut_1.setBounds(0, 0, 185, 58);
		pn_error.add(lblLogOut_1);
		
		JPanel pnHOME = new JPanel();
		pnHOME.setBorder(new LineBorder(UIManager.getColor("Button.darkShadow")));
		pnHOME.setBackground(UIManager.getColor("Button.disabledShadow"));
		pnHOME.setBounds(205, 10, 817, 531);
		contentPane.add(pnHOME);
		pnHOME.setLayout(new CardLayout(0, 0));
		
		JPanel pnInformation = new JPanel();
		pnInformation.setBackground(UIManager.getColor("Button.highlight"));
		pnHOME.add(pnInformation, "name_308747668878800");
		pnInformation.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(25, 93, 183, 236);
		pnInformation.add(panel_1);
		panel_1.setLayout(null);
		
		 lb_anhthe = new JLabel("");
		lb_anhthe.setBounds(0, 0, 183, 236);
		panel_1.add(lb_anhthe);
		
		JLabel lblNewLabel_2 = new JLabel("YOUR IMAGE ");
		lblNewLabel_2.setForeground(new Color(65, 105, 225));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(25, 339, 183, 25);
		pnInformation.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(229, 93, 553, 426);
		pnInformation.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("NAME : ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 66, 91, 35);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("ID: ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_1.setBounds(10, 25, 70, 35);
		panel_2.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("DATE OF BIRTH : ");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_2.setBounds(10, 105, 171, 35);
		panel_2.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("GENDER : ");
		lblNewLabel_3_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_2_1.setBounds(10, 150, 102, 35);
		panel_2.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("ETHNIC GROUP : ");
		lblNewLabel_3_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_2_1_1.setBounds(10, 195, 171, 35);
		panel_2.add(lblNewLabel_3_2_1_1);
		
		JLabel lblNewLabel_3_2_1_1_1 = new JLabel("RELIGION : ");
		lblNewLabel_3_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_2_1_1_1.setBounds(10, 240, 118, 35);
		panel_2.add(lblNewLabel_3_2_1_1_1);
		
		JLabel lblNewLabel_3_2_1_1_2 = new JLabel("TELEPHONE NUMBER : ");
		lblNewLabel_3_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_2_1_1_2.setBounds(10, 285, 179, 35);
		panel_2.add(lblNewLabel_3_2_1_1_2);
		
		JLabel lblNewLabel_3_2_1_1_1_1 = new JLabel("EMAIL : ");
		lblNewLabel_3_2_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_3_2_1_1_1_1.setBounds(10, 331, 138, 35);
		panel_2.add(lblNewLabel_3_2_1_1_1_1);
		
		tx_id = new JTextField();
		tx_id.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		tx_id.setBounds(191, 25, 352, 35);
		panel_2.add(tx_id);
		tx_id.setColumns(10);
		
		tx_name = new JTextField();
		tx_name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		tx_name.setColumns(10);
		tx_name.setBounds(191, 66, 352, 35);
		panel_2.add(tx_name);
		
		tx_dob = new JTextField();
		tx_dob.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		tx_dob.setColumns(10);
		tx_dob.setBounds(191, 107, 352, 35);
		panel_2.add(tx_dob);
		
		tx_gender = new JTextField();
		tx_gender.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		tx_gender.setColumns(10);
		tx_gender.setBounds(191, 150, 352, 35);
		panel_2.add(tx_gender);
		
		tx_ethnicgroup = new JTextField();
		tx_ethnicgroup.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		tx_ethnicgroup.setColumns(10);
		tx_ethnicgroup.setBounds(191, 195, 352, 35);
		panel_2.add(tx_ethnicgroup);
		
		tx_religion = new JTextField();
		tx_religion.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		tx_religion.setColumns(10);
		tx_religion.setBounds(191, 240, 352, 35);
		panel_2.add(tx_religion);
		
		tx_tn = new JTextField();
		tx_tn.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		tx_tn.setColumns(10);
		tx_tn.setBounds(191, 285, 352, 37);
		panel_2.add(tx_tn);
		
		tx_mail = new JTextField();
		tx_mail.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		tx_mail.setColumns(10);
		tx_mail.setBounds(191, 332, 352, 35);
		panel_2.add(tx_mail);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("BASIC INFORMATION");
		lblNewLabel_3_1_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3_1_1.setBounds(0, 10, 815, 35);
		pnInformation.add(lblNewLabel_3_1_1);
		GradeDao dDao = new GradeDao() ;
		JPanel pnScore = new JPanel();
		pnScore.setBackground(SystemColor.text);
		pnHOME.add(pnScore, "name_309050258066900");
		pnScore.setLayout(null);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("YOUR SCORE");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setForeground(new Color(65, 105, 225));
		lblNewLabel_3_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_3_1_1_1.setBounds(120, 10, 562, 35);
		pnScore.add(lblNewLabel_3_1_1_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		panel_4.setBackground(UIManager.getColor("Button.highlight"));
		panel_4.setBounds(10, 69, 503, 450);
		pnScore.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Lap Trinh Co Ban : ");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(10, 30, 143, 31);
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Lap Trinh Huong Doi Tuong : ");
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(10, 87, 192, 31);
		panel_4.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Giai Tich : ");
		lblNewLabel_4_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_1_1.setBounds(10, 141, 192, 31);
		panel_4.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Tieng Anh : ");
		lblNewLabel_4_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_1_1_1.setBounds(10, 195, 192, 31);
		panel_4.add(lblNewLabel_4_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Co So Du Lieu : ");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_1_1_1_1.setBounds(10, 250, 192, 31);
		panel_4.add(lblNewLabel_4_1_1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("Giao Duc The Chat : ");
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4_1_1_1_1_1.setBounds(10, 301, 192, 31);
		panel_4.add(lblNewLabel_4_1_1_1_1_1);
		
		tx_ltcb = new JTextField();
		tx_ltcb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tx_ltcb.setHorizontalAlignment(SwingConstants.CENTER);
		tx_ltcb.setBounds(214, 30, 279, 38);
		panel_4.add(tx_ltcb);
		tx_ltcb.setColumns(10);
		
		tx_lthdt = new JTextField();
		tx_lthdt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tx_lthdt.setHorizontalAlignment(SwingConstants.CENTER);
		tx_lthdt.setColumns(10);
		tx_lthdt.setBounds(212, 85, 279, 38);
		panel_4.add(tx_lthdt);
		
		tx_gt = new JTextField();
		tx_gt.setHorizontalAlignment(SwingConstants.CENTER);
		tx_gt.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tx_gt.setColumns(10);
		tx_gt.setBounds(212, 139, 279, 38);
		panel_4.add(tx_gt);
		
		tx_ta = new JTextField();
		tx_ta.setHorizontalAlignment(SwingConstants.CENTER);
		tx_ta.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tx_ta.setColumns(10);
		tx_ta.setBounds(212, 193, 279, 38);
		panel_4.add(tx_ta);
		
		tx_csdl = new JTextField();
		tx_csdl.setHorizontalAlignment(SwingConstants.CENTER);
		tx_csdl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tx_csdl.setColumns(10);
		tx_csdl.setBounds(212, 241, 279, 38);
		panel_4.add(tx_csdl);
		
		tx_gdtc = new JTextField();
		tx_gdtc.setHorizontalAlignment(SwingConstants.CENTER);
		tx_gdtc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tx_gdtc.setColumns(10);
		tx_gdtc.setBounds(212, 299, 279, 38);
		panel_4.add(tx_gdtc);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(UIManager.getColor("Button.disabledForeground")));
		panel_5.setBackground(UIManager.getColor("Button.disabledShadow"));
		panel_5.setBounds(523, 69, 282, 450);
		pnScore.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_4_2 = new JLabel("Diem Trung Binh Cong ");
		lblNewLabel_4_2.setForeground(new Color(220, 20, 60));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4_2.setBounds(10, 34, 262, 31);
		panel_5.add(lblNewLabel_4_2);
		
		tx_tbc = new JTextField();
		tx_tbc.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tx_tbc.setHorizontalAlignment(SwingConstants.CENTER);
		tx_tbc.setColumns(10);
		tx_tbc.setBounds(10, 75, 262, 38);
		panel_5.add(tx_tbc);
		
		JLabel lblNewLabel_4_2_1 = new JLabel("Xep Loai");
		lblNewLabel_4_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_4_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4_2_1.setBounds(10, 135, 262, 31);
		panel_5.add(lblNewLabel_4_2_1);
		
		tx_xl = new JTextField();
		tx_xl.setHorizontalAlignment(SwingConstants.CENTER);
		tx_xl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		tx_xl.setColumns(10);
		tx_xl.setBounds(10, 173, 262, 38);
		panel_5.add(tx_xl);
		JPanel pnError = new JPanel();
		pnError.setBackground(new Color(255, 255, 255));
		pnHOME.add(pnError, "name_365567308879800");
		pnError.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ERROR REPORT ");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(10, 10, 795, 49);
		pnError.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(SystemColor.scrollbar));
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(10, 79, 267, 37);
		pnError.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Enter error information");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setFont(new Font("Sylfaen", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(0, 0, 267, 37);
		panel_3.add(lblNewLabel_8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Error information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(200, 200, 200)));
		panel_6.setBackground(SystemColor.textHighlightText);
		panel_6.setBounds(10, 138, 795, 294);
		pnError.add(panel_6);
		panel_6.setLayout(null);
		
		 textPane_error = new JTextPane();
		textPane_error.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		textPane_error.setBounds(10, 23, 775, 261);
		panel_6.add(textPane_error);
		
		JButton btnNewButton = new JButton("Submit");
		menu = new Menu() ;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int result = addInfo(); // Gọi phương thức add để lưu thông tin lỗi vào cơ sở dữ liệu
		        if (result == 1) {
		            JOptionPane.showMessageDialog(null, "Successfully added error information");
		            textPane_error.setText(""); // Xóa nội dung trong JTextPane sau khi đã lưu thành công
		        } else {
		            JOptionPane.showMessageDialog(null, "Error occurred while adding error information");
		        }
 			}
		});
		JPanel pnn_schedule = new JPanel();
		pnn_schedule.setBackground(Color.WHITE);
		pnHOME.add(pnn_schedule, "name_569336983092000");
		pnn_schedule.setLayout(null);
		btnNewButton.setForeground(new Color(255, 0, 0));	
		btnNewButton.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnNewButton.setBounds(619, 442, 174, 29);
		pnError.add(btnNewButton);
		
		

		 tx_csdl.setEditable(false);
		 tx_dob.setEditable(false);
		 tx_ethnicgroup.setEditable(false);
		 tx_gdtc.setEditable(false);
		 tx_gender.setEditable(false);
		 tx_gt.setEditable(false);
		 tx_id.setEditable(false);
		 tx_ltcb.setEditable(false);
		 tx_lthdt.setEditable(false);
		 tx_mail.setEditable(false);
		 tx_name.setEditable(false);
		 tx_religion.setEditable(false);
		 tx_ta.setEditable(false);
		 tx_tbc.setEditable(false);
		 tx_xl.setEditable(false);
		 tx_tn.setEditable(false);
		 
		 JLabel lblNewLabel_3_2_1_1_1_1_1 = new JLabel("ADDRESS :");
		 lblNewLabel_3_2_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		 lblNewLabel_3_2_1_1_1_1_1.setBounds(10, 380, 138, 35);
		 panel_2.add(lblNewLabel_3_2_1_1_1_1_1);
		 
		 tx_diachi = new JTextField();
		 tx_diachi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 tx_diachi.setEditable(false);
		 tx_diachi.setColumns(10);
		 tx_diachi.setBounds(191, 384, 352, 35);
		 panel_2.add(tx_diachi);
		 
		 JButton btnNewButton_1 = new JButton("Open Schedule");
		 btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));

		 btnNewButton_1.setBounds(51, 374, 137, 25);
		 pnInformation.add(btnNewButton_1);
		 
		 JButton btnNewButton_1_1 = new JButton("Chat with teacher");
		 btnNewButton_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		 btnNewButton_1_1.setBounds(25, 425, 183, 25);
		 pnInformation.add(btnNewButton_1_1);
		 
		
		 
		 JLabel lblNewLabel_3_1_1_2 = new JLabel("YOUR SCHEDULE");
		 lblNewLabel_3_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_3_1_1_2.setForeground(Color.RED);
		 lblNewLabel_3_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 lblNewLabel_3_1_1_2.setBounds(0, 10, 815, 35);
		 pnn_schedule.add(lblNewLabel_3_1_1_2);
		 
		 table = new JTable();
		 table.setBounds(0, 0, 1, 1);
		 pnn_schedule.add(table);
		 
		 
		 JScrollPane scrollPane = new JScrollPane(table);
		 scrollPane.setBounds(0, 115, 815, 189);
		 pnn_schedule.add(scrollPane);
			table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Lesson", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"		}
			){
				 boolean[] canEdit = new boolean [] {
			                false, false, false, false, false ,false , false ,false 
			            };

			            public boolean isCellEditable(int rowIndex, int columnIndex) {
			                return canEdit [columnIndex];
			            }
			});
			table.getColumnModel().getColumn(0).setPreferredWidth(100);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(100);
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
			table.getColumnModel().getColumn(4).setPreferredWidth(100);
			table.getColumnModel().getColumn(5).setPreferredWidth(100);
			table.getColumnModel().getColumn(6).setPreferredWidth(100);
			JLabel lblNewLabel_9 = new JLabel("Notes : ");
			lblNewLabel_9.setForeground(Color.RED);
			lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 19));
			lblNewLabel_9.setBounds(10, 375, 99, 36);
			pnn_schedule.add(lblNewLabel_9);
			
			JLabel lblNewLabel_12 = new JLabel("Sáng : \r\nTiết 1: 07h30 \r\nTiết 2: 08h30 \r\nTiết 3: 09h30 \r\nTiết 4: 10h30 \r\nTiết 5: 11h30");
			lblNewLabel_12.setForeground(Color.BLACK);
			lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_12.setBounds(10, 412, 469, 41);
			pnn_schedule.add(lblNewLabel_12);
			
			JLabel lblNewLabel_12_1 = new JLabel("Chiều : \nTiết 6: 13h00 \nTiết 7: 14h00 \nTiết 8: 15h00 \nTiết 9: 16h00 \nTiết 10: 17h00 \n");
			lblNewLabel_12_1.setForeground(Color.BLACK);
			lblNewLabel_12_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
			lblNewLabel_12_1.setBounds(10, 453, 469, 55);
			pnn_schedule.add(lblNewLabel_12_1);
			
			JPanel pnChat = new JPanel();
			pnChat.setBackground(Color.WHITE);
			pnHOME.add(pnChat, "name_1180565289129500");
			pnChat.setLayout(null);
			
			JLabel lblNewLabel_33 = new JLabel("MESSENGER");
			lblNewLabel_33.setForeground(new Color(0, 0, 128));
			lblNewLabel_33.setFont(new Font("Times New Roman", Font.BOLD, 23));
			lblNewLabel_33.setBounds(10, 10, 160, 33);
			pnChat.add(lblNewLabel_33);
			
			JLabel lblNewLabel_34 = new JLabel("- Chat with your teacher");
			lblNewLabel_34.setForeground(new Color(0, 0, 128));
			lblNewLabel_34.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_34.setBounds(164, 24, 172, 13);
			pnChat.add(lblNewLabel_34);
			
			JPanel pnConversation = new JPanel();
			pnConversation.setLayout(null);
			pnConversation.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Conversation", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
			pnConversation.setBackground(Color.WHITE);
			pnConversation.setBounds(10, 89, 795, 283);
			pnChat.add(pnConversation);
			
			JTextArea messageField = new JTextArea();
			messageField.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			messageField.setBounds(10, 21, 775, 252);
			pnConversation.add(messageField);
			
			JPanel pnMess = new JPanel();
			pnMess.setLayout(null);
			pnMess.setBorder(new TitledBorder(null, "Chat here", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			pnMess.setBackground(Color.WHITE);
			pnMess.setBounds(10, 382, 795, 74);
			pnChat.add(pnMess);
			
		    chatArea = new JTextArea();
			chatArea.setFont(new Font("Sylfaen", Font.PLAIN, 13));
			chatArea.setBounds(10, 10, 775, 54);
			pnMess.add(chatArea);
			
			JPanel panel_24 = new JPanel();
			panel_24.setLayout(null);
			panel_24.setBorder(new LineBorder(Color.PINK));
			panel_24.setBackground(Color.WHITE);
			panel_24.setBounds(645, 466, 160, 35);
			pnChat.add(panel_24);
			
			JLabel lblNewLabel_38 = new JLabel("SEND");
			lblNewLabel_38.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_38.setForeground(Color.BLUE);
			lblNewLabel_38.setFont(new Font("Times New Roman", Font.BOLD, 16));
			lblNewLabel_38.setBounds(10, 0, 140, 35);
			panel_24.add(lblNewLabel_38);
			
			JButton btnConnect = new JButton("Click to connect ");
			btnConnect.setFont(new Font("Times New Roman", Font.BOLD, 16));
			btnConnect.setBounds(10, 64, 211, 21);
			pnChat.add(btnConnect);
			JLabel lblNewLabel_10 = new JLabel("Offline");
			lblNewLabel_10.setForeground(Color.RED);
			lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 15));
			lblNewLabel_10.setBounds(231, 61, 75, 27);
			pnChat.add(lblNewLabel_10);
			 btnNewButton_1.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		pnError.setVisible(false);
						pnInformation.setVisible(false);
						pnScore.setVisible(false);
						pnn_schedule.setVisible(false);
						pnChat.setVisible(false) ;
						pnn_schedule.setVisible(true);
						tableModle = (DefaultTableModel) table.getModel() ;
						showSchedul();
				 	}
				 });
				lblNewLabel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						pnError.setVisible(false);
						pnInformation.setVisible(true);
						pnScore.setVisible(false);
						pnn_schedule.setVisible(false);
						pnn_schedule.setVisible(false);
						pnChat.setVisible(false) ;
						tx_thaydoi.setText("Information");
					}
				});
				pndiem.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						pnError.setVisible(false);
						pnInformation.setVisible(false);
						pnScore.setVisible(true);
						tx_thaydoi.setText("Your Score");
						pnChat.setVisible(false) ;
						pnn_schedule.setVisible(false);
					}
				});
				lblLogOut_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						pnError.setVisible(true);
						pnInformation.setVisible(false);
						pnScore.setVisible(false);
						tx_thaydoi.setText("Error");
						pnChat.setVisible(false) ;
						pnn_schedule.setVisible(false);
					}
				});
				btnNewButton_1_1.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		pnError.setVisible(false);
						pnInformation.setVisible(false);
						pnScore.setVisible(false);
						tx_thaydoi.setText("Chat");
						pnChat.setVisible(true) ;
						pnn_schedule.setVisible(false);
				 	}
				 });
	
	}
	public ImageIcon ResizeImage (String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath) ;
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lb_anhthe.getWidth(), lb_anhthe.getHeight(), Image.SCALE_SMOOTH);
	    ImageIcon image = new ImageIcon(newImg) ;
	    return image ;
	
	}	public void setModel(Student g) {
		tx_id.setText(String.valueOf(g.getMahs()));
		tx_name.setText(String.valueOf(g.getFullname()));
		tx_dob.setText(String.valueOf(g.getDateofbirth()));
		tx_gender.setText(String.valueOf(g.getGender()));
	    tx_religion.setText(String.valueOf(g.getReligion()));
		tx_ethnicgroup.setText(String.valueOf(g.getEthnicgroup()));
		tx_tn.setText(String.valueOf(g.getPhonenumber()));
		tx_mail.setText(String.valueOf(g.getEmail()));
		lb_anhthe.setIcon(ResizeImage(g.getAnh()));
		tx_diachi.setText(String.valueOf(g.getDiaChi()));
		pn_welcome.setText(String.valueOf(g.getFullname()));	
	}
	public void setScore (Grade g) {
		tx_csdl.setText(String.valueOf(g.getCsdl())) ;
		tx_gt.setText(String.valueOf(g.getGt())) ;
		tx_ta.setText(String.valueOf(g.getTanh())) ;
		tx_ltcb.setText(String.valueOf(g.getC())) ;
		tx_lthdt.setText(String.valueOf(g.getJava())) ;
		tx_gdtc.setText(String.valueOf(g.getGdtc())) ;
		tx_xl.setText(String.valueOf(g.getXepLoai())) ;
		tx_tbc.setText(String.valueOf(g.getTrungBinhCong())) ;
	}
	public void resetScore () {
		tx_csdl.setText("") ;
		tx_gt.setText("") ;
		tx_ta.setText("") ;
		tx_ltcb.setText("") ;
		tx_lthdt.setText("") ;
		tx_gdtc.setText("") ;
		tx_xl.setText("") ;
		tx_tbc.setText("") ;
	}
	public String  getTextError () {
		return textPane_error.getText() ;
	}
	public int addInfo() {
	Connection connection = null ;
	PreparedStatement statement = null ;
	String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
    String username = "sa";
    String password = "123456789";
    try {
    	connection = DriverManager.getConnection(url ,username , password) ;
    	String sql = "update student set noti  = ? where mahs=?" ;
        statement = connection.prepareStatement(sql) ;
        statement.setString(2, tx_id.getText());
        statement.setString(1, textPane_error.getText());
        if (statement.executeUpdate() > 0) {
        	System.out.println("thêm thành công");
        	// Nếu thành công 
               return 1 ;
        }
    } catch  (Exception e1) {
    	System.out.println("Error" + e1.toString());
    } finally {
    	try {
    		connection.close();
    		statement.close();
    	} catch (Exception e2) {
			
		}
    }
    return -1 ; 
	}
	public void showSchedul() {
	scheduleList = StudentModify.getSchedule() ;
		// xóa dữ liệu trong bảng 
		tableModle.setRowCount(0);
		for (Schedule schedule : scheduleList) {
			tableModle.addRow(new Object[] { schedule.getTimeSlot() , schedule.getMonday() , schedule.getTuesday() , schedule.getWednesday() , schedule.getThursday() , schedule.getFriday() , schedule.getSaturday() , schedule.getSunday()});
		}
	}
}
