/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bk_nd;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.out;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author elcot
 */
public class aspect_listing {
    String product_name;
    public ArrayList a;
    //String product_id[]=new String[2];
    public String aspect[]=new String[5];
    int frequency[]=new int[5];
    public aspect_listing(String s,ArrayList l)
    {
        product_name=s;
        a=l;
    }
    public ArrayList find_frequent()
    {
        //String fileName = "/WEB-INF/aspect_ranked_till_500.txt";
        //InputStream ins =getResourceAsStream(fileName);
        try
        {
            //if(true)
                //return "haiiiiiiiiiii";
            //if(ins!= null)
            
            {
              
            BufferedReader br = new BufferedReader((new FileReader("D:\\aspect based suggestion\\data\\output.txt")));
            String data=br.readLine();
            //return data+"is here";
            int i=1;
            ArrayList l=new ArrayList();
            String pr=null;
            //if(true)
              //  return "haiiiiiiiiiii";
            while((data= br.readLine())!= null)
            {
    
                    pr=data.substring(0,data.indexOf(" "));
                    String as=data.substring(10,data.lastIndexOf(" "));
            //        if(true)
              //      return "hello";
                    if(a.indexOf(pr)!=-1&&i<=5)
                    {
                        l.add(as);
                        i++;
                        //out.println("<a href=img.html>"+"<h3>"+as+"</h3></a><br>");
                        //l.add(as);
                    }
                    
                    //i++;
            }
            return l;
            }
        }
        catch(Exception e)
        {
            //return "exception";
        }

          //  aspect[0]="hello this is aspect 0";
        return null;
        //out.println(a+"is the array lirst");
            //return Integer.toString(a.indexOf("011040047X"));
    }
    public ArrayList productranking() throws FileNotFoundException, IOException
    {
        BufferedReader br = new BufferedReader((new FileReader("D:\\aspect based suggestion\\data\\prod_rank.txt")));
            String data=br.readLine();
            //return data+"is here";
            int i=1;
            ArrayList l=new ArrayList();
            String pr=null;
            //if(true)
              //  return "haiiiiiiiiiii";
            while((data= br.readLine())!= null)
            {
    
                    pr=data.substring(0,data.indexOf(" "));
                    String as=data.substring(10);
            //        if(true)
              //      return "hello";
                    if(a.indexOf(pr)!=-1)
                    {
                        l.add(pr+" "+as);
                        i++;
                        //out.println("<a href=img.html>"+"<h3>"+as+"</h3></a><br>");
                        //l.add(as);
                    }
                    
                    //i++;
            }
            return l;
            }
    
public ArrayList review_dis() throws IOException, ParseException
{
  JSONParser parser = new JSONParser();
 //       FileWriter out = null;
   //      out = new FileWriter("D:/output.txt");
         
        //Object obj = parser.parse(new FileReader("D:/aspect based suggestion/temp.json"));
         JSONArray arr = (JSONArray) parser.parse(new FileReader("D:/aspect based suggestion/review.json"));
 // MaxentTagger tagger = new MaxentTagger("taggers/left3words-wsj-0-18.tagger");
  int i=0;
  ArrayList l=new ArrayList();
  for (Object o : arr)
  {
    JSONObject person = (JSONObject) o;

    //String name = (String) person.get("reviewerID");
    //System.out.println(name);

    String p_id = (String) person.get("asin");
//    System.out.println(city);

    String review_content = (String) person.get("reviewText");
    
//    l.add("hai");
    //l.add(p_id);
     if(a.indexOf(p_id)!=-1)
                    {
                        //l.add("hell0");
                        l.add(review_content);
                        i++;
                      //  i++;
                        //out.println("<a href=img.html>"+"<h3>"+as+"</h3></a><br>");
                        //l.add(as);
                    }
     if(i>10)
         break;
  }
        return l;
}
public ArrayList review_classify(ArrayList aspects)
{
    try
    {
    JSONParser parser = new JSONParser();
    JSONArray arr = (JSONArray) parser.parse(new FileReader("D:/aspect based suggestion/review.json"));
  int i=0;
  ArrayList l=new ArrayList();
  for (Object o : arr)
  {
    JSONObject person = (JSONObject) o;

    //String name = (String) person.get("reviewerID");
    //System.out.println(name);

    String p_id = (String) person.get("asin");
//    System.out.println(city);

    String review_content = (String) person.get("reviewText");
    
//    l.add("hai");
    //l.add(p_id);
     if(a.indexOf(p_id)!=-1)
                    {
                        for(int j=0;j<aspects.size();j++)
                        {
                        if(review_content.contains((CharSequence) aspects.get(j)))
                        //l.add("hell0");
                        l.add(review_content+"  [  "+aspects.get(j)+"  ]");
                        
                        }
                        i++;
                      //  i++;
                        //out.println("<a href=img.html>"+"<h3>"+as+"</h3></a><br>");
                        //l.add(as);
                    }
     if(i>10)
         break;
  }
        return l;
    //return null;
}
    catch(Exception e)
    {
        return null;
    }
  
    
}

}