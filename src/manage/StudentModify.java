package manage;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import Main.Menu;
import Score.Grade;

// CRUD (insert , update , delete , findAll )
public class StudentModify {
	public static List<Student> findAll() {
		List<Student> studentList = new ArrayList();
		Connection connection = null;
		Statement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";

		try {

			connection = DriverManager.getConnection(url, username, password);
			String sql = "select * from student";
			// sử dụng để thực thi câu lệnh sql
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			// Resultset chứa kết quả của truy vấn
			// executeQuery : thực thi câu lệnh và trả về kqua
			while (resultSet.next()) {
				Student std = new Student(resultSet.getInt("id"), resultSet.getString("mahs"),
						resultSet.getString("fullname"), resultSet.getString("dateofbirth"),
						resultSet.getString("gender"), resultSet.getString("ethnic_group"),
						resultSet.getString("religion"), resultSet.getString("phone_number"),
						resultSet.getString("email"), resultSet.getString("anh"), resultSet.getString("diachi"));
				studentList.add(std);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return studentList;
	}

	public static void insert(Student std) {
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);

			// Querry
			String sql = "insert into student (fullname , dateofbirth , gender , ethnic_group , religion ,phone_number ,email , diachi) values (? ,?,?,? ,? , ? , ? , ?)";
			statement = connection.prepareCall(sql);
			statement.setString(1, std.getFullname());
			statement.setString(2, std.getDateofbirth());
			statement.setString(3, std.getGender());
			statement.setString(4, std.getEthnicgroup());
			statement.setString(5, std.getReligion());
			statement.setString(6, std.getPhonenumber());
			statement.setString(7, std.getEmail());
			statement.setString(8, std.getDiaChi());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void update(Student std) {
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);

			// Querry
			String sql = "update student set fullname=? , dateofbirth=? , gender=? , ethnic_group=? , religion=? , phone_number=? , email=? , diachi=?  where id=?";
			statement = connection.prepareCall(sql);

			statement.setString(2, std.getFullname());
//	    statement.setString(3, std.getDateofbirth());
			statement.setString(4, std.getGender());
			statement.setString(5, std.getEthnicgroup());
			statement.setString(6, std.getReligion());
			statement.setString(7, std.getPhonenumber());
			statement.setString(8, std.getEmail());
			statement.setString(9, std.getDiaChi());
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void delete(String user) {
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);

			// Querry
			String sql = "delete from student where mahs=?";
			statement = connection.prepareCall(sql);
			statement.setString(1, user);
			statement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

// hàm sắp xếp theo mahs 
	public static List<Student> sortASC() {
		List<Student> studentList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "select * from  [dbo].[student] order by fullname asc ";
			statement = connection.prepareCall(sql);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Student std = new Student(resultSet.getInt("id"), resultSet.getString("mahs"),
						resultSet.getString("fullname"), resultSet.getString("dateofbirth"),
						resultSet.getString("gender"), resultSet.getString("ethnic_group"),
						resultSet.getString("religion"), resultSet.getString("phone_number"),
						resultSet.getString("email"), resultSet.getString("anh"), resultSet.getString("diachi"));
				studentList.add(std);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentList;
	}

// Hàm sort điểm học sinh  	
	public static List<Grade> sortScoreASC() { // sx tang 
		List<Grade> gradeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
		    String sql = "SELECT dbo.Score.mahs, dbo.student.fullname , dbo.Score.ltcb, dbo.Score.hdt, dbo.Score.gt, dbo.Score.ta, dbo.Score.csdl, dbo.Score.gdtc ,  dbo.Score.xeploai , ((dbo.Score.ltcb + dbo.Score.hdt + dbo.Score.gt + dbo.Score.ta + dbo.Score.csdl + dbo.Score.gdtc) /6) as avg_score  FROM dbo.Score INNER JOIN dbo.student ON dbo.Score.mahs = dbo.student.mahs order by avg_score " ;
			statement = connection.prepareCall(sql);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				// Di chuyển con trỏ đến dòng tiếp theo trong resultSet . trả về true nếu còn
				// dòng tiếp theo
				Grade g = new Grade();
				// Tạo một đối tượng Grade mới . nhận giá trị
				g.setSv(new Student(resultSet.getString(1), resultSet.getString(2)));
				// getStrinng : lấy giá trị của cột với chỉ số hoặc tên cột cụ thể dưới dạng
				// chuỗi
				g.setC(resultSet.getDouble(3));
				g.setJava(resultSet.getDouble(4));
				g.setGt(resultSet.getDouble(5));
				g.setTanh(resultSet.getDouble(6));
				g.setCsdl(resultSet.getDouble(7));
				g.setGdtc(resultSet.getDouble(8));
				gradeList.add(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return gradeList;
	}

	public static List<Grade> sortScoreDESC() { // sx giảm 
		List<Grade> gradeList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "SELECT dbo.Score.mahs, dbo.student.fullname , dbo.Score.ltcb, dbo.Score.hdt, dbo.Score.gt, dbo.Score.ta, dbo.Score.csdl, dbo.Score.gdtc , dbo.Score.xeploai , ((dbo.Score.ltcb + dbo.Score.hdt + dbo.Score.gt + dbo.Score.ta + dbo.Score.csdl + dbo.Score.gdtc) /6) as avg_score  FROM dbo.Score INNER JOIN dbo.student ON dbo.Score.mahs = dbo.student.mahs order by avg_score  desc";
			statement = connection.prepareCall(sql);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				// Di chuyển con trỏ đến dòng tiếp theo trong resultSet . trả về true nếu còn
				// dòng tiếp theo
				Grade g = new Grade();
				// Tạo một đối tượng Grade mới . nhận giá trị
				g.setSv(new Student(resultSet.getString(1), resultSet.getString(2)));
				// getStrinng : lấy giá trị của cột với chỉ số hoặc tên cột cụ thể dưới dạng
				// chuỗi
				g.setC(resultSet.getDouble(3));
				g.setJava(resultSet.getDouble(4));
				g.setGt(resultSet.getDouble(5));
				g.setTanh(resultSet.getDouble(6));
				g.setCsdl(resultSet.getDouble(7));
				g.setGdtc(resultSet.getDouble(8));
				gradeList.add(g);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return gradeList;
	}

	public static List<Student> sortDESC() {
		List<Student> studentList = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "select * from  [dbo].[student] order by fullname desc ";
			statement = connection.prepareCall(sql);
			statement.execute();
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Student std = new Student(resultSet.getInt("id"), resultSet.getString("mahs"),
						resultSet.getString("fullname"), resultSet.getString("dateofbirth"),
						resultSet.getString("gender"), resultSet.getString("ethnic_group"),
						resultSet.getString("religion"), resultSet.getString("phone_number"),
						resultSet.getString("email"), resultSet.getString("anh"), resultSet.getString("diachi"));
				studentList.add(std);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return studentList;
	}

	public static List<Student> findByFullName(String fullname) {
		List<Student> studentList = new ArrayList();
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";

		try {

			connection = DriverManager.getConnection(url, username, password);
			String sql = "select * from student where fullname like ?";
			statement = connection.prepareCall(sql);
			statement.setString(1, "%" + fullname + "%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Student std = new Student(resultSet.getInt("id"), resultSet.getString("mahs"),
						resultSet.getString("fullname"), resultSet.getString("dateofbirth"),
						resultSet.getString("gender"), resultSet.getString("ethnic_group"),
						resultSet.getString("religion"), resultSet.getString("phone_number"),
						resultSet.getString("email"), resultSet.getString("anh"), resultSet.getString("diachi"));
				studentList.add(std);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return studentList;
	}
   
	public Student getSinhVienById(String mahs) { // hàm lấy ra 1 id của sinh viên
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		Student sv = new Student();
		try {
			connection = DriverManager.getConnection(url, username, password);

			// Querry
			String sql = "select * from student where mahs=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, mahs);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				// lấy gía trị tại bảng cở sở dữ liệu ở mỗi dòng
				sv.setId(resultSet.getInt("id"));
				sv.setMahs(resultSet.getString("mahs"));
				sv.setFullname(resultSet.getString("fullname"));
				sv.setDateofbirth(resultSet.getString("dateofbirth"));
				sv.setGender(resultSet.getString("gender"));
				sv.setEthnicgroup(resultSet.getString("ethnic_group"));
				sv.setReligion(resultSet.getString("religion"));
				sv.setPhonenumber(resultSet.getString("phone_number"));
				sv.setEmail(resultSet.getString("email"));
				sv.setAnh(resultSet.getString("anh"));
				sv.setDiaChi(resultSet.getString("diachi"));
				return sv;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close(); // đóng dữ liệu
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	public int updateStudent(Student std) { // hàm cập nhật
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "update student set fullname  = ? , dateofbirth = ? , gender = ? , ethnic_group = ? , 	religion =? , phone_number = ? , email=? , diachi=? where mahs=?";
			statement = connection.prepareStatement(sql);
			// Đặt giá trị cho tham số cần thực hiện
			statement.setString(9, std.getMahs());
			statement.setString(1, std.getFullname());
			statement.setString(2, std.getDateofbirth());
			statement.setString(3, std.getGender());
			statement.setString(4, std.getEthnicgroup());
			statement.setString(5, std.getReligion());
			statement.setString(6, std.getPhonenumber());
			statement.setString(7, std.getEmail());
			statement.setString(8, std.getDiaChi());
			if (statement.executeUpdate() > 0) {
				System.out.println("chỉnh sửa thành công");
				// Nếu thành công
				return 1;
			}
		} catch (Exception e) {
			System.out.println("Error" + e.toString());
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (Exception e) {

			}
		}

		return -1;
	}

	public static List<Schedule> getSchedule() {
		List<Schedule> ls = new ArrayList<Schedule>();
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "SELECT  time_slot, monday, tuesday, wednesday, thursday, friday, saturday, sunday FROM SCHEDULE;";
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Schedule schedule = new Schedule();
				schedule.setTimeSlot(resultSet.getString("time_slot"));
				schedule.setMonday(resultSet.getString("monday"));
				schedule.setTuesday(resultSet.getString("tuesday"));
				schedule.setWednesday(resultSet.getString("wednesday"));
				schedule.setThursday(resultSet.getString("thursday"));
				schedule.setFriday(resultSet.getString("friday"));
				schedule.setSaturday(resultSet.getString("saturday"));
				schedule.setSunday(resultSet.getString("sunday"));
				ls.add(schedule);
			}

		} catch (Exception e) {
			System.out.println("Error" + e.toString());
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (Exception e) {

			}
		}

		return ls;
	}
	public static List<Student> findAbsences(String mahs) {
		List<Student> studentList = new ArrayList();
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";

		try {

			connection = DriverManager.getConnection(url, username, password);
			String sql = "select * from Attendance where mahs like ?";
			statement = connection.prepareCall(sql);
			statement.setString(1, "%" + mahs + "%");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Student std = new Student(resultSet.getString("mahs"), resultSet.getDate("date_attended"),
						     resultSet.getBoolean("is_present"));
				studentList.add(std);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return studentList;
	}
	public static void countPresentAndAbsent(String date , JLabel txAbsent , JLabel txPresent) {
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "SELECT \r\n"
					+ "    SUM(CASE WHEN is_present = 1 THEN 1 ELSE 0 END) AS so_hoc_sinh_co_mat,\r\n"
					+ "    SUM(CASE WHEN is_present = 0 THEN 1 ELSE 0 END) AS so_hoc_sinh_vang_mat\r\n"
					+ "FROM \r\n"
					+ "    Attendance\r\n"
					+ "WHERE \r\n"
					+ "    date_attended = ? ;";
			statement = connection.prepareCall(sql);
			statement.setString(1, date);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				txPresent.setText(resultSet.getString("so_hoc_sinh_co_mat"));
				txAbsent.setText(resultSet.getString("so_hoc_sinh_vang_mat"));	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
