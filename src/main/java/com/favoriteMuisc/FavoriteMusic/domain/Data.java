package com.favoriteMuisc.FavoriteMusic.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Data implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String country;
	private String state;
	private String city;
	private String favoriteSong;
	private String favoriteAlbum;
	private String favoriteBand;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT-3")
	private Instant created_at;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'z'", timezone = "GMT-3")
	private Instant updated_at;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "FAVORITEMUSICGENRES")
	private Set<Integer> favoriteMusicGenres = new HashSet<>();

	@JsonIgnore
	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "user_id")
	@MapsId
	private User user;

	public Data() {

	}

	public Data(User user) {
		this.user = user;
	}

	public Data(Integer id, String country, String state, String city, String favoriteSong, String favoriteAlbum,
			String favoriteBand, Set<Integer> favoriteMusicGenres, User user) {
		super();
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.favoriteSong = favoriteSong;
		this.favoriteAlbum = favoriteAlbum;
		this.favoriteBand = favoriteBand;
		this.favoriteMusicGenres = favoriteMusicGenres;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Instant getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Instant created_at) {
		this.created_at = created_at;
	}

	public Instant getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Instant updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
