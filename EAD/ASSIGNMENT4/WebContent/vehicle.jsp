<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="margin-top:0px">
        
            <table cellpadding="20"> 
                    <tr>
                        <td style="width:900px" > <h1><span style="color:darkturquoise">Meta</span><span style="color:black">-Parking</span></h1></td>
                        <td ><a href="">Home</a></td>
                        <td><a href="login.jsp" id="signin"   >Sign-in</a></td>
                        <td><a href="index.jsp"  id="signup">Sign-up</a></td>
                        <td><a href="vehicle.jsp"  id="vh">Vehicle form</a></td>
                         <td><a href="LogoutServlet">logout</a></td>
                    </tr>
            </table>
    </div>
   
 <!--Add Vehicle form-->
    <div id ="vehicle_div"> <!---->
            <form action="VehicleServlet" name = "add_vehicle_form" method="GET" onsubmit="return validateVehicleForm()">
                    <table border="0px" align="center" cellspacing="0px" width="60%"  cellpadding="10">
                            <tr>
                                <th colspan="2"><h1>Add Vehicle Form</h1></th>
                            </tr>
                            <!--Employee Name-->
                            <tr>
                                <td width="20%"><label>Vehicle Name</label></td>
                                <td width="10%"><input type="text" name="vehicle_emp_name" id="vehicle_emp_name" placeholder="Enter Vehicle Name" onkeypress="return removeError(id)"></td>
                                <td width="30%" style="text-align: left"><span id="vehicle_emp_error_message"></span></td>
                            </tr>
                              <!--Employee id-->
                            <tr>
                                    <td width="20%"><label>Employee Id</label></td>
                                    <td width="10%"><input type="text" value="<%=request.getAttribute("id") %>"  name="vehicle_emp_id" id="vehicle_emp_id" placeholder="Enter Employee Id" onkeypress="return removeError(id)" ></td>
                                    <td width="30%" style="text-align: left"><span id="vehicle_emp_id_error_message"></span></td>
                            </tr>
                             <!--vehicle type-->
                             <tr>
                                    <td width="20%"><label>Vehicle Type</label></td>
                                    <td width="10%"><select name="vehicle_type" id="vehicle_type" onchange="setRateOfVehicle()">
                                               <option name="Car" value="Cycle">Cycle</option>
                                               <option name="Motorcycle" value="Motorcycle">Motorcycle </option>
                                               <option name="FourWheeler" value="FourWheeler">FourWheeler</option>
                                    </select></td>
                                    <td width="30%" style="text-align: left"><span id="vehicle_type_error_message"></span></td>
                            </tr>

                            <!--Vehicle Number-->
                         <tr>
                                <td width="20%"><label>Vehicle Number</label></td>
                                <td width="10%"><input type="text" onkeypress="return numbers(event)"  maxlength=4  name="vehicle_number" id="vehicle_number" placeholder="Number(Last four digit)" ></td>
                                <td width="30%" style="text-align: left"><span id="vehicle_number_error_message"></span></td>
                        </tr>
                        <tr>
                                <td width="20%"><label>Identification</label></td>
                                <td width="10%"><textarea rows="3" name="vehicle_identification" id="vehicle_identification" placeholder="Optional"></textarea></td>
                                <td width="30%" style="text-align: left"><span id="vehicle_identification__error_message"></span></td>
                        </tr>


    
                            <!--submit button-->
                            <tr>
                                <td colspan="2"><center><input type="submit" value="Add Vehicle"> </center></td>
                            </tr>
                   </table>
            </form>   
    </div>
</body>
</html>