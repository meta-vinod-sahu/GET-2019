/*
 * Controller
 */
package com.metacube.Parking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.EmployeeDTO;
import com.metacube.Parking.model.ImageDTO;
import com.metacube.Parking.model.LoginDTO;
import com.metacube.Parking.model.PassDTO;
import com.metacube.Parking.model.PlanDTO;
import com.metacube.Parking.model.Vehicle;
import com.metacube.Parking.model.VehicleDTO;
import com.metacube.Parking.service.EmployeeService;
import com.metacube.Parking.utils.DTOUtil;

@Controller
public class FrontController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Get Mapping for Registration page
	 * @param model
	 * @return view
	 */
	@GetMapping("/RegistrationPage")
	public String register(Model model){
		model.addAttribute(new EmployeeDTO());
		return "RegistrationPage";
	}

	/**
	 * Post Mapping for Registration Page
	 * @param emp to be validated
	 * @param result
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/RegistrationPage")
	public String doRegister(@Validated EmployeeDTO emp,BindingResult result,RedirectAttributes attribute){
		if(result.hasErrors()){
			return "RegistrationPage";
		}else{
			try{
				if(!emp.getPassword().equals(emp.getRepass())){
					ObjectError error = new ObjectError("Password","Passwords Don't Match!");
					result.addError(error);
					return "RegistrationPage";
				}else{
					employeeService.addEmployee(DTOUtil.map(emp,Employee.class));
					attribute.addFlashAttribute("msg", "Your Employee Id is :" + employeeService.getEmployeeId());
					return "redirect:/VehiclePage"; 
				}
			}catch (DuplicateKeyException e) {
				ObjectError error =  new ObjectError("Exception","Email must be unique");
				result.addError(error);
				return "RegistrationPage";
			}
		}
	}

	/**
	 * Get Mapping for Login Page
	 * @param msg
	 * @param model
	 * @return view
	 */
	@GetMapping("/LoginPage")
	public String login(@RequestParam(value="msg",required=false) String msg,Model model){
		model.addAttribute(new LoginDTO());
		model.addAttribute("msg",msg);
		return "LoginPage";
	}

	/**
	 * Post Mapping for Login Page
	 * @param login
	 * @param result
	 * @param attribute
	 * @param request
	 * @return view
	 */
	@PostMapping("/LoginPage")
	public String doLogin(@Validated LoginDTO login,BindingResult result,RedirectAttributes attribute,HttpServletRequest request){
		String password;		
		if(result.hasErrors()){
			return "LoginPage";
		}else{
			password = employeeService.auth(login.getEmail());
			if(!login.getPassword().equals(password)){
				ObjectError error = new ObjectError("Auth","Authentication Failed!");
				result.addError(error);
				return "LoginPage";
			}else{
				if(login.getEmail() != null){
					HttpSession session = request.getSession();
					session.setAttribute("email",login.getEmail());
				}
				
				attribute.addAttribute("Email",login.getEmail());
				return "redirect:/HomePage";
			}
		}
	}

	/**
	 * Get Mapping for Vehicle Page
	 * @param model
	 * @return view
	 */
	@GetMapping("/VehiclePage")
	public String vehicle(Model model){
		model.addAttribute(new VehicleDTO());
		return "VehiclePage";
	}

	/**
	 * Post Mapping for Vehicle Page
	 * @param vehicle
	 * @param result
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/VehiclePage")
	public String doVehicle(@Validated VehicleDTO vehicle,BindingResult result,RedirectAttributes attribute){
		if(result.hasErrors()){
			return "VehiclePage";
		}else{
			employeeService.addVehicle(DTOUtil.map(vehicle,Vehicle.class));
			attribute.addAttribute("type",vehicle.getType());
			return "redirect:/PassDetails";
		}
	}

	/**
	 * Get Mapping for Pass Details page
	 * @param type
	 * @param model
	 * @return view
	 */
	@GetMapping("/PassDetails")
	public String pass(@RequestParam("type") String type,Model model){
		model.addAttribute("planDTO",new PlanDTO());
		Map<Double,String> prices = new HashMap<Double,String>();
		PassDTO passDTO = employeeService.getPrice(type);
		prices.put(passDTO.getDaily(), passDTO.getDaily() + "Daily");
		prices.put(passDTO.getMonthly(), passDTO.getMonthly() + "Monthly");
		prices.put(passDTO.getYearly(), passDTO.getYearly() + "Yearly");
		model.addAttribute("priceList", prices);
		return "PassDetails";
	}

	/**
	 * Post Mapping for Pass Details Page
	 * @param planDTO
	 * @param result
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/PassDetails")
	public String doPass(@Validated PlanDTO planDTO,BindingResult result,RedirectAttributes attribute){
		double plan = employeeService.getValueByCurrency( planDTO.getPlan(),planDTO.getCurrency());
		attribute.addFlashAttribute("getPass","Your Selected Plan is :" + plan);
		return "redirect:/LoginPage";
	}

	/**
	 * Get Mapping for Home Page
	 * @param Email
	 * @param model
	 * @return view
	 */
	@GetMapping("/HomePage")
	public String home(@RequestParam(value="Email") String Email,Model model){
		Employee e = employeeService.getEmployeeByEmail(Email);
		model.addAttribute("emp",e);
		return "HomePage";
	}

	/**
	 * Post Mapping for Home Page
	 * @return view
	 */
	@PostMapping("/HomePage")
	public String doHome(){
		return "forward:/EditPage"; 
	}

	/**
	 * Get Mapping for Edit page
	 * @param model 
	 * @return view
	 */
	@GetMapping("/EditPage")
	public String edit(@RequestParam(value="Email") String Email,Model model){
		Employee e = employeeService.getEmployeeByEmail(Email);
		model.addAttribute("employeeDTO",e);
		return "EditPage";
	}

	/**
	 * Post Mapping for Edit page
	 * @param emp
	 * @param result
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/EditPage")
	public String doEdit(@Validated EmployeeDTO emp,BindingResult result,RedirectAttributes attribute){
		if(result.hasErrors()){
			return "EditPage";
		}else{
			employeeService.updateEmployee(DTOUtil.map(emp,Employee.class));
			attribute.addAttribute("Email",emp.getEmail());
			attribute.addFlashAttribute("edit","Sucessfully Updated!");
			return "redirect:/HomePage"; 
		}
	}

	/**
	 * Get Mapping for File Upload Page
	 * @param Email
	 * @param model
	 * @return view
	 */
	@GetMapping("/FileUpload")
	public String fileUpload(@RequestParam(value="Email") String Email,Model model){
		model.addAttribute(new ImageDTO());
		return "FileUpload";
	}

	/**
	 * Post Mapping for File Upload page
	 * @param image
	 * @param result
	 * @param attribute
	 * @return view
	 */
	@PostMapping("/FileUpload")
	public String doFileUpload(@Validated ImageDTO image,BindingResult result,RedirectAttributes attribute){
		if(result.hasErrors()){
			return "FileUpload";
		}else{
			employeeService.addImage(image.getImageURL(),image.getEmail());
			attribute.addFlashAttribute("img",image.getImageURL());
			attribute.addAttribute("Email",image.getEmail());
			attribute.addFlashAttribute("edit","Image Sucessfully Updated!");
			return "redirect:/HomePage";
		}
	}

	/**
	 * Get Mapping for Friend Page
	 * @param Email
	 * @param model
	 * @return view
	 */
	@GetMapping("/FriendPage")
	public String friend(@RequestParam(value="Email") String Email,Model model){
		List<Employee> friends = employeeService.getFriends(Email);
		model.addAttribute("friend",friends);
		return "FriendPage";
	}

	/**
	 * Get mapping for Friend Profile Page
	 * @param email
	 * @param model
	 * @return view
	 */
	@GetMapping("/FriendProfile")
	public String friendProfile(@RequestParam(value="email") String email,Model model){
		Employee e = employeeService.getEmployeeByEmail(email);
		model.addAttribute("emp",e);
		return "FriendProfile";
	}	

	/**
	 * Get Mapping for Log Out Page
	 * @param request
	 * @return view
	 */
	@GetMapping("/LogOutPage")
	public String logOut(HttpServletRequest request){
		HttpSession session= request.getSession(false);
		if(session != null){
			session.invalidate();
		}

		return "redirect:/LoginPage";
	}
}