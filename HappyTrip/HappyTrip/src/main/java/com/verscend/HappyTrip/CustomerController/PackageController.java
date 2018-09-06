package com.verscend.HappyTrip.CustomerController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.verscend.HappyTrip.Entity.PackageTrip;
import com.verscend.HappyTrip.Entity.Repository.PackageRepository;
@RestController
@RequestMapping("/Package")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class PackageController {
	
	@Autowired
	PackageRepository packRepo;
	
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public void addPackage(@RequestBody PackageTrip packageTrip) {
		
		packRepo.save(packageTrip);
	}
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public void deletePackage(@PathVariable int id) {
		packRepo.deleteById(id);
	}
	@RequestMapping("/update")
	public void updatePackage(@RequestBody PackageTrip packageTrip) {
		packRepo.save(packageTrip);
	}
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<PackageTrip> showPackage() {
		return (List<PackageTrip>) packRepo.findAll();
	}
	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer corsConfigurer() 
	{
		  return new WebMvcConfigurerAdapter() 
		  {
		  @Override
		  public void addCorsMappings(CorsRegistry registry) 
			  {
				  
				  	registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
			  }
		  };
	 }
}
