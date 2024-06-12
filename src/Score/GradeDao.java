package Score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import manage.Student;

public class GradeDao {
List <Grade> ls = new ArrayList<Grade>();
public int add (Grade d) {
	Connection connection = null ;
	PreparedStatement statement = null ;
	String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
    String username = "sa";
    String password = "123456789";
    try {
    	connection = DriverManager.getConnection(url ,username , password) ;
    	String sql = "insert into Score (mahs , ltcb , hdt , gt ,ta , csdl ,gdtc , xeploai )values(?,?,?,?,?,?,? , ?)" ;
        statement = connection.prepareStatement(sql) ;
        // Đặt giá trị cho tham số cần thực hiện 
        statement.setString(1, d.getSv().getMahs());
        statement.setDouble(2, d.getC());
        statement.setDouble(3, d.getJava());
        statement.setDouble(4,  d.getGt());
        statement.setDouble(5,  d.getTanh());
        statement.setDouble(6,  d.getCsdl());
        statement.setDouble(7,  d.getGdtc());
        statement.setString(8, d.getXepLoai());
        if (statement.executeUpdate() > 0) {
        	System.out.println("thêm thành công");
        	// Nếu thành công 
               return 1 ;
        }
    } catch  (Exception e) {
    	System.out.println("Error" + e.toString());
    } finally {
    	try {
    		connection.close();
    		statement.close();
    	} catch (Exception e) {
			
		}
    }
    return -1 ;
    // Nếu không thành công 
}
public List<Grade> getAllGrade() { // lấy all diem trong danh sách
	List<Grade> ls = new ArrayList<>();
	Connection connection = null ;
	PreparedStatement statement = null ;
	String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
    String username = "sa";
    String password = "123456789";
    try {
    	connection = DriverManager.getConnection(url ,username , password) ;
    	String sql = "SELECT dbo.Score.mahs, dbo.student.fullname , dbo.Score.ltcb, dbo.Score.hdt, dbo.Score.gt, dbo.Score.ta, dbo.Score.csdl, dbo.Score.gdtc FROM dbo.Score INNER JOIN dbo.student ON dbo.Score.mahs = dbo.student.mahs" ;
        statement = connection.prepareStatement(sql) ;
        ResultSet resultSet = statement.executeQuery();
        // Trả về kết quả truy vấn . Đối tượng này chứa tất cả các thông tin trong cơ sở dữ liệu 
        while (resultSet.next()) {
        	// Di chuyển con trỏ đến dòng tiếp theo trong resultSet . trả về true nếu còn dòng tiếp theo
        	Grade g = new Grade() ;
        	// Tạo một đối tượng Grade mới . nhận giá trị 
        	g.setSv(new Student(resultSet.getString(1), resultSet.getString(2)));
            // getStrinng : lấy giá trị của cột với chỉ số hoặc tên cột cụ thể dưới dạng chuỗi
            g.setC(resultSet.getDouble(3));
            g.setJava(resultSet.getDouble(4));
            g.setGt(resultSet.getDouble(5));
            g.setTanh(resultSet.getDouble(6));
            g.setCsdl(resultSet.getDouble(7));
            g.setGdtc(resultSet.getDouble(8));
            ls.add(g);
        }
        
    } catch  (Exception e) {
    	System.out.println("Error" + e.toString());
    } finally {
    	try {
    		connection.close();
    		statement.close();
    	} catch (Exception e) {
			
		}
    }
	
	return ls ;
}
public Grade getOndeGradeBySv (String masv) { // hàm lấy bởi 1 sv
	Connection connection = null ;
	PreparedStatement statement = null ;
	String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
    String username = "sa";
    String password = "123456789";
    try {
    	connection = DriverManager.getConnection(url ,username , password) ;
    	String sql = "SELECT dbo.Score.mahs, dbo.student.fullname  , dbo.Score.ltcb, dbo.Score.hdt, dbo.Score.gt, dbo.Score.ta, dbo.Score.csdl, dbo.Score.gdtc FROM dbo.Score INNER JOIN dbo.student ON dbo.Score.mahs = dbo.student.mahs where Score.mahs =? " ;
        statement = connection.prepareStatement(sql) ;
        statement.setString(1, masv);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
        	Grade g  = new Grade();
        	g.setSv(new Student(rs.getString(1), rs.getString(2)));
            // getStrinng : lấy giá trị của cột với chỉ số hoặc tên cột cụ thể dưới dạng chuỗi
            g.setC(rs.getDouble(3));
            g.setJava(rs.getDouble(4));
            g.setGt(rs.getDouble(5));	
            g.setTanh(rs.getDouble(6));
            g.setCsdl(rs.getDouble(7));
            g.setGdtc(rs.getDouble(8));
            return g ;
        }
     
    } catch  (Exception e) {
    	System.out.println("Error" + e.toString());
    } finally {
    	try {
    		connection.close();
    		statement.close();
    	} catch (Exception e) {
			
		}
    }
    return null ;
}
public int updateGrade (Grade d) { // hàm cập nhật 
	Connection connection = null ;
	PreparedStatement statement = null ;
	String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
    String username = "sa";
    String password = "123456789";
    try {
    	connection = DriverManager.getConnection(url ,username , password) ;
    	String sql = "update Score set ltcb  = ? , hdt = ? , gt = ? , ta = ? , 	csdl =? , gdtc = ? , xeploai = ? where mahs=?" ;
        statement = connection.prepareStatement(sql) ;
        // Đặt giá trị cho tham số cần thực hiện 
        statement.setString(8, d.getSv().getMahs());
        statement.setDouble(1,  d.getC());
        statement.setDouble(2,  d.getJava());
        statement.setDouble(3,  d.getGt());
        statement.setDouble(4,  d.getTanh());
        statement.setDouble(5, d.getCsdl());
        statement.setDouble(6,  d.getGdtc());
        statement.setString(7, d.getXepLoai());
        if (statement.executeUpdate() > 0) {
        	System.out.println("chỉnh sửa thành công");
        	// Nếu thành công 
               return 1 ;
        }
    } catch  (Exception e) {
    	System.out.println("Error" + e.toString());
    } finally {
    	try {
    		connection.close();
    		statement.close();
    	} catch (Exception e) {
			
		}
    }
	
	return -1 ;
}
public int delGrade (String masv) { // hàm xóa 
	Connection connection = null ;
	PreparedStatement statement = null ;
	String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
    String username = "sa";
    String password = "123456789";
    try {
    	connection = DriverManager.getConnection(url ,username , password) ;
    	String sql = "delete Score where mahs=?" ;
        statement = connection.prepareStatement(sql) ;
        // Đặt giá trị cho tham số cần thực hiện 
        statement.setString(1, masv);
        statement.executeUpdate();
        if (statement.executeUpdate() > 0) {
        	// Nếu thành công 
               return 1 ;
        }
    } catch  (Exception e) {
    	System.out.println("Error" + e.toString());
    } finally {
    	try {
    		connection.close();
    		statement.close();
    	} catch (Exception e) {
			
		}
    }
	
	return -1 ;
}
public Grade getAtPosition(int pos) { // hàm kiểm tra vị trí 
	return ls.get(pos);
}
}
