package com.favoriteMuisc.FavoriteMusic.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.favoriteMuisc.FavoriteMusic.domain.enums.MusicGenre;

public class SongNewDTO implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Integer id;

	private String name;
	private String album;
	private String band;
	private String review;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-3")
	private String year;
	private MusicGenre genre;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public MusicGenre getGenre() {
		return genre;
	}
	public void setGenre(MusicGenre genre) {
		this.genre = genre;
	}
	
	
	

}
