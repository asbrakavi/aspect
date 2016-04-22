/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk_nd;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author elcot
 */
public class review_class {
    public void classify()
    {
        try{
            
        
     Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn =
       DriverManager.getConnection("jdbc:mysql://localhost/temp","root","shiva");
            System.out.println("done till driver manager");
  Statement stmt=conn.createStatement();  
        
       
  
 ResultSet rs=stmt.executeQuery("select * from noun");  

           JSONParser parser = new JSONParser();
 //       FileWriter out = null;
   //      out = new FileWriter("D:/output.txt");
         
        //Object obj = parser.parse(new FileReader("D:/aspect based suggestion/temp.json"));
         JSONArray a = (JSONArray) parser.parse(new FileReader("D:/aspect based suggestion/review.json"));
//  MaxentTagger tagger = new MaxentTagger("taggers/left3words-wsj-0-18.tagger");
  int i=0;
  for (Object o : a)
  {
      i++;
      if(i>500)
          break;
    JSONObject review = (JSONObject) o;
    

 //   String name = (String) review.get("reviewerID");
    //System.out.println(name);

    String prod_id = (String) review.get("asin");
//    System.out.println(city);

    //String = (String) review.get("reviewText");
  //  System.out.println(cc);
    JSONArray helpful=(JSONArray) review.get("helpful");
    //int t=helpful.size();
    long a1=(long)helpful.get(0);
    long b=(long)helpful.get(1);
    float rate=0;
    rate=(b==0)?b:(a1/(float)b);
    System.out.println(i+" "+prod_id+" "+rate);
   // out.write(cc);

    Double overall = (Double) review.get("overall");
     //stmt.executeUpdate("INSERT INTO `prod_rating`(idprod_rating,prod_id,overall) VALUE (null,'"+prod_id+"','"+overall+"')");
  }
   
     }
         catch(Exception e)
                {
                System.out.println(e);
                }
       
}
}

