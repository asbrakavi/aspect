/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk_nd;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author elcot
 */
public class prod_rank {
       public static void main(String[] args) throws FileNotFoundException, IllegalAccessException, IOException, ParseException, ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
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
    
   // out.write(cc);

    Double overall = (Double) review.get("overall");
     stmt.executeUpdate("INSERT INTO `prod_rating`(idprod_rating,prod_id,overall) VALUE (null,'"+prod_id+"','"+overall+"')");
  }
     rs=stmt.executeQuery("SELECT prod_id,COUNT(prod_id),sum(overall),sum(overall)/COUNT(prod_id) as aver\n" +
"FROM prod_rating group by prod_id ORDER BY aver DESC; ");  
     while(rs.next())
     {
         String prod=rs.getString(1);
         int aver_over=rs.getInt(4);
         System.out.println(prod+" "+aver_over);
     }
  //  System.out.println(job);
//String tagged = tagger.tagString(cc);

//System.out.println(tagged);
//String[] s_noun=extractNouns(tagged);
/*for(String temp:s_noun)
  {
      
    System.out.println(temp);
  }
  */      
}
    
}


