import java.sql.*;

public class rough {

	public static void main(String[] args) throws Exception {
		
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/Demo","root","Y@mini81189");  
			 
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from donor");  
			while(rs.next()) { 
			System.out.println(rs.getInt(2));  
			}
			con.close();  
			}catch(Exception e) {
				System.out.println(e);
			}

	}

}
