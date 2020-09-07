package com.favoriteMuisc.FavoriteMusic.domain.enums;

public enum MusicGenre {

	ACOUSTIC(1, "ACOUSTIC"), ALTERNATIVE(2, "ALTERNATIVE"), BLUES(3, "BLUES"), BOSSANOVA(4, "BOSSANOVA"),
	CLASSICAL(5, "CLASSICAL"), COUNTRY(6, "COUNTRY"), ELETRONIC(7, "ELETRONIC"), FOLK(8, "FOLK"), FUNK(9, "FUNK"),
	GOSPEL(10, "GOSPEL"), HEAVYMETAL(11, "HEAVYMETAL"), HIPHOP(12, "HIPHOP"), INDIE(13, "INDIE"),
	INSTRUMENTAL(14, "INSTRUMENTAL"), JAZZ(15, "JAZZ"), POP(16, "POP"), RAP(17, "RAP"), REGGAE(18, "REGGAE"),
	ROCK(19, "ROCK"), SOUL(20, "SOUL");

	private int cod;
	private String description;

	private MusicGenre(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}

	public static MusicGenre toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (MusicGenre x : MusicGenre.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Id inválido: " + cod);
	}

	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

}
