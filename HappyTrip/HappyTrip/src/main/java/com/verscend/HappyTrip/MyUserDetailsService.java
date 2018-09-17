package com.verscend.HappyTrip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.verscend.HappyTrip.Entity.Customers;
import com.verscend.HappyTrip.Entity.Repository.CustomersRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomersRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) {
		System.out.println(username);
		if (username.equals("Admin@admin.com")) {
			return User.builder().username("Admin@admin.com").password(passwordEncoder.encode("password")).roles("ADMIN").build();
		}
		Customers user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return User.builder().username(user.getEmail()).password(passwordEncoder.encode(user.getPassword())).roles("USER").build();
	}
}