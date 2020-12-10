package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataProvider {

	 //Khai báo driver làm việc với MySQL Server
   private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
   
   //Khai báo database cần làm việc
   private static final String DATABASE_LINK = "jdbc:mysql://localhost:3306/new_je0620dev?serverTimezone=UTC";
   /**
    * Hàm lấy kết nối đến db MySQL
    * @return Trả về db kết nối
    */
  public static Connection layKetNoi()
  {
      Connection conn = null;
       try {
           //Nạp driver vào để sử dụng cho java biết cần làm việc với hệ quản trị db nào
           Class.forName(JDBC_DRIVER);
           
           conn = DriverManager.getConnection(DATABASE_LINK, "root", "");
           
       } catch (ClassNotFoundException ex) {
           System.err.println("Không tìm thấy driver. Chi tiết: " + ex.getMessage());
       } catch (SQLException ex) {
           System.err.println("Lỗi không kết nối được với MySQL. Chi tiết: " + ex.getMessage());
       }
      
       return conn;
  }
}
