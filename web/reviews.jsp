
<%@page import="java.util.ArrayList"%>
<%@page import="bk_nd.aspect_listing"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.io.*, java.net.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!--A Design by W3layouts
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<head>
<title>Free Smart Store Website Template | Home :: w3layouts</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<link href="css/style.css" rel="stylesheet" type="text/css" media="all"/>
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
<script src="js/script.js" type="text/javascript"></script>
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script> 
<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript" src="js/nav-hover.js"></script>
<link href='http://fonts.googleapis.com/css?family=Monda' rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Doppio+One' rel='stylesheet' type='text/css'>
<script type="text/javascript">
  $(document).ready(function($){
    $('#dc_mega-menu-orange').dcMegaMenu({rowItems:'4',speed:'fast',effect:'fade'});
  });
</script>
</head>
<body>
  <div class="wrap">
	<div class="header">
		<div class="header_top">
			<div class="logo">
				<a href="index.html"><img src="images/logo.png" alt="" /></a>
			</div>
			  <div class="header_top_right">
                          <!--    <font face="comic sans ms" color="green"> Logged in successfully!!!</font>-->
                          </div>
			<!--<input type=button  onClick="'location.href='login.html' " value='LOGIN'>
			<input type=button  onClick="'location.href='signup.html' " value='SIGNUP'>-->
			


			<div class="search_box">
                            <form action="file.jsp" method="post">
                                <input type="text" name="prod_name" value="Search for Products" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search for Products';}">&nbsp;&nbsp;<input type="submit" value="SEARCH">
				    </form>
			    </div>
		
	 </div>
	 <div class="clear"></div>
 </div>
	<div class="menu">
	  <ul id="dc_mega-menu-orange" class="dc_mm-orange">
		 <li><a href="index.html">Home</a></li>
  
  <li><a href="faq.html">FAQS</a></li>
  <li><a href="contact.html">Contact</a> </li>
<li><a href="logout.html">Logout</a></li>
  <div class="clear"></div>
</ul>
</div>
	<div class="header_bottom">
		
              <div class="heading">
                  <%
String fileName = "/WEB-INF/aspect_ranked_till_500.txt";
String fname="/WEB-INF/prod_rank.txt";
InputStream ins = application.getResourceAsStream(fileName);
//InputStream ins2 = application.getResourceAsStream(fname);
//String temp=request.getParameter("prod_name");
//temp.toLowerCase();
HttpSession sess=request.getSession();
String temp=sess.getAttribute("prod_name").toString();
   Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = null;
            conn =
       DriverManager.getConnection("jdbc:mysql://localhost/aspect_based_suggestion","root","shiva");
            //System.out.println("done till driver manager");
  Statement stmt=conn.createStatement();  
  //out.println("here done till driver manager");
ResultSet rs=stmt.executeQuery("select product_id from products where name='"+temp+"'");  
//if(rs==null) response.sendRedirect("http://10.10.226.135:8080/aspect/logout.html");
String p_id=null;
ArrayList l1=new ArrayList();
while(rs.next())  
{
    p_id=rs.getString(1);
    //out.println(p_id);
    l1.add(p_id);
}
//BufferedReader br = new BufferedReader((new InputStreamReader(ins)));
//String data;
//int i=0;
ArrayList l=new ArrayList();
ArrayList aspects=new ArrayList();
aspect_listing a=new aspect_listing(temp,l1);
//sess.setAttribute("asp_obj", a);
//out.println("the various aspects are:<br>");
//a.product_name=" ";
aspects=(a.find_frequent());
if(aspects.size()<1)
    response.sendRedirect("http://10.10.226.135:8080/aspect/notfound.html");
/*for(int j=0;j<aspects.size();j++)
{
    out.println(aspects.get(j)+"<br>");
}

out.println("the various products are:<br>");

for(int j=0;j<a.a.size();j++)
{
    out.println(a.a.get(j)+"<br>");
}

out.println("product ranking on 5<br>");
l=a.productranking();
for(int j=0;j<l.size();j++)
{
    out.println(l.get(j)+"<br>");
}
        */
//out.println(a.review_dis()+"<br><br>");
%>
<br>
<ul>
    <font face="comic sans ms" size="4">
                  <%
l=a.review_classify(aspects);
//out.println("<ul>");
for(int j=0;j<l.size();j++)
{
    out.println(l.get(j)+"<br><br>");
    //out.println(l.get(j)+"</li><br><br>");
}


                  %></font>
</ul>
        </div>
	    </div>
	  <div class="clear"></div>
  </div>	
</div>
 <!--<div class="main">
    <div class="content">
    	<div class="content_top">
    		<div class="heading">
    		<h3>Feature Products</h3>
    		</div>
    	</div>
	      <div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview-3.html"><img src="images/feature-pic1.jpg" alt="" /></a>
					 <h2>Car Mobile Holder </h2>
					 <p>ClassyTek Car Mobile Holder Mount Bracket Holder Stand 360 Degree Rotating - Black by ClassyTek</p>
					 <p><span class="price">Rs:120.00</span></p>
					  
				     <div class="button"><span><a href="preview-3.html" class="details">Details</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview-2.html"><img src="images/feature-pic2.jpg" alt="" /></a>
					 <h2>iPhone case </h2>
					 <p>Luxury Back Case Cover for Iphone 4/4S (Rose Gold)by ACCWORLD</p>
					 <p><span class="price">Rs:200</span></p>
				     
				     <div class="button"><span><a href="#" class="details">Details</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview-4.html"><img src="images/feature-pic3.jpg" alt="" /></a>
					 <h2>Power Bank </h2>
					 <p>Intex Power Bank 6000 Mah It Pb-602 by Intex</p>
					 <p><span class="price">Rs:667</span></p>
				      
				     <div class="button"><span><a href="#" class="details">Details</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<img src="images/feature-pic4.jpg" alt="" />
					 <h2>HeadSet</h2>
					 <p>Stereo Headset Earpods with Mic and Volume Controller for Apple iPhone 5, 4S, 4, iPad, iPod Touch Nano by Rebel</p>
					 <p><span class="price">Rs:151</span></p>
				      
				     <div class="button"><span><a href="#" class="details">Details</a></span></div>
				</div>
			</div>
			
			<div class="section group">
				<div class="grid_1_of_4 images_1_of_4">
					 <a href="preview-3.html"><img src="images/new-pic1.jpg" alt="" /></a>
					 <div class="discount">
					 <span class="percentage">40%</span>
					</div>
					 <h2>Mobile Case</h2>
					<p>Hello Kitty Silicone With Pendant Back Case Cover For Samsung S4 I 9500
by Go Crazzy</p>					 <span class="price">Rs:299</span></p>
				     
				     <div class="button"><span><a href="preview-3.html" class="details">Details</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview-4.html"><img src="images/new-pic2.jpg" alt="" /></a>
					 <div class="discount">
					 <span class="percentage">22%</span>
					</div>
					<h2>Flip Covers</h2>
					 <p>Uni Mobile Care Fancy Diary Card Wallet Flip Case Back Cover For Samsung Galaxy Grand/Grand Neo i9082/i9060 by Uni Mobile Care </p>
					 <span class="price">Rs:199</span></p>
				     
				     <div class="button"><span><a href="preview-4.html" class="details">Details</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
					<a href="preview-2.html"><img src="images/new-pic4.jpg" alt="" /></a>
					<div class="discount">
					 <span class="percentage">55%</span>
					</div>
					 <h2>Usb Cable</h2>
					<p>Micro USB OTG Cable for Tablets and Mobiles (Black)
by Generic</p>
					<span class="price">Rs:75</span></p>
				      
				     <div class="button"><span><a href="preview-2.html" class="details">Details</a></span></div>
				</div>
				<div class="grid_1_of_4 images_1_of_4">
				 <img src="images/new-pic3.jpg" alt="" />
				  <div class="discount">
					 <span class="percentage">66%</span>
					</div>
					<h2>Selfie Stick</h2>
					 <p>Origlow New Generation Latest Mini Monopod Aux Selfie Stick (Color May Vary)
by Origlow Accessories</p>
										 
					 <span class="price">Rs:155</span></p>
				      
				     <div class="button"><span><a href="#" class="details">Details</a></span></div>
				</div>
			</div>
    </div>
 </div>
-->

   
     
    
    <script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
	  			containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
	 		};
			*/
			
			$().UItoTop({ easingType: 'easeOutQuart' });
			
		});
	</script>
    <a href="#" id="toTop" style="display: block;"><span id="toTopHover" style="opacity: 1;"></span></a>
    <link href="css/flexslider.css" rel='stylesheet' type='text/css' />
							  <script defer src="js/jquery.flexslider.js"></script>
							  <script type="text/javascript">
								$(function(){
								  SyntaxHighlighter.all();
								});
								$(window).load(function(){
								  $('.flexslider').flexslider({
									animation: "slide",
									start: function(slider){
									  $('body').removeClass('loading');
									}
								  });
								});
							  </script>
</body>

</html>
