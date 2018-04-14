package com.ou.authentication;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ou.entity.User;
import com.ou.services.UserService;

@Service
public class DBAuthenticationServices implements UserDetailsService {
	@Autowired
	UserService userService;

	
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.findByEmail(email);
		if (user == null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		
		String role = String.valueOf(user.getRole());
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		if (role != null) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		}

		CustomUserDetails customUserDetails = new CustomUserDetails();
        customUserDetails.setUser(user);
        customUserDetails.setAuthorities(grantedAuthorities);
        return customUserDetails;
	}

}
