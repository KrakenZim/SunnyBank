package com.data;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.data.service.CustomClientDetailsService;


@Configuration
@EnableWebSecurity
@Order(2)
public class ClientSecurityConfig{
	
	@Bean
	public UserDetailsService customClientDetailsService() {
		return new CustomClientDetailsService();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder2() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider2() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(customClientDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder2());
		return authProvider;
	}
	
	@Bean
	public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
		http.authenticationProvider(authenticationProvider2());
		
		http.authorizeRequests().antMatchers("/").permitAll();
		
		http.antMatcher("/client/**")
			.authorizeRequests().anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/client/login")
					.usernameParameter("email")
					.loginProcessingUrl("/client/login")
					.defaultSuccessUrl("/client/welcome")
				.permitAll()
			.and()
		    .logout()
		    	.logoutUrl("/client/logout")
		    	.logoutSuccessUrl("/");
		return http.build();
	}
}

