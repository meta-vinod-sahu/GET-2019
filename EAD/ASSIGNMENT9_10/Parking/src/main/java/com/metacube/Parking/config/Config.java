/*
 * Configuration Class
 */
package com.metacube.Parking.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.metacube.Parking.model.Employee;
import com.metacube.Parking.model.PassDTO;
import com.metacube.Parking.model.Vehicle;
import com.metacube.Parking.service.EmployeeService;
import com.metacube.Parking.service.EmployeeServiceImpl;
import com.metacube.Parking.service.EmployeeServiceImpl2;
import com.metacube.Parking.utils.ValidationFilter;

@Configuration
public class Config {

	
	@Bean 
	public EmployeeService employee() {
		return new EmployeeServiceImpl();
	}
	
	
	
	
	@Bean
	public FilterRegistrationBean<ValidationFilter> validationFilter(){
	    FilterRegistrationBean<ValidationFilter> registrationBean 
	      = new FilterRegistrationBean<>();
	         
	    registrationBean.setFilter(new ValidationFilter());
	    registrationBean.addUrlPatterns("/HomePage",
	    		"/EditPage",
	    		"/FileUpload",
	    		"/FriendPage",
	    		"/FriendProfile"
	    		);
	         
	    return registrationBean;    
	}
}
