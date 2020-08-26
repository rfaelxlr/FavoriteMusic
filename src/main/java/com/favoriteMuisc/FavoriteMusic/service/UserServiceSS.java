package com.favoriteMuisc.FavoriteMusic.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.favoriteMuisc.FavoriteMusic.security.UserSS;

public class UserServiceSS {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
