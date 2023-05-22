package com.example.demo.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;

	@Override
	@Bean
	public UserDetailsService userDetailsService() {
		return new CustomUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
		.authorizeRequests()
		    .antMatchers("/").hasAnyAuthority("USER", "EDITOR", "ADMIN")
		    .antMatchers("/save", "/new", "/register", "/process_register").permitAll()
		    .antMatchers("/index").authenticated()
		    .antMatchers("/users/*").hasAnyAuthority("EDITOR", "ADMIN")
			//.antMatchers("/users","/view","/index","/", "/view/**", "/user_form", "/account").authenticated()
			/*.anyRequest().authenticated()
			.antMatchers("/login")
            .access("hasRole('ANONYMOUS')")
			.and()
			.formLogin()
			    .loginPage("/login")
			    .failureUrl("/login?error")
			    .defaultSuccessUrl("/index")
				.usernameParameter("email")

				.permitAll()*/
			.and()
			.logout().logoutSuccessUrl("/login?logout").permitAll();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	            .ignoring()
	            .antMatchers("/resources/**","/agent-images/**", "/static/**", "/css/**", "/js/**", "/images/**", "/icon/**");
	}


}