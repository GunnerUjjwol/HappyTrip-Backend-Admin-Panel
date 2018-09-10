package com.verscend.HappyTrip.Entity.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.verscend.HappyTrip.Entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
	
	
		@Query(value = "select * from booking where booked_date between ?1 and ?2", nativeQuery = true)
			List<Map<String, Object>> dateBasedRecord(String fromDate, String toDate); 
		 


}
