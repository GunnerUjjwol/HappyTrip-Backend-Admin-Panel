package com.verscend.HappyTrip;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
        http.authorizeRequests()
        		.antMatchers("/UserQuery/**").permitAll()
        		.antMatchers("/Package/**").permitAll()
        		.antMatchers("/h2-console/**").permitAll()
        		.antMatchers("/UserQuery/add/**").permitAll()
        		
        		.antMatchers("/Customers/add/**").permitAll()
        		
        		.anyRequest().authenticated()
//        		.anyRequest().permitAll()
        	.and()
            	.httpBasic()
            .and()
            	.cors()
            .and()
            	.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            	.csrf().disable()
            	.headers().frameOptions().disable();
    	// @formatter:on
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return this.userDetailsService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowedOrigins(Arrays.asList("*"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("*"));
		corsConfiguration.setMaxAge(24 * 60 * 60L);
		UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
		corsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return corsConfigurationSource;
	}
}