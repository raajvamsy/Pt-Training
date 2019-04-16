package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Conn {
	protected static Connection con;
	protected static Statement st;
	protected static ResultSet rs;
	protected static PreparedStatement ps;
	private  String user = "root";
	private String pass = "password";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";


	public Conn()
	{
		 try
		 {
			 Class.forName(driver).newInstance();
			 con = DriverManager.getConnection("jdbc:sqlserver://IMCHLT024\\SQLEXPRESS;username="+user+";password="+pass);
			 st = con.createStatement(); 
			 st.executeQuery("use StudentPortal");
			 
		 }
		 catch(Exception e){
			 System.out.println(e.getMessage());
		 }
	}
	
	public  boolean validate(LoginModel lm)
	{
		String username = lm.getuser();
		String password = lm.getpass();
//		String username = "root";
//		String password = "password";
		String sql = "select * from Login where Username =? and Password =?;";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			return rs.next();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());;
			return false;
		}
			
	}
//	public static void main(String[] args)
//	{
//		Conn cn = new Conn();
//		System.out.println(cn.validate());
//	}
}
