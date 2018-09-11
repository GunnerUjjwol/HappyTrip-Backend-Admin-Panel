package com.verscend.HappyTrip.Entity.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.verscend.HappyTrip.Entity.Customers;
public interface CustomersRepository extends CrudRepository<Customers,Integer>{
		//Customers findByEmail(String email);
		Customers findById(int id);
		Customers findByEmail(String email);
//		@Query(value = "select id from customers where email = ?1", nativeQuery = true)
//		Object emailCheck(String email); 
		
		
}



