package com.favoriteMuisc.FavoriteMusic.resource;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.favoriteMuisc.FavoriteMusic.security.JWTUtil;
import com.favoriteMuisc.FavoriteMusic.security.UserSS;
import com.favoriteMuisc.FavoriteMusic.service.UserServiceSS;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;
	

	@PostMapping(value = "/refresh_token")
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserServiceSS.authenticated();
		Integer id = user.getId();
		String token = jwtUtil.generateToken(user.getUsername(),id,user.getAuthorities());
		response.addHeader("Authorization", "Bearer " + token);
        response.addHeader("access-control-expose-headers", "Authorization");
        response.addHeader("access-control-expose-headers", "X-Total-Count");
		return ResponseEntity.noContent().build();
	}
	

	
}