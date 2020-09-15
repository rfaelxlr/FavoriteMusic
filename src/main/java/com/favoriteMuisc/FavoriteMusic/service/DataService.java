package com.favoriteMuisc.FavoriteMusic.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favoriteMuisc.FavoriteMusic.domain.Data;
import com.favoriteMuisc.FavoriteMusic.domain.User;
import com.favoriteMuisc.FavoriteMusic.dto.DataDTO;
import com.favoriteMuisc.FavoriteMusic.repository.DataRepository;
import com.favoriteMuisc.FavoriteMusic.security.UserSS;
import com.favoriteMuisc.FavoriteMusic.service.exceptions.DataIntegrityException;
import com.favoriteMuisc.FavoriteMusic.service.exceptions.ObjectNotFoundException;

@Service
public class DataService {
	@Autowired
	private DataRepository repo;
	
	@Autowired
	private UserService userService;


	public List<Data> findAll() {

		return repo.findAll();
	}

	public Data find(Integer id) {
		Optional<Data> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Data.class.getName()));
	}
	
	public Data fromDTO(DataDTO objDTO) {
		UserSS userAuth = UserServiceSS.authenticated();
		User user = userService.find(userAuth.getId());

		Data obj = new Data(null,objDTO.getCountry(),objDTO.getState(),objDTO.getCity(),objDTO.getFavoriteSong(),objDTO.getFavoriteAlbum(),objDTO.getFavoriteAlbum(),objDTO.getFavoriteMusicGenres(),user);

		return obj;
	}

	@Transactional
	public Data insert(Data obj) {
		obj.setId(null);
		obj = repo.save(obj);
		return obj;
	}

	public Data update(Data obj) {
		Data newObj = find(obj.getId());

		updateData(newObj, obj);
		newObj.setUpdated_at(Instant.now());

		return repo.save(newObj);
	}

	public void delete(Integer id) {
		Data obj = find(id);
		try {
			repo.delete(obj);

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não foi possível deletar os dados");
		}

	}

	private void updateData(Data newObj, Data obj) {
		newObj.setCountry(obj.getCountry());
		newObj.setState(obj.getState());
		newObj.setCity(obj.getCity());
		newObj.setFavoriteSong(obj.getFavoriteSong());
		newObj.setFavoriteAlbum(obj.getFavoriteAlbum());
		newObj.setFavoriteBand(obj.getFavoriteBand());
		newObj.setFavoriteMusicGenres(obj.getFavoriteMusicGenres());

	}


}
