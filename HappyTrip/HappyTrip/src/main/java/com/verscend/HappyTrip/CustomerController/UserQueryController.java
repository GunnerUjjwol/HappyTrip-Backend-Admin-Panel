package com.verscend.HappyTrip.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.verscend.HappyTrip.Entity.PackageTrip;
import com.verscend.HappyTrip.Entity.UserMessage;
import com.verscend.HappyTrip.Entity.Repository.PackageRepository;
import com.verscend.HappyTrip.Entity.Repository.UserQueryRepository;
import com.verscend.HappyTrip.Entity.UserMessage;

@RestController
@RequestMapping("/UserQuery")
@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
public class UserQueryController {
	@Autowired
	UserQueryRepository userMessage;

	@RequestMapping("/add")
	public void addQuery(@RequestBody UserMessage message) {
		userMessage.save(message);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteQuery(@PathVariable int id) {
		userMessage.deleteById(id);
	}

	/*
	 * @RequestMapping("/update") public void updatePackage(@RequestBody UserMessage
	 * message) { userMessage.save(message); }
	 */
	@RequestMapping("/all")
	public List<UserMessage> showPackage() {
		return (List<UserMessage>) userMessage.findAll();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}

}
