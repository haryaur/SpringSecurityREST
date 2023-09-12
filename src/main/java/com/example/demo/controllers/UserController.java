package com.example.demo.controllers;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired
;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.response.LoginResponse;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.security.WebSecurityConfig;
import com.example.demo.services.UsersService;

@Import(WebSecurityConfig.class)
@RestController
public class UserController {

	@Autowired
	private UsersService usersService;

	@Autowired
	private UsersRepository usersRepo;

	@Autowired
	private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Users users,Principal principal,
    		CustomUserDetails customUserDetails){
    	LoginResponse response = new LoginResponse();
    	Authentication authentication =
        		authenticationManager.authenticate(
        				new UsernamePasswordAuthenticationToken(
        				users.getEmail(), users.getPassword()));
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){     	
        	String errorMessage = "invalid username or password"; 
        	response.setSuccessful(errorMessage);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String myEmail = authentication.getName();
        Users user = usersRepo.findByEmail(myEmail);
        String fullname =user.getFirstName() + " " + user.getLastName();
        Collection<? extends GrantedAuthority> role = authentication.getAuthorities();
        String roles = role.toString();
        System.out.println(roles);
        response.setName(fullname);
    	response.setSuccessful("Login Successful");
    	response.setRole(roles);
    	
        return response;
    }
    
    
    
	//CONTROLLER TO CREATE A NEW USER
	@PostMapping("/new_register")
	public String processRegister(@RequestBody Users users) {
		Users existingUser = usersRepo.findByEmail(users.getEmail());
	    if(existingUser == null){
	        usersService.registerDefaultUser(users);
	    }
	    else {
	    	String alreadyExists = "User Already Exist";
	    	return alreadyExists;
	}
	    String message = "Hello";
        return message;
	}
	
	@GetMapping("/users")
	public List<Users> listUsers(Users users, Authentication authentication) throws Exception {
		try {
			List<Users> listUsers = usersService.listAll();
			return listUsers;
		} catch (Exception e) {
			throw new Exception ("Unable to access");
		}
	}
	
}
