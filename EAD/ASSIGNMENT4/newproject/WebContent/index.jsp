<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Meta-parking:System</title>
    <script>
          
          function initiate(){
                    registration_div_id=document.getElementById("registration_div");
                     login_div_id=document.getElementById("login_div"); 
                     employee_name_letters = /^([a-z]+[ ]?|[a-z]+)+$/;
                     vehicle_emp_div_id=document.getElementById("vehicle_div");


                     vehicle_emp_name=document.getElementById("vehicle_emp_name");
                     vehicle_emp_id=document.getElementById("vehicle_emp_id");
                     vehicle_emp_type=document.getElementById("vehicle_type");
                     vehicle_emp_number=document.getElementById("vehicle_number");
                     vehicle_duration=document.getElementById("duration_div");
                     daily=document.getElementById("daily");
                     monthly=document.getElementById("monthly");
                     yearly=document.getElementById("yearly");
                     change_currency = document.getElementById("change_currency");
                     dailyprice=document.getElementById("dailyprice");
                     monthlyprice=document.getElementById("monthlyprice");
                     yearlyyprice = document.getElementById("yearlyprice");
                     
                }

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
                function numbers(e)
		       {

                   if(document.getElementById("employee_contact"))
                   {
                    document.getElementById('contact_error_message').innerHTML ="";      
                   }
                   if(document.getElementById("vehicle_number"))
                   {
                    document.getElementById('vehicle_number_error_message').innerHTML ="";      
                   }
                var x=(window.event)?event.keyCode:e.which;
                if((x>=48 && x<=57))
                
                {
                return true;
                } 
                
                else
                {
                return false;
            
                }
         }
               
                //for show div of registration form//
                function onClickSignupButtonShowForm(){
               
                            if (registration_div_id.style.display === "none" && login_div_id.style.display === "none" ) {
                                registration_div_id.style.display = "block";
                                
                            } 
                            else if(login_div_id.style.display === "block" && registration_div_id.style.display === "none"){
                                registration_div_id.style.display = "block";
                                login_div_id.style.display = "none";

                           }
                           else if(registration_div_id.style.display === "block"){
                            registration_div_id.style.display = "none";
                          } 
                           else {
                                registration_div_id.style.display = "none";
                            }
                }

                //for show div of login form//
                function onClickShowForm(id){

                    if(id=="signin"){
                        registration_div_id.style.display = "none";
                        vehicle_emp_div_id.style.display = "none";
                        login_div_id.style.display = "block";
                    }
                    else if(id=="signup"){
                        login_div_id.style.display = "none";
                        vehicle_emp_div_id.style.display = "none";
                        registration_div_id.style.display = "block";
                    }
                    else{
                        login_div_id.style.display = "none";
                        registration_div_id.style.display = "none";
                        vehicle_emp_div_id.style.display = "block";
                    }
            
                   
               }
            
                //for Registration form validation function //          
                function validateSignupForm() {
                       //for username validation//
                        employee_name = document.forms["registration_form"]["employee_name"].value;
                         employee_name_letters = /^([a-z]+[ ]?|[a-z]+)+$/;
                        if (employee_name == "") {
                            document.getElementById('username_error_message').innerHTML ="Name must be filled out";
                            document.getElementById('username_error_message').style.color = "red";
                            return false;
                        }
                        if(employee_name.length<2){
                        document.getElementById('username_error_message').innerHTML ="Name must be contain minimum two character";
                        document.getElementById('username_error_message').style.color = "red";
                           return false;
                        }
                       if(!employee_name.match(employee_name_letters)){
                        document.getElementById('username_error_message').innerHTML ="Name should not contain any numbers or special character";
                        document.getElementById('username_error_message').style.color = "red";
                        return false;
                        }
                        //for password validation//
                        var employee_password = document.forms["registration_form"]["employee_password"].value;
                        var employee_confirm_password = document.forms["registration_form"]["employee_confirm_password"].value;
                        if (employee_password == "") {
                            document.getElementById('password_error_message').innerHTML ="Password must be filled out";
                            document.getElementById('password_error_message').style.color = "red";
                            return false;
                        }
                        if (employee_confirm_password == "") {
                            document.getElementById('confirm_password_error_message').innerHTML ="confirm Password must be filled out";
                            document.getElementById('confirm_password_error_message').style.color = "red";
                            return false;
                        }
                        if(!employee_password.match("(?=.*[a-z])")){
                        document.getElementById('password_error_message').innerHTML ="Password contain at least one lower case";
                        document.getElementById('password_error_message').style.color = "red";
                        return false;
                        }
                        if(!employee_password.match("(?=.*[0-9])")){
                        document.getElementById('password_error_message').innerHTML ="Password should contain at one digit ";
                        document.getElementById('password_error_message').style.color = "red";
                        return false;
                        }
                        if(!employee_password.match("(?=.*[A-Z])")){
                        document.getElementById('password_error_message').innerHTML ="Password contain at least one upper case ";
                        document.getElementById('password_error_message').style.color = "red";
                        return false;
                        }
                        if(!employee_password.match("(?=^.{8,}$)")){
                        document.getElementById('password_error_message').innerHTML ="Password length minimum 8 ";
                        document.getElementById('password_error_message').style.color = "red";
                        return false;
                        }
                        //check confirm password//
                        if(!employee_password.match(employee_confirm_password)){
                        document.getElementById('confirm_password_error_message').innerHTML ="Password mismatch";
                        document.getElementById('confirm_password_error_message').style.color = "red";
                        return false;
                        }

                        //for email validation//
                        var employee_emailid = document.forms["registration_form"]["employee_emailid"].value;
                        var emailid_pattern  = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.]{3,5})+\.([A-Za-z]{2,4})$/;

                        if(emailid_pattern.test(employee_emailid)==false){
                        document.getElementById('emailid_error_message').innerHTML ="Enter Valid Email Address ";
                        document.getElementById('emailid_error_message').style.color = "red";
                        return false;
                        }
                        //for contact validaton//
                        var employee_contact = document.forms["registration_form"]["employee_contact"].value;
                        
                        if (employee_contact.length <8) {
                            if(employee_contact.length ==0){
                                document.getElementById('contact_error_message').innerHTML ="Contact field is empty";
                               
                            }
                            else{
                                document.getElementById('contact_error_message').innerHTML ="Contact length should be greater then 8";
                            }
                            document.getElementById('contact_error_message').style.color = "red";
                            
                            return false;
                        }
                       //for gender validaton//
                        var employee_gender = document.getElementsByName("employee_gender");
                   
                        if( employee_gender[0].checked == false && employee_gender[1].checked ==false){
                            document.getElementById('gender_error_message').innerHTML ="Please select your gender";
                            document.getElementById('gender_error_message').style.color = "red";
                            return false;
                        }
                        else{
                            var emp_id = 58889;
                            emp_id+=1;
                            var login= confirm("Registration successfully.Continue With Your Login Id="+emp_id);
                           
                            
                           if(login === true && registration_div_id.style.display === "block"){
                              
                              //  registration_div_id.style.display = "none";
                               // login_div_id.style.display = "block";
                              //  vehicle_emp_div_id.style.display ="block"
                                //document.getElementById("employee_login_name").value = emp_id;
                                vehicle_emp_id.value = emp_id;
                                return true;
                           }
                           
                           
                        }
          }
               function validateVehicleForm(){
                        if (vehicle_emp_name.value == "") {
                            document.getElementById('vehicle_emp_error_message').innerHTML ="Name must be filled out";
                            document.getElementById('vehicle_emp_error_message').style.color = "red";
                            return false;
                        }
                        if(!vehicle_emp_name.value.match(employee_name_letters)){
                        document.getElementById('vehicle_emp_error_message').innerHTML ="Name should not contain any numbers or special character";
                        document.getElementById('vehicle_emp_error_message').style.color = "red";
                        return false;
                        }
                        if (vehicle_emp_id.value == "") {
                            document.getElementById('vehicle_emp_id_error_message').innerHTML ="Id must be filled out";
                            document.getElementById('vehicle_emp_id_error_message').style.color = "red";
                            return false;
                        }
                        if (vehicle_emp_number.value == "") {
                            document.getElementById('vehicle_number_error_message').innerHTML ="Number must be filled out";
                            document.getElementById('vehicle_number_error_message').style.color = "red";
                            return false;
                        }
                        if (vehicle_emp_number.value.length <4) {
                            document.getElementById('vehicle_number_error_message').innerHTML ="Vehicle number invalid";
                            document.getElementById('vehicle_number_error_message').style.color = "red";
                            return false;
                        }
                        if (vehicle_emp_type.value == "") {
                            document.getElementById('vehicle_type_error_message').innerHTML ="Type must be filled out";
                            document.getElementById('vehicle_type_error_message').style.color = "red";
                            return false;
                        }
                        else{
                            vehicle_duration.style.display ="block"
                            if(vehicle_emp_type.value == "Cycle"){
                                //daily.value = "Daily(5)";
                               dailyprice.innerHTML = "Daily(5)";
                               monthlyprice.innerHTML = "Monthly(100)";
                               yearlyyprice.innerHTML = "Yearly(500)";

                               document.getElementById("radioprice1").value = "Daily(5)";
                               document.getElementById("radioprice2").value = "Monthly(100)";
                               document.getElementById("radioprice3").value= "Yearly(500)";
                              // monthly.value = "Monthly(100)";
                              // yearly.value = "Yearly(500)";
                               return false;
                            }
                            else if(vehicle_emp_type.value == "Motorcycle"){
                               //daily.value = "Daily("+10+")";
                               dailyprice.innerHTML = "Daily(100)";
                               monthlyprice.innerHTML = "Monthly(200)";
                               yearlyyprice.innerHTML = "Yearly(1000)";

                             document.getElementById("radioprice1").value = "Monthly(100)";
                             document.getElementById("radioprice2").value = "Daily(100)";
                             document.getElementById("radioprice3").value= "Yearly(1000)";
                              // monthly.value = "Monthly("+200+")";
                              // yearly.value = "Yearly("+1000+")";
                            }
                            else if(vehicle_emp_type.value == "FourWheeler"){
                              // daily.value = "Daily(20)";
                              dailyprice.innerHTML = "Daily(20)";
                               monthlyprice.innerHTML = "Monthly(500)";
                               yearlyyprice.innerHTML = "Yearly(3500)";

                               document.getElementById("radioprice1").value= "Daily(20)";
                               document.getElementById("radioprice2").value = "Monthly(500)";
                               document.getElementById("radioprice3").value = "Yearly(3500)";
                              // monthly.value = "Monthly(500)";
                              // yearly.value = "Yearly(3500)";
                            }
                            
                           
                        }

               }

               function setRateOfVehicle(){
                change_currency = document.getElementById("change_currency").value ="INR";
                if(vehicle_emp_type.value == "Cycle"){
                               dailyprice.innerHTML = "Daily(5)";
                               monthlyprice.innerHTML = "Monthly(100)";
                               yearlyyprice.innerHTML = "Yearly(500)";

                               
                               document.getElementById("radioprice1").value = "Daily(5)";
                               document.getElementById("radioprice2").value = "Monthly(100)";
                               document.getElementById("radioprice3").value= "Yearly(500)";
                            }
                            else if(vehicle_emp_type.value == "Motorcycle"){
                                dailyprice.innerHTML = "Daily(100)";
                               monthlyprice.innerHTML = "Monthly(200)";
                               yearlyyprice.innerHTML = "Yearly(1000)";

                               document.getElementById("radioprice1").value = "Monthly(200)";
                               document.getElementById("radioprice2").value = "Daily(100)";
                               document.getElementById("radioprice3").value = "Yearly(1000)";
                               
                            }
                            else if(vehicle_emp_type.value == "FourWheeler"){
                                dailyprice.innerHTML = "Daily(20)";
                               monthlyprice.innerHTML = "Monthly(500)";
                               yearlyyprice.innerHTML = "Yearly(3500)";

                               document.getElementById("radioprice1").value= "Daily(20)";
                               document.getElementById("radioprice2").value = "Monthly(500)";
                               document.getElementById("radioprice3").value = "Yearly(3500)";
                            }
               }

               function changeRate(){
                   change_currency = document.getElementById("change_currency")
                                            if(change_currency.value == "INR"){
                                                        if(vehicle_emp_type.value == "Cycle"){
                                                            dailyprice.innerHTML = "Daily("+5+")";
                                                            monthlyprice.innerHTML = "Monthly("+100+")";
                                                            yearlyyprice.innerHTML  = "Yearly("+500+")";

                                                            document.getElementById("radioprice1").value = "Daily(5)";
                                                            document.getElementById("radioprice2").value= "Monthly(100)";
                                                            document.getElementById("radioprice3").value = "Yearly(500)";
                                                            }
                                                            else if(vehicle_emp_type.value == "Motorcycle"){
                                                                dailyprice.innerHTML = "Daily("+10+")";
                                                            monthlyprice.innerHTML = "Monthly("+200+")";
                                                            yearlyyprice.innerHTML  = "Yearly("+1000+")";

                                                            document.getElementById("radioprice1").value = "Monthly(200)";
                                                            document.getElementById("radioprice2").value = "Daily(100)";
                                                            document.getElementById("radioprice3").value= "Yearly(1000)";
                                                            }
                                                            else if(vehicle_emp_type.value == "FourWheeler"){
                                                                dailyprice.innerHTML = "Daily("+20+")";
                                                            monthlyprice.innerHTML = "Monthly("+500+")";
                                                            yearlyyprice.innerHTML  = "Yearly("+35000+")";

                                                            document.getElementById("radioprice1").value = "Daily(20)";
                                                            document.getElementById("radioprice2").value = "Monthly(500)";
                                                            document.getElementById("radioprice3").value = "Yearly(3500)";
                                                            }
                                        }
                                        else if(change_currency.value == "USD"){
                                                        if(vehicle_emp_type.value == "Cycle"){
                                                            dailyprice.innerHTML = "Daily("+5*0.0139237951+")";
                                                            monthlyprice.innerHTML = "Monthly("+100*0.0139237951+")";
                                                            yearlyyprice.innerHTML  =  "Yearly("+500*0.0139237951+")";
                                                          
                                                            document.getElementById("radioprice1").value = "Daily("+5*0.0139237951+")";
                                                            document.getElementById("radioprice2").value = "Monthly("+100*0.0139237951+")";
                                                            document.getElementById("radioprice3").value =  "Yearly("+500*0.0139237951+")";
                                                            }
                                                            else if(vehicle_emp_type.value == "Motorcycle"){

                                                                dailyprice.innerHTML = "Daily("+100*0.0139237951+")";
                                                            monthlyprice.innerHTML = "Monthly("+200*0.0139237951+")";
                                                            yearlyyprice.innerHTML  =  "Yearly("+1000*0.0139237951+")";

                                                            document.getElementById("radioprice1").value = "Daily("+100*0.0139237951+")";
                                                            document.getElementById("radioprice2").value = "Monthly("+200*0.0139237951+")";
                                                            document.getElementById("radioprice3").value =  "Yearly("+1000*0.0139237951+")";

                                                            }
                                                            else if(vehicle_emp_type.value == "FourWheeler"){
                                                                dailyprice.innerHTML ="Daily("+20*0.0139237951+")";
                                                            monthlyprice.innerHTML =  "Monthly("+500*0.0139237951+")";
                                                            yearlyyprice.innerHTML  = "Yearly("+3500*0.0139237951+")";

                                                            document.getElementById("radioprice1").value= "Daily("+20*0.0139237951+")";
                                                            document.getElementById("radioprice2").value = "Monthly("+500*0.0139237951+")";
                                                            document.getElementById("radioprice3").value=  "Yearly("+3500*0.0139237951+")";

                                                            
                                                               
                                                        }
                                        }
                                        else if(change_currency.value == "YEN"){
                                                        if(vehicle_emp_type.value == "Cycle"){
                                                            dailyprice.innerHTML =     "Daily("+5*1.49+")";
                                                            monthlyprice.innerHTML =   "Monthly("+100*1.49+")";
                                                            yearlyyprice.innerHTML  =  "Yearly("+500*1.49+")";

                                                            document.getElementById("radioprice1").value = "Daily("+5*1.49+")";
                                                            document.getElementById("radioprice2").value =  "Monthly("+100*1.49+")";
                                                            document.getElementById("radioprice3").value=   "Yearly("+500*1.49+")";

                                                            }
                                                            else if(vehicle_emp_type.value == "Motorcycle"){
                                                                dailyprice.innerHTML= "Daily("+10*1.49+")";
                                                                monthlyprice.innerHTML = "Monthly("+200*1.49+")";
                                                                yearlyyprice.innerHTML= "Yearly("+1000*1.49+")";

                                                                document.getElementById("radioprice1").value  = "Daily("+10*1.49+")";
                                                                document.getElementById("radioprice2").value =  "Monthly("+200*1.49+")";
                                                                document.getElementById("radioprice3").value =   "Yearly("+1000*1.49+")";
                                                            }
                                                            else if(vehicle_emp_type.value == "FourWheeler"){
                                                                dailyprice.innerHTML = "Daily("+20*1.49+")";
                                                                monthlyprice.innerHTML= "Monthly("+500*1.49+")";
                                                                yearlyyprice.innerHTML = "Yearly("+3500*1.49+")";

                                                            document.getElementById("radioprice1").value =  "Daily("+20*1.49+")";
                                                            document.getElementById("radioprice2").value = "Monthly("+500*1.49+")";
                                                            document.getElementById("radioprice3").value =   "Yearly("+3500*1.49+")";
                                                        }
                                        }
               }
              function getFinalPrice(){
                var radioButtons = document.getElementsByName("radioprice");
                for(var i = 0; i < radioButtons.length; i++){
                    if(radioButtons[i].checked){
                       var rate_value = radioButtons[i].value;
                       alert("Your Final price"+rate_value);
                    }
                   
              }
              }
        </script>
</head>
<body style="margin-top: 0px" onload="initiate()" >


    <div style="margin-top:0px">
        
            <table cellpadding="20"> 
                    <tr>
                        <td style="width:900px" > <h1><span style="color:darkturquoise">Meta</span><span style="color:black">-Parking</span></h1></td>
                        <td ><a href="">Home</a></td>
                        <td><a href="login.jsp" id="signin"   >Sign-in</a></td>
                        <td><a href="#"  id="signup">Sign-up</a></td>
                        <td><a href="vehicle.jsp"  id="vh">Vehicle form</a></td>
                         <td><a href="FriendServlet">Friend</a></td>
                    </tr>
            </table>
    </div>
   
    <!--Add Duration -->
    <div id ="duration_div" style="display:none" >   
                    <table border="0px" align="center" cellspacing="0px" width="60%"  cellpadding="10">
                            <!--submit button-->
                            <tr>
                                <td colspan="2"><input type="radio" id="radioprice1" name="radioprice" value="d" ><span id="dailyprice"></span></td>
                                <td colspan="2"><input type="radio" id="radioprice2" name="radioprice" value="m" ><span id="monthlyprice"></span></span></td>
                                <td colspan="2"><input type="radio" id="radioprice3" name="radioprice" value="y" ><span id="yearlyprice"></span></td>
                                <td width="10%"><select name="change_currency" id="change_currency" onchange="changeRate()">
                                        <option name="inr" value="INR">INR</option>
                                        <option name="yen" value="YEN">YEN </option>
                                        <option name="usd" value="USD">USD</option>
                             </select></td>
                            </tr>
                            <tr>
                               <td colspan="3" align="center"><input type="button" name="getpass" id="gatpass" value="GETPASS" onclick="getFinalPrice()"></td>
                            </tr>
                   </table>
    </div>
   
    <!-- Registration form -->

 



 <div id="registration_div"> 
   
        <form action="EmployeeRegistration" name = "registration_form" method="GET" > <!-- onsubmit="return validateSignupForm() -->
                <table border="0px" align="center" cellspacing="0px" width="60%"  cellpadding="10">
                        <tr>
                            <th colspan="2"><%= request.getParameter("message")==null ? "": request.getParameter("message")%></th>
                         <td>
                         <%
                       
                         String n =(String)session.getAttribute("emailid");  
								
								%>
								<b> <%= n==null?" ":n %> your session </b> <br>
                         </td>  
                        </tr>
                        <tr>
                            <th colspan="2"><h1>Employee Registration</h1></th>
                        </tr>
                        <!--Employee Name-->
                        <tr>
                            <td width="20%"><label>Employee Name</label></td>
                            <td width="10%"><input type="text" name="employee_name" id="employee_name" placeholder="Enter Employee Name" value="" onkeypress="return removeError(id)"></td>
                            <td width="30%" style="text-align: left"><span id="username_error_message"></span></td>
                        </tr>
                          <!--Employee password-->
                        <tr>
                                <td width="20%"><label>Password</label></td>
                                <td width="10%"><input type="password" name="employee_password" id="employee_password" placeholder="Enter password" onkeypress="return removeError(id)"></td>
                                <td width="30%" style="text-align: left"><span id="password_error_message"></span></td>
                        </tr>

                        <!--confirm password-->
                        <tr>
                                <td width="20%"><label>Confirm Password</label></td>
                                <td width="10%"><input type="password" name="employee_confirm_password" id="employee_confirm_password" placeholder="Enter Confirm Password" onkeypress="return removeError(id)"></td>
                                <td width="30%" style="text-align: left"><span id="confirm_password_error_message"></span></td>
                        </tr>
                        <!--organisation-->
                        <tr>
                            <td width="20%"><label>Organisation</label></td>
                            <td width="10%"><select name="organization_type" id="organization_type" onchange="setRateOfVehicle()">
                                       <option name="Car" value="METACUBE">METACUBE</option>
                                       <option name="Motorcycle" value="INFOSYS">INFOSYS </option>
                                       <option name="FourWheeler" value="WIPRO">WIPRO</option>
                            </select></td>
                            <td width="30%" style="text-align: left"><span id="vehicle_type_error_message"></span></td>
                    </tr>
                        <!--Email id-->
                        <tr>
                                <td width="20%"><label>Email-id</label></td>
                                <td width="10%"><input type="text" name="employee_emailid" id="employee_emailid" placeholder="Enter Email Address" onkeypress="return removeError(id)"></td>
                                <td width="30%" style="text-align: left"><span id="emailid_error_message"></span></td>
                        </tr>
                         <!--Contact Number-->
                         <tr>
                                <td width="20%"><label>Contact Number</label></td>
                                <td width="10%"><input type="text" name="employee_contact" maxlength="10" id="employee_contact" onkeypress=" return numbers(this.event)" placeholder="Enter Contact Number" ></td>
                                <td width="30%" style="text-align: left"><span id="contact_error_message"></span></td>
                        </tr>
                        <!--Gender-->
                        <tr>
                                <td width="20%"><label>Gender</label></td>
                                <td width="10%"><input type="radio" name="employee_gender" id="employee_gender" value="Male" >Male &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                    <input type="radio" name="employee_gender" id="employee_gender" value="Female">Female</td>
                                <td width="30%" style="text-align: left"><span id="gender_error_message"></span></td>
                        </tr>
                        <!--submit button-->
                        <tr>
                            <td colspan="2"><center><input type="submit" value="Register"> </center></td>
                        </tr>
               </table>
        </form>
          
    </div>

     <div>

     </div>
</body>
</html>