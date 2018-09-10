package com.verscend.HappyTrip.Entity.Repository;

import org.springframework.data.repository.CrudRepository;
import com.verscend.HappyTrip.Entity.Customers;
public interface CustomersRepository extends CrudRepository<Customers,Integer>{

Customers findByEmail(String email);

Customers findById(int id);


}



