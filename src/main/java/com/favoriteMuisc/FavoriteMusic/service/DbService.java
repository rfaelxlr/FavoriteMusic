package com.favoriteMuisc.FavoriteMusic.service;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.favoriteMuisc.FavoriteMusic.domain.User;
import com.favoriteMuisc.FavoriteMusic.domain.enums.Profile;
import com.favoriteMuisc.FavoriteMusic.repository.UserRepository;


@Service
public class DbService {

	@Autowired
	private UserRepository userRepository;
	

	@Autowired
	BCryptPasswordEncoder pe;

	
	public void instantiateTestDatabase() throws ParseException {
		User user1 = new User(null, "Rafa", "rafa@hotmail.com", pe.encode("teste1"));
		user1.addProfile(Profile.ADMIN);
		
		User user2 = new User(null, "Bia", "bia@hotmail.com", pe.encode("teste1"));
		userRepository.saveAll(Arrays.asList(user1, user2));

	}
}
