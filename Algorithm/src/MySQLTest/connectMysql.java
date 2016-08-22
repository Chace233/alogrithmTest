package MySQLTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class connectMysql {
	
	public Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testdb","root","wsfd0628");
		return con;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		connectMysql c = new connectMysql();
		Connection con = c.getConnection();
		PreparedStatement sql;
		sql = con.prepareStatement("select * from test01");
		ResultSet res = sql.executeQuery();
		System.out.println("执行查询语句：");
		while(res.next()){
			String id = res.getString(1);
			String pid = res.getString("pid");
			System.out.println("id : "+id+"-->"+pid);
		}
	}
}
