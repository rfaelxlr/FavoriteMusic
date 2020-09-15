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

import com.favoriteMuisc.FavoriteMusic.domain.Data;
import com.favoriteMuisc.FavoriteMusic.domain.User;
import com.favoriteMuisc.FavoriteMusic.dto.DataDTO;
import com.favoriteMuisc.FavoriteMusic.dto.UserNewDTO;
import com.favoriteMuisc.FavoriteMusic.service.DataService;
import com.favoriteMuisc.FavoriteMusic.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	UserService service;
	
	@Autowired
	DataService dataService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<User>> findAll() {

		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> find(@PathVariable Integer id) {

		User obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value = "/{id}/data")
	public ResponseEntity<Data> findData(@PathVariable Integer id) {

		Data obj = dataService.find(id);

		return ResponseEntity.ok().body(obj);
	}
	
	

	@PostMapping
	public ResponseEntity<User> insert(@Valid @RequestBody UserNewDTO objDTO) {
		User obj = service.fromDTO(objDTO);

		obj = service.insert(obj);

		//URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		return ResponseEntity.ok().body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@Valid @RequestBody User obj, @PathVariable Integer id) {
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.ok().body(obj);

	}
	
	@PutMapping(value = "/{id}/data")
	public ResponseEntity<Data> updateData(@Valid @RequestBody DataDTO objDTO, @PathVariable Integer id) {
		Data data = dataService.fromDTO(objDTO);
		data.setId(id);
		data = dataService.update(data);

		return ResponseEntity.ok().body(data);

	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}
}
