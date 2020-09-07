package com.favoriteMuisc.FavoriteMusic.dto;

import java.io.Serializable;
import java.util.Set;

public class DataDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String country;
	private String state;
	private String city;
	private String favoriteSong;
	private String favoriteAlbum;
	private String favoriteBand;

	private Set<Integer> favoriteMusicGenres;
	
	public DataDTO() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getFavoriteSong() {
		return favoriteSong;
	}

	public void setFavoriteSong(String favoriteSong) {
		this.favoriteSong = favoriteSong;
	}

	public String getFavoriteAlbum() {
		return favoriteAlbum;
	}

	public void setFavoriteAlbum(String favoriteAlbum) {
		this.favoriteAlbum = favoriteAlbum;
	}

	public String getFavoriteBand() {
		return favoriteBand;
	}

	public void setFavoriteBand(String favoriteBand) {
		this.favoriteBand = favoriteBand;
	}

	public Set<Integer> getFavoriteMusicGenres() {
		return favoriteMusicGenres;
	}

	public void setFavoriteMusicGenres(Set<Integer> favoriteMusicGenres) {
		this.favoriteMusicGenres = favoriteMusicGenres;
	}

}
