package com.ebill.api.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustomAuthSuccessHandler customAuthSuccessHandler;

	@Bean
	public CustomAccessDeniedHandler getAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(auth);
		//auth.userDetailsService(null);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);

		// disabling Cross-Site Request Forgery
		http.csrf().disable();
		
		// no authentication required
		http.authorizeRequests().antMatchers("/").permitAll();
		
		// authenticated users
		http.authorizeRequests().antMatchers("/getStudents", "/adminHome", "/userHome").authenticated();

		// restricting access
		http.authorizeRequests().antMatchers("/getUsers").hasAnyAuthority("admin").and().exceptionHandling()
				.accessDeniedHandler(getAccessDeniedHandler());

		// configure login form
		http.authorizeRequests().and().formLogin().loginPage("/login").successHandler(customAuthSuccessHandler)
				.failureUrl("/login?failed").usernameParameter("username").passwordParameter("password")

				// Config for Logout Page
				.and().logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout");

		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	  
	
	
	
	
	
	
}
