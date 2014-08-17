package com.empdata;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import java.sql.*;
@Path("/emp")
public class Fetch {

	
    @GET
    @Path("/users")
    @Produces(MediaType.TEXT_PLAIN)
    public String getUsers()
    {  String result = "";
	try {
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", 
		"root", "pass");
		  Statement st=con.createStatement();
		  ResultSet rs=st.executeQuery("select * from token");
		  
		 while(rs.next()){
			 result=result+rs.getString(1)+"--"+rs.getString(2)+"\n";
			
		 }
		  
		  } catch (Exception e) {
		  System.out.println("Error"+e.getMessage());
		  }
  
  return result;
    }
}
