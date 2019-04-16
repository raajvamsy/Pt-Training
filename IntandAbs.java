import java.sql.*;


public class Emp extends Empdetails{

	public static void main(String[] args)
	{
		Emp e = new Emp();
		e.connection();
		e.Displayrecords("select * from Employee;");
	}
}

abstract class Empdetails{
//	private  String name;
//	private  int age;
//	private  int salary;
//	private  int exp;
//	private  int Depno;
//	private  int empcode;
//	
	protected  Connection con;
	protected  Statement st;
	protected  ResultSet rs,rs1;
	private  String user = "root";
	private  String pass = "password";
	protected ResultSetMetaData rsmd;
	
	public void Displayrecords(String query)
	{
		try
		{
			 
			 rs = st.executeQuery(query);
//			 rs1 = st.executeQuery("select count(*) as count from Employee;");
//			 int count = rs1.getInt("count");
			 rsmd = rs.getMetaData();
			 int k = rsmd.getColumnCount();
			 String[] columns = new String[k-1];
			 while(k>1)
			 {
				 columns[rsmd.getColumnCount()-k]=rsmd.getColumnName(rsmd.getColumnCount()-k+2);
				 k--;
			 }
			 for(String s:columns)
			 {
				 System.out.print(s+" ");
				 
			 }
//			 System.out.println(count);
			 
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}
	public void connection() {
		 try
		 {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 con = DriverManager.getConnection("jdbc:sqlserver://IMCHLT024\\SQLEXPRESS;username="+user+";password="+pass);
			 st = con.createStatement(); 
			 try 
			 {
				 st.executeQuery("use Employee_");
			 }
			 catch(Exception e)
			 {
				 //
			 }
		 }
		 catch(Exception e){
			 System.out.println(e.getMessage());
		 }	
	}
	
}
interface EmpCalc{
	public int salarycalc();
}
