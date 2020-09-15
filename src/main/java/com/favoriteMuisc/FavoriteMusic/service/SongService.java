package com.favoriteMuisc.FavoriteMusic.service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.favoriteMuisc.FavoriteMusic.domain.Song;
import com.favoriteMuisc.FavoriteMusic.domain.User;
import com.favoriteMuisc.FavoriteMusic.dto.SongNewDTO;
import com.favoriteMuisc.FavoriteMusic.repository.SongRepository;
import com.favoriteMuisc.FavoriteMusic.security.UserSS;
import com.favoriteMuisc.FavoriteMusic.service.exceptions.DataIntegrityException;
import com.favoriteMuisc.FavoriteMusic.service.exceptions.ObjectNotFoundException;

@Service
public class SongService {
	@Autowired
	private UserService userService;

	@Autowired
	private SongRepository repo;

	public List<Song> findAll() {

		return repo.findAll();
	}

	public Song find(Integer id) {
		Optional<Song> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Song.class.getName()));
	}

	public Song fromDTO(SongNewDTO objDTO) {

		Song song = new Song(null, objDTO.getName(), objDTO.getAlbum(), objDTO.getBand(), objDTO.getReview(),
				objDTO.getYear(), objDTO.getGenre());

		return song;
	}

	@Transactional
	public Song insert(Song obj) {
		UserSS userAuth = UserServiceSS.authenticated();
		User user = userService.find(userAuth.getId());
		obj.setId(null);
		obj.setUser(user);

		obj.setCreated_at(Instant.now());
		obj.setUpdated_at(Instant.now());
		obj = repo.save(obj);

		return obj;
	}

	public Song update(Song obj) {
		Song newObj = find(obj.getId());

		updateData(newObj, obj);
		newObj.setUpdated_at(Instant.now());

		return repo.save(newObj);
	}

	public void delete(Integer id) {
		Song obj = find(id);
		try {
			repo.delete(obj);

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não foi possível deletar a música");
		}

	}

	private void updateData(Song newObj, Song obj) {

		newObj.setName(obj.getName());
		newObj.setAlbum(obj.getAlbum());
		newObj.setBand(obj.getBand());
		newObj.setGenre(obj.getGenre());
		newObj.setYear(obj.getYear());
	}

}
