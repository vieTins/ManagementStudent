package Main;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.xml.catalog.Catalog;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.jdbc.JDBCCategoryDataset;

import com.toedter.calendar.JDateChooser;

import Chart.AddresChart;
import Chart.GenderChart;
import Chart.XepLoaiChart;
import Score.Grade;
import Score.GradeDao;
import Student.StudentInformation;
import manage.ExcelFile;
import manage.Schedule;
import manage.Student;
import manage.StudentModify;

import java.awt.Scrollbar;
import java.awt.ScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.naming.ldap.SortControl;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;

public class Menu extends JFrame {
	DefaultTableModel tabelModel;
	GradeDao dDao = new GradeDao();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txmahs;
	private JTextField txName;
	private JDateChooser txdate;
	private JTextField txEthnic;
	private JTextField txReligion;
	private JTextField txPhonenumber;
	private JTextField txEmail;
	private JTable tabel_student;
	private JLabel lblanhthe;
	private String duongdananh;
	private JLabel lbcountstd;
	List<Student> studentList = new ArrayList<>();
	List<Student> studentListSort = new ArrayList<>();
	List<Student> studentListSortASC = new ArrayList<>();
	private JLabel lbl_chuchay;
	private JTable tblfind;
	private JTextField txltcb;
	private JTextField txlthdt;
	private JTextField txgt;
	private JTextField txta;
	private JTextField txcsdl;
	private JTextField txgdtc;
	private JTable table_score;
	private JTextField tx_timkiem;
	private JTextField tx_id;
	private JTextField tx_name;
	private ButtonGroup buttonGroup;
	DefaultTableModel tableModel2;
	DefaultTableModel tableModel3;
	Student std = new Student();
	List<Grade> ScoreList = new ArrayList<>();
	List<Grade> ScoreListASC = new ArrayList<>();
	List<Grade> ScoreListDESC = new ArrayList<>();
	List<Schedule> scheduleList = new ArrayList<>();
	private JTextField txaverage;
	private JComboBox txGender;
	private JComboBox txDiachi;
	private JLabel txanhscore;
	private JTextPane txNotification;
	private String v;
	private JTextField txIDFind;
	private JTable table_1;
	private Menu menu;
	private JPanel panel_21;
	private JLabel txToTal;
	private JLabel lbDate;
	protected JCheckBox presentCheckbox;
	protected JCheckBox absentCheckbox;
	protected String date;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					Menu frame = new Menu();
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
	public Menu() {
		setForeground(Color.BLUE);
		setFont(new Font("Times New Roman", Font.BOLD, 16));
		setTitle("STUDENT MANAGEMENT");

		duongdananh = "D:\\Anh The\\Background.png";
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Main/seminar.png")));
		int width = 225;
		int height = 715;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 1452, 752);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel main = new JPanel();
		main.setBorder(new LineBorder(Color.LIGHT_GRAY));
		main.setBackground(SystemColor.text);
		main.setBounds(10, 0, 1438, 715);
		contentPane.add(main);
		main.setLayout(null);

		JPanel pnMenu = new JPanel();
		pnMenu.setBounds(-3, 0, 225, 715);
		pnMenu.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		pnMenu.setBackground(SystemColor.text);
		main.add(pnMenu);
		pnMenu.setLayout(null);

		JLabel lblNewLabel = new JLabel("  HClass");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setIcon(new ImageIcon(Menu.class.getResource("/Main/classmates.png")));
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 48, 205, 62);
		pnMenu.add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.activeCaptionBorder);
		separator.setBounds(0, 131, 225, 2);
		pnMenu.add(separator);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				closeMenu();
			}

			private void closeMenu() {
				new Thread(new Runnable() {

					@Override
					public void run() {
						for (int i = width; i > 0; i--) {
							pnMenu.setSize(i, height);
							try {
								// Nghĩ 2s
								Thread.sleep(2);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		lblNewLabel_1.setIcon(new ImageIcon(Menu.class.getResource("/Main/close.png")));
		lblNewLabel_1.setBounds(183, 10, 42, 39);
		pnMenu.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("  HOME");
		lblNewLabel_2.setBackground(SystemColor.text);
		lblNewLabel_2.setIcon(new ImageIcon(Menu.class.getResource("/Main/home.png")));
		lblNewLabel_2.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setBounds(10, 131, 215, 62);
		pnMenu.add(lblNewLabel_2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1.setBounds(0, 191, 225, 2);
		pnMenu.add(separator_1);

		JLabel lblNewLabel_2_1 = new JLabel("  STUDENT");
		lblNewLabel_2_1.setIcon(new ImageIcon(Menu.class.getResource("/Main/education.png")));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(10, 191, 215, 62);
		pnMenu.add(lblNewLabel_2_1);

		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1_1.setBounds(0, 251, 225, 2);
		pnMenu.add(separator_1_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("  MANAGE");
		lblNewLabel_2_1_1.setIcon(new ImageIcon(Menu.class.getResource("/Main/verified.png")));
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1.setBounds(10, 251, 215, 61);
		pnMenu.add(lblNewLabel_2_1_1);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBackground(SystemColor.activeCaptionBorder);
		separator_1_2.setBounds(0, 310, 225, 2);
		pnMenu.add(separator_1_2);

		JLabel score = new JLabel("  SCORE");

		score.setIcon(new ImageIcon(Menu.class.getResource("/Main/speedometer.png")));
		score.setHorizontalAlignment(SwingConstants.LEFT);
		score.setFont(new Font("Serif", Font.PLAIN, 20));
		score.setBounds(10, 381, 215, 62);
		pnMenu.add(score);

		JSeparator separator_1_2_1 = new JSeparator();
		separator_1_2_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1_2_1.setBounds(0, 375, 225, 2);
		pnMenu.add(separator_1_2_1);

		JLabel lblNewLabel_2_1_1_2 = new JLabel("  SEARCH");
		lblNewLabel_2_1_1_2.setIcon(new ImageIcon(Menu.class.getResource("/Main/user (1).png")));
		lblNewLabel_2_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_1_2.setFont(new Font("Serif", Font.PLAIN, 20));
		lblNewLabel_2_1_1_2.setBounds(10, 311, 215, 62);
		pnMenu.add(lblNewLabel_2_1_1_2);

		JSeparator separator_1_2_1_1 = new JSeparator();
		separator_1_2_1_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1_2_1_1.setBounds(0, 441, 225, 2);
		pnMenu.add(separator_1_2_1_1);

		JLabel logout = new JLabel("  STUDENT'S SCORE");

		logout.setIcon(new ImageIcon(Menu.class.getResource("/Main/data-collection.png")));
		logout.setHorizontalAlignment(SwingConstants.LEFT);
		logout.setFont(new Font("Serif", Font.PLAIN, 20));
		logout.setBounds(10, 444, 215, 56);
		pnMenu.add(logout);

		JSeparator separator_1_2_1_1_1 = new JSeparator();
		separator_1_2_1_1_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1_2_1_1_1.setBounds(0, 499, 225, 2);
		pnMenu.add(separator_1_2_1_1_1);

		JLabel lblAttendance = new JLabel("ATTENDANCE");
		lblAttendance.setIcon(new ImageIcon(Menu.class.getResource("/Main/available.png")));
		lblAttendance.setHorizontalAlignment(SwingConstants.LEFT);
		lblAttendance.setFont(new Font("Serif", Font.PLAIN, 20));
		lblAttendance.setBounds(10, 501, 215, 56);
		pnMenu.add(lblAttendance);

		JSeparator separator_1_2_1_1_1_1 = new JSeparator();
		separator_1_2_1_1_1_1.setBackground(SystemColor.activeCaptionBorder);
		separator_1_2_1_1_1_1.setBounds(0, 555, 225, 2);
		pnMenu.add(separator_1_2_1_1_1_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(11, 10, 50, 33);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openMenu();
			}

			private void openMenu() {
				// Tạo một luồng mới để chạy song song với luồng chính
				new Thread(new Runnable() {
					// Thực hiện phương thức run trong giao diện Runable
					@Override
					public void run() {
						// Lặp từ 0 đến giá trị của width
						for (int i = 0; i < width; i++) {
							pnMenu.setSize(i, height);
							try {
								// Tạm dừng thực hiện của luồng trong 2ml s
								Thread.sleep(2);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
				}).start();
			}
		});
		lblNewLabel_3.setIcon(new ImageIcon(Menu.class.getResource("/Main/menu-bar.png")));
		main.add(lblNewLabel_3);

		JPanel pncontainer = new JPanel();
		pncontainer.setBounds(232, 86, 1206, 629);
		main.add(pncontainer);
		pncontainer.setLayout(new CardLayout(0, 0));

		JPanel Home = new JPanel();
		Home.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		Home.setBackground(Color.WHITE);
		pncontainer.add(Home, "name_1823441012359700");
		Home.setLayout(null);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1.setBounds(400, 70, 378, 90);
		Home.add(panel_1_1);
		panel_1_1.setLayout(null);

		JLabel lblNewLabel_29 = new JLabel("  Notification ");

		lblNewLabel_29.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_29.setForeground(new Color(255, 255, 255));
		lblNewLabel_29.setIcon(new ImageIcon(Menu.class.getResource("/Main/notification (1).png")));
		lblNewLabel_29.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_29.setBounds(10, 10, 358, 70);
		panel_1_1.add(lblNewLabel_29);

		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_1_2.setBackground(new Color(100, 149, 237));
		panel_1_2.setBounds(856, 70, 340, 90);
		Home.add(panel_1_2);
		panel_1_2.setLayout(null);

		JLabel lblNewLabel_30 = new JLabel("  Log Out");
		lblNewLabel_30.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Do you want to log out?");
				if (option == 0) {
					Login_Version1 login = new Login_Version1();
					login.setVisible(true);
					dispose();
				}
			}
		});
		lblNewLabel_30.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_30.setIcon(new ImageIcon(Menu.class.getResource("/Main/log-out.png")));
		lblNewLabel_30.setForeground(new Color(255, 255, 255));
		lblNewLabel_30.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_30.setBounds(10, 10, 320, 70);
		panel_1_2.add(lblNewLabel_30);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(10, 10, 340, 41);
		Home.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("STUDENT MANAGEMENT");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(SystemColor.textHighlight);
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_7.setBounds(10, 0, 320, 41);
		panel_2.add(lblNewLabel_7);

		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_1_1_1.setBackground(new Color(100, 149, 237));
		panel_1_1_1.setBounds(10, 70, 340, 90);
		Home.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);

		lbcountstd = new JLabel("0");
		lbcountstd.setForeground(new Color(255, 255, 255));
		lbcountstd.setHorizontalAlignment(SwingConstants.CENTER);
		lbcountstd.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbcountstd.setBounds(254, 6, 76, 74);
		panel_1_1_1.add(lbcountstd);

		JLabel lblNewLabel_11 = new JLabel(" Number of student : ");
		lblNewLabel_11.setForeground(new Color(255, 255, 255));
		lblNewLabel_11.setIcon(new ImageIcon(Menu.class.getResource("/Main/student.png")));
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_11.setBounds(10, 10, 234, 70);
		panel_1_1_1.add(lblNewLabel_11);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.textHighlight));
		panel_1.setBackground(SystemColor.text);
		panel_1.setBounds(10, 256, 1186, 188);
		Home.add(panel_1);
		panel_1.setLayout(null);

		table = new JTable();
		table.setFont(new Font("Rockwell", Font.PLAIN, 12));
		table.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Lesson", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getColumnModel().getColumn(5).setPreferredWidth(100);
		table.getColumnModel().getColumn(6).setPreferredWidth(100);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 1186, 188);
		panel_1.add(scrollPane);

		JLabel lblNewLabel_8 = new JLabel(" SCHEDULE");
		lblNewLabel_8.setIcon(new ImageIcon(Menu.class.getResource("/Main/schedule.png")));
		lblNewLabel_8.setForeground(SystemColor.menuText);
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(439, 205, 257, 41);
		Home.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Notes : ");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_9.setBounds(10, 473, 99, 36);
		Home.add(lblNewLabel_9);

		JLabel lblNewLabel_12 = new JLabel(
				"Sáng : \r\nTiết 1: 07h30 \r\nTiết 2: 08h30 \r\nTiết 3: 09h30 \r\nTiết 4: 10h30 \r\nTiết 5: 11h30");
		lblNewLabel_12.setForeground(new Color(0, 0, 0));
		lblNewLabel_12.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_12.setBounds(10, 499, 469, 41);
		Home.add(lblNewLabel_12);

		JLabel lblNewLabel_12_1 = new JLabel("Chiều : \n" + "Tiết 6: 13h00 \n" + "Tiết 7: 14h00 \n" + "Tiết 8: 15h00 \n"
				+ "Tiết 9: 16h00 \n" + "Tiết 10: 17h00 \n" + "");
		lblNewLabel_12_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_12_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_12_1.setBounds(10, 532, 469, 55);
		Home.add(lblNewLabel_12_1);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(20, 509, 46, 0);
		Home.add(separator_3);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(380, 10, 532, 36);
		Home.add(panel_6);
		panel_6.setLayout(null);

		lbl_chuchay = new JLabel("Student Management Project  - Van Phuc And Viet Tin  ");
		lbl_chuchay.setIcon(new ImageIcon(Menu.class.getResource("/Main/idea (1).png")));
		chuchay();
		lbl_chuchay.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lbl_chuchay.setForeground(new Color(0, 0, 255));
		lbl_chuchay.setBounds(0, 0, 522, 36);
		panel_6.add(lbl_chuchay);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(763, 513, 433, 90);
		Home.add(scrollPane_4);

		txNotification = new JTextPane();
		txNotification.setFont(new Font("Times New Roman", Font.BOLD, 14));
		scrollPane_4.setViewportView(txNotification);

		JLabel lblNewLabel_9_1 = new JLabel("Notification : ");
		lblNewLabel_9_1.setForeground(Color.RED);
		lblNewLabel_9_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_9_1.setBounds(763, 473, 126, 36);
		Home.add(lblNewLabel_9_1);

		JButton btnNewButton_4 = new JButton("Clear");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				PreparedStatement statement = null;
				String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
				String username = "sa";
				String password = "123456789";
				try {
					connection = DriverManager.getConnection(url, username, password);
					String sql = "UPDATE student SET noti = NULL";
					statement = connection.prepareStatement(sql);
					if (statement.executeUpdate() > 0) {
						txNotification.setText("");
						System.out.println("chỉnh sửa thành công");
						// Nếu thành công
					}
				} catch (Exception e1) {
					System.out.println("Error" + e.toString());
				} finally {
					try {
						connection.close();
						statement.close();
					} catch (Exception e1) {

					}
				}
			}
		});
		btnNewButton_4.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnNewButton_4.setBounds(659, 579, 94, 24);
		Home.add(btnNewButton_4);

		JButton btnNewButton_4_3 = new JButton("Change");

		btnNewButton_4_3.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnNewButton_4_3.setBounds(1102, 450, 94, 24);
		Home.add(btnNewButton_4_3);

		lblNewLabel_29.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = JOptionPane.showInputDialog(null, "Enter Notifications");
				if (input != null && input.length() > 0) {
					txNotification.setText(txNotification.getText() + " - " + input + "\n");
				}
			}
		});

		JPanel Manage = new JPanel();
		Manage.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		Manage.setBackground(SystemColor.text);
		pncontainer.add(Manage, "name_1823457865179300");
		Manage.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("ENTER STUDENT INFORMATION");
		lblNewLabel_13.setForeground(new Color(30, 144, 255));
		lblNewLabel_13.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_13.setBounds(37, 10, 435, 39);
		Manage.add(lblNewLabel_13);

		JSeparator separator_4 = new JSeparator();
		separator_4.setForeground(new Color(0, 0, 255));
		separator_4.setBounds(37, 47, 403, 2);
		Manage.add(separator_4);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(Color.GRAY));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 74, 768, 545);
		Manage.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_14 = new JLabel("NAME : ");
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14.setBounds(37, 132, 95, 39);
		panel_3.add(lblNewLabel_14);

		JLabel lblNewLabel_14_1 = new JLabel("DATE OF BIRTH : ");
		lblNewLabel_14_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14_1.setBounds(37, 181, 133, 39);
		panel_3.add(lblNewLabel_14_1);

		JLabel lblNewLabel_14_2 = new JLabel("GENDER : ");
		lblNewLabel_14_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14_2.setBounds(37, 230, 95, 39);
		panel_3.add(lblNewLabel_14_2);

		JLabel lblNewLabel_14_2_1 = new JLabel("ETHNIC FROUP  : ");
		lblNewLabel_14_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14_2_1.setBounds(37, 279, 133, 39);
		panel_3.add(lblNewLabel_14_2_1);

		JLabel lblNewLabel_14_2_1_1 = new JLabel("RELIGION  : ");
		lblNewLabel_14_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14_2_1_1.setBounds(37, 328, 133, 39);
		panel_3.add(lblNewLabel_14_2_1_1);

		JLabel lblNewLabel_14_2_1_1_1 = new JLabel("PHONE NUMBER  : ");
		lblNewLabel_14_2_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14_2_1_1_1.setBounds(37, 377, 166, 39);
		panel_3.add(lblNewLabel_14_2_1_1_1);

		JLabel lblNewLabel_14_2_1_1_2 = new JLabel("EMAIL  : ");
		lblNewLabel_14_2_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14_2_1_1_2.setBounds(37, 426, 133, 39);
		panel_3.add(lblNewLabel_14_2_1_1_2);

		JLabel lblNewLabel_14_3 = new JLabel("ID  : ");
		lblNewLabel_14_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14_3.setBounds(37, 83, 95, 39);
		panel_3.add(lblNewLabel_14_3);

		JLabel lblNewLabel_15 = new JLabel("  Please enter complete information");
		lblNewLabel_15.setIcon(new ImageIcon(Menu.class.getResource("/Main/notification.png")));
		lblNewLabel_15.setForeground(Color.RED);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblNewLabel_15.setBounds(23, 39, 194, 32);
		panel_3.add(lblNewLabel_15);

		txName = new JTextField();
		txName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txName.setColumns(10);
		txName.setBounds(184, 133, 399, 39);
		panel_3.add(txName);

		txdate = new JDateChooser();
		txdate.setDateFormatString("yyyy-MM-dd");
		txdate.setBounds(184, 181, 399, 39);
		panel_3.add(txdate);

		txGender = new JComboBox();
		txGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txGender.setModel(new DefaultComboBoxModel(new String[] { "Male", "Female" }));
		txGender.setBounds(184, 240, 399, 21);
		panel_3.add(txGender);

		txEthnic = new JTextField();
		txEthnic.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txEthnic.setColumns(10);
		txEthnic.setBounds(184, 279, 399, 39);
		panel_3.add(txEthnic);

		txReligion = new JTextField();
		txReligion.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txReligion.setColumns(10);
		txReligion.setBounds(184, 327, 399, 39);
		panel_3.add(txReligion);

		txPhonenumber = new JTextField();
		txPhonenumber.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txPhonenumber.setColumns(10);
		txPhonenumber.setBounds(184, 376, 399, 39);
		panel_3.add(txPhonenumber);

		txEmail = new JTextField();
		txEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txEmail.setColumns(10);
		txEmail.setBounds(184, 426, 399, 39);
		panel_3.add(txEmail);

		JLabel lblNewLabel_16 = new JLabel("  BASIC INFORMATION");
		lblNewLabel_16.setIcon(new ImageIcon(Menu.class.getResource("/Main/user (2).png")));
		lblNewLabel_16.setForeground(new Color(178, 34, 34));
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_16.setBounds(112, 17, 546, 32);
		panel_3.add(lblNewLabel_16);
		txmahs = new JTextField();
		txmahs.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txmahs.setColumns(10);
		txmahs.setBounds(184, 83, 399, 39);
		panel_3.add(txmahs);

		JLabel lblNewLabel_14_2_1_1_2_1 = new JLabel("ADDRESS : ");
		lblNewLabel_14_2_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_14_2_1_1_2_1.setBounds(37, 483, 133, 39);
		panel_3.add(lblNewLabel_14_2_1_1_2_1);

		txDiachi = new JComboBox();
		txDiachi.setModel(new DefaultComboBoxModel(new String[] { "", "An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang",
				"Bắc Kạn", "Bạc Liêu", "Bắc Ninh", "Bến Tre", "Bình Định", "Bình Dương", "Bình Phước", "Bình Thuận",
				"Cà Mau", "Cao Bằng", "Đắk Lắk", "Đắk Nông", "Điện Biên", "Đồng Nai", "Đồng Tháp", "Gia Lai",
				"Hà Giang", "Hà Nam", "Hà Tĩnh", "Hải Dương", "Hậu Giang", "Hòa Bình", "Hưng Yên", "Khánh Hòa",
				"Kiên Giang", "Kon Tum", "Lai Châu", "Lâm Đồng", "Lạng Sơn", "Lào Cai", "Long An", "Nam Định",
				"Nghệ An", "Ninh Bình", "Ninh Thuận", "Phú Thọ", "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh",
				"Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa",
				"Thừa Thiên Huế", "Tiền Giang", "Trà Vinh", "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái",
				"Phú Yên", "Cần Thơ", "Đà Nẵng", "Hải Phòng", "Hà Nội", "TP HCM" }));
		txDiachi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txDiachi.setBounds(184, 493, 399, 32);
		panel_3.add(txDiachi);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(Color.GRAY));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(808, 74, 376, 372);
		Manage.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_17 = new JLabel("CHOOSE IMAGE");
		lblNewLabel_17.setIcon(new ImageIcon(Menu.class.getResource("/Main/image.png")));
		lblNewLabel_17.setForeground(new Color(220, 20, 60));
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_17.setBounds(60, 10, 273, 33);
		panel_4.add(lblNewLabel_17);

		lblanhthe = new JLabel("");
		lblanhthe.setBounds(113, 53, 187, 266);
		panel_4.add(lblanhthe);

		JButton btnNewButton = new JButton("Choose");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser f = new JFileChooser("D:\\Anh The");
					f.setDialogTitle("Open File");
					f.showOpenDialog(null);
					File ftenanh = f.getSelectedFile();
					duongdananh = ftenanh.getAbsolutePath();
					if (duongdananh != null) {
						lblanhthe.setIcon(ResizeImage(String.valueOf(duongdananh)));
						System.out.println(duongdananh);
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Not Image");
					System.out.println("Chua chon anh");
					System.out.println(duongdananh);
				}
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(90, 329, 242, 33);
		panel_4.add(btnNewButton);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new LineBorder(Color.GRAY));
		panel_5.setBounds(808, 456, 376, 163);
		Manage.add(panel_5);
		panel_5.setLayout(null);

		JButton btnNewButton_1 = new JButton("Insert");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection connection = null;
				PreparedStatement statement = null;
				String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
				String username = "sa";
				String password = "123456789";
				try {
					connection = DriverManager.getConnection(url, username, password);
					String studentID = txmahs.getText();
					String queryCheck = "Select * from student where mahs=?";
					try (PreparedStatement preparedStatement = connection.prepareStatement(queryCheck)) {
						preparedStatement.setString(1, studentID);
						ResultSet resultSet = preparedStatement.executeQuery();
						String phonenumber = txPhonenumber.getText();
						String email = txEmail.getText();
						String diachi = txDiachi.getSelectedItem().toString();
						// Thay đổi kiểu dữ liệu của selectedDate thành java.util.Date
						java.util.Date selectedDate = txdate.getDate();

						// Chuyển đổi từ java.util.Date sang java.sql.Date
						if (resultSet.next()) {
							JOptionPane.showMessageDialog(null, "Student code already exists");
						} else if (studentID.length() == 0 || phonenumber.length() == 0 || email.length() == 0
								|| diachi.length() == 0 || selectedDate == null) {
							JOptionPane.showMessageDialog(null, "Please Enter Full Information");
						} else {
							Date sqlDate = new Date(selectedDate.getTime());
							if (phonenumber.length() != 10 || phonenumber.charAt(0) != '0') {
								JOptionPane.showMessageDialog(null, "Invalid PhoneNumber - Length's PhoneNumber is 10");
							} else if (!email.contains("@vku.udn.vn") || email.length() == 0) {
								JOptionPane.showMessageDialog(null, "Invalid Email - Enter email's school");
							} else if (!isValidDate(sqlDate)) {
								JOptionPane.showMessageDialog(null, "Please select a valid Date of Birth");
							} else if (diachi.length() == 0) {
								JOptionPane.showMessageDialog(null, "Please Enter Address");
							} else {
								String sql = "insert into student (mahs,fullname,dateofbirth,gender,ethnic_group,religion,phone_number,email,anh,diachi) values (?,? ,?,?,? ,? , ? , ?,?,?)";
								statement = connection.prepareCall(sql);
								String mahs = txmahs.getText();
								statement.setString(1, mahs);
								statement.setString(2, txName.getText());
								Date date = new java.sql.Date(txdate.getDate().getTime());
								SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
								String dateString = sdf.format(date);
								statement.setString(3, dateString);
								String gender = txGender.getSelectedItem().toString();
								statement.setString(4, gender);
								String ethnicgroup = txEthnic.getText();
								statement.setString(5, ethnicgroup);
								String religion = txReligion.getText();
								statement.setString(6, religion);
								statement.setString(7, phonenumber);
								String anh = duongdananh;
								statement.setString(8, email);
								statement.setString(9, anh);

								statement.setString(10, diachi);
								statement.executeUpdate();
								showStudent();
								count();
								JOptionPane.showMessageDialog(null, "Successful", "Notification",
										JOptionPane.INFORMATION_MESSAGE);
							}
						}
					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(211, 69, 155, 33);
		panel_5.add(btnNewButton_1);

		JLabel lblNewLabel_18 = new JLabel("ADD NEW STUDENT");
		lblNewLabel_18.setIcon(new ImageIcon(Menu.class.getResource("/Main/add-user.png")));
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_18.setForeground(new Color(220, 20, 60));
		lblNewLabel_18.setBounds(86, 10, 242, 33);
		panel_5.add(lblNewLabel_18);

		JButton btnNewButton_1_1 = new JButton("Reset");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txmahs.setText("");
				txName.setText("");
				txGender.setSelectedIndex(0);
				txdate.setDate(null);
				txEmail.setText("");
				txEthnic.setText("");
				txPhonenumber.setText("");
				txReligion.setText("");
				txDiachi.setSelectedIndex(0);
				lblanhthe.setIcon(ResizeImage(String.valueOf("D:\\Anh The\\Background.png")));
			}
		});
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1.setBackground(Color.RED);
		btnNewButton_1_1.setBounds(10, 69, 155, 33);
		panel_5.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Insert By File");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelFile excelFile = new ExcelFile();
				excelFile.ImportFileExcel();
				showStudent();
			}
		});

		btnNewButton_1_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1_1_1.setBackground(Color.RED);
		btnNewButton_1_1_1.setBounds(10, 112, 155, 33);
		panel_5.add(btnNewButton_1_1_1);

		JPanel Student = new JPanel();
		Student.setBorder(new LineBorder(SystemColor.windowBorder));
		Student.setBackground(Color.WHITE);
		pncontainer.add(Student, "name_1945512342257500");
		Student.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(400, 35, 413, 46);
		panel_7.setBorder(new LineBorder(SystemColor.textText));
		panel_7.setBackground(Color.WHITE);
		Student.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_19 = new JLabel("  Student Information");
		lblNewLabel_19.setIcon(new ImageIcon(Menu.class.getResource("/Main/personal-information.png")));
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setForeground(new Color(220, 20, 60));
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_19.setBounds(10, 0, 393, 46);
		panel_7.add(lblNewLabel_19);

		JPanel panel_15 = new JPanel();
		panel_15.setBounds(1011, 103, 185, 431);
		panel_15.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_15.setBackground(Color.WHITE);
		Student.add(panel_15);
		panel_15.setLayout(null);

		JLabel lbanhhs = new JLabel("");
		lbanhhs.setBounds(10, 10, 165, 256);
		panel_15.add(lbanhhs);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(10, 102, 991, 432);
		panel_8.setBackground(new Color(255, 255, 255));
		Student.add(panel_8);
		panel_8.setLayout(null);
		tabel_student = new JTable();
		tabel_student.setForeground(SystemColor.desktop);
		tabel_student.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tabel_student.setBorder(new LineBorder(SystemColor.windowBorder));
		tabel_student.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "ID", "Name",
				"Date Of Birth", "Gender", "Ethnic Group", "Religion", "Phone Number", "Email", "Image", "Address" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, true, false, false, false,
					false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		tabel_student.getColumnModel().getColumn(0).setResizable(false);
		tabel_student.getColumnModel().getColumn(1).setResizable(false);
		tabel_student.getColumnModel().getColumn(2).setResizable(true);
		tabel_student.getColumnModel().getColumn(3).setResizable(false);
		tabel_student.getColumnModel().getColumn(4).setResizable(false);
		tabel_student.getColumnModel().getColumn(5).setResizable(false);
		tabel_student.getColumnModel().getColumn(6).setResizable(false);
		tabel_student.getColumnModel().getColumn(7).setResizable(false);
		tabel_student.getColumnModel().getColumn(8).setResizable(false);
		tabel_student.getColumnModel().getColumn(9).setResizable(false);
		tabel_student.getColumnModel().getColumn(10).setResizable(false);
		tabel_student.getSelectionModel().addListSelectionListener(event -> {
			if (!event.getValueIsAdjusting()) {
				int selectedRow = tabel_student.getSelectedRow();
				if (selectedRow != -1) {
					String imagePath = (String) tabel_student.getValueAt(selectedRow, 9);
					lbanhhs.setIcon(ResizeImage(imagePath));
				}
			}
		});

		JScrollPane scrollPane_1 = new JScrollPane(tabel_student);
		scrollPane_1.setBounds(0, 0, 991, 432);
		panel_8.add(scrollPane_1);

		JLabel lblNewLabel_10 = new JLabel("  Delete Student");
		lblNewLabel_10.setBounds(749, 558, 185, 42);
		lblNewLabel_10.setIcon(new ImageIcon(Menu.class.getResource("/Main/delete-folder.png")));
		lblNewLabel_10.setForeground(new Color(220, 20, 60));
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		Student.add(lblNewLabel_10);

		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.setBounds(944, 551, 249, 54);
		btnNewButton_2.setBackground(new Color(255, 182, 193));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = tabel_student.getSelectedRow();
				if (selectedIndex >= 0) {
					Student std = studentList.get(selectedIndex);
					int option = JOptionPane.showConfirmDialog(null, "Do you want to delete this item?");
					System.out.println("option" + option);
					if (option == 0) {
						StudentModify.delete(std.getMahs());
						showStudent();
						showScore();
						count();
					}
				}
			}
		});
		Student.add(btnNewButton_2);

		JLabel lblNewLabel_27 = new JLabel("IMAGE");
		lblNewLabel_27.setForeground(new Color(220, 20, 60));
		lblNewLabel_27.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_27.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_27.setBounds(0, 302, 185, 29);
		panel_15.add(lblNewLabel_27);

		JPanel panel_11 = new JPanel();
		panel_11.setBounds(10, 563, 258, 42);
		panel_11.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_11.setBackground(new Color(255, 255, 255));
		Student.add(panel_11);
		panel_11.setLayout(null);

		JLabel lblNewLabel_28 = new JLabel("   Open Gender Chart ");
		lblNewLabel_28.setIcon(new ImageIcon(Menu.class.getResource("/Main/gender-symbol.png")));
		lblNewLabel_28.setForeground(new Color(220, 20, 60));
		lblNewLabel_28.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GenderChart genderChart = new GenderChart("Gender Chart");
				genderChart.setVisible(true);
			}
		});
		lblNewLabel_28.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_28.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28.setBounds(10, 0, 238, 42);
		panel_11.add(lblNewLabel_28);

		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_14.setBackground(Color.WHITE);
		panel_14.setBounds(295, 563, 258, 42);
		Student.add(panel_14);
		panel_14.setLayout(null);

		JLabel lblNewLabel_28_1 = new JLabel("   Open Address Chart ");
		lblNewLabel_28_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddresChart addresChart = new AddresChart();
				addresChart.setVisible(true);
			}
		});
		lblNewLabel_28_1.setIcon(new ImageIcon(Menu.class.getResource("/Main/analytics.png")));
		lblNewLabel_28_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_28_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_28_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_28_1.setBounds(10, 0, 238, 42);
		panel_14.add(lblNewLabel_28_1);

		JButton btnNewButton_5 = new JButton("Export Excel File");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelFile excelFile = new ExcelFile();
				excelFile.exportFileExcel();
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_5.setBounds(1013, 72, 183, 21);
		Student.add(btnNewButton_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Sort up ascending", "Sort descending" }));
		comboBox.setFont(new Font("Times New Roman", Font.BOLD, 13));
		comboBox.setBounds(879, 72, 122, 20);
		Student.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentModify studentModify = new StudentModify();
				String selectedOption = (String) comboBox.getSelectedItem();
				if (selectedOption.equals("Sort descending")) {
					studentModify.sortDESC();
					showStudentSort();
				} else {
					studentModify.sortASC();
					showStudentSortASC();
				}
			}
		});

		buttonGroup = new ButtonGroup();

		JPanel Search = new JPanel();
		Search.setBorder(new LineBorder(SystemColor.textInactiveText));
		Search.setBackground(Color.WHITE);
		pncontainer.add(Search, "name_1945613465051000");
		Search.setLayout(null);

		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_9.setBackground(SystemColor.text);
		panel_9.setBounds(339, 10, 560, 52);
		Search.add(panel_9);
		panel_9.setLayout(null);

		JLabel lblNewLabel_20 = new JLabel("  FIND STUDENT ");
		lblNewLabel_20.setIcon(new ImageIcon(Menu.class.getResource("/Main/analysis.png")));
		lblNewLabel_20.setForeground(new Color(220, 20, 60));
		lblNewLabel_20.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_20.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_20.setBounds(10, 0, 540, 52);
		panel_9.add(lblNewLabel_20);

		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_10.setBackground(SystemColor.text);
		panel_10.setBounds(10, 72, 1186, 547);
		Search.add(panel_10);
		panel_10.setLayout(null);

		tblfind = new JTable();
		tblfind.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tblfind.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "ID", "Name", "Date Of Birth",
				"Gender", "Ethnic Group", "Religion", "Phone Number", "Email", "Image", "Address" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false, false, false, true, false, false, false,
					true };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		JScrollPane scrollPane_2 = new JScrollPane(tblfind);
		scrollPane_2.setBounds(26, 40, 944, 426);
		panel_10.add(scrollPane_2);

		JButton btnNewButton_3 = new JButton("FIND");
		DefaultTableModel tableModel_1 = (DefaultTableModel) tblfind.getModel();

		btnNewButton_3.setBounds(935, 498, 175, 39);
		panel_10.add(btnNewButton_3);
		btnNewButton_3.setForeground(new Color(220, 20, 60));
		btnNewButton_3.setBackground(new Color(255, 192, 203));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel lblNewLabel_21 = new JLabel("Click to search for students ->");
		lblNewLabel_21.setForeground(new Color(0, 0, 0));
		lblNewLabel_21.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNewLabel_21.setBounds(728, 500, 200, 36);
		panel_10.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("Image of student");
		lblNewLabel_22.setForeground(new Color(220, 20, 60));
		lblNewLabel_22.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_22.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_22.setBounds(980, 47, 181, 19);
		panel_10.add(lblNewLabel_22);

		JLabel lbanhthe1 = new JLabel("");
		lbanhthe1.setBounds(990, 76, 186, 318);
		panel_10.add(lbanhthe1);

		JLabel lbanh = new JLabel("");
		lbanh.setBounds(10, 10, 176, 252);

		JPanel pnQuanLyDiem = new JPanel();
		pnQuanLyDiem.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnQuanLyDiem.setBackground(Color.WHITE);
		pncontainer.add(pnQuanLyDiem, "name_2230341691844999");
		pnQuanLyDiem.setLayout(null);

		table_score = new JTable();
		table_score.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		table_score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		table_score.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID ", "Name", "Lap Trinh Co Ban",
				"Lap Trinh Huong Doi Tuong", "Giai Tich", "Tieng Anh", "Co So Du Lieu", "GDTC", "Xep Loai" }));
		JScrollPane scrollPane_3 = new JScrollPane(table_score);
		scrollPane_3.setBounds(33, 81, 1163, 406);
		pnQuanLyDiem.add(scrollPane_3);

		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_16.setBackground(Color.WHITE);
		panel_16.setBounds(43, 533, 345, 49);
		pnQuanLyDiem.add(panel_16);
		panel_16.setLayout(null);

		JLabel lblNewLabel_31 = new JLabel("  Click to open Student Score Chart ");
		lblNewLabel_31.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				XepLoaiChart xepLoaiChart = new XepLoaiChart();
				xepLoaiChart.setVisible(true);
			}
		});
		lblNewLabel_31.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_31.setIcon(new ImageIcon(Menu.class.getResource("/Main/pie-chart.png")));
		lblNewLabel_31.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_31.setForeground(new Color(220, 20, 60));
		lblNewLabel_31.setBounds(0, 0, 345, 49);
		panel_16.add(lblNewLabel_31);

		JLabel lblNewLabel_32 = new JLabel("  STUDENT 'S SCORE ");
		lblNewLabel_32.setIcon(new ImageIcon(Menu.class.getResource("/Main/customer-satisfaction.png")));
		lblNewLabel_32.setForeground(new Color(220, 20, 60));
		lblNewLabel_32.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_32.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_32.setBounds(33, 10, 1163, 50);
		pnQuanLyDiem.add(lblNewLabel_32);

		JButton btnNewButton_5_1 = new JButton("Export Excel File");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelFile excelFile = new ExcelFile();
				excelFile.ExportFileScore();
			}
		});
		btnNewButton_5_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		btnNewButton_5_1.setBounds(1013, 533, 183, 21);
		pnQuanLyDiem.add(btnNewButton_5_1);

		JComboBox comboBox_1 = new JComboBox(); // sap xep diem theo diem trung binh
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Sort up ascending", "Sort descending" }));
		comboBox_1.setFont(new Font("Times New Roman", Font.BOLD, 13));
		comboBox_1.setBounds(1074, 497, 122, 20);
		pnQuanLyDiem.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentModify studentModify = new StudentModify();
				String selectedOption = (String) comboBox_1.getSelectedItem();
				if (selectedOption.equals("Sort descending")) {
					studentModify.sortScoreDESC();
					showScoreSortDESC();
				} else {
					studentModify.sortScoreASC();
					showScoreSortASC();
				}
			}
		});
		JPanel pnScore = new JPanel();
		pnScore.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnScore.setBackground(Color.WHITE);
		pncontainer.add(pnScore, "name_2230663691348400");
		pnScore.setLayout(null);

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_13.setBounds(322, 10, 520, 68);
		pnScore.add(panel_13);
		panel_13.setLayout(null);

		JLabel lblNewLabel_23 = new JLabel(" ENTER SCORE ");
		lblNewLabel_23.setIcon(new ImageIcon(Menu.class.getResource("/Main/high-score.png")));
		lblNewLabel_23.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_23.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_23.setBounds(0, 10, 517, 48);
		panel_13.add(lblNewLabel_23);

		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_12.setBackground(new Color(255, 255, 255));
		panel_12.setBounds(10, 100, 670, 519);
		pnScore.add(panel_12);
		panel_12.setLayout(null);

		JLabel lblNewLabel_24 = new JLabel("Lap Trinh Co Ban   : ");
		lblNewLabel_24.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24.setBounds(10, 33, 204, 31);
		panel_12.add(lblNewLabel_24);

		txltcb = new JTextField();
		txltcb.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txltcb.setBounds(247, 30, 351, 31);
		panel_12.add(txltcb);
		txltcb.setColumns(10);

		JLabel lblNewLabel_24_1 = new JLabel("Lap Trinh Huong Doi Tuong :");
		lblNewLabel_24_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24_1.setBounds(10, 91, 227, 31);
		panel_12.add(lblNewLabel_24_1);

		txlthdt = new JTextField();
		txlthdt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txlthdt.setColumns(10);
		txlthdt.setBounds(247, 91, 351, 31);
		panel_12.add(txlthdt);

		JLabel lblNewLabel_24_1_1 = new JLabel("Giai Tich :");
		lblNewLabel_24_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24_1_1.setBounds(10, 147, 183, 31);
		panel_12.add(lblNewLabel_24_1_1);

		txgt = new JTextField();
		txgt.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txgt.setColumns(10);
		txgt.setBounds(247, 147, 351, 31);
		panel_12.add(txgt);

		JLabel lblNewLabel_24_1_1_1 = new JLabel("Tieng Anh  :");
		lblNewLabel_24_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24_1_1_1.setBounds(10, 200, 183, 31);
		panel_12.add(lblNewLabel_24_1_1_1);

		txta = new JTextField();
		txta.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txta.setColumns(10);
		txta.setBounds(247, 200, 351, 31);
		panel_12.add(txta);

		JLabel lblNewLabel_24_1_1_1_1 = new JLabel("Co So Du Lieu :");
		lblNewLabel_24_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24_1_1_1_1.setBounds(10, 247, 183, 31);
		panel_12.add(lblNewLabel_24_1_1_1_1);

		txcsdl = new JTextField();
		txcsdl.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txcsdl.setColumns(10);
		txcsdl.setBounds(247, 245, 351, 34);
		panel_12.add(txcsdl);

		JLabel lblNewLabel_24_1_1_1_1_1 = new JLabel("GDTC :");
		lblNewLabel_24_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24_1_1_1_1_1.setBounds(10, 298, 183, 31);
		panel_12.add(lblNewLabel_24_1_1_1_1_1);

		txgdtc = new JTextField();
		txgdtc.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txgdtc.setColumns(10);
		txgdtc.setBounds(247, 298, 351, 31);
		panel_12.add(txgdtc);

		JLabel lblNewLabel_24_1_1_1_1_1_1 = new JLabel("Average Score :");
		lblNewLabel_24_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1_1_1_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24_1_1_1_1_1_1.setBounds(10, 349, 198, 31);
		panel_12.add(lblNewLabel_24_1_1_1_1_1_1);

		txaverage = new JTextField();
		txaverage.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txaverage.setColumns(10);
		txaverage.setBounds(247, 347, 351, 34);
		txaverage.setEditable(false);
		panel_12.add(txaverage);

		JLabel lblNewLabel_25_1 = new JLabel("Please Enter Full Infomation");
		lblNewLabel_25_1.setForeground(Color.RED);
		lblNewLabel_25_1.setFont(new Font("Sylfaen", Font.ITALIC, 18));
		lblNewLabel_25_1.setBounds(10, 416, 321, 23);
		panel_12.add(lblNewLabel_25_1);

		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(Color.LIGHT_GRAY));
		panel_17.setBackground(Color.WHITE);
		panel_17.setBounds(695, 100, 498, 513);
		pnScore.add(panel_17);
		panel_17.setLayout(null);

		JLabel lblNewLabel_24_1_1_1_2_1 = new JLabel("ID  :");
		lblNewLabel_24_1_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1_1_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24_1_1_1_2_1.setBounds(21, 172, 48, 31);
		panel_17.add(lblNewLabel_24_1_1_1_2_1);

		tx_id = new JTextField();
		tx_id.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tx_id.setColumns(10);
		tx_id.setBounds(79, 172, 257, 31);
		panel_17.add(tx_id);

		JLabel lblNewLabel_24_1_1_1_2_1_1 = new JLabel("NAME  :");
		lblNewLabel_24_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1_1_1_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_24_1_1_1_2_1_1.setBounds(10, 102, 73, 31);
		panel_17.add(lblNewLabel_24_1_1_1_2_1_1);

		tx_name = new JTextField();
		tx_name.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tx_name.setColumns(10);
		tx_name.setBounds(79, 102, 257, 31);
		panel_17.add(tx_name);

		JButton btnNewButton_4_1 = new JButton("ADD");
		btnNewButton_4_1.setBackground(Color.PINK);
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validateForm()) {
					Grade g = getModel();
					if (dDao.getOndeGradeBySv(g.getSv().getMahs()) != null) {
						JOptionPane.showMessageDialog(null, "Student Code Already Exists", "Notification",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						if (dDao.add(g) > 0) {
							JOptionPane.showMessageDialog(null, "Add Successful", "Notification",
									JOptionPane.INFORMATION_MESSAGE);
							txaverage.setText(String.valueOf(g.getTrungBinhCong()));
							fillDataTable();
						}
						reset();
					}
				} else {
					reset();
					JOptionPane.showMessageDialog(null, "Please check for more complete information", "Notification",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnNewButton_4_1.setForeground(Color.BLACK);
		btnNewButton_4_1.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_4_1.setBounds(346, 105, 142, 23);
		panel_17.add(btnNewButton_4_1);

		JButton btnNewButton_4_2 = new JButton("RESET");
		btnNewButton_4_2.setBackground(Color.PINK);

		btnNewButton_4_2.setForeground(Color.BLACK);
		btnNewButton_4_2.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btnNewButton_4_2.setBounds(346, 175, 142, 23);
		panel_17.add(btnNewButton_4_2);

		JLabel lblNewLabel_24_1_1_1_2 = new JLabel("ID  :");
		lblNewLabel_24_1_1_1_2.setBounds(21, 32, 48, 31);
		panel_17.add(lblNewLabel_24_1_1_1_2);
		lblNewLabel_24_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_24_1_1_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));

		tx_timkiem = new JTextField();
		tx_timkiem.setBounds(79, 32, 257, 31);
		panel_17.add(tx_timkiem);
		tx_timkiem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		tx_timkiem.setColumns(10);

		JButton btnFind = new JButton("FIND");
		btnFind.setBackground(Color.PINK);
		btnFind.setBounds(346, 31, 142, 23);
		panel_17.add(btnFind);
		btnFind.setForeground(Color.BLACK);
		btnFind.setFont(new Font("Times New Roman", Font.BOLD, 19));

		JLabel lblNewLabel_25 = new JLabel("Show Information");
		lblNewLabel_25.setForeground(new Color(65, 105, 225));
		lblNewLabel_25.setFont(new Font("Sylfaen", Font.ITALIC, 18));
		lblNewLabel_25.setBounds(10, 78, 160, 23);
		panel_17.add(lblNewLabel_25);

		JLabel lblNewLabel_26 = new JLabel("STUDENT ' S IMAGE");
		lblNewLabel_26.setForeground(new Color(65, 105, 225));
		lblNewLabel_26.setIcon(new ImageIcon(Menu.class.getResource("/Main/image.png")));
		lblNewLabel_26.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblNewLabel_26.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_26.setBounds(79, 482, 257, 31);
		panel_17.add(lblNewLabel_26);

		txanhscore = new JLabel("");
		txanhscore.setBounds(105, 226, 206, 246);
		panel_17.add(txanhscore);

		JButton btEdit = new JButton("EDIT");
		btEdit.setBackground(Color.PINK);
		btEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validateForm()) {
					Grade g = getModel();
					if (dDao.updateGrade(g) > 0) {
						fillDataTable();
						showScore();
					}
					JOptionPane.showMessageDialog(null, "EDITION SUCCESSFUL", "NOTIFICATION",
							JOptionPane.INFORMATION_MESSAGE);

				} else {
					JOptionPane.showMessageDialog(null, "PLEASE ENTER THE INFORMATION NEEDED TO BE CORRECTED",
							"NOTIFICATION", JOptionPane.ERROR_MESSAGE);
					reset();
				}
			}

		});
		btEdit.setForeground(Color.BLACK);
		btEdit.setFont(new Font("Times New Roman", Font.BOLD, 19));
		btEdit.setBounds(346, 226, 142, 23);
		panel_17.add(btEdit);

		JButton btdelete = new JButton("DELETE");
		btdelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btdelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (validateForm()) {
					Grade g = getModel();
					if (dDao.delGrade(tx_id.getText()) > 0) {
						fillDataTable();
						showScore();
					}
					JOptionPane.showMessageDialog(null, "DELETION SUCCESSFUL", "NOTIFICATION",
							JOptionPane.INFORMATION_MESSAGE);
					tx_id.setText("");
					tx_name.setText("");
					tx_timkiem.setText("");
					String anhbasic = "D:\\Anh The\\Background.png";
					txanhscore.setIcon(ResizeImage(anhbasic));
					txgdtc.setText("");
					txgt.setText("");
					txltcb.setText("");
					txlthdt.setText("");
					txta.setText("");
					txcsdl.setText("");
					txaverage.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "NOT FOUND", "NOTIFICATION", JOptionPane.ERROR_MESSAGE);
				}
				showScore();
			}
		});
		btdelete.setForeground(Color.BLACK);
		btdelete.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btdelete.setBackground(Color.PINK);
		btdelete.setBounds(346, 279, 142, 23);
		panel_17.add(btdelete);

		JButton btnNewButton_4_1_1 = new JButton("IMPORT FILE");
		btnNewButton_4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelFile exceFile = new ExcelFile();
				exceFile.ImportScoreByFile();
				showScore();
			}
		});
		btnNewButton_4_1_1.setBackground(Color.PINK);
		btnNewButton_4_1_1.setForeground(Color.BLACK);
		btnNewButton_4_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_4_1_1.setBounds(346, 331, 142, 23);
		panel_17.add(btnNewButton_4_1_1);

		JPanel pnAttendance = new JPanel();
		pnAttendance.setBackground(new Color(255, 255, 255));
		pncontainer.add(pnAttendance, "name_1055111027240900");
		pnAttendance.setBorder(new LineBorder(SystemColor.activeCaptionBorder));
		pnAttendance.setLayout(null);

		JLabel lblNewLabel_33 = new JLabel("ATTENDANCE");
		lblNewLabel_33.setBounds(10, 10, 198, 33);
		pnAttendance.add(lblNewLabel_33);
		lblNewLabel_33.setIcon(new ImageIcon(Menu.class.getResource("/Main/roll-call.png")));
		lblNewLabel_33.setForeground(new Color(0, 0, 128));
		lblNewLabel_33.setFont(new Font("Times New Roman", Font.BOLD, 23));

		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_18.setBackground(SystemColor.controlLtHighlight);
		JScrollPane scrollPane_5 = new JScrollPane(panel_18);
		panel_18.setLayout(null);

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(SystemColor.text);
		panel_19.setBorder(new LineBorder(SystemColor.textInactiveText));
		panel_19.setBounds(0, 0, 231, 33);
		panel_18.add(panel_19);
		panel_19.setLayout(null);

		JLabel lblNewLabel_35 = new JLabel("Your Student");
		lblNewLabel_35.setIcon(new ImageIcon(Menu.class.getResource("/Main/teamwork.png")));
		lblNewLabel_35.setForeground(Color.DARK_GRAY);
		lblNewLabel_35.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_35.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_35.setBounds(10, 0, 211, 33);
		panel_19.add(lblNewLabel_35);

		txIDFind = new JTextField();
		txIDFind.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		txIDFind.setBounds(10, 43, 177, 19);
		panel_18.add(txIDFind);
		txIDFind.setColumns(10);

		JLabel lblNewLabel_36 = new JLabel("");

		lblNewLabel_36.setIcon(new ImageIcon(Menu.class.getResource("/Main/user (1).png")));
		lblNewLabel_36.setBounds(197, 43, 24, 24);
		panel_18.add(lblNewLabel_36);

		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.WHITE);
		panel_20.setBounds(10, 72, 211, 319);
		panel_18.add(panel_20);
		panel_20.setLayout(null);

		table_1 = new JTable();
		table_1.setBounds(0, 0, 1, 1);
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table_1.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "ID", "Date", "Status" }) {
			boolean[] canEdit = new boolean[] { false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		DefaultTableModel tableModel_2 = (DefaultTableModel) table_1.getModel();
		lblNewLabel_36.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = txIDFind.getText();
				if (input != null && input.length() > 0) {
					studentList = StudentModify.findAbsences(input);
					tableModel_2.setRowCount(0);
					for (Student student : studentList) {
						tableModel_2.addRow(new Object[] { student.getMahs(), student.getDate(), student.isPresent() });
					}
					table_1.getSelectionModel().addListSelectionListener(event -> {
						if (!event.getValueIsAdjusting()) {
							// xủ lí lựa chọn khi không ở trong quá trình diều chỉnh thông tin
							int selectedRow = table_1.getSelectedRow();
							if (selectedRow != -1) {
								String id = (String) table_1.getValueAt(selectedRow, 0);
								System.out.println(id);

							}
						}
					});
				} else {
					JOptionPane.showMessageDialog(null, "ERROR", "NOTIFICATION", JOptionPane.ERROR_MESSAGE);
					showStudent();

				}
			}
		});

		scrollPane_5.setBounds(10, 50, 233, 569);
		pnAttendance.add(scrollPane_5);

		JScrollPane scrollPane_6 = new JScrollPane(table_1);
		scrollPane_6.setBounds(0, 0, 211, 319);
		panel_20.add(scrollPane_6);

		JLabel lblNewLabel_37 = new JLabel("Number of students absent :");
		lblNewLabel_37.setForeground(Color.RED);
		lblNewLabel_37.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_37.setBounds(10, 435, 162, 24);
		panel_18.add(lblNewLabel_37);

		JLabel lblNewLabel_37_1 = new JLabel("Number of students present :");
		lblNewLabel_37_1.setForeground(Color.BLUE);
		lblNewLabel_37_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_37_1.setBounds(10, 469, 167, 24);
		panel_18.add(lblNewLabel_37_1);

		JLabel lblNewLabel_37_2 = new JLabel("TOTAL : ");
		lblNewLabel_37_2.setForeground(Color.BLACK);
		lblNewLabel_37_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_37_2.setBounds(10, 401, 79, 24);
		panel_18.add(lblNewLabel_37_2);

		txToTal = new JLabel("");
		txToTal.setForeground(Color.BLACK);
		txToTal.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txToTal.setBounds(99, 401, 51, 24);
		panel_18.add(txToTal);

		JLabel txAbsent = new JLabel("");
		txAbsent.setForeground(Color.BLACK);
		txAbsent.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txAbsent.setBounds(182, 435, 36, 24);
		panel_18.add(txAbsent);

		JLabel txPresent = new JLabel("");
		txPresent.setForeground(Color.BLACK);
		txPresent.setFont(new Font("Times New Roman", Font.BOLD, 18));
		txPresent.setBounds(185, 469, 36, 24);
		panel_18.add(txPresent);

		panel_21 = new JPanel();
		panel_21.setForeground(Color.BLACK);
		panel_21.setBorder(new LineBorder(Color.DARK_GRAY));
		panel_21.setBackground(Color.WHITE);
		panel_21.setBounds(253, 50, 943, 569);
		pnAttendance.add(panel_21);
		panel_21.setLayout(null);

		JPanel pnCheckAttendance = new JPanel();
		pnCheckAttendance.setBackground(new Color(255, 255, 255));
		pnCheckAttendance.setBounds(10, 44, 923, 515);
		pnCheckAttendance.setLayout(new GridLayout(0, 1, 0, 5)); // 1 column, variable rows, 5px gap

		JScrollPane scrollPane_7 = new JScrollPane(pnCheckAttendance);
		scrollPane_7.setBounds(10, 44, 923, 515);
		panel_21.add(scrollPane_7);

		JLabel lblNewLabel_34 = new JLabel("Date : ");
		lblNewLabel_34.setForeground(Color.RED);
		lblNewLabel_34.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_34.setBounds(10, 10, 61, 24);
		panel_21.add(lblNewLabel_34);

		lbDate = new JLabel("");
		lbDate.setForeground(Color.BLACK);
		lbDate.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lbDate.setBounds(70, 10, 203, 24);
		panel_21.add(lbDate);

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tx_timkiem.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "PLEASE ENTER STUDENT ID", "NOTIFICATION",
							JOptionPane.ERROR_MESSAGE);
				} else {
					// Tìm kiếm sinh viên bằng id từ ô tìm kiếm
					Student sv = new StudentModify().getSinhVienById(tx_timkiem.getText());
					// Nếu sinh viên đã tồn tại , gọi Pt để lấy thông tin điểm số của hs đó
					if (sv != null) {
						Grade d = dDao.getOndeGradeBySv(sv.getMahs());
						if (d != null) {
							tx_name.setText(sv.getFullname());
							tx_id.setText(sv.getMahs());
							txanhscore.setIcon(ResizeImage(sv.getAnh()));
							// Nếu có thông tin điểm sẽ set dulieu
							setModel(d);
						} else {
							// Nếu không có thông tin thì sẽ set các thông tin trên các trường được nhập
							tx_id.setText(sv.getMahs());
							tx_name.setText(sv.getFullname());
							txanhscore.setIcon(ResizeImage(sv.getAnh()));
							txgdtc.setText("");
							txgt.setText("");
							txltcb.setText("");
							txlthdt.setText("");
							txta.setText("");
							txcsdl.setText("");
							txaverage.setText("");
						}
					} else {
						JOptionPane.showMessageDialog(null, "NOT FOUND", "Notification", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String input = JOptionPane.showInputDialog(null, "Enter Full Name To Search", "Notification",
						JOptionPane.INFORMATION_MESSAGE);
				if (input != null && input.length() > 0) {
					studentList = StudentModify.findByFullName(input);
					tableModel_1.setRowCount(0);
					for (Student student : studentList) {
						tableModel_1.addRow(new Object[] { tableModel_1.getRowCount() + 1, student.getMahs(),
								student.getFullname(), student.getDateofbirth(), student.getGender(),
								student.getEthnicgroup(), student.getReligion(), student.getPhonenumber(),
								student.getEmail(), student.getAnh(), student.getDiaChi() });
					}
					// set ảnh khi chọn sv
					tblfind.getSelectionModel().addListSelectionListener(event -> {
						if (!event.getValueIsAdjusting()) {
							// xủ lí lựa chọn khi không ở trong quá trình diều chỉnh thông tin
							int selectedRow = tblfind.getSelectedRow();
							if (selectedRow != -1) {
								String imagePath = (String) tblfind.getValueAt(selectedRow, 9);
								lbanhthe1.setIcon(ResizeImage(imagePath));
							}
						}
					});
				} else {
					JOptionPane.showMessageDialog(null, "ERROR", "NOTIFICATION", JOptionPane.ERROR_MESSAGE);
					showStudent();

				}

			}
		});
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tx_id.setText("");
				tx_name.setText("");
				tx_timkiem.setText("");
				String anhbasic = "D:\\Anh The\\Background.png";
				txanhscore.setIcon(ResizeImage(anhbasic));
				txgdtc.setText("");
				txgt.setText("");
				txltcb.setText("");
				txlthdt.setText("");
				txta.setText("");
				txcsdl.setText("");
				txaverage.setText("");

			}
		});
		JLabel lblNewLabel_4 = new JLabel("HCLASS ");
		lblNewLabel_4.setBounds(1092, 0, 243, 47);
		lblNewLabel_4.setIcon(new ImageIcon(Menu.class.getResource("/Main/seminar.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 40));
		main.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Connect love");
		lblNewLabel_5.setBounds(1316, 30, 98, 13);
		lblNewLabel_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		main.add(lblNewLabel_5);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(1138, 53, 197, 2);
		separator_2.setForeground(SystemColor.textHighlight);
		main.add(separator_2);

		JPanel panel = new JPanel();
		panel.setBounds(233, 30, 343, 43);
		panel.setBackground(SystemColor.text);
		panel.setBorder(new LineBorder(SystemColor.activeCaption));
		main.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("OPTION  | ");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_6.setBounds(86, 10, 103, 23);
		panel.add(lblNewLabel_6);

		JLabel txOption = new JLabel("Home");
		txOption.setForeground(Color.RED);
		txOption.setFont(new Font("Sylfaen", Font.BOLD, 20));
		txOption.setBounds(199, 14, 134, 23);
		panel.add(txOption);
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home.setVisible(true);
				Manage.setVisible(false);
				Student.setVisible(false);
				Search.setVisible(false);
				pnScore.setVisible(false);
				pnAttendance.setVisible(false);
				txOption.setText("Home");
			}
		});
		lblNewLabel_2_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Manage.setVisible(true);
				Home.setVisible(false);
				Student.setVisible(false);
				Search.setVisible(false);
				pnScore.setVisible(false);
				pnAttendance.setVisible(false);
				txOption.setText("Manage");
			}
		});

		lblNewLabel_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Student.setVisible(true);
				Manage.setVisible(false);
				Home.setVisible(false);
				Search.setVisible(false);
				pnQuanLyDiem.setVisible(false);
				pnScore.setVisible(false);
				pnAttendance.setVisible(false);
				txOption.setText("Student");
			}
		});

		lblNewLabel_2_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Search.setVisible(true);
				Student.setVisible(false);
				Manage.setVisible(false);
				Home.setVisible(false);
				pnQuanLyDiem.setVisible(false);
				pnScore.setVisible(false);
				pnAttendance.setVisible(false);
				txOption.setText("Search");
			}
		});
		lblAttendance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Search.setVisible(false);
				Student.setVisible(false);
				Manage.setVisible(false);
				Home.setVisible(false);
				pnQuanLyDiem.setVisible(false);
				pnScore.setVisible(false);
				pnAttendance.setVisible(true);
				txOption.setText("Attendance");
//				Lấy ngày tháng hiện tại 
				LocalDate ngayHienTai = LocalDate.now();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				date = ngayHienTai.format(format);
				lbDate.setText(date);
				Connection connection = null;
				PreparedStatement statement = null;
				String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
				String username = "sa";
				String password = "123456789";
				try {
					connection = DriverManager.getConnection(url, username, password);
					String sql = "select mahs , fullname from student";
					statement = connection.prepareCall(sql);
					ResultSet resultSet = statement.executeQuery();
					while (resultSet.next()) {
						String mahs = resultSet.getString("mahs");
						String fullname = resultSet.getString("fullname");
						JPanel studentPanel = new JPanel(new BorderLayout());
						studentPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						JLabel mahsLabel = new JLabel("ID : " + mahs);
						mahsLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
						JLabel fullnameLabel = new JLabel("Name : " + fullname);
						fullnameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
						studentPanel.add(mahsLabel, BorderLayout.NORTH);
						studentPanel.add(fullnameLabel, BorderLayout.CENTER);
						presentCheckbox = new JCheckBox("Present");
						presentCheckbox.setFont(new Font("Times New Roman", Font.BOLD, 13));
						presentCheckbox.setForeground(Color.BLUE);
						absentCheckbox = new JCheckBox("Absent");
						absentCheckbox.setFont(new Font("Times New Roman", Font.BOLD, 13));
						absentCheckbox.setForeground(Color.RED);
						presentCheckbox.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									updateAttendance(mahs, true);
								} catch (Exception e2) {
									e2.printStackTrace();
								}

							}
						});
						absentCheckbox.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								try {
									updateAttendance(mahs, false);
								} catch (Exception e2) {
									e2.printStackTrace();
								}

							}
						});
						ButtonGroup attendanceGroup = new ButtonGroup();
						attendanceGroup.add(presentCheckbox);
						attendanceGroup.add(absentCheckbox);
						JPanel checkboxPanel = new JPanel(new GridLayout(1, 2));
						checkboxPanel.add(presentCheckbox);
						checkboxPanel.add(absentCheckbox);
						studentPanel.add(checkboxPanel, BorderLayout.EAST);
						pnCheckAttendance.add(studentPanel);
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				} finally {
					if (statement != null) {
						try {
							statement.close();
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					}
					if (connection != null) {
						try {
							connection.close();
						} catch (SQLException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
					}
				}
			}
		});
		System.out.println(absentCheckbox);
		score.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnScore.setVisible(true);
				Student.setVisible(false);
				Manage.setVisible(false);
				Home.setVisible(false);
				Search.setVisible(false);
				pnQuanLyDiem.setVisible(false);
				pnAttendance.setVisible(false);
				txOption.setText("Score");
			}
		});
		logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnQuanLyDiem.setVisible(true);
				pnScore.setVisible(false);
				Student.setVisible(false);
				Manage.setVisible(false);
				Home.setVisible(false);
				Search.setVisible(false);
				pnAttendance.setVisible(false);
				txOption.setText("Student's Score");
			}
		});

		tableModel2 = (DefaultTableModel) table_score.getModel();
		showScore(); // hiển thị điểm
		tabelModel = (DefaultTableModel) tabel_student.getModel();
		showStudent(); // hiển thị sinh viên
		tableModel3 = (DefaultTableModel) table.getModel();
		showSchedul();
		count();
		StudentModify studentModify = new StudentModify();
		LocalDate ngayHienTai = LocalDate.now();
		String formattedDate = ngayHienTai.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		JButton btnNewButton_6 = new JButton("Completed");
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_6.setBounds(10, 519, 107, 21);
		panel_18.add(btnNewButton_6);
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "select mahs , noti  from student ";
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				if (rs.getString("noti") != null) {
					txNotification.setText(txNotification.getText() + "\n" + rs.getString("noti") + " - "
							+ rs.getString("mahs") + " \n ");
				}
			}
		} catch (Exception e1) {
			System.out.println("Error" + e1.toString());
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (Exception e2) {

			}
		}
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				Connection connection = null;
				PreparedStatement statement = null;
				String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
				String username = "sa";
				String password = "123456789";
				String sql = "UPDATE SCHEDULE SET monday=?, tuesday=?, wednesday=?, thursday=?, friday=?, saturday=?, sunday=? WHERE time_slot=?";

				try {
					connection = DriverManager.getConnection(url, username, password);
					statement = connection.prepareStatement(sql);

					for (int row = 0; row < model.getRowCount(); row++) {
						String timeSlot = (String) model.getValueAt(row, 0);
						String Monday = (String) model.getValueAt(row, 1);
						String Tuesday = (String) model.getValueAt(row, 2);
						String Wednesday = (String) model.getValueAt(row, 3);
						String Thursday = (String) model.getValueAt(row, 4);
						String Friday = (String) model.getValueAt(row, 5);
						String Saturday = (String) model.getValueAt(row, 6);
						String Sunday = (String) model.getValueAt(row, 7);

						// Thiết lập các tham số trong câu lệnh UPDATE
						statement.setString(1, Monday);
						statement.setString(2, Tuesday);
						statement.setString(3, Wednesday);
						statement.setString(4, Thursday);
						statement.setString(5, Friday);
						statement.setString(6, Saturday);
						statement.setString(7, Sunday);
						statement.setString(8, timeSlot);

						// Thực thi câu lệnh UPDATE
						if (statement.executeUpdate() > 0) {
							System.out.println("Thực hiện thành công cho hàng " + row);
						}
					}
				} catch (SQLException ex) {
					System.out.println("Lỗi khi cập nhật dữ liệu: " + ex.getMessage());
				} finally {
					try {
						if (statement != null) {
							statement.close();
						}
						if (connection != null) {
							connection.close();
						}
					} catch (SQLException ex) {
						System.out.println("Lỗi khi đóng kết nối: " + ex.getMessage());
					}
				}
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Successful attendance");
				studentModify.countPresentAndAbsent(date, txAbsent, txPresent);
			}
		});
	}

	// hàm điều chỉnh kích thước image
	public ImageIcon ResizeImage(String ImagePath) {
		ImageIcon MyImage = new ImageIcon(ImagePath);
		Image img = MyImage.getImage();
		Image newImg = img.getScaledInstance(lblanhthe.getWidth(), lblanhthe.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		return image;
	}

	private void showStudent() { // hàm hiển thị thông tin
		studentList = StudentModify.findAll();
		// xóa dữ liệu trong bảng
		tabelModel.setRowCount(0);
		for (Student student : studentList) {
			tabelModel.addRow(new Object[] { tabelModel.getRowCount() + 1, student.getMahs(), student.getFullname(),
					student.getDateofbirth(), student.getGender(), student.getEthnicgroup(), student.getReligion(),
					student.getPhonenumber(), student.getEmail(), student.getAnh(), student.getDiaChi() });
		}
	}

	private void showStudentSort() { // hàm hiển thị thông tin sau khi sắp xếp
		studentListSort = StudentModify.sortDESC();
		// xóa dữ liệu trong bảng
		tabelModel.setRowCount(0);
		for (Student student : studentListSort) {
			tabelModel.addRow(new Object[] { tabelModel.getRowCount() + 1, student.getMahs(), student.getFullname(),
					student.getDateofbirth(), student.getGender(), student.getEthnicgroup(), student.getReligion(),
					student.getPhonenumber(), student.getEmail(), student.getAnh(), student.getDiaChi() });
		}
	}

	// hàm hiển thị thông tin sau khi sắp xếp
	private void showScoreSortASC() { // sx tang
		ScoreListASC = StudentModify.sortScoreASC();
		tableModel2.setRowCount(0);
		for (Grade d : ScoreListASC) {
			tableModel2.addRow(new Object[] { d.getSv().getMahs(), d.getSv().getFullname(), d.getC(), d.getJava(),
					d.getGt(), d.getTanh(), d.getCsdl(), d.getGdtc(), d.getXepLoai() });
		}

	}

	private void showScoreSortDESC() { // sx giam
		ScoreListDESC = StudentModify.sortScoreDESC();
		tableModel2.setRowCount(0);
		for (Grade d : ScoreListDESC) {
			tableModel2.addRow(new Object[] { d.getSv().getMahs(), d.getSv().getFullname(), d.getC(), d.getJava(),
					d.getGt(), d.getTanh(), d.getCsdl(), d.getGdtc(), d.getXepLoai() });
		}

	}

	private void showStudentSortASC() { // hàm hiển thị thông tin sau khi sắp xếp
		studentListSortASC = StudentModify.sortASC();
		// xóa dữ liệu trong bảng
		tabelModel.setRowCount(0);
		for (Student student : studentListSortASC) {
			tabelModel.addRow(new Object[] { tabelModel.getRowCount() + 1, student.getMahs(), student.getFullname(),
					student.getDateofbirth(), student.getGender(), student.getEthnicgroup(), student.getReligion(),
					student.getPhonenumber(), student.getEmail(), student.getAnh(), student.getDiaChi() });
		}
	}

	public void showSchedul() {
		scheduleList = StudentModify.getSchedule();
		// xóa dữ liệu trong bảng
		tableModel3.setRowCount(0);
		for (Schedule schedule : scheduleList) {
			tableModel3.addRow(new Object[] { schedule.getTimeSlot(), schedule.getMonday(), schedule.getTuesday(),
					schedule.getWednesday(), schedule.getThursday(), schedule.getFriday(), schedule.getSaturday(),
					schedule.getSunday() });
		}
	}

	private void showScore() {
		ScoreList = dDao.getAllGrade();
		tableModel2.setRowCount(0);
		for (Grade d : ScoreList) {
			tableModel2.addRow(new Object[] { d.getSv().getMahs(), d.getSv().getFullname(), d.getC(), d.getJava(),
					d.getGt(), d.getTanh(), d.getCsdl(), d.getGdtc(), d.getXepLoai() });
		}
	}

	public void chuchay() {
		new Thread() { // sử dụng hàm đa luồng để thực hiện chạy dòng chữ
			public void run() {
				while (true) {
					try {
						Thread.sleep(180); // tốc độ chạy của dòng chữ
						SwingUtilities.invokeAndWait(new Runnable() {
							public void run() {
								String text = lbl_chuchay.getText() + "";
								// text = student manager
								text = text.substring(1) + text.charAt(0);
								// text substring (1) bắt đầu với kí tự 1 trở đi
								// text charAt lấy kí tự đầu tiên.
								lbl_chuchay.setText(text);
							}
						});
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}.start();// bắt đầu
	}


	public void count() {
		int firstColumnIndex = 0;
		int lastRowIndex = tabel_student.getRowCount() - 1;
		if (lastRowIndex == -1) {
			lbcountstd.setText("0");
		} else {
			Object value = tabel_student.getValueAt(lastRowIndex, firstColumnIndex);
			lbcountstd.setText(value.toString());
			txToTal.setText(value.toString());
		}	
	}

	public Grade getGradeAtPosition(int pos) {
		Grade g = new Grade();
		Student sv = new Student();
		sv.setMahs(table_score.getValueAt(pos, 0).toString());
		sv.setFullname(table_score.getValueAt(pos, 1).toString());
		g.setSv(sv);
		g.setC(Double.parseDouble(table_score.getValueAt(pos, 2).toString()));
		g.setJava(Double.parseDouble(table_score.getValueAt(pos, 3).toString()));
		g.setGt(Double.parseDouble(table_score.getValueAt(pos, 4).toString()));
		g.setTanh(Double.parseDouble(table_score.getValueAt(pos, 5).toString()));
		g.setCsdl(Double.parseDouble(table_score.getValueAt(pos, 6).toString()));
		g.setGdtc(Double.parseDouble(table_score.getValueAt(pos, 7).toString()));
		return g;
	}

	public boolean validateForm() {
		if (tx_id.getText().isEmpty() || txcsdl.getText().isEmpty() || txgdtc.getText().isEmpty()
				|| txgt.getText().isEmpty() || txlthdt.getText().isEmpty() || txta.getText().isEmpty()
				|| txltcb.getText().isEmpty()) {
			return false;
		} else {
			try {
				double c = Double.parseDouble(txltcb.getText());
				double java = Double.parseDouble(txlthdt.getText());
				double gt = Double.parseDouble(txgt.getText());
				double ta = Double.parseDouble(txta.getText());
				double csdl = Double.parseDouble(txcsdl.getText());
				double gdtc = Double.parseDouble(txgdtc.getText());
				if (c > 10 || c < 0) {
					return false;
				}
				if (java > 10 || java < 0) {
					return false;
				}
				if (gt > 10 || gt < 0) {
					return false;
				}
				if (ta > 10 || ta < 0) {
					return false;
				}
				if (csdl > 10 || csdl < 0) {
					return false;
				}
				if (gdtc > 10 || gdtc < 0) {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}
		return true;
	}

	public void setModel(Grade g) {
		txltcb.setText(String.valueOf(g.getC()));
		txlthdt.setText(String.valueOf(g.getJava()));
		txta.setText(String.valueOf(g.getTanh()));
		txgt.setText(String.valueOf(g.getGt()));
		txcsdl.setText(String.valueOf(g.getCsdl()));
		txgdtc.setText(String.valueOf(g.getGdtc()));
		txaverage.setText(String.valueOf(g.getTrungBinhCong()));
	}

	public Grade getModel() {
		Grade g = new Grade();
		g.setId(0);
		Student std = new Student(tx_id.getText(), tx_name.getText());
		g.setSv(std);
		g.setC(Double.parseDouble(txltcb.getText()));
		g.setJava(Double.parseDouble(txlthdt.getText()));
		g.setGt(Double.parseDouble(txgt.getText()));
		g.setTanh(Double.parseDouble(txta.getText()));
		g.setCsdl(Double.parseDouble(txcsdl.getText()));
		g.setGdtc(Double.parseDouble(txgdtc.getText()));
		return g;
	}

	public Student getModelStd() {
		Student std = new Student();
		std.setMahs(tx_id.getText());
		Date date = new java.sql.Date(txdate.getDate().getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(date);
		std.setDateofbirth(dateString);
		std.setDiaChi(txDiachi.getSelectedItem().toString());
		std.setEmail(txEmail.getText());
		std.setEthnicgroup(txEthnic.getText());
		std.setFullname(tx_name.getText());
		std.setGender(txGender.getSelectedItem().toString());
		std.setPhonenumber(txPhonenumber.getText());
		std.setReligion(txReligion.getText());
		return std;
	}

	public void reset() {
		tx_id.setText("");
		tx_name.setText("");
		tx_timkiem.setText("");
		String anhbasic = "D:\\Anh The\\Background.png";
		txanhscore.setIcon(ResizeImage(anhbasic));
		txgdtc.setText("");
		txgt.setText("");
		txltcb.setText("");
		txlthdt.setText("");
		txta.setText("");
		txcsdl.setText("");
		txaverage.setText("");
	}

	public void fillDataTable() {
		DefaultTableModel model = (DefaultTableModel) table_score.getModel();
		model.setRowCount(0); // clear bảng
		for (Grade g : dDao.getAllGrade()) {
			// tạo đối tượng lưu các hàng
			Object rowData[] = new Object[9];
			rowData[0] = g.getSv().getMahs();
			rowData[1] = g.getSv().getFullname();
			rowData[2] = g.getC();
			rowData[3] = g.getJava();
			rowData[4] = g.getTanh();
			rowData[5] = g.getGt();
			rowData[6] = g.getCsdl();
			rowData[7] = g.getGdtc();
			rowData[8] = g.getXepLoai();
			model.addRow(rowData);
		}

	}

	public void check() {
		String phoneNumber = txPhonenumber.getText();
		if (phoneNumber.length() != 11) {

		}
	}

	public void error(String s) {
		txNotification.setText(s);
	}

	public boolean isValidDate(Date date) {
		if (date == null) {
			return false;
		}
//	    Ngày  hiện tại
		LocalDate currentDate = LocalDate.now();
		Calendar calendar = Calendar.getInstance();
//	    đặt thời gian cho đối tượng calendar
		calendar.setTime(date);
		LocalDate selectedDate = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH));
		return !selectedDate.isAfter(currentDate);
	}

	public void openFile(String file) {
		File path = new File(file);
		try {
			Desktop.getDesktop().open(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//  phương thức điểm danh 
	public void updateAttendance(String mahs, boolean isPresent) {
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String queryChek = "Select * from Attendance where mahs = ? and date_attended = ?";
			try (PreparedStatement preparedStatement = connection.prepareStatement(queryChek)) {
				preparedStatement.setString(1, mahs);
				preparedStatement.setString(2, date);
				System.out.println(date);
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) {
					JOptionPane.showMessageDialog(null, "This student is already enrolled");
					int choose = JOptionPane.showConfirmDialog(null, "Do you want to do it again?");
					System.out.println(choose);
					if (choose == 0) {
						String sqlUpdate = "UPDATE Attendance SET is_present = ? WHERE mahs = ? AND date_attended = ?";
						PreparedStatement statement2 = connection.prepareCall(sqlUpdate);	
						statement2.setBoolean(1, isPresent);
						statement2.setString(2, mahs);
						statement2.setString(3, date);
						int rowAffected = statement2.executeUpdate();
					}
				} else {
					String sql = "INSERT INTO Attendance (mahs, date_attended, is_present) VALUES (?, ?, ?)";
					statement = connection.prepareCall(sql);
					statement.setString(1, mahs);
					statement.setString(2, date);
					statement.setBoolean(3, isPresent);
					int rowAffected = statement.executeUpdate();	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Đóng kết nối và câu lệnh
			try {
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

}
