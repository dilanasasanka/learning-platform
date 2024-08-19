package com.example.learningplatform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.learningplatform.entity.User;
import com.example.learningplatform.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(
            user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().name()));
    }

    public User registerUser(User user) {
        return userRepository.save(user);
    }
    
    public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
    
    public User findById(Long id) {
		return userRepository.getUserById(id);
	}
    
}


