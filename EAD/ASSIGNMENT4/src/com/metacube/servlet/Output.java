package com.metacube.servlet;

import java.awt.List;
import java.awt.List.*;
import java.util.ArrayList;

import pojo.Employee;

public class Output {
	public static String passDetails(double[] price, int employee_id){
		String s = "<div align='center'>"
				+"<form method='get' action='PassServlet'>"
				+"<p>1. Select Plans in (USD)</p>"
				+"<input type='hidden' name='emp_id' value='"+employee_id+"'>"
				+"<select name = 'plan'>"
				+" <option  value= '"+ price[0] +"'/>" + price[0] + " Daily</option>"
				+ " <option value= '"+ price[1] +"'/>" + price[1] + " Monthly</option>"
				+ " <option value= '"+ price[2] +"'/>" + price[2] + " Yearly</option>"
				+" </select></br></br>"
				+ "<p>2. Do You Want To Change Currency</p>"
				+"<select name='currency' align='center'>"
				+"<option  value = 'USD'>USD</option>"
				+ "<option  value= 'INR'>INR</option>"
				+ " <option value= 'YEN'>YEN</option>"
				+"</select>"
				+"<input type='submit' value = 'GetPass'/>"
				+"</div>";
		return s;
	}

	public static String printOutputWithLink(Employee e,boolean showLink){
		String res = "<html>"
				+"<h3>EmployeeDetail</h3>"
				+"<table>"
				+"<tr><td>Employee Id </td><td>Full Name </td><td>Gender </td><td>Email </td><td>Contact Number </td><td>Organization </td></tr>"
				+ "<tr><td>" + e.getId()+" </td><td>" + e.getEmployee_name() +" </td><td>"+e.getEmployee_gender()+" </td><td>"+e.getEmployee_emailid() +" </td><td>"+e.getEmployee_contact()+" "
				+ "</td><td>"+e.getOrganization_type()+" </td><td></tr></table>";
		if(showLink){
			res += "<a href='EditEmployeeServlet?id=" +e.getId()+ "'> Edit </a><br>"
					+"<a href='FriendServlet?id=" +e.getId()+ "'> Friend </a><br>"
					+"<a href='LogOutServlet'> Log Out </a><br>"
					+"<input type='hidden' name='email' value='"+e.getEmployee_emailid() +"'/>";
		}

		return res;
	}

	public static String onUpdate(Employee e){
		String onUpdate = "<html>"
				+"<form method='get' action='UpdateEmployeeServlet'>"
				+"<h3>Update Employee</h3>"
				+"<table>"
				+"<tr><td>Employee Id<td><td><input type='text' name='employee_id' value ='"+ e.getId() +"'readonly></td></tr>"
				+"<tr><td>Password<td><td><input type='password' name='password' value ='"+e.getEmployee_password() +"'></td></tr>"
				+"<tr><td>Full Name<td><td><input type='text' name='full_name' value ='"+e.getEmployee_name() +"'></td></tr>"
				+"<tr><td>Gender<td><td><input type='text' name='gender' value ='"+ e.getEmployee_gender() +"'></td></tr>"
				+"<tr><td>Email<td><td><input type='text' name='email' value ='"+ e.getEmployee_gender() +"'></td></tr>"
				+"<tr><td>Contact Number<td><td><input type='text' name='contact_number' value ='"+ e.getEmployee_contact()+"'></td></tr>"
				+"<tr><td>Organization<td><td><input type='text' name='org' value ='"+e.getOrganization_type()  +"'></td></tr>"
				+"</table>"
				+"<input type = 'submit' value='Update'/>"
				+"</form>";	
		return onUpdate;
	}

	public static String printFriend(ArrayList<Employee> emp){
		String res = "<html>"
				+"<h3>Friends</h3>"
				+"<table cellpadding=20 cellspacing=20 >"
				+"<tr><td>id</td><td>Name</td><td>Email id</td><td>Gender</td><td>Contact nmuber</td><td>organization</td></tr>";
		for(Employee e:emp){
			res+= "<tr><td>" + e.getId()+ "</td><td>" + e.getEmployee_name()+ "</td><td>" + e.getEmployee_emailid()+ "</td><td>" + e.getEmployee_gender()+ "</td><td>" + e.getEmployee_contact()+ "</td><td>" + e.getOrganization_type()+ "</td></tr>";
		}

		return res;
	}
}
