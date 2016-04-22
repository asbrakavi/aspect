/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk_nd;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author elcot
 */
public class aspect_top {
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException, FileNotFoundException
    {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = null;
            conn =
       DriverManager.getConnection("jdbc:mysql://localhost/aspect_based_suggestion","root","shiva");
            //System.out.println("done till driver manager");
  Statement stmt=conn.createStatement();  
  
ResultSet rs=stmt.executeQuery("SELECT product_id,noun, COUNT(noun)AS Frequency\n" +
"FROM aspect_id group by noun ORDER BY COUNT(noun) DESC; ");  
PrintStream out = new PrintStream(new FileOutputStream("D:\\aspect based suggestion\\data\\output.txt"));
System.setOut(out);
  //int flag=0;
 int t=0;
 String s1=new String("this is a string");
while(rs.next())  
{
    String p_id=rs.getString(1);
    //   System.out.println(s1+" "+p_id);
    if(p_id.equals(s1))
    {
     
        t++;
    }
    else
        t=1;
    
    String noun=rs.getString(2);
    int frequency=rs.getInt(3);
    
    /*if(s1.equals("shiva"))
        out.println("helllllloooooo");*/
    if(t<=5)
    {
    System.out.println(p_id+" "+noun+" "+Integer.toString(frequency));
    //System.out.println(t);
    }
    s1=p_id;
   
   //     t=0;
    //System.out.println("hai"+s1+s2);

    
}
    }
    
}
