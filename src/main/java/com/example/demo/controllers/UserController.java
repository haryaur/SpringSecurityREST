package com.example.demo.controllers;

import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.BranchLocation;
import com.example.demo.entities.Request;
import com.example.demo.entities.Roles;
import com.example.demo.entities.StaffPosition;
import com.example.demo.entities.Users;
import com.example.demo.repositories.UsersRepository;
import com.example.demo.response.GetUserResponse;
import com.example.demo.response.LoginResponse;
import com.example.demo.response.RegistrationResponse;
import com.example.demo.response.ViewUserResponse;
import com.example.demo.security.CustomUserDetails;
import com.example.demo.security.WebSecurityConfig;
import com.example.demo.services.BranchService;
import com.example.demo.services.RequestCountService;
import com.example.demo.services.StaffPositionService;
import com.example.demo.services.UsersService;

@Import(WebSecurityConfig.class)
@RestController
public class UserController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private StaffPositionService staffPositionService;
    
	@Autowired
	private RequestCountService requestCountService;
	

	@Autowired
	private UsersRepository usersRepo;
	

	@Autowired
	private AuthenticationManager authenticationManager;
	

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Users users,
    		Principal principal,Request request, CustomUserDetails customUserDetails){
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
        Collection<? extends GrantedAuthority> role = authentication.getAuthorities();
        String roles = role.toString();
        System.out.println(roles);
        System.out.println(user.getEmail());
        String position = user.getStaffPosition().getPositionName();
    	response.setSuccessful("Login Successful");
    	response.setName(fullname);
    	response.setStaffId(staffId);
    	response.setPosition(position);
    	if(position.equals("Branch")) {
    	 response.setAllMyRequest(requestCountService.getRequestCountAllUser(user.getUserId()));
    	 response.setAllApprovedRequest(requestCountService.getRequestCountApprovedUser(user.getUserId()));
         response.setAllPendingRequest(requestCountService.getRequestCountPendingUser(user.getUserId()));
    	 response.setAllRejectedRequest(requestCountService.getRequestCountRejectedUser(user.getUserId()));
    	 response.setRecentRequests(Arrays.asList(requestCountService.getRecentUser(user.getUserId())));
        }
    	if(position.equals("Manager")) {
    		    response.setAllMyRequest(requestCountService.getRequestCountAllManager(user.getFirstName()));
    	    	response.setAllApprovedRequest(requestCountService.getRequestCountApprovedManager(user.getFirstName()));
    	    	response.setAllPendingRequest(requestCountService.getRequestCountPendingManager(user.getFirstName()));
    	    	response.setAllRejectedRequest(requestCountService.getRequestCountRejectedManager(user.getFirstName()));
    	    	response.setRecentRequests(Arrays.asList(requestCountService.getRequestRecentManager(user.getFirstName())));
    	}
    	  if(position.equals("Procurement Manager")) {
    		  response.setAllMyRequest(requestCountService.getRequestCountAllHeadOffice(user.getFirstName()));
  	    	  response.setAllApprovedRequest(requestCountService.getRequestCountApprovedHeadOffice(user.getFirstName()));
  	    	  response.setAllPendingRequest(requestCountService.getRequestCountPendingHeadOffice(user.getFirstName()));
  	    	  response.setAllRejectedRequest(requestCountService.getRequestCountRejectedHeadOffice(user.getFirstName()));
  	    	response.setRecentRequests(Arrays.asList(requestCountService.getRequestRecentHeadOffice(user.getFirstName())));
    	  }
    	  else {}
        return response;
    }
    
    
    @GetMapping("/register")
    public RegistrationResponse register(RegistrationResponse registrationResponse) {
    	List<StaffPosition> staff = staffPositionService.listAll();
    	List<BranchLocation> branch = branchService.listAll();
    	registrationResponse.setBranch(branch);
    	registrationResponse.setPosition(staff);
    	return registrationResponse;
    	
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
	public GetUserResponse listUsers(GetUserResponse getUserResponse, Authentication authentication) {
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		String firstName = customUserDetails.getFirstName();
		String staffId= customUserDetails.getStaffId();
		String position= customUserDetails.getPosition();
		List<Users> listUsers = usersService.listAll();
		getUserResponse.setName(firstName);
		getUserResponse.setPosition(position);
		getUserResponse.setStaffId(staffId);
		getUserResponse.setUsers(Arrays.asList(listUsers));
		return getUserResponse;
	}
	
	@GetMapping("/users/{userId}")
	public ViewUserResponse viewUser(@PathVariable("userId") int userId, 
		Authentication authentication, ViewUserResponse viewUserResponse) {
		CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
		String firstName = customUserDetails.getFirstName();
		String staffId= customUserDetails.getStaffId();
		String position= customUserDetails.getPosition();
		Users users = usersService.getOne(userId);
		viewUserResponse.setName(firstName);
		viewUserResponse.setStaffId(staffId);
		viewUserResponse.setPosition(position);
		viewUserResponse.setUsers(users);
		return viewUserResponse;
	}
     //METHOD TO UPDATE THE USERDETAILS
	@PutMapping(value="/user/edit/{userId}")
	public Object editUser(@PathVariable("userId") int userId,@RequestBody Users users) {
		Users details = usersRepo.findById(userId);
		users.setStaffPosition(details.getStaffPosition());
		users.setRoles(details.getRoles());
		users.setBranchLocation(details.getBranchLocation());
		details.setFirstName(details.getFirstName());//this can be used to populate other fields
		usersService.save(users);
		
		return "details successfully updated";
	}
	
}

//@PostMapping("/login")
//public LoginResponse login(@RequestBody Users users,
//		Principal principal,Request request){
//	LoginResponse response = new LoginResponse();
//	Authentication authentication =
//    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//    				users.getEmail(), users.getPassword()));
//    if (authentication == null || authentication instanceof AnonymousAuthenticationToken){     	
//    	String errorMessage = "invalid username or password"; 
//    	response.setSuccessful(errorMessage);
//    }
//    SecurityContextHolder.getContext().setAuthentication(authentication);
//    String myEmail = authentication.getName();
//    Users user = usersRepo.findByEmail(myEmail);
//    String fullname =user.getFirstName() + " " + user.getLastName();
//    String staffId = user.getStaffId();
//    String position = user.getStaffPosition().getPositionName();
//    
//	response.setSuccessful("Login Successful");
//	response.setLogin(fullname);
//	response.setStaffId(staffId);
//	response.setPosition(position);
//	if(position.equals("Branch")) {
//	 response.setAllMyRequest(Arrays.asList(requestService.getRequestAllUser(user.getUserId())));
//	 response.setAllApprovedRequest(Arrays.asList(requestService.getRequestApprovedUser(user.getUserId())));
//     response.setAllPendingRequest(Arrays.asList(requestService.getRequestPendingUser(user.getUserId())));
//	 response.setAllRejectedRequest(Arrays.asList(requestService.getRequestRejectedUser(user.getUserId())));
//    }
//	if(position.equals("Manager")) {
//		    response.setAllMyRequest(Arrays.asList(requestService.getRequestAllManager(user.getFirstName())));;
//	    	response.setAllApprovedRequest(Arrays.asList(requestService.getRequestApprovedManager(user.getFirstName())));
//	    	response.setAllPendingRequest(Arrays.asList(requestService.getRequestPendingManager(user.getFirstName())));
//	    	response.setAllRejectedRequest(Arrays.asList(requestService.getRequestRejectedManager(user.getFirstName())));
//	  }
//	  if(position.equals("Procurement Manager")) {
//		  response.setAllMyRequest(Arrays.asList(requestService.getRequestAllHeadOffice(user.getFirstName())));;
//	    	  response.setAllApprovedRequest(Arrays.asList(requestService.getRequestApprovedHeadOffice(user.getFirstName())));
//	    	  response.setAllPendingRequest(Arrays.asList(requestService.getRequestPendingHeadOffice(user.getFirstName())));
//	    	  response.setAllRejectedRequest(Arrays.asList(requestService.getRequestRejectedHeadOffice(user.getFirstName())));
//	  }
//	  else {}
//    return response;
//}
