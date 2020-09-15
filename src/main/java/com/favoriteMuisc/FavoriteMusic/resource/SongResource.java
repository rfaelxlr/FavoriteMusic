package com.favoriteMuisc.FavoriteMusic.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.favoriteMuisc.FavoriteMusic.domain.Song;
import com.favoriteMuisc.FavoriteMusic.dto.SongNewDTO;
import com.favoriteMuisc.FavoriteMusic.service.SongService;

@RestController
@RequestMapping(value = "/songs")
public class SongResource {

	@Autowired
	SongService service;

	@GetMapping(value = "/all")
	public ResponseEntity<List<Song>> findAll() {

		List<Song> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Song> find(@PathVariable Integer id) {

		Song obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Song> insert(@Valid @RequestBody SongNewDTO objDTO) {
		Song obj = service.fromDTO(objDTO);

		obj = service.insert(obj);

		// URI uri =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Song> update(@Valid @RequestBody Song obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.ok().body(obj);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}
}
