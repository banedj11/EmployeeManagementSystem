package com.baka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.baka.models.Employee;
import com.baka.service.EmployeeService;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class MyEmployeeManagementSystemApplication implements CommandLineRunner{

	@Bean
	public AuditorAware<String> auditorAware(){
		
		return new SecurityAuditor();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyEmployeeManagementSystemApplication.class, args);
	}

	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*Employee employee = new Employee();
		employee.setFirstName("Admin");
		employee.setLastName("Adminic");
		employee.setEmail("admin@live.com");
		employee.setPassword("admin");
		employee.setGender("Male");
		employee.setSallary("1000");
		employeeService.saveAdmin(employee);*/
	}

}
