package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Roles;
import com.example.demo.entities.Users;
import com.example.demo.repositories.RolesRepository;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepo;

	@Autowired RolesRepository rolesRepo;


	@Autowired PasswordEncoder passwordEncoder;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public void registerDefaultUser(Users users) {
//		Roles roleUser = rolesRepo.findByName("User");
//		users.setRoles(roleUser);
		encodePassword(users);
		users.setUserCreated(LocalDateTime.now());
		usersRepo.save(users);
	}

	public List<Users> listAll() {
		return usersRepo.findAll();
	}

	public Users getOne(int userId) {
		return usersRepo.findById(userId);
	}

	public List<Roles> listRoles() {
		return rolesRepo.findAll();
	}

	public void save(Users users) {
		encodePassword(users);
		usersRepo.save(users);
	}


	private void encodePassword(Users users) {
		String encodedPassword = passwordEncoder.encode(users.getPassword());
		users.setPassword(encodedPassword);
	}
	
	public void login(Users users) {Authentication authentication =
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
    				users.getEmail(), users.getPassword()));
    if (authentication == null || authentication instanceof AnonymousAuthenticationToken){
    	
    	String errorMessage = "invalid username or password";
    	
    }
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String myEmail = authentication.getName();
    Users user = usersRepo.findByEmail(myEmail);
    String name =user.getFirstName();
    
	}
}
