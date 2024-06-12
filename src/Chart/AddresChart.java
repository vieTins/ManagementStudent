package Chart;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class AddresChart extends JFrame {

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
					AddresChart frame = new AddresChart();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddresChart() {
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Connection connection = null ;
		setBounds(100, 100, 500, 500);
		String url = "jdbc:sqlserver://LAPTOP-QAOB3NRI\\SQLEXPRESS:1433;databaseName=Student_Management;encrypt=true;trustServerCertificate=true";
	    String username = "sa";
	    String password = "123456789";
	    try {
	    	connection = DriverManager.getConnection(url, username , password);
	    	 DefaultPieDataset dataset = getGenderDataset(connection);
	    	 // Tạo biểu đồ tròn 
	    	 JFreeChart chart = ChartFactory.createPieChart("Address Chart", dataset , true , true , false) ;
	    	 ChartPanel chartPanel = new ChartPanel(chart) ;
	    	 chartPanel.setPreferredSize(new java.awt.Dimension(300,200));
	    	 this.setContentPane(chartPanel);
	    }catch (Exception e) {
	    	e.printStackTrace();
	    } finally {
			try {
				if (connection != null) {
					connection.close();
				}
			}catch (Exception e1) {
				e1.printStackTrace(); 
			}
		}
	}
	 private DefaultPieDataset getGenderDataset(Connection connection) throws SQLException {
	        DefaultPieDataset dataset = new DefaultPieDataset();

	        String query = "select diachi , count ( *  ) as count from student group by diachi ";
	        try (PreparedStatement statement = connection.prepareStatement(query);
	             ResultSet resultSet = statement.executeQuery()) {

	            while (resultSet.next()) {
	                String gender = resultSet.getString("diachi");
	                int count = resultSet.getInt("count");
	                dataset.setValue(gender, count);
	            }
	        }

	        return dataset;
	    }

}
