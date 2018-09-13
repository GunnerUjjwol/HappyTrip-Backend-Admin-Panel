package com.verscend.HappyTrip.CustomerController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.verscend.HappyTrip.Entity.Booking;
import com.verscend.HappyTrip.Entity.Customers;
import com.verscend.HappyTrip.Entity.bookedStatus;
import com.verscend.HappyTrip.Entity.Repository.BookingRepository;

@RestController
@RequestMapping("/Booking")
@CrossOrigin(origins = "*",allowedHeaders="*")
public class BookingController {
	
	
	
	@Autowired
	BookingRepository bookingRepo;
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public void addBooking(@RequestBody String jsonString) {
		System.out.println(jsonString);
		JSONObject job = new JSONObject(jsonString);
		
		
		
		JSONObject jsonPckg=(JSONObject) job.get("PackageTrip");
		
		
		System.out.println(jsonPckg);
		
//		PackageTrip pckg= (PackageTrip)job.get("PackageTrip");
		Booking booking = new Booking();
	
		booking.setLocation(jsonPckg.getString("location"));
		booking.setPrice(jsonPckg.getString("price"));
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date= sdf.parse(job.getString("startDate"));
			System.out.println(date);
			booking.setStartDate(date);
		} catch (JSONException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		booking.setBookedstatus(bookedStatus.BOOKED);
		booking.setUser(job.getString("user"));
		
		System.out.println(booking.toString());
		bookingRepo.save(booking);
	}
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public List<Booking> showBookings() {
		System.out.println("returning data!!!");
		return (List<Booking>) bookingRepo.findAll();
	}
	
	
	@RequestMapping(value = "/cancel/{bookId}", method=RequestMethod.GET)
	public void cancelbooking( @PathVariable int bookId) {
		
		Booking b= bookingRepo.findByBookId(bookId);
		System.out.println(b);
		b.setBookedstatus(bookedStatus.CANCELLED);
		System.out.println(b.getBookedstatus());
		bookingRepo.save(b);
	}
	
	@RequestMapping(value="filter/{fromDate}/{toDate}", method = RequestMethod.GET)
	List<Map<String,Object>> dateBasedRecord(@PathVariable String fromDate, @PathVariable String toDate) {
		List<Map<String, Object>> filtered = bookingRepo.dateBasedRecord(fromDate, toDate);
		return filtered;		
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
