<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
 
 
 
       function removeError(id){
          if(id=="employee_name")
          {
           document.getElementById('username_error_message').innerHTML ="";      
          }
          if(id=="employee_login_email")
          {
           document.getElementById('login_username_error_message').innerHTML ="";      
          }
         
          if(id=="employee_password")
          {
           document.getElementById('password_error_message').innerHTML ="";      
          }
          if(id=="employee_confirm_password")
          {
           document.getElementById('confirm_password_error_message').innerHTML ="";      
          }
          if(id=="employee_emailid")
          {
           document.getElementById('emailid_error_message').innerHTML ="";      
          }
         
          if(id=="employee_gender")
          {
           document.getElementById('gender_error_message').innerHTML ="";      
          }

          //login validate
          if(id=="employee_login_name")
          {
           document.getElementById('login_username_error_message').innerHTML ="";      
          }
          if(id=="employee_login_password")
          {
           document.getElementById('login_password_error_message').innerHTML ="";      
          }


          //vehicle name
          if(id=="vehicle_emp_name")
          {
           document.getElementById('vehicle_emp_error_message').innerHTML ="";      
          }
          if(id=="vehicle_emp_id")
          {
           document.getElementById('vehicle_emp_id_error_message').innerHTML ="";      
          }
          
          
         
       }
     
       
      
     //for validate login form//
      function validateLoginForm() {
    	
              //for username validation//
                 var employee_login_emailid = document.forms["login_form"]["employee_login_email"].value;
                 var employee_login_password = document.forms["login_form"]["employee_login_password"].value;
               var emailid_pattern  = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.]{3,5})+\.([A-Za-z]{2,4})$/;
               
               if(employee_login_emailid == ""){
                   document.getElementById('login_username_error_message').innerHTML ="Email must be filled out  ";
                   document.getElementById('login_username_error_message').style.color = "red";
                   return false;
                   }
               if(emailid_pattern.test(employee_login_emailid)==false){
               document.getElementById('login_username_error_message').innerHTML ="Enter Valid Email Address ";
               document.getElementById('login_username_error_message').style.color = "red";
               return false;
               }
               //for password validation//
               if (employee_login_password == "") {
                   document.getElementById('login_password_error_message').innerHTML ="Password must be filled out";
                   document.getElementById('login_password_error_message').style.color = "red";
                   return false;
               }
              else{
           	   login_div_id.style.display = "block";
                  registration_div_id.style.display = "none";
                  vehicle_emp_div_id.style.display = "none";
                 
                 
              }
            
           }
 </script>
</head>
<body>
<div style="margin-top:0px">
        
            <table cellpadding="20"> 
                    <tr>
                        <td style="width:900px" > <h1><span style="color:darkturquoise">Meta</span><span style="color:black">-Parking</span></h1></td>
                        <td ><a href="">Home</a></td>
                       
                        <td><a href="index.jsp"  id="signup" >Sign-up</a></td>
                        <td><a href="vehicle.jsp"  id="vh"  >Vehicle form</a></td>
                         <td><a href="FriendServlet">Friend</a></td>
                    </tr>
            </table>
    </div>
	<!--Login form-->
	<div id="login_div" >
		<form action="EmployeeLogin" name="login_form" method="GET" onsubmit=" return validateLoginForm()">
			<table border="0px" align="center" cellspacing="0px" width="60%"
				cellpadding="10">
				<tr>
					<th colspan="2"><%= request.getParameter("message")==null ? "": request.getParameter("message")%></th>
					 <td>
                         <%
                       
                         String n=(String)session.getAttribute("emailid");  
								
								%>
								<b> <%= n==null?" ":n %> your session </b> <br>
                         </td>
				</tr>
				<tr>
					<th colspan="2"><h1>Employee Login</h1></th>
				</tr>
				<!--Employee Name-->
				<tr>
					<td width="20%"><label>Employee Name</label></td>
					<td width="10%"><input type="text" name="employee_login_email"
						id="employee_login_email" placeholder="Enter Employee Email"
						onkeypress="return removeError(id)"></td>
					<td width="30%" style="text-align: left"><span
						id="login_username_error_message"></span></td>
				</tr>
				<!--Employee password-->
				<tr>
					<td width="20%"><label>Password</label></td>
					<td width="10%"><input type="password"
						name="employee_login_password" id="employee_login_password"
						placeholder="Enter password" onkeypress="return removeError(id)"></td>
					<td width="30%" style="text-align: left"><span
						id="login_password_error_message"></span></td>
				</tr>

				<!--submit button-->
				<tr>
					<td colspan="2"><center><input type="submit" name="login" value="Login"></center></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>