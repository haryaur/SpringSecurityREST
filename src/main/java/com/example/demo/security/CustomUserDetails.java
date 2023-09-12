package com.example.demo.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.entities.Roles;
import com.example.demo.entities.Users;

public class CustomUserDetails  implements UserDetails{
	private static final long serialVersionUID = 1L;
	private Users users;

	public CustomUserDetails(Users users) {
		this.users = users;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Roles> role = users.getRoles();
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();

        for (Roles roles : role) {
            authorities.add(new SimpleGrantedAuthority(roles.getRoleName()));
        }

        return authorities;
	}
	
	
	

	@Override
	public String getPassword() {
		return users.getPassword();
	}

	
	public String getUsername() {
		return users.getEmail();
	}

	public void setRoles(Set<Roles> roles) {
		this.users.setRoles(roles);
	}

	public Set<Roles> getRoles() {
		return users.getRoles();
	}


	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	public void setFirstName(String firstName) {
		this.users.setFirstName(firstName);
	}

	public void setLastname(String lastName) {
		this.users.setLastName(lastName);
	}

	public void setPassword(String password) {
		this.users.setPassword(password);
	}


	public String getFirstName() {
		return users.getFirstName();
	}
	public String getLastName() {
		return users.getLastName();
	}

	public int getUserId() {
		return users.getUserId();
	}

	public String getFullName() {
		return users.getFirstName() + " " + users.getLastName();
	}
	public String getEmail() {
		return users.getEmail();
	}
}


