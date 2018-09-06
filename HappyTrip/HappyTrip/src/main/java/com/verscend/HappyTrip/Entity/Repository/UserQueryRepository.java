package com.verscend.HappyTrip.Entity.Repository;

import org.springframework.data.repository.CrudRepository;


import com.verscend.HappyTrip.Entity.UserMessage;

public interface UserQueryRepository extends CrudRepository<UserMessage,Integer> {

}
