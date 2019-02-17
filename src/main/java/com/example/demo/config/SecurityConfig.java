package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;

	@Autowired
	public void authentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.jdbcAuthentication().dataSource(datasource)
				.passwordEncoder(enocder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/h2-console").permitAll()
				.antMatchers("/createUser").hasAnyRole("ADMIN")
				.antMatchers("/saveUser").hasAnyRole("ADMIN")
				.antMatchers("/deleteUser").hasAnyRole("ADMIN")
				.antMatchers("/user").hasAnyRole("USER").anyRequest()
				.authenticated().and().httpBasic();
		http.csrf().disable();

	}

	@Bean
	public BCryptPasswordEncoder enocder() {
		return new BCryptPasswordEncoder();
	}

}
