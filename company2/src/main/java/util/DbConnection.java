package util;                     // 定義 package 名稱為 util

import java.sql.Connection;       // 匯入 JDBC 的 Connection 類別
import java.sql.DriverManager;    // 匯入 JDBC 的 DriverManager 類別
import java.sql.SQLException;     // 匯入 JDBC 的 SQLException 類別

public class DbConnection {       // 定義 DbConnection 類別

	public static void main(String[] args) {         // 主方法，程式執行進入點
		System.out.println(DbConnection.getDb());   // 呼叫 getDb 方法並列印回傳的 Connection 物件
	}
	
	public static Connection getDb()                 // 宣告靜態方法 getDb，回傳 Connection 型別
	{
		Connection conn = null;                      // 初始化 Connection 物件為 null
		String url = "jdbc:mysql://localhost:3306/company2";  // 設定資料庫連線 URL
		String user = "root";  // 設定資料庫使用者名稱
		String password = "password";  // 設定資料庫密碼
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  // 載入 MySQL JDBC 驅動程式
			conn = DriverManager.getConnection(url, user, password);  // 建立資料庫連線
		} catch (ClassNotFoundException e) {
			System.out.println("no driver");  // 若未找到 JDBC 驅動程式，顯示錯誤訊息
			e.printStackTrace();  // 列印堆疊追蹤資訊
		} catch (SQLException e) {
			e.printStackTrace();  // 若連線發生 SQL 錯誤，列印錯誤堆疊資訊
		}
		
		return conn;  // 回傳建立好的資料庫連線物件
	}

}
