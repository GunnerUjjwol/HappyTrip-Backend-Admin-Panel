package com.verscend.HappyTrip.CustomerController;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.verscend.HappyTrip.Entity.Booking;
import com.verscend.HappyTrip.Entity.Customers;
import com.verscend.HappyTrip.Entity.bookedStatus;
import com.verscend.HappyTrip.Entity.Repository.CustomersRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.validation.constraints.Email;

@EnableGlobalMethodSecurity(prePostEnabled = true) 
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Customers")
public class CustomerController {

	@Autowired
	CustomersRepository cusRep;
	// TODO: need to store the username and password in the list
	// List<HashMap<String, String>> CustomersLogin = new ArrayList<>();

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Customers> getAll() {
		return (List<Customers>) cusRep.findAll();
	}

//	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
//	public Customers getUser(@PathVariable int id) {
//		System.out.println(cusRep.findById(id));
//		return cusRep.findById(id);
//	}	
	
	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping(path = "/user/check", method = RequestMethod.GET)
	public Customers getUserDetails(Principal principal) {
		return cusRep.findByEmail(principal.getName());
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(path = "/admin/check", method = RequestMethod.GET)
	public Object getAdminDetails(Authentication authentication) {
		return authentication.getDetails();
	}
	
//	@RequestMapping(value = "/check",method = RequestMethod.GET)
//	public Customers CheckUser(Principal principal) {
//		return cusRep.findByEmail(principal.getName());
//	}
//	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Customers getUser(Principal principal) {
		System.out.println("from/user"+principal.getName());
		for(Booking b :  new ArrayList<>(cusRep.findByEmail(principal.getName()).getBookings()))
		{
			if(b.getBookedstatus() == bookedStatus.CANCELLED)
			{
				cusRep.findByEmail(principal.getName()).getBookings().remove(b);
			}
		}
		return(cusRep.findByEmail(principal.getName()));
	}

	@RequestMapping(value = "/add/{email}", method = RequestMethod.POST)
	public HashMap<String, String> insert(@PathVariable String email, @RequestBody Customers customer) {
		HashMap<String,String> result = new HashMap<>();
 		if (cusRep.findByEmail(customer.getEmail().trim()) != null) {
 			result.put("register","no");
			System.out.println("not saving");
		} else {
			cusRep.save(customer);
			result.put("register","yes");
		}
		return result;
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public void update(@RequestBody Customers customer) {
		cusRep.save(customer);
		System.out.println("data updated!!!");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") int id) {
		System.out.println(id);
		cusRep.deleteById(id);
	}

	@RequestMapping(value = "/sendMail")
	public void message() {

	}

	// This is used for login
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public HashMap<String, String> login(@RequestBody String login) {

		// This hashmap is used to return data back to angular
		HashMap<String, String> returnedData = new HashMap<>();

		JSONObject loginObject = new JSONObject(login);
		String userName = loginObject.getString("userName");
		String password = loginObject.getString("password");

		List<Customers> customerList = (List<Customers>) cusRep.findAll();
		String result = "failed";
		returnedData.put("res", result);
		for (Customers cus : new ArrayList<>(customerList)) {
			String name = cus.getFirstName() + " " + cus.getLastName();
			String pass = cus.getPassword();
			if (userName.equals(name) && password.equals(pass)) {
				result = "passed";
				returnedData.put("res", result);
				return returnedData;
			}
		}

		return returnedData;
	}

	@RequestMapping(value = "/addBooking/{id}", method = RequestMethod.POST)
	public void InsertBooking(@PathVariable int id, @RequestBody Booking booking) {

		for (Customers c : cusRep.findAll()) {
			if (c.getId() == id) {
				
				c.setBookings(booking);
				cusRep.save(c);

			}
		}
	}

	@RequestMapping(value = "/getBooking")
	public List<Booking> getBookings(Principal principal) {
		Customers c= cusRep.findByEmail(principal.getName()); 
		return c.getBookings();
//		for (Customers c : cusRep.findAll()) {
//			if (c.getId() == id) {
//				System.out.println(c.getBookings());
//				return c.getBookings();
//			}
//		}
//		return null;
	}

	// for cancellation
//	@RequestMapping(value = "/cancel/{customerId}/{bookId}", method=RequestMethod.GET)
//	public void cancelbooking(@PathVariable int customerId, @PathVariable int bookId) {
//		
//		Customers c= cusRep.findById(customerId);
//		c.getBookings().get(bookId - 1).setBookedstatus(bookedStatus.CANCELLED);
//		
//		
////		for (Customers c : cusRep.findAll()) {
////			if (c.getId() == customerId) {
////				c.getBookings().get(bookId - 1).setBookedstatus(bookedStatus.CANCELLED);
////				cusRep.save(c);
////			}
////		}
////		System.out.println("Reaching controller, but not executing for loop");
//
//	}
	
	
	//getting the price of the booked packages 
	@RequestMapping(value = "/getPrice",method = RequestMethod.GET)
	public int getPrice(Principal principal) {
		int price = 0;
		for(Booking b: cusRep.findByEmail(principal.getName()).getBookings())
		{
			if(b.getBookedstatus()== bookedStatus.BOOKED) {
				
					price += Integer.parseInt(b.getPrice());
				
			}
		}
	
		
		return price;
	}	

	@SuppressWarnings("deprecation")
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedOrigins("*");
			}
		};
	}
}
