package com.favoriteMuisc.FavoriteMusic.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.favoriteMuisc.FavoriteMusic.service.validations.UserInsert;

@UserInsert
public class UserNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String username;
	@Email(message = "Email inválido")
	@NotEmpty(message = "Preenchimento Obrigatório")
	private String email;

	@NotEmpty(message = "Preenchimento Obrigatório")
	private String password;

	public UserNewDTO() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
