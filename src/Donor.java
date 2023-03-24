import java.util.*;

import java.sql.*;


public class Donor {
	

	public static void main(String[] args) throws Exception {
		System.out.println("Admin user Id :");
		Scanner sc = new Scanner(System.in);
		String admin=sc.nextLine();
		System.out.println("Password :");
		String pass=sc.nextLine();
		if(admin.equals("yamini")&&pass.equals("yamini")) 
		{
			System.out.println(" 1. Add Donner\n 2. Delete Donor\n 3. view Donor Details\n 4. Update Donor details");
			int ch=sc.nextInt();
			try 
			{
				Connection con=null;
				Class.forName("com.mysql.cj.jdbc.Driver"); 
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Demo?"+"user=root&password=Y@mini81189");
				// create a Statement from the connection
				Statement statement = con.createStatement();

				// insert the data
				
				
				//Connection con=DriverManager.getConnection(  
				//"jdbc:mysql://localhost:3306/Demo","root","Y@mini81189");   
				
			
				
				switch(ch) 
				{
					case 1:
						System.out.println("Adding .....");
						
						
						PreparedStatement stmt1=con.prepareStatement("insert into donor (name,phno,blood) values(?,?,?)");
						//ResultSet stmt1=statement.executeQuery("insert into donor (name,phno,blood) values(?,?,?)\"");
						System.out.println("Donor Full Name : ");
						String Donor =sc.next();
						stmt1.setString(1,Donor);//1 specifies the first parameter in the query  
						System.out.println("Ph no : ");
						Long phno=sc.nextLong();
						stmt1.setLong(2,phno);
						System.out.println("Blood Group : ");
						String blood=sc.next();
						stmt1.setString(3,blood); 
						int i=stmt1.executeUpdate();  
						System.out.println(i+" records affected");  
						System.out.println("Data Entered Successfully : ");
						
						
						 
						
						break;
					case 2:
						System.out.println("Deleting.....");
						
						PreparedStatement stmt=con.prepareStatement("delete from donor where name=?");  
						System.out.println("name : ");
						String name =sc.next();
						stmt.setString(1,name);
						int k=stmt.executeUpdate(); //to reflect in the database  
						System.out.println(k+" records affected");  
						
						
						break;
					case 3:
						ResultSet rs=statement.executeQuery("select * from donor");  
						while(rs.next()) {
							System.out.print("name : "+rs.getString(1)+" \t"); 
							System.out.print("phno : "+rs.getInt(2)+" \t"); 
							System.out.println("blood group : "+rs.getString(3)+" \t"); 
							
						}
						
						break;
					case 4:
						System.out.println("update .....");
						
						PreparedStatement stmt2=con.prepareStatement("update emp set blood=? phno=? where name=?");  
						System.out.println("Blood Group : ");
						String blood1=sc.next();
						stmt2.setString(1,blood1); 
						//1 specifies the first parameter in the query  
						System.out.println("Ph no : ");
						Long phno2=sc.nextLong();
						stmt2.setLong(2,phno2);
						System.out.println("Donor Full Name : ");
						String Donor1 =sc.next();
						stmt2.setString(3,Donor1);
						
						int i1=stmt2.executeUpdate();  
						System.out.println(i1+" records affected");  
						System.out.println("Data Entered Successfully : ");
						
						break;
			
				}//switch
			
			}//try
			catch(Exception e)
				{
				System.out.println(e);
				}
		}//if
		
		else {
			System.out.println("please give correct user Id or password");
		}
		
		

	}//main

}
