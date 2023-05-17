package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersRepository usersRepo;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = usersRepo.findByEmail(username);
		if (users == null) {
			throw new UsernameNotFoundException("User not found");
		}

		return new CustomUserDetails(users);
	}


}
