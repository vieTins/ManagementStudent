package manage;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.Units;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import Score.GradeDao;

public class ExcelFile {
	public void exportFileExcel() {
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "select * from student";
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
//	        tạo một workbook excel 
			XSSFWorkbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("StudentsData");
//	        tạo dòng đầu tiên để lưu tiêu đề
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("ID");
			headerRow.createCell(1).setCellValue("Mã HS");
			headerRow.createCell(2).setCellValue("Họ và tên");
			headerRow.createCell(3).setCellValue("Ngày sinh");
			headerRow.createCell(4).setCellValue("Giới tính");
			headerRow.createCell(5).setCellValue("Dân tộc");
			headerRow.createCell(6).setCellValue("Khu vực");
			headerRow.createCell(7).setCellValue("Số điện thoại");
			headerRow.createCell(8).setCellValue("Email");
			headerRow.createCell(9).setCellValue("Ảnh");
			headerRow.createCell(10).setCellValue("Địa chỉ");
			headerRow.createCell(11).setCellValue("Mật khẩu");
			headerRow.createCell(12).setCellValue("Thông báo");
//          ghi dữ liệu từ resultSet vào các dòng tiếp theo của sheet 
			int rowNum = 1;
			while (rs.next()) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(rs.getInt("id"));
				row.createCell(1).setCellValue(rs.getString("mahs"));
				row.createCell(2).setCellValue(rs.getString("fullname"));
				row.createCell(3).setCellValue(rs.getDate("dateofbirth").toString());
				row.createCell(4).setCellValue(rs.getString("gender"));
				row.createCell(5).setCellValue(rs.getString("ethnic_group"));
				row.createCell(6).setCellValue(rs.getString("religion"));
				row.createCell(7).setCellValue(rs.getString("phone_number"));
				row.createCell(8).setCellValue(rs.getString("email"));
				row.createCell(9).setCellValue(rs.getString("anh"));
				row.createCell(10).setCellValue(rs.getString("diachi"));
				row.createCell(11).setCellValue(rs.getString("mk"));
				row.createCell(12).setCellValue(rs.getString("noti"));
			}
//          lưu dữ liệu vào file excel
			FileOutputStream outputStream = new FileOutputStream("‪StudentsData.xlsx");
			workbook.write(outputStream);
			workbook.close();
			connection.close();
			outputStream.close();
			JOptionPane.showMessageDialog(null, "Export Successful");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

//  import file excel 
	public void ImportFileExcel() {
		String fileExcel = "ImportStudentData.xlsx";
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		StudentModify studentModify = new StudentModify();
		try {
			connection = DriverManager.getConnection(url, username, password);
			FileInputStream excelFile = new FileInputStream(new File(fileExcel));
			Workbook workbook = WorkbookFactory.create(excelFile);
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
//			bỏ qua hàng đầu tiên 
				if (row.getRowNum() == 0) {
					continue;
				}
				String mahs = row.getCell(0).getStringCellValue();
				String fullname = row.getCell(1).getStringCellValue();
				String dateOfBirth = row.getCell(2).getStringCellValue();
				String gender = row.getCell(3).getStringCellValue();
				String ethnicGroup = row.getCell(4).getStringCellValue();
				String religion = row.getCell(5).getStringCellValue();
				String phoneNumber = row.getCell(6).getStringCellValue();
				String email = row.getCell(7).getStringCellValue();
				String anh = row.getCell(8).getStringCellValue();
				String diaChi = row.getCell(9).getStringCellValue();
				String mk = row.getCell(10).getStringCellValue();
				String noti = row.getCell(11).getStringCellValue();
				String checkSQL = "select * from student where mahs =? ";
				try (PreparedStatement preparedStatement = connection.prepareStatement(checkSQL)) {
					preparedStatement.setString(1, mahs);
					ResultSet resultSet = preparedStatement.executeQuery();
					if (resultSet.next()) {
						JOptionPane.showMessageDialog(null, "Student " + mahs + "  already exits");
					} else if (noti.length() == 0 || mk.length() == 0) {
						continue;
					} else {
						String sql = "INSERT INTO student ( mahs, fullname, dateofbirth, gender, ethnic_group, religion, phone_number, email, anh, diachi, mk, noti) "
								+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
						statement = connection.prepareStatement(sql);
						statement.setString(1, mahs);
						statement.setString(2, fullname);
						statement.setString(3, dateOfBirth);
						statement.setString(4, gender);
						statement.setString(5, ethnicGroup);
						statement.setString(6, religion);
						statement.setString(7, phoneNumber);
						statement.setString(8, email);
						statement.setString(9, anh);
						statement.setString(10, diaChi);
						statement.setString(11, mk);
						statement.setString(12, noti);
						statement.executeUpdate();
					}
				}
			}
			JOptionPane.showMessageDialog(null, "Data Imported successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//  Hàm nhập điểm dùng file excel 
	public void ImportScoreByFile() {
		String fileExcel = "ImportScoreData.xlsx";
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		GradeDao gradeDao = new GradeDao();
		try {
			connection = DriverManager.getConnection(url, username, password);
			FileInputStream excelFile = new FileInputStream(new File(fileExcel));
			Workbook workbook = WorkbookFactory.create(excelFile);
			Sheet sheet = workbook.getSheetAt(0);
			for (Row row : sheet) {
				// bỏ qua hàng đầu tiên
				if (row.getRowNum() == 0) {
					continue;
				}
				String mahs = row.getCell(0).getStringCellValue();
//					tìm kiếm sinh viên theo id
				Student sv = new StudentModify().getSinhVienById(mahs);
				if (gradeDao.getOndeGradeBySv(mahs) != null) {
					continue;
				} else if (sv == null) {
					continue;
				} else {
					float ltcb = (float) row.getCell(1).getNumericCellValue();
					float hdt = (float) row.getCell(2).getNumericCellValue();
					float gt = (float) row.getCell(3).getNumericCellValue();
					float ta = (float) row.getCell(4).getNumericCellValue();
					float csdl = (float) row.getCell(5).getNumericCellValue();
					float gdtc = (float) row.getCell(6).getNumericCellValue();
					String xeploai = row.getCell(7).getStringCellValue();
					String sql = "Insert into Score (mahs , ltcb , hdt , gt , ta , csdl , gdtc , xeploai)"
							+ "values (?,?,?,?,?,?,?,? ) ";
					statement = connection.prepareStatement(sql);
					statement.setString(1, mahs);
					statement.setFloat(2, ltcb);
					statement.setFloat(3, hdt);
					statement.setFloat(4, gt);
					statement.setFloat(5, ta);
					statement.setFloat(6, csdl);
					statement.setFloat(7, gdtc);
					statement.setString(8, xeploai);
					statement.executeUpdate();
				}
			}
			JOptionPane.showMessageDialog(null, "Import data successfully");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error occurred while importing data: " + e.getMessage());
		}
	}

	public void ExportFileScore() {
		Connection connection = null;
		PreparedStatement statement = null;
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
		String username = "sa";
		String password = "123456789";
		try {
			connection = DriverManager.getConnection(url, username, password);
			String sql = "select * from Score";
			statement = connection.prepareStatement(sql);
			ResultSet rs = statement.executeQuery();
//			        tạo một workbook excel 
			XSSFWorkbook workbook = new XSSFWorkbook();
			Sheet sheet = workbook.createSheet("StudentsData");
//			        tạo dòng đầu tiên để lưu tiêu đề
			Row headerRow = sheet.createRow(0);
			headerRow.createCell(0).setCellValue("STT");
			headerRow.createCell(1).setCellValue("Mã HS");
			headerRow.createCell(2).setCellValue("Lập trình cơ bản");
			headerRow.createCell(3).setCellValue("Hướng đối tượng");
			headerRow.createCell(4).setCellValue("Giải tích");
			headerRow.createCell(5).setCellValue("Tiếng anh");
			headerRow.createCell(6).setCellValue("Cơ sở dữ liệu");
			headerRow.createCell(7).setCellValue("Giáo dục thể chất");
			headerRow.createCell(8).setCellValue("Xếp loại");
			int rowNum = 1;
			while (rs.next()) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(rs.getInt("stt"));
				row.createCell(1).setCellValue(rs.getString("mahs"));
				row.createCell(2).setCellValue(rs.getFloat("ltcb"));
				row.createCell(3).setCellValue(rs.getFloat("hdt"));
				row.createCell(4).setCellValue(rs.getFloat("gt"));
				row.createCell(5).setCellValue(rs.getFloat("ta"));
				row.createCell(6).setCellValue(rs.getFloat("csdl"));
				row.createCell(7).setCellValue(rs.getFloat("gdtc"));
				row.createCell(8).setCellValue(rs.getString("xeploai"));
			}
			FileOutputStream outputStream = new FileOutputStream("‪ScoreData.xlsx");
			workbook.write(outputStream);
			workbook.close();
			connection.close();
			outputStream.close();
			JOptionPane.showMessageDialog(null, "Export Successful");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
