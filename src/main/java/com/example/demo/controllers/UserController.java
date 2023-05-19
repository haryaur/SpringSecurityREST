package com.example.demo.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired
;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.RegistrationDTO;
import com.example.demo.entities.BranchManager;
import com.example.demo.entities.Request;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.response.LoginResponse;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.security.WebSecurityConfig;
import com.example.demo.services.ManagerService;
import com.example.demo.services.RequestService;
import com.example.demo.services.UsersService;

@Import(WebSecurityConfig.class)
@RestController
public class UserController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private ManagerService managerService;
    
	@Autowired
	private RequestService requestService;
	

	@Autowired
	private UsersRepository usersRepo;
	

	@Autowired
	private AuthenticationManager authenticationManager;





  //CONTROLLER TO LOGIN
//    @PostMapping("/login")
//    public String showLoginForm(User user) {
//        //method  to prevent accessing the login page when already logged in
//        Authentication authentication = SecurityContextHolder.getContext().getAuthen tication();
//        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
//        	return "Bad login";
//        }
//           else {
//
//               authentication = authenticationManager.authenticate(
//                       new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
//               SecurityContextHolder.getContext().setAuthentication(authentication);
//               return "Good";
//           }
//    }


    @PostMapping("/login")
    public LoginResponse login(@RequestBody Users users,
    		Principal principal,Request request){
    	LoginResponse response = new LoginResponse();
    	Authentication authentication =
        		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
        				users.getEmail(), users.getPassword()));
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken){     	
        	String errorMessage = "invalid username or password"; 
        	response.setSuccessful(errorMessage);
        }
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String myEmail = authentication.getName();
        Users user = usersRepo.findByEmail(myEmail);
        String fullname =user.getFirstName() + " " + user.getLastName();
        String staffId = user.getStaffId();
        String position = user.getStaffPosition().getPositionName();
        
    	response.setSuccessful("Login Successful");
    	response.setLogin(fullname);
    	response.setStaffId(staffId);
    	response.setPosition(position);
    	if(position.equals("Branch")) {
    	 response.setAllMyRequest(Arrays.asList(requestService.getRequestAllUser(user.getUserId())));
    	 response.setAllApprovedRequest(Arrays.asList(requestService.getRequestApprovedUser(user.getUserId())));
         response.setAllPendingRequest(Arrays.asList(requestService.getRequestPendingUser(user.getUserId())));
    	 response.setAllRejectedRequest(Arrays.asList(requestService.getRequestRejectedUser(user.getUserId())));
        }
    	if(position.equals("Manager")) {
    		    response.setAllMyRequest(Arrays.asList(requestService.getRequestAllManager(user.getFirstName())));;
    	    	response.setAllApprovedRequest(Arrays.asList(requestService.getRequestApprovedManager(user.getFirstName())));
    	    	response.setAllPendingRequest(Arrays.asList(requestService.getRequestPendingManager(user.getFirstName())));
    	    	response.setAllRejectedRequest(Arrays.asList(requestService.getRequestRejectedManager(user.getFirstName())));
    	  }
    	  if(position.equals("Procurement Manager")) {
    		  response.setAllMyRequest(Arrays.asList(requestService.getRequestAllHeadOffice(user.getFirstName())));;
  	    	  response.setAllApprovedRequest(Arrays.asList(requestService.getRequestApprovedHeadOffice(user.getFirstName())));
  	    	  response.setAllPendingRequest(Arrays.asList(requestService.getRequestPendingHeadOffice(user.getFirstName())));
  	    	  response.setAllRejectedRequest(Arrays.asList(requestService.getRequestRejectedHeadOffice(user.getFirstName())));
    	  }
    	  else {}
        return response;
    }
    
	//CONTROLLER TO CREATE A NEW USER
	@PostMapping("/new_register")
	public String processRegister(@RequestBody Users users) {
//		Users user = registrationDTO.getUsers();
//		BranchManager manager = registrationDTO.getBranchManager();
		Users existingUser = usersRepo.findByEmail(users.getEmail());
	    if(existingUser == null){
	    //	int x =user.getStaffPosition().getPositionId();
	        usersService.registerDefaultUser(users);
	     //   if(x == 2) {
	       // managerService.AddManager(manager);
	    	//} else {}
	    }
	    else {
	    	String alreadyExists = "User Already Exist";
	    	return alreadyExists;
	}
	    String message = "Hello";
        return message;
	}
	
	@GetMapping("/users")
	public List<Users> listUsers() {
		List<Users> listUsers = usersService.listAll();

		return listUsers;
	}
	
	@GetMapping("/index")
	public String Home(Authentication authentication) {
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		String firstName = customUserDetails.getFirstName();
		String Hi= "Good day" + firstName;
		return Hi;
	}
	
	@GetMapping("/users/{userId}")
	public Object viewUser(@PathVariable("userId") int userId) {
		Users users = usersService.getOne(userId);
		return users;
	}
     //METHOD TO UPDATE THE USERDETAILS
	@PutMapping(value="/user/edit/{userId}")
	public Object editUser(@PathVariable("userId") int userId,@RequestBody Users users) {
		Optional<Users> details = usersRepo.findById(userId);
		Users usersDetails = details.get();
		usersDetails.setFirstName(users.getFirstName());//this can be used to populate other fields
		usersService.save(users);
		
		return "details successfully updated";
	}
	
}
